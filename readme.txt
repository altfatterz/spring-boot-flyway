Using flyway command line tool:

************************************************************************************************************************
-- Baselines an existing database at the baselineVersion --
************************************************************************************************************************

flyway baseline -locations=filesystem:src/main/resources/db/migration -url=jdbc:postgresql://localhost:5432/flyway -user=Zoltan

Result:
Flyway 3.2.1 by Boxfuse

Database: jdbc:postgresql://localhost:5432/flyway (PostgreSQL 9.4)
Creating Metadata table: "public"."schema_version"
Schema baselined with version: 1

************************************************************************************************************************
-- Prints the information about applied, current and pending migrations --
************************************************************************************************************************

flyway info -url=jdbc:postgresql://localhost:5432/flyway -user=Zoltan

Result:
Flyway 3.2.1 by Boxfuse

Database: jdbc:postgresql://localhost:5432/flyway (PostgreSQL 9.4)

+---------+-----------------------+---------------------+---------+
| Version | Description           | Installed on        | State   |
+---------+-----------------------+---------------------+---------+
| 1       | << Flyway Baseline >> | 2016-02-04 13:59:11 | Baselin |
+---------+-----------------------+---------------------+---------+

************************************************************************************************************************
-- Validates the applied migrations against the ones on the classpath --
************************************************************************************************************************

flyway validate -locations=filesystem:src/main/resources/db/migration -url=jdbc:postgresql://localhost:5432/flyway -user=Zoltan

Result:
Flyway 3.2.1 by Boxfuse

Database: jdbc:postgresql://localhost:5432/flyway (PostgreSQL 9.4)
Validated 3 migrations (execution time 00:00.021s)
ERROR: Validate failed. Detected resolved migration not applied to database: 2

************************************************************************************************************************
-- Migrates the database --
************************************************************************************************************************

flyway migrate -locations=filesystem:src/main/resources/db/migration -url=jdbc:postgresql://localhost:5432/flyway -user=Zoltan

Result:

Flyway 3.2.1 by Boxfuse

Database: jdbc:postgresql://localhost:5432/flyway (PostgreSQL 9.4)
Validated 3 migrations (execution time 00:00.021s)
Current version of schema "public": 1
Migrating schema "public" to version 2 - Add country field to athletes table
Migrating schema "public" to version 3 - Create index first name in athletes table
Successfully applied 2 migrations to schema "public" (execution time 00:00.043s).

