#!/bin/sh

until liquibase --defaults-file=/script/liquibase.properties --search-path=/liquibase/changelog status --changelog-file=init-schema.yaml;
do
  >&2 echo "Postgres is unavailable - sleeping"
  sleep 10
done

>&2 echo "Postgres is up - executing command"
exec "$@"
