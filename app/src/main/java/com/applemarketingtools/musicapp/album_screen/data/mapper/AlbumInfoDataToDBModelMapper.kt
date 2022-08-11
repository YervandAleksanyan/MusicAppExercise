package com.applemarketingtools.musicapp.album_screen.data.mapper

import com.applemarketingtools.musicapp.album_screen.data.models.AlbumInfoDataModel
import com.applemarketingtools.musicapp.album_screen.data.models.entityes.AlbumInfoDataEntity
import com.applemarketingtools.musicapp.core.mapper.Mapper

class AlbumInfoDataToDBModelMapper : Mapper<AlbumInfoDataModel, AlbumInfoDataEntity> {

    override fun map(s: AlbumInfoDataModel): AlbumInfoDataEntity =

        AlbumInfoDataEntity().apply {
            id = s.id
            artistId = s.artistId
            artistName = s.artistName
            artistUrl = s.artistUrl
            imageUrl = s.imageUrl
            contentAdvisoryRating = s.contentAdvisoryRating
            kind = s.kind
            name = s.name
            releaseDate = s.releaseDate
            url = s.url
            copyright = s.copyright
        }
}