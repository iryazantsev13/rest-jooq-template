package games.classifier.managertdd.domain.exception

import org.springframework.http.HttpStatus

enum class ValidationErrorCode {
    GAME_CODE_TOO_SHORT, GAME_CODE_TOO_LONG, NULL_GAME_CODE, NULL_PRICE, NULL_NAME
}

class ValidationException(errorCode: ValidationErrorCode): BaseException(
    errorCode = when (errorCode) {
        ValidationErrorCode.GAME_CODE_TOO_SHORT -> "GAME_CODE_TOO_SHORT"
        ValidationErrorCode.GAME_CODE_TOO_LONG -> "GAME_CODE_TOO_LONG"
        ValidationErrorCode.NULL_GAME_CODE -> "NULL_GAME_CODE"
        ValidationErrorCode.NULL_PRICE -> "NULL_PRICE"
        ValidationErrorCode.NULL_NAME -> "NULL_NAME"
    },
    message = when (errorCode) {
        ValidationErrorCode.GAME_CODE_TOO_SHORT -> "Dto has a gameCode with less than 1000"
        ValidationErrorCode.GAME_CODE_TOO_LONG -> "Dto has a gameCode with more than 40000"
        ValidationErrorCode.NULL_GAME_CODE -> "Dto has a null gameCode"
        ValidationErrorCode.NULL_PRICE -> "Dto has a null price"
        ValidationErrorCode.NULL_NAME -> "Dto has a null generalName"
    },
    status = HttpStatus.BAD_REQUEST,
)