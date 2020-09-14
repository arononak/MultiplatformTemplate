package com.example.multiplatformtemplate.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Response<T>(
    val status: String,
    val data: T
)