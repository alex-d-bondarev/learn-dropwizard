.DEFAULT_GOAL := default

default:
	@echo "The following commands are supported:"
	@echo "start_service \t\t # Start java service"
	@echo "jacoco_dump \t\t # Dump the collected jacoco coverage from the running java service"
	@echo "jacoco_report \t\t # Create HTML report based on dumped jacoco coverage"
	@echo "jacoco_combined_report \t # Combine jacoco reports from unit tests and running application"

start_service:
	@echo "Starting java service with jacoco agent"
	java -javaagent:'./jacoco/jacocoagent.jar=address=*,port=36320,destfile=./target/jacoco-m/jacoco-m.exec,output=tcpserver' -jar target/com-learn-dropwizard-1.0-SNAPSHOT.jar server config.yml

jacoco_dump:
	@echo "Starting jacoco report dump"
	java -jar ./jacoco/jacococli.jar dump --address localhost --port 36320 --destfile ./target/jacoco-m/jacoco-m.exec

jacoco_report:
	@echo "Starting jacoco report generation"
	java -jar ./jacoco/jacococli.jar report ./target/jacoco-m/jacoco-m.exec --classfiles ./target/classes/com --sourcefiles ./src/main/java/com --html ./target/jacoco-m

jacoco_combined_report:
	@echo "Starting jacoco combined report generation"
	@echo "Merge jacoco exec from unit tests and manual run"
	java -jar ./jacoco/jacococli.jar merge ./target/jacoco.exec ./target/jacoco-m/jacoco-m.exec --destfile ./target/jacoco-c/jacoco-c.exec
	@echo "Create HTML report"
	java -jar ./jacoco/jacococli.jar report ./target/jacoco-c/jacoco-c.exec --classfiles ./target/classes/com --sourcefiles ./src/main/java/com --html ./target/jacoco-c
