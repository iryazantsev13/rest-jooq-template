package games.classifier.managertdd.infrastructure.adapters.input.http.v1

import games.classifier.managertdd.application.port.input.GameService
import games.classifier.managertdd.infrastructure.adapters.input.http.v1.dto.GameDto
import games.classifier.managertdd.infrastructure.adapters.input.http.v1.dto.GameListDto
import games.classifier.managertdd.infrastructure.adapters.input.http.v1.dto.GameParamsDto
import games.classifier.managertdd.infrastructure.adapters.input.http.v1.mapper.GameMapper.Companion.toGameData
import games.classifier.managertdd.infrastructure.adapters.input.http.v1.mapper.GameMapper.Companion.toGameDto
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["api/v1/game"])
class GameApiController(
    private val gameService: GameService
) {

    @GetMapping(produces = [APPLICATION_JSON_VALUE])
    fun getAll(
        @RequestParam("page", required = false, defaultValue = "0") pageIndex: Int,
        @RequestParam("size", required = false, defaultValue = "100") pageSize: Int
    ): ResponseEntity<GameListDto> {
        val pagedData = gameService.getAll(pageIndex, pageSize)
        return ResponseEntity.ok().body(
            GameListDto(pagedData.first, pagedData.second.map { toGameDto(it) })
        )
    }

    @GetMapping(path = ["{gameId}"], produces = [APPLICATION_JSON_VALUE])
    fun getById(
        @PathVariable gameId: Int
    ): ResponseEntity<GameDto> =
        ResponseEntity.ok().body(toGameDto(gameService.getById(gameId)))

    @PostMapping(consumes = [APPLICATION_JSON_VALUE])
    fun create(
        @RequestBody dto: GameDto
    ) = gameService.create(toGameData(dto))

    @PutMapping("/{gameId}", consumes = [APPLICATION_JSON_VALUE])//, produces = [MediaType.ALL_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun update(
        @PathVariable gameId: Int, @RequestBody dto: GameParamsDto
    ) = gameService.update(gameId, toGameData(dto))

    @DeleteMapping("/{gameId}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteById(
        @PathVariable gameId: Int
    ) = gameService.deleteById(gameId)
}