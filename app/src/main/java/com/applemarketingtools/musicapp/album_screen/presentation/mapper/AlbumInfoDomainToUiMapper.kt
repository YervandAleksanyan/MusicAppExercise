package com.applemarketingtools.musicapp.album_screen.presentation.mapper

import com.applemarketingtools.musicapp.album_screen.domain.models.AlbumInfoDomainModel
import com.applemarketingtools.musicapp.album_screen.presentation.models.AlbumInfoPresentationModel
import com.applemarketingtools.musicapp.core.mapper.Mapper

class AlbumInfoDomainToUiMapper : Mapper<AlbumInfoDomainModel, AlbumInfoPresentationModel> {

    override fun map(s: AlbumInfoDomainModel): AlbumInfoPresentationModel =
        AlbumInfoPresentationModel(
            artistName = s.artistName.orEmpty(),
            artworkUrl100 = s.imageUrl.orEmpty(),
            id = s.id.orEmpty(),
            name = s.name.orEmpty(),
            artistId = s.artistId.orEmpty(),
            artistUrl = s.artistUrl.orEmpty(),
            contentAdvisoryRating = s.artistUrl.orEmpty(),
            kind = s.kind.orEmpty(),
            releaseDate = s.releaseDate.orEmpty(),
            url = s.url.orEmpty(),
            copyright = s.copyright.orEmpty()
        )

}