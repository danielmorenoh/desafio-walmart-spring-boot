# desafio-walmart-spring-boot

Creación contenedor:

docker build -t "spring-boot-docker" .

Ejecución contenedor:

docker run  --name spring-boot-docker -p 8080:8080 spring-boot-docker:latest 
