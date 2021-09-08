package org.oooc.kry.global.exception

import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.global.dto.ErrorResponse
import org.oooc.kry.global.enum.ErrorCode
import org.oooc.kry.problem.exception.ProblemNotFoundException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerErrorAdvice {
    @ExceptionHandler(ProblemNotFoundException::class)
    fun handleProblemNotFoundException(exception: ProblemNotFoundException): APIResponse<ErrorResponse> {
        return APIResponse(
            error = ErrorResponse(code = ErrorCode.PROBLEM_NOT_FOUND, message = exception.message)
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException): APIResponse<ErrorResponse> {
        return APIResponse(
            error = ErrorResponse(code = ErrorCode.METHOD_ARGUMENT_NOT_VALID, message = "Method argument is not valid.")
        )
    }
}
