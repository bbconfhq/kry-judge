package org.oooc.kry.global.dto

data class APIResponse<T>(
    val data: T? = null,
    val error: ErrorResponse? = null
)
