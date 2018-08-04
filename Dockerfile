FROM java:openjdk-8-jre-alpine

EXPOSE 8080 8081
COPY ./target /target
COPY ./config.yml config.yml
CMD java -jar \
    target/com-learn-dropwizard-1.0-SNAPSHOT.jar \
    server config.yml

HEALTHCHECK --interval=5m --timeout=15s \
  CMD curl -f http://localhost:8081/healthcheck || exit 1