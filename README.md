# rest-jooq-template
На примере заглушки под классификатор лотерейной продукции

Для запуска модуля необходимо отключить миграции liquibase, для этого в конфигурации необходимо выключить параметр:
 > spring.liquibase.enabled: false

соответственно, чтобы отрабатывали тесты, необходимо выставить параметр в true