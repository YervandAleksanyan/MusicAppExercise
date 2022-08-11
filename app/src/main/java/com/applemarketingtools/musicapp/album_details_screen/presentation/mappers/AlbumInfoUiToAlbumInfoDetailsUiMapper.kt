package com.applemarketingtools.musicapp.album_details_screen.presentation.mappers

import com.applemarketingtools.musicapp.album_details_screen.presentation.model.AlbumInfoDetailsPresentationModel
import com.applemarketingtools.musicapp.album_details_screen.presentation.utils.StringFormatter
import com.applemarketingtools.musicapp.album_screen.presentation.models.AlbumInfoPresentationModel
import com.applemarketingtools.musicapp.core.mapper.Mapper

class AlbumInfoUiToAlbumInfoDetailsUiMapper(
    private val stringFormatter:StringFormatter
) :
    Mapper<AlbumInfoPresentationModel, AlbumInfoDetailsPresentationModel> {
    override fun map(s: AlbumInfoPresentationModel): AlbumInfoDetailsPresentationModel =
        AlbumInfoDetailsPresentationModel(
            artistName = s.artistName,
            imageUrl = s.artworkUrl100,
            id = s.id,
            name = s.name,
            artistId = s.artistId,
            artistUrl = s.artistUrl,
            contentAdvisoryRating = s.artistUrl,
            kind = s.kind,
            releaseDate = if(s.releaseDate.isNotEmpty()) stringFormatter.prepareReleaseDate(s.releaseDate) else "",
            url = s.url,
            copyright = s.copyright
        )
}