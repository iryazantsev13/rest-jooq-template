package games.classifier.managertdd

import games.classifier.manager.infrastructure.adapters.db.Tables.T_GAME
import org.jooq.DSLContext
import org.junit.ClassRule
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.testcontainers.containers.PostgreSQLContainer

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SpringExtension::class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
class AbstractIntegrationTest {

	@Autowired
	lateinit var dsl: DSLContext

	companion object {
		@ClassRule
		@JvmStatic
		val postgresSQLContainer: PostgreSQLContainer<*> = PostgreSQLContainer("postgres:15.1")
			.withDatabaseName("db_game")
			.withExposedPorts(5432)
			.withUsername("postgres")
			.withPassword("12345")

		@JvmStatic
		@ClassRule
		@DynamicPropertySource
		fun init(registry: DynamicPropertyRegistry) {
			postgresSQLContainer.start()
			registry.add("spring.datasource.url", postgresSQLContainer::getJdbcUrl)
		}

		@AfterAll
		@JvmStatic
		fun destroy() {
			postgresSQLContainer.stop()
		}
	}

	@AfterEach
	fun cleanUpDb() {
		dsl.deleteFrom(T_GAME).execute()
	}

}
