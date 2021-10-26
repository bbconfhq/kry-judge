package org.oooc.kry.global.exception

import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.global.dto.ErrorResponse
import org.oooc.kry.global.enum.ErrorCode
import org.oooc.kry.problem.exception.ProblemNotFoundException
import org.oooc.kry.user.domain.exception.UserNotFoundException
import org.springframework.validation.BindingResult
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

    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(exception: UserNotFoundException): APIResponse<ErrorResponse> {
        return APIResponse(
                error = ErrorResponse(code = ErrorCode.USER_NOT_FOUND, message = exception.message)
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException): APIResponse<ErrorResponse> {

        val bindingResult: BindingResult = exception.bindingResult

        val builder: StringBuilder = StringBuilder()

        builder.append("[")
        for(fieldError in bindingResult.getFieldErrors()) {
            builder.append("{")
            builder.append(fieldError.getField())
            builder.append(" : ")
            builder.append(fieldError.getRejectedValue())
            builder.append("}")
            builder.append(", ")
        }
        builder.setLength(builder.length-2)
        builder.append("]")

        return APIResponse(
            error = ErrorResponse(code = ErrorCode.METHOD_ARGUMENT_NOT_VALID, message = "Method argument" + builder.toString() + "is not valid.")
        )
    }
}
