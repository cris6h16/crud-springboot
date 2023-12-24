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