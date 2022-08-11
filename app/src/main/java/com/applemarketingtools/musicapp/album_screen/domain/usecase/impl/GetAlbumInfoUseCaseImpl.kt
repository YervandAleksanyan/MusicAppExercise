package com.applemarketingtools.musicapp.album_screen.domain.usecase.impl

import com.applemarketingtools.musicapp.album_screen.domain.models.AlbumInfoDomainModel
import com.applemarketingtools.musicapp.album_screen.domain.repository.AlbumInfoRepository
import com.applemarketingtools.musicapp.core.domain.usecase.FlowUseCase
import com.applemarketingtools.musicapp.core.model.Result
import com.applemarketingtools.musicapp.core.model.mapResultData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class GetAlbumInfoUseCaseImpl(
    coroutineDispatcher: CoroutineDispatcher,
    private val musicAppRepo: AlbumInfoRepository
) : FlowUseCase<Int, List<AlbumInfoDomainModel>>(coroutineDispatcher = coroutineDispatcher) {


    override fun execute(parameters: Int): Flow<Result<List<AlbumInfoDomainModel>>> =
        musicAppRepo.getAlbumInfoData(count = parameters).mapResultData { it }
}
