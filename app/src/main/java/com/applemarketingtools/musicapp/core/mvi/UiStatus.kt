package com.applemarketingtools.musicapp.core.mvi

import androidx.compose.runtime.Immutable

@Immutable
sealed class UiStatus {
    object  Loading : UiStatus()
    object Success : UiStatus()
    object Empty:UiStatus()
    data class Failed(val message: String = "") : UiStatus()
}
