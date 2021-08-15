package org.oooc.kry.global

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.*

data class ErrorBody(
    val status:String,
    val message:String,
    val timestamp: Date
)

class ErrorResponse: ResponseEntity<ErrorBody> {
    constructor(body: ErrorBody, httpStatus: HttpStatus) : super(body, httpStatus)

    companion object {
        fun badReqeust(message:String): ErrorResponse {
            val status = HttpStatus.BAD_REQUEST
            return ErrorResponse(ErrorBody(status.value().toString(), message, Date()), status)
        }

        fun notFound(message:String): ErrorResponse {
            val status = HttpStatus.NOT_FOUND
            return ErrorResponse(ErrorBody(status.value().toString(), message, Date()), status)
        }
    }
}