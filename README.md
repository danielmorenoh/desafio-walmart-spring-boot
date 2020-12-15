# desafio-walmart-spring-boot

Obtener imagen:

sudo docker pull demorenoh/spring-boot-docker

Creación y ejecución contenedor:

sudo docker run -d --name spring-boot-docker -p 8080:9000 --link mongodb-local:mongo spring-boot-docker:latest
