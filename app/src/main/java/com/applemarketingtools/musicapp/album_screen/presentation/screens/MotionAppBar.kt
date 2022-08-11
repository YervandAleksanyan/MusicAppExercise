package com.applemarketingtools.musicapp.album_screen.presentation.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import com.applemarketingtools.musicapp.R
import com.applemarketingtools.musicapp.ui.theme.MusicAppTheme


@OptIn(ExperimentalMotionApi::class)
@Composable
fun MotionAppBar(
    lazyScrollState: LazyGridState,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current

    // recourses
    val titleAppBar = stringResource(id = R.string.album_info_tool_bar_title)
    val appBarHeight = dimensionResource(id = R.dimen.top_app_bar_height)
    val motionScene = remember {
        context.resources
            .openRawResource(R.raw.motion_scene)
            .readBytes()
            .decodeToString()
    }

    val progress by animateFloatAsState(
        targetValue = if (remember { derivedStateOf { lazyScrollState.firstVisibleItemIndex } }.value in 0..4) 0f else 1f,
        animationSpec = tween(500)
    )


    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        MotionLayout(
            motionScene = MotionScene(content = motionScene),
            progress = progress,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {

            val propertiesTopAppBar = motionProperties(id = "box_top_app_bar")
            val propertiesTitleTopAppBar = motionProperties(id = "top_app_bar_title")

            content.invoke()

            Box(
                modifier = Modifier
                    .layoutId(propertiesTopAppBar.value.id())
                    .fillMaxWidth()
                    .height(appBarHeight)
                    .alpha(propertiesTopAppBar.value.float("alpha"))
                    .background(
                        MusicAppTheme.colors.primaryBackground,
                    )
            )

            Text(
                modifier = Modifier
                    .layoutId(propertiesTitleTopAppBar.value.id()),
                fontSize = propertiesTitleTopAppBar.value.fontSize("fontSize"),
                text = titleAppBar,
                color = MusicAppTheme.colors.primaryTextToolBar,
                fontWeight = MusicAppTheme.typography.titleLarge.fontWeight,
                maxLines = 1,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
