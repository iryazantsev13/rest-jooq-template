#!/bin/sh
liquibase --defaults-file=/script/liquibase.properties --search-path=/liquibase/changelog  update --changelog-file='init-schema.yaml'
