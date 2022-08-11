package com.applemarketingtools.musicapp.album_screen.data.mapper

import com.applemarketingtools.musicapp.album_screen.data.models.AlbumInfoDataModel
import com.applemarketingtools.musicapp.album_screen.data.models.entityes.AlbumInfoDataEntity
import com.applemarketingtools.musicapp.core.mapper.Mapper

class AlbumInfoDBToDataModelMapper : Mapper<AlbumInfoDataEntity, AlbumInfoDataModel> {

    override fun map(s: AlbumInfoDataEntity): AlbumInfoDataModel =
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