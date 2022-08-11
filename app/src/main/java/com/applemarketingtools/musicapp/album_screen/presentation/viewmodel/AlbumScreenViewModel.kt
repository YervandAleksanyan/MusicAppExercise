package com.applemarketingtools.musicapp.album_screen.presentation.viewmodel

import androidx.compose.runtime.Stable
import androidx.lifecycle.viewModelScope
import com.applemarketingtools.musicapp.album_screen.domain.usecase.impl.GetAlbumInfoUseCaseImpl
import com.applemarketingtools.musicapp.album_screen.presentation.mapper.AlbumInfoDomainToUiMapper
import com.applemarketingtools.musicapp.album_screen.presentation.models.AlbumInfoPresentationModel
import com.applemarketingtools.musicapp.album_screen.presentation.models.AlbumInfoScreenSideEffect
import com.applemarketingtools.musicapp.album_screen.presentation.models.AlbumInfoScreenViewState
import com.applemarketingtools.musicapp.core.COUNT_RESPONSE_DATA
import com.applemarketingtools.musicapp.core.extensions.d
import com.applemarketingtools.musicapp.core.extensions.toJson
import com.applemarketingtools.musicapp.core.model.ViewState
import com.applemarketingtools.musicapp.core.model.mapResultData
import com.applemarketingtools.musicapp.core.model.toViewState
import com.applemarketingtools.musicapp.core.mvi.UiStatus
import com.applemarketingtools.musicapp.core.presentation.viewmodel.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

@Stable
class AlbumScreenViewModel(
    private val getAlbumInfoUseCase: GetAlbumInfoUseCaseImpl,
    private val albumInfoDomainToUiMapper: AlbumInfoDomainToUiMapper
) : ContainerHost<AlbumInfoScreenViewState, AlbumInfoScreenSideEffect>, BaseViewModel() {

    private val viewStateMutableStateFlow =
        MutableStateFlow<ViewState<List<AlbumInfoPresentationModel>>>(ViewState.Loading)
    val isRefreshing = MutableStateFlow(false)


    override val container =
        container<AlbumInfoScreenViewState, AlbumInfoScreenSideEffect>(AlbumInfoScreenViewState.initial())

    fun loadInitialData() {
        viewModelScope.launch {
            val result = getAlbumInfoUseCase(COUNT_RESPONSE_DATA).mapResultData {
                it.map { albumInfoDomainModel ->
                    albumInfoDomainToUiMapper.map(s = albumInfoDomainModel)
                }
            }.first().toViewState { it.isEmpty() }

            postViewState(result)
        }
    }

    fun itemClicked(data: AlbumInfoPresentationModel) {
        intent {
            postSideEffect(
                AlbumInfoScreenSideEffect.NavigateToAlbumInfoDetailsScreen(
                    isItemClicked = true,
                    data = data.toJson().orEmpty()
                )
            )
        }
    }

    private fun reducer() {
        intent {
            reduce {
                when (viewStateMutableStateFlow.value) {
                    is ViewState.Success -> {
                        AlbumInfoScreenViewState(
                            status = UiStatus.Success,
                            data = (viewStateMutableStateFlow.value as ViewState.Success<List<AlbumInfoPresentationModel>>).data
                        )
                    }
                    is ViewState.Empty -> AlbumInfoScreenViewState(
                        status = UiStatus.Empty,
                        data = emptyList()
                    )
                    is ViewState.Loading -> AlbumInfoScreenViewState(
                        status = UiStatus.Loading,
                        data = emptyList()
                    )

                    is ViewState.Error -> {
                        AlbumInfoScreenViewState(
                            status = UiStatus.Failed(message = (viewStateMutableStateFlow.value as ViewState.Error<List<AlbumInfoPresentationModel>>).errorMessage.orEmpty()),
                            data = emptyList()
                        )
                    }
                }
            }
        }
    }


    private suspend fun postViewState(newViewState: ViewState<List<AlbumInfoPresentationModel>>) {
        // Check State
        val prevViewState = viewStateMutableStateFlow.value
        if (prevViewState.isSuccess() && newViewState.isSuccess()) {
            d { "postViewState -> Data Updated" }
        }

        viewStateMutableStateFlow.emit(newViewState)
        reducer()
    }

    fun refresh() {
        viewModelScope.launch {
            setRefresh(true)
            postViewState(ViewState.Loading)
            delay(1000)                           // show screen Loading from swipe refresh
            loadInitialData()
        }
    }

    fun tryAgainClicked() {
        viewModelScope.launch {
            postViewState(ViewState.Loading)
            loadInitialData()
        }
    }

    fun setRefresh(isRefresh: Boolean) {
        viewModelScope.launch {
            isRefreshing.emit(isRefresh)
        }
    }
}