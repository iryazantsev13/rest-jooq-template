package games.classifier.managertdd.domain.exception

import org.springframework.http.HttpStatus

class GameAlreadyExistsException(id: Int): BaseException(
    errorCode = "GAME_ALREADY_EXISTS",
    message = "Game with code: $id already exists",
    status = HttpStatus.CONFLICT,
)