package com.applemarketingtools.musicapp.album_screen.data.mapper

import com.applemarketingtools.musicapp.album_screen.data.models.AlbumInfoDataModel
import com.applemarketingtools.musicapp.album_screen.data.models.network.AlbumInfoDataResponse
import com.applemarketingtools.musicapp.core.mapper.Mapper

class AlbumInfoResponseToDataModelMapper : Mapper<AlbumInfoDataResponse, AlbumInfoDataModel> {

    override fun map(s: AlbumInfoDataResponse): AlbumInfoDataModel =
        AlbumInfoDataModel(
            artistId = s.artistId,
            artistName = s.artistName,
            imageUrl = s.imageUrl,
            id = s.id,
            name = s.name,
            artistUrl = s.artistUrl,
            contentAdvisoryRating = s.contentAdvisoryRating,
            kind = s.kind,
            releaseDate = s.releaseDate,
            url = s.url,
            copyright = s.copyright
        )
}