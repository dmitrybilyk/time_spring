Spring batch:

job - importxmltodb

Import coffee from xml to db:

1. Start Postgres db
docker run -p 5438:5432 -e POSTGRES_PASSWORD=password -e POSTGRES_DB=time -d --rm --name postgres_time  postgres:9.6

2. Start the Spring boot application

3. run the job:
curl 'http://localhost:8083/job/start'

dmitry@dmitry-pc:~/dev/projects/time_spring/build/libs$ 
java -jar /home/dmitry/dev/projects/time_spring/build/libs/time-0.0.1-SNAPSHOT.jar CommandLineJobRunner com.learn.time.time.batch.importxmltodb.configuration.BatchConfiguration importUserJob


Run Rabbit: docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.8-management

0.0.0.0:15672 > guest/guest




-------------
spring-data-flow
-------------
1. wget -O docker-compose.yml https://raw.githubusercontent.com/spring-cloud/spring-cloud-dataflow/main/src/docker-compose/docker-compose.yml

2. export DATAFLOW_VERSION=2.9.1
   export SKIPPER_VERSION=2.8.1
3. docker-compose up

