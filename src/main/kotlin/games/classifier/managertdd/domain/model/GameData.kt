package games.classifier.managertdd.domain.model

data class GameData(
    val gameCode: Int,
    val generalName: String?,
    val price: Long,
    val isDeleted: Boolean = false
)
