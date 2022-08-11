package com.applemarketingtools.musicapp.album_screen.data.mapper

import com.applemarketingtools.musicapp.album_screen.data.models.AlbumInfoDataModel
import com.applemarketingtools.musicapp.album_screen.domain.models.AlbumInfoDomainModel
import com.applemarketingtools.musicapp.core.mapper.Mapper

class AlbumInfoDataToDomainModelMapper : Mapper<AlbumInfoDataModel, AlbumInfoDomainModel> {

    override fun map(s: AlbumInfoDataModel): AlbumInfoDomainModel =
        AlbumInfoDomainModel(
            artistId = s.artistId,
            artistName = s.artistName,
            artistUrl = s.artistUrl,
            imageUrl = s.imageUrl,
            contentAdvisoryRating = s.contentAdvisoryRating,
            id = s.id,
            kind = s.kind,
            name = s.name,
            releaseDate = s.releaseDate,
            url = s.url,
            copyright = s.copyright
        )
}