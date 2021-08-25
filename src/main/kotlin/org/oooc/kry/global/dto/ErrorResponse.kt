package org.oooc.kry.global.dto

import org.oooc.kry.global.enum.ErrorCode

data class ErrorResponse(
    val code: ErrorCode,
    val message: String?
)
