# smart-kids-api

Local setup:

1. Create the DB in psql command line: createdb smrtkidzdb
2. Create schema/roles/users
3. Run the flyway app first.
4. Build/Run the API: ./mvnw clean spring-boot:run -Dspring-boot.run.profiles=local

Swagger:
http://localhost:8082/swagger-ui/#/
