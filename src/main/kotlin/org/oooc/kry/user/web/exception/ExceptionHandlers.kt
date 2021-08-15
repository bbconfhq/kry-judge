package org.oooc.kry.user.web.exception

import org.oooc.kry.global.ErrorResponseEntity
import org.oooc.kry.global.ResourceNotFoundException
import org.springframework.context.MessageSource
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

@ControllerAdvice
class ExceptionHandlers (val messageSource: MessageSource) {
    @ExceptionHandler(UserNotFoundException::class)
    fun userNotFound(exception: UserNotFoundException, locale: Locale) =
        ErrorResponseEntity.badRequest(messageSource.getMessage(exception, locale))

    @ExceptionHandler(ResourceNotFoundException::class)
    fun resourceNotFound(exception: UserNotFoundException, locale: Locale) =
        ErrorResponseEntity.badRequest(messageSource.getMessage(exception, locale))
}