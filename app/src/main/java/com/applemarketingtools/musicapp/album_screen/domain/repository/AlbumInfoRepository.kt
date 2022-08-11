package com.applemarketingtools.musicapp.album_screen.domain.repository

import com.applemarketingtools.musicapp.album_screen.domain.models.AlbumInfoDomainModel
import com.applemarketingtools.musicapp.core.model.Result
import kotlinx.coroutines.flow.Flow


interface AlbumInfoRepository {

    fun getAlbumInfoData(count: Int): Flow<Result<List<AlbumInfoDomainModel>>>
}