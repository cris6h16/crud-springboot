This CRUD use PostgreSQL, you need:

- [x] Log with `postgres` user (superuser privileges)
- [x] Create a Database named: `test_required`

```postgresql
CREATE DATABASE test_required
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = 100
    IS_TEMPLATE = False;
```

- [x] Into above database, create Schema named: `exercise1`

```postgresql
CREATE SCHEMA exercise1 AUTHORIZATION postgres;
```

- [x] create a user:
    - username: `prueba`
    - password: `prueba`

```postgresql
    CREATE ROLE prueba WITH
    LOGIN
    PASSWORD 'prueba'
    NOSUPERUSER
    NOCREATEDB
    NOCREATEROLE
    INHERIT
    NOREPLICATION
    CONNECTION LIMIT 5;
```

- [x] Grant privileges to user `prueba` on `exercise1` schema

```postgresql
GRANT CREATE ON SCHEMA exercise1 TO prueba;
GRANT USAGE ON SCHEMA exercise1 TO prueba;
```

- [x] Test the CRUD ✔

You can test the CRUD with the following commands//
I'll use `curl` command in my **ubuntu terminal**, you can use **git bash** in Windows or adapt the commands to your
CLI.

```bash
================================================== Validations test ==================================================

curl -X POST -H "Content-type: application/json" -d '{"name":"", "age":""}' http://localhost:8080/api/driver/create && echo
curl -X POST -H "Content-type: application/json" -d '{"name":"", "age":"70"}' http://localhost:8080/api/driver/create && echo
curl -X POST -H "Content-type: application/json" -d '{"name":"cristian", "age":""}' http://localhost:8080/api/driver/create && echo
curl -X POST -H "Content-type: application/json" -d '{"name":"jose", "age":"89"}' http://localhost:8080/api/driver/create && echo
curl -X POST -H "Content-type: application/json" -d '{"name":"", "age":"99999"}' http://localhost:8080/api/driver/create && echo



================================================== CREATE: Valid Driver Insertion ==================================================

curl -X POST -H "Content-type: application/json" -d '{"name":"cristian", "age":"20"}' http://localhost:8080/api/driver/create && echo
curl -X POST -H "Content-type: application/json" -d '{"name":"pepe", "age":"51"}' http://localhost:8080/api/driver/create && echo
curl -X POST -H "Content-type: application/json" -d '{"name":"victor hugo", "age":"35"}' http://localhost:8080/api/driver/create && echo
curl -X POST -H "Content-type: application/json" -d '{"name":"juanito", "age":"33"}' http://localhost:8080/api/driver/create && echo


================================================== READ: List all ==================================================

curl http://localhost:8080/api/driver/list && echo

================================================== READ: List One(Put one valid Id) ==================================================

curl http://localhost:8080/api/driver/1 && echo



================================ UPDATE one (replace id with the Driver that you can update) =================================

curl -X PUT -H "Content-type: application/json" -d '{"name":"UpdatedName", "age":30}' http://localhost:8080/api/driver/1 && echo


================================================== List all after update ==================================================

curl http://localhost:8080/api/driver/list && echo


================================================== DELETE One(Put one valid Id) ==================================================

curl -X DELETE http://localhost:8080/api/driver/1 && echo


================================================== List All After Delete ==================================================

curl http://localhost:8080/api/driver/list && echo

```