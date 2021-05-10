# smart-kids-api

Local setup:

1. Start the database server in local: pg_ctl -D /usr/local/var/postgres start
2. Create the DB in psql command line: createdb smrtkidzdb
3. Create schema/roles/users
4. Run the flyway app first.
5. Build/Run the API: ./mvnw clean spring-boot:run -Dspring-boot.run.profiles=local

Swagger:
http://localhost:8082/swagger-ui/#/
