FROM postgres:9.5.1
MAINTAINER altfatterz@gmail.com
COPY 1_schema.sql /docker-entrypoint-initdb.d/
COPY 2_data.sql /docker-entrypoint-initdb.d/
