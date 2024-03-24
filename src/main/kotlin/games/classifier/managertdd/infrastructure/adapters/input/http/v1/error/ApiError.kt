package games.classifier.managertdd.infrastructure.adapters.input.http.v1.error

data class ApiError(
    val errorCode: String,
    val message: String,
)
