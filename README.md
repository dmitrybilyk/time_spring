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

