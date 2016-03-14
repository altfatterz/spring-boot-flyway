Database migration with [Flyway](https://flywaydb.org/)

Example for blog post: http://zoltanaltfatter.com/2016/03/14/database-migration-with-flyway

```
$ ./gradlew clean build
$ docker-compose up
```

In the logs it is visible that the database changes are applied

```
o.f.core.internal.util.VersionPrinter    : Flyway 4.0 by Boxfuse
o.f.c.i.dbsupport.DbSupportFactory       : Database: jdbc:postgresql://postgres/mydb (PostgreSQL 9.5)
o.f.core.internal.command.DbValidate     : Successfully validated 2 migrations (execution time 00:00.024s)
o.f.c.i.metadatatable.MetaDataTableImpl  : Creating Metadata table: "public"."schema_version"
o.f.core.internal.command.DbBaseline     : Successfully baselined schema with version: 1
o.f.core.internal.command.DbMigrate      : Current version of schema "public": 1
o.f.core.internal.command.DbMigrate      : Migrating schema "public" to version 2 - Add country field to athletes table
o.f.core.internal.command.DbMigrate      : Migrating schema "public" to version 3 - Create index first name in athletes table
o.f.core.internal.command.DbMigrate      : Successfully applied 2 migrations to schema "public" (execution time 00:00.047s)
```

Connect to the postgresql instance (using your own DOCKER_HOST IP) 

```
psql -h 192.168.99.100 -d mydb -U docker
```

the `schema_version` records the applied changes:

```
installed_rank  | version |                description                |   type   |                      script                       |  checksum  | installed_by |        installed_on        | execution_time | success
----------------+---------+-------------------------------------------+----------+---------------------------------------------------+------------+--------------+----------------------------+----------------+---------
              1 | 1       | << Flyway Baseline >>                     | BASELINE | << Flyway Baseline >>                             |            | docker       | 2016-03-14 09:24:38.979852 |              0 | t
              2 | 2       | Add country field to athletes table       | SQL      | V2__Add_country_field_to_athletes_table.sql       | -674532233 | docker       | 2016-03-14 09:24:39.043319 |              4 | t
              3 | 3       | Create index first name in athletes table | SQL      | V3__Create_index_first_name_in_athletes_table.sql | 1143920342 | docker       | 2016-03-14 09:24:39.064954 |              4 | t
```

Clean after yourself:

```
docker-compose down -v --rmi=all
```
