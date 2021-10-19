Postgres
docker run -p 5438:5432 -e POSTGRES_PASSWORD=password -e POSTGRES_DB=time -d --rm --name postgres_time  postgres:9.6

run the job:
curl 'http://localhost:8083/job/start'

dmitry@dmitry-pc:~/dev/projects/time_spring/build/libs$ 
java -jar /home/dmitry/dev/projects/time_spring/build/libs/time-0.0.1-SNAPSHOT.jar CommandLineJobRunner com.learn.time.time.batch.BatchConfiguration importUserJob