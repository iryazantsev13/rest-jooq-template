package games.classifier.managertdd.infrastructure.adapters.input.http.v1.dto

data class GameDto(
    val gameCode: Int = 0,
    val generalName: String?,
    val price: Long,
    val isDelete: Boolean = false,
)
