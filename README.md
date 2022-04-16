Run mysql docker:
docker run -d --name mysql -p 3306:3306 -e MYSQL_ROOT_USERNAME=root -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=time mysql:8.0



Run Rabbit: docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.8-management

0.0.0.0:15672 > guest/guest




-------------
spring-data-flow
-------------
1. wget -O docker-compose.yml https://raw.githubusercontent.com/spring-cloud/spring-cloud-dataflow/main/src/docker-compose/docker-compose.yml

2. export DATAFLOW_VERSION=2.9.1
   export SKIPPER_VERSION=2.8.1
3. docker-compose up


--------------------
to run with remote postgres wfo_core
--------------------
DATABASE_NAME:wfo_core
DATABASE_HOST:10.17.2.32
DATABASE_PORT:5432

spring.datasource.url=jdbc:postgresql://${DATABASE_HOST}:${DATABASE_PORT}/${DATABASE_NAME}
spring.datasource.username=wfo_user
spring.datasource.password=wfo_pass

flyway.url = jdbc:postgresql://${DATABASE_HOST}:${DATABASE_PORT}/${DATABASE_NAME}
flyway.schemas = proc_schema
flyway.user = wfo_user
flyway.password = wfo_pass
spring.flyway.baseline-on-migrate=true

//	runtimeOnly("com.h2database:h2")
runtimeOnly("org.postgresql:postgresql:42.3.3")
implementation("org.flywaydb:flyway-core")
//	runtimeOnly("mysql:mysql-connector-java:8.0.19")
