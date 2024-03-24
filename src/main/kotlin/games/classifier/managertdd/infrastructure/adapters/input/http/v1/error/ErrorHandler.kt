package games.classifier.managertdd.infrastructure.adapters.input.http.v1.error

import games.classifier.managertdd.domain.exception.BaseException
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice()
class ErrorHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(BaseException::class)
    fun handleBaseException(ex: BaseException): ResponseEntity<ApiError> {
        val apiError = ApiError(
            errorCode = ex.errorCode,
            message = ex.message,
        )

        return ResponseEntity(apiError, ex.status)
    }
}