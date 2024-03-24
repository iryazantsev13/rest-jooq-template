package games.classifier.managertdd.infrastructure.config

import games.classifier.managertdd.application.port.input.GameService
import games.classifier.managertdd.application.port.output.GameRepository
import games.classifier.managertdd.application.service.GameServiceImpl
import games.classifier.managertdd.infrastructure.adapters.output.repository.GameRepositoryImpl
import org.jooq.DSLContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Suppress("unused")
@Configuration
class BeanConfiguration {
    @Bean
    fun createGameService(
        gameRepository: GameRepository
    ): GameService {
        return GameServiceImpl(gameRepository = gameRepository)
    }

    @Bean
    fun createGameRepository(dslContext: DSLContext): GameRepository {
        return GameRepositoryImpl(dslContext)
    }
}