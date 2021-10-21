## LearnDW

You can copy and reuse code [![MIT License](http://img.shields.io/badge/license-MIT-green.svg)](https://github.com/selenide/selenide/blob/master/LICENSE)

### Running LearnDW

#### How to start the LearnDW application from terminal

1. Run `mvn clean install` to build application
2. Start application via one of:
   1. `java -jar target/com-learn-dropwizard-1.0-SNAPSHOT.jar server config.yml`
   2. `make start_service`
3. To check that application is running navigate to url `http://localhost:8080`

#### How to start the LearnDW application from IDE

1. Add new configuration as "Application"
1. Set Main class = LearnDWApplication
1. Set Program Arguments = server config.yml
1. Save configuration
1. Run or debug from IDE
1. Reference: https://blog.indrek.io/articles/running-a-dropwizard-application-in-intellij-eclipse-and-netbeans/

#### How to run via Dockerfile

1. Download Docker from https://www.docker.com/get-docker
1. Install Docker
1. Run `mvn clean install` to build application
1. Build image: `docker image build -t learn-drop-wizard .`
1. Run image `docker container run -p 8080:8080 -p 8081:8081 -d learn-drop-wizard`
1. To check that application is running navigate to url `http://localhost:8080`
1. To stop running image `docker stop $(docker ps -a -q)`

#### How to run via docker-compose

1. Download Docker from https://www.docker.com/get-docker
2. Install Docker
3. Run `docker-compose up` to run LearnDW in Docker
4. Click `^C` to stop LearnDW in Docker

### Check test coverage
[Slides](https://docs.google.com/presentation/d/1Zsc9JwJCcVhzOGQQs5BQclYFNcG5IpiesV1BGS5WFQs/edit?usp=sharing)
1. Build the project `mvn clean install`
2. Start the service `make start_service`
3. Send request to several endpoints, like:
   1. [Hello, Stranger!](http://localhost:8080/hello-world)
   2. [Hello, Handsome!](http://localhost:8080/hello-world?name=Handsome)
4. In separate terminal run `make jacoco_all`
5. Check jacoco reports:
   1. [Unit tests coverage](./target/jacoco-ut/index.html)
   2. [Manual tests coverage](./target/jacoco-m/index.html)
   2. [Combined coverage](./target/jacoco-c/index.html)

### LearnDW features

#### Health Check

To see your applications' health enter url `http://localhost:8081/healthcheck`

#### Endpoints

##### Hello World
###### Default request
* http://localhost:8080/hello-world
###### Parameterized request
* http://localhost:8080/hello-world?name=\<Your Parameter>

Example: http://localhost:8080/hello-world?name=Jim

##### Sum numbers
* http://localhost:8080/sum/\<First Number>/and/\<Second Number>

Example: http://localhost:8080/sum/2/and/5

##### Wait milliseconds
###### Default request
* http://localhost:8080/wait
###### Parameterized request
* http://localhost:8080/wait?timeout=\<Milliseconds to wait>

Example: http://localhost:8080/wait?timeout=500

##### Other URLs
All other non implemented endpoints will throw custom 404 error:
* code = 404
* message = Custom page not found error

