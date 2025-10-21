FROM eclipse-temurin:21
LABEL maintainer="emanuelrodrigueser@gmail.com"
WORKDIR /app
COPY target/cadastroDeNinjas-0.0.1-SNAPSHOT.jar /app/cadastro_de_ninja_docker.jar
ENTRYPOINT ["java", "-jar", "cadastro_de_ninja_docker.jar"]

