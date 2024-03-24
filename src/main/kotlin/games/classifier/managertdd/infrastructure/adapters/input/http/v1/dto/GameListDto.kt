package games.classifier.managertdd.infrastructure.adapters.input.http.v1.dto

data class GameListDto(
    val totalCount: Int,
    val games: List<GameDto>,
)
