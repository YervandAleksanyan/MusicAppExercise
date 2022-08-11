package com.applemarketingtools.musicapp.album_screen.presentation.screens

import android.app.Activity
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import com.applemarketingtools.musicapp.R
import com.applemarketingtools.musicapp.album_screen.presentation.GRID_CELLS_FIX_COUNT
import com.applemarketingtools.musicapp.album_screen.presentation.models.AlbumInfoScreenSideEffect
import com.applemarketingtools.musicapp.album_screen.presentation.viewmodel.AlbumScreenViewModel
import com.applemarketingtools.musicapp.core.mvi.UiStatus
import com.applemarketingtools.musicapp.core.navigation.AppRoutes
import com.applemarketingtools.musicapp.core.presentation.screens.EmptyListScreen
import com.applemarketingtools.musicapp.core.presentation.screens.LoadingIndicator
import com.applemarketingtools.musicapp.core.presentation.screens.NetworkErrorScreen
import com.applemarketingtools.musicapp.ui.theme.MusicAppStyle
import com.applemarketingtools.musicapp.ui.theme.MusicAppTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.koin.androidx.compose.viewModel
import org.orbitmvi.orbit.compose.collectSideEffect


@Composable
fun AlbumInfoScreen(
    modifier: Modifier,
    navController: NavController
) {

    val albumViewModel: AlbumScreenViewModel by viewModel()
    val albumInfoViewState by albumViewModel.container.stateFlow.collectAsState()
    val isRefreshing by albumViewModel.isRefreshing.collectAsState()
    val lazyScrollState = rememberLazyGridState()
    val systemUiController = rememberSystemUiController()
    val isDarkModeValue = isSystemInDarkTheme()
    val isDarkMode by remember { mutableStateOf(isDarkModeValue) }
    val activity = LocalContext.current as Activity
    val statusBackground = MusicAppTheme.colors.primaryBackground.value


    // album info recourses
    val itemWidth = dimensionResource(id = R.dimen.album_info_item_width)
    val itemHeight = dimensionResource(id = R.dimen.album_info_item_height)
    val itemHorizontalDivider = dimensionResource(id = R.dimen.album_info_item_divider_hor)
    val itemVerticalDivider = dimensionResource(id = R.dimen.album_info_item_divider_vertical)
    val itemContentHorizontalPadding = dimensionResource(id = R.dimen.album_info_item_padding_hor)
    val itemContentVerticalPadding =
        dimensionResource(id = R.dimen.album_info_item_padding_vertical)


    SideEffect {
        WindowCompat.setDecorFitsSystemWindows(activity.window, true)

        systemUiController.setStatusBarColor(
            color = Color(statusBackground).copy(alpha = 0.85f),          // Change status bar color
            darkIcons = !isDarkMode
        )
    }

    LaunchedEffect(key1 = true) {
        albumViewModel.loadInitialData()
    }

    albumViewModel.collectSideEffect { sideEffects ->
        when (sideEffects) {
            is AlbumInfoScreenSideEffect.NavigateToAlbumInfoDetailsScreen -> {
                if (sideEffects.isItemClicked) {
                    navController.navigate(
                        "${AppRoutes.AlbumInfoDetailsScreen.route}/${
                            Uri.encode(
                                sideEffects.data
                            )
                        }"
                    )
                }
            }
        }
    }

    Surface(modifier = modifier.background(MusicAppTheme.colors.primaryBackground)) {

        when (albumInfoViewState.status) {
            is UiStatus.Success -> {
                albumViewModel.setRefresh(false)
                SetupMainToolBar(

                    lazyScrollState,

                    ) {
                    SwipeRefresh(
                        modifier = Modifier.layoutId("content"),
                        state = rememberSwipeRefreshState(isRefreshing),
                        onRefresh = { albumViewModel.refresh() },
                        indicator = { state, trigger ->
                            SwipeRefreshIndicator(
                                state = state,
                                refreshTriggerDistance = trigger,
                                scale = true,
                                contentColor = MusicAppTheme.colors.buttonPrimary
                            )
                        }

                    ) {
                        LazyVerticalGrid(
                            modifier = modifier.background(MusicAppTheme.colors.primaryBackground),
                            verticalArrangement = Arrangement.spacedBy(itemVerticalDivider),
                            horizontalArrangement = Arrangement.spacedBy(
                                itemHorizontalDivider
                            ),
                            contentPadding = PaddingValues(
                                horizontal = itemContentHorizontalPadding,
                                vertical = itemContentVerticalPadding
                            ),
                            columns = GridCells.Fixed(GRID_CELLS_FIX_COUNT),
                            state = lazyScrollState

                        ) {
                            items(albumInfoViewState.data) { item ->

                                ItemAlbumInfoScreen(
                                    modifier = Modifier
                                        .width(itemWidth)
                                        .height(itemHeight),
                                    data = item,
                                ) { onItemClickData ->
                                    albumViewModel.itemClicked(data = onItemClickData)
                                }
                            }
                        }
                    }
                }
            }
            is UiStatus.Empty -> {
                albumViewModel.setRefresh(false)
                EmptyListScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MusicAppTheme.colors.primaryBackground)
                )
            }
            is UiStatus.Failed -> {
                albumViewModel.setRefresh(false)
                NetworkErrorScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MusicAppTheme.colors.primaryBackground),
                ) {
                    albumViewModel.tryAgainClicked()
                }
            }
            is UiStatus.Loading -> {
                LoadingIndicator(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

