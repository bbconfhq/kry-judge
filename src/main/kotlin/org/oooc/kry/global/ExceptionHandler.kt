package org.oooc.kry.global

import org.oooc.kry.global.ResourceNotFoundException
import org.springframework.context.MessageSource
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

@ControllerAdvice
class ExceptionHandler (val messageSource: MessageSource) {
    @ExceptionHandler(ResourceNotFoundException::class)
    fun resourceNotFound(exception: ResourceNotFoundException, locale: Locale) =
        ErrorResponse.badReqeust(messageSource.getMessage(exception, locale))
}