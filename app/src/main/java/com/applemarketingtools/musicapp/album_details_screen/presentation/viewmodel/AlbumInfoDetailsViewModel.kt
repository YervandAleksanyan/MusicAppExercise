package com.applemarketingtools.musicapp.album_details_screen.presentation.viewmodel

import androidx.compose.runtime.Stable
import androidx.lifecycle.viewModelScope
import com.applemarketingtools.musicapp.album_details_screen.presentation.mappers.AlbumInfoUiToAlbumInfoDetailsUiMapper
import com.applemarketingtools.musicapp.album_details_screen.presentation.model.AlbumInfoDetailsPresentationModel
import com.applemarketingtools.musicapp.album_details_screen.presentation.model.AlbumInfoDetailsSideEffect
import com.applemarketingtools.musicapp.album_details_screen.presentation.model.AlbumInfoDetailsViewState
import com.applemarketingtools.musicapp.album_screen.presentation.models.AlbumInfoPresentationModel
import com.applemarketingtools.musicapp.core.extensions.d
import com.applemarketingtools.musicapp.core.model.ViewState
import com.applemarketingtools.musicapp.core.mvi.UiStatus
import com.applemarketingtools.musicapp.core.presentation.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

@Stable
class AlbumInfoDetailsViewModel(
    private val uiMapper: AlbumInfoUiToAlbumInfoDetailsUiMapper
) :
    ContainerHost<AlbumInfoDetailsViewState, AlbumInfoDetailsSideEffect>, BaseViewModel() {

    private val viewStateMutableStateFlow =
        MutableStateFlow<ViewState<AlbumInfoDetailsPresentationModel>>(ViewState.Loading)
    override val container =
        container<AlbumInfoDetailsViewState, AlbumInfoDetailsSideEffect>(AlbumInfoDetailsViewState.initial())


    fun loadInitialAlbumInfoData(albumInfoData: AlbumInfoPresentationModel) {
        val presentationData = uiMapper.map(albumInfoData)
        viewModelScope.launch {
            postViewState(ViewState.Success(presentationData))

        }
    }


    private fun reducer() {
        intent {
            reduce {
                when (viewStateMutableStateFlow.value) {
                    is ViewState.Success -> {
                        AlbumInfoDetailsViewState(
                            status = UiStatus.Success,
                            data = (viewStateMutableStateFlow.value as ViewState.Success<AlbumInfoDetailsPresentationModel>).data
                        )
                    }
                    is ViewState.Empty -> AlbumInfoDetailsViewState(
                        status = UiStatus.Empty,
                        data = AlbumInfoDetailsPresentationModel.initial()
                    )
                    is ViewState.Loading -> AlbumInfoDetailsViewState(
                        status = UiStatus.Loading,
                        data = AlbumInfoDetailsPresentationModel.initial()
                    )

                    is ViewState.Error -> {
                        AlbumInfoDetailsViewState(
                            status = UiStatus.Failed(message = (viewStateMutableStateFlow.value as ViewState.Error<AlbumInfoDetailsPresentationModel>).errorMessage.orEmpty()),
                            data = AlbumInfoDetailsPresentationModel.initial()
                        )
                    }
                }
            }
        }
    }


    private suspend fun postViewState(newViewState: ViewState<AlbumInfoDetailsPresentationModel>) {
        // Check State
        val prevViewState = viewStateMutableStateFlow.value
        if (prevViewState.isSuccess() && newViewState.isSuccess()) {
            d { "postViewState -> Data Updated" }
        }

        viewStateMutableStateFlow.emit(newViewState)
        reducer()
    }

    fun onVisitButtonClicked(artisUrl: String) {
        intent {
            postSideEffect(
                AlbumInfoDetailsSideEffect.OnVisitButtonClicked(
                    isClicked = true,
                    artistUrl = artisUrl
                )
            )
        }
    }
}