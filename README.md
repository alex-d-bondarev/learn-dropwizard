## LearnDW

Travis: [![Build Status](https://travis-ci.org/alex-d-bondarev/learn-drop-wizard.svg?branch=master)](https://travis-ci.org/alex-d-bondarev/learn-drop-wizard)


### Running LearnDW


#### How to start the LearnDW application from terminal

1. Run `mvn clean install` to build application
1. Start application with `java -jar target/com-learn-dropwizard-1.0-SNAPSHOT.jar server config.yml`
1. To check that application is running navigate to url `http://localhost:8080`

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
1. Install Docker
1. Run `docker-compose up` to run LearnDW in Docker
1. Click `^C` to stop LearnDW in Docker

### LearnDW features

#### Health Check

To see your applications health enter url `http://localhost:8081/healthcheck`

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

