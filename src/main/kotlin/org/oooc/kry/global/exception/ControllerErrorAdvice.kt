package org.oooc.kry.global.exception

import org.oooc.kry.board.exception.BoardNotFoundException
import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.global.dto.ErrorResponse
import org.oooc.kry.global.enum.ErrorCode
import org.oooc.kry.problem.exception.ProblemNotFoundException
import org.springframework.dao.DataIntegrityViolationException
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

    @ExceptionHandler(BoardNotFoundException::class)
    fun handleBoardNotFoundException(exception: BoardNotFoundException): APIResponse<ErrorResponse> {
        return APIResponse(
            error = ErrorResponse(code = ErrorCode.BOARD_NOT_FOUND, message = exception.message)
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException): APIResponse<ErrorResponse> {
        val bindingResult = exception.bindingResult

        val sb = StringBuilder()
        for (fieldError in bindingResult.fieldErrors) {
            sb.append('[')
            sb.append(fieldError.field)
            sb.append("]")
            sb.append("은(는) ")
            sb.append(fieldError.defaultMessage)
            sb.append(" 입력된 값: ")
            sb.append('[')
            sb.append(fieldError.rejectedValue)
            sb.append(']')
        }
        val message = sb.toString()

        return APIResponse(
            error = ErrorResponse(code = ErrorCode.METHOD_ARGUMENT_NOT_VALID, message = message)
        )
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataIntegrityViolationException(exception: DataIntegrityViolationException): APIResponse<ErrorResponse> {
        return APIResponse(
            error = ErrorResponse(code = ErrorCode.DATA_INTEGRITY_VIOLATION, message = exception.message)
        )
    }
}
