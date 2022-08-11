package com.applemarketingtools.musicapp.album_screen.data.mapper

import com.applemarketingtools.musicapp.album_screen.data.models.AlbumInfoDataModel
import com.applemarketingtools.musicapp.album_screen.domain.models.AlbumInfoDomainModel
import com.applemarketingtools.musicapp.core.mapper.Mapper

class AlbumInfoDomainToDataModelMapper : Mapper<AlbumInfoDomainModel, AlbumInfoDataModel> {

    override fun map(s: AlbumInfoDomainModel): AlbumInfoDataModel =
        AlbumInfoDataModel(
            artistId = s.artistId,
            artistName = s.artistName,
            imageUrl = s.imageUrl,
            id = s.id,
            name = s.name,
            contentAdvisoryRating = s.contentAdvisoryRating,
            kind = s.kind,
            releaseDate = s.releaseDate,
            url = s.url,
            artistUrl = s.artistUrl,
            copyright = s.copyright
        )
}