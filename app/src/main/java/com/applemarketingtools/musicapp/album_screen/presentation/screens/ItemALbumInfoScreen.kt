package com.applemarketingtools.musicapp.album_screen.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.applemarketingtools.musicapp.R
import com.applemarketingtools.musicapp.album_screen.presentation.models.AlbumInfoPresentationModel
import com.applemarketingtools.musicapp.ui.theme.MusicAppTheme


@Composable
fun ItemAlbumInfoScreen(
    modifier: Modifier,
    data: AlbumInfoPresentationModel,
    onItemClicked: (AlbumInfoPresentationModel) -> Unit
) {

    // recourses
    val cardElevation =
        dimensionResource(id = R.dimen.album_info_item_card_elevation)
    val firstLabelStartPadding =
        dimensionResource(id = R.dimen.album_info_item_first_label_padding_start)
    val firstLabelEndPadding =
        dimensionResource(id = R.dimen.album_info_item_first_label_padding_end)
    val secondLabelStartPadding =
        dimensionResource(id = R.dimen.album_info_item_second_label_padding_start)
    val secondLabelEndPadding =
        dimensionResource(id = R.dimen.album_info_item_second_label_padding_end)
    val secondLabelBottomPadding =
        dimensionResource(id = R.dimen.album_info_item_second_label_padding_bottom)

    Card(
        modifier = modifier
            .shadow(
                clip = true,
                ambientColor = Color.White,
                elevation = cardElevation,
                shape = MusicAppTheme.roundedCornerShape.shapeMedium
            )
            .clickable {
                onItemClicked.invoke(data)
            },
        shape = MusicAppTheme.roundedCornerShape.shapeMedium,
        backgroundColor = MusicAppTheme.colors.primaryBackground
    ) {
        AsyncImage(
            model = data.artworkUrl100,
            contentScale = ContentScale.Crop,
            contentDescription = "IconAlbum",
            modifier = modifier
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = data.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = firstLabelStartPadding, end = firstLabelEndPadding),
                style = MusicAppTheme.typography.labelMedium,
                color = MusicAppTheme.colors.primaryText,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = data.artistName,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = secondLabelStartPadding,
                        end = secondLabelEndPadding,
                        bottom = secondLabelBottomPadding
                    ),
                style = MusicAppTheme.typography.labelSmall,
                color = MusicAppTheme.colors.secondaryText,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
@Preview
private fun ItemAlbumInfoScreenPreview() {
    ItemAlbumInfoScreen(
        modifier = Modifier
            .width(173.dp)
            .height(173.dp),
        data = AlbumInfoPresentationModel.initial()
    ) {

    }
}