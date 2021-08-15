package org.oooc.kry.global.dto

import org.springframework.http.HttpStatus

data class APIResponse<T>(
    val code: Int = HttpStatus.OK.value(),
    val message: String = HttpStatus.OK.reasonPhrase,
    val result: T? = null
)
