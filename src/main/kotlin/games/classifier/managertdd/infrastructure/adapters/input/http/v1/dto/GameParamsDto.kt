package games.classifier.managertdd.infrastructure.adapters.input.http.v1.dto

data class GameParamsDto(
    val generalName: String,
    val price: Long,
    val isDelete: Boolean,
)
