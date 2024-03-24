package games.classifier.managertdd.infrastructure.adapters.input.http.v1.mapper

import games.classifier.managertdd.domain.exception.ValidationErrorCode
import games.classifier.managertdd.domain.exception.ValidationException
import games.classifier.managertdd.domain.model.GameData
import games.classifier.managertdd.infrastructure.adapters.input.http.v1.dto.GameDto
import games.classifier.managertdd.infrastructure.adapters.input.http.v1.dto.GameParamsDto

interface GameMapper {
    companion object {

        fun toGameData(dto: GameParamsDto): GameData {
            return GameData(
                gameCode = 0,
                generalName = dto.generalName,
                price = dto.price,
                isDeleted = dto.isDelete,
            )
        }

        fun toGameDto(game: GameData): GameDto {
            return GameDto(
                gameCode = game.gameCode,
                generalName = game.generalName,
                price = game.price,
                isDelete = game.isDeleted
            )
        }

        fun toGameData(dto: GameDto): GameData {
            if (dto.gameCode == 0) {
                throw ValidationException(ValidationErrorCode.NULL_GAME_CODE)
            }

            if (dto.gameCode < 1000) {
                throw ValidationException(ValidationErrorCode.GAME_CODE_TOO_SHORT)
            }
            if (dto.gameCode >= 40000) {
                throw ValidationException(ValidationErrorCode.GAME_CODE_TOO_LONG)
            }

            return GameData(
                gameCode = dto.gameCode,
                generalName = dto.generalName,
                price = dto.price,
                isDeleted = dto.isDelete,
            )
        }
    }
}