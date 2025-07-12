#run spring bookt
# from project root
mvn spring-boot:run
# OR build a fat-jar:
# mvn clean package && java -jar target/hello-sb-1.0.0.jar
curl http://localhost:8080
curl http://localhost:8080/users/1

