FROM java:openjdk-8-jre-alpine

EXPOSE 8080
COPY ./target /target
COPY ./config.yml config.yml
CMD java -jar \
    target/com-learn-dropwizard-1.0-SNAPSHOT.jar \
    server config.yml