package com.applemarketingtools.musicapp.core.extensions

import kotlinx.coroutines.Job

fun Job?.isActive() = this != null && this.isActive