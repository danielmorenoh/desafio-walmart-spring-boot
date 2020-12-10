# desafio-walmart-spring-boot

Creación imagen:

docker build -t "spring-boot-docker" .

Creación y ejecución contenedor:

docker run -d --name spring-boot-docker -p 8080:9000 --link mongodb-local:mongo spring-boot-docker:latest
