package games.classifier.managertdd.domain.exception

import org.springframework.http.HttpStatus

class GameNotFoundException(id: Int): BaseException(
    errorCode = "GAME_NOT_FOUND",
    message = "Game with code: $id not found",
    status = HttpStatus.NOT_FOUND,
)