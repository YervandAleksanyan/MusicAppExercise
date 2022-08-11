@file:Suppress("unused")

package com.applemarketingtools.musicapp.core.domain.repository

import com.applemarketingtools.musicapp.core.extensions.tryOrNull
import com.applemarketingtools.musicapp.core.model.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface MultiSourceRepository

fun <T> MultiSourceRepository.cacheElseNetwork(
    networkCall: suspend () -> T,
    cacheCall: suspend () -> T?,
    updateCache: suspend (T) -> Unit
): Flow<Result<T>> = flow {
    // Cache
    val cacheResponse = tryOrNull { cacheCall() }
    if (cacheResponse != null && ((cacheResponse as? List<*>).orEmpty()).isNotEmpty()) {
        emit(Result.Success(cacheResponse))
        return@flow

    }
    // Network
    try {
        val networkResponse = networkCall()
        // Post result
        emit(Result.Success(networkResponse))
        // Update cache
        updateCache(networkResponse)
    } catch (t: Throwable) {
        emit(Result.Error(t))
    }
}

