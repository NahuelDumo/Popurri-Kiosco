# Etapa de construcción
FROM maven:3.8.4-openjdk-17 AS build

# Establecer un directorio de trabajo
WORKDIR /app

# Clonar el repositorio desde GitHub
RUN git clone https://github.com/NahuelDumo/Popurri-Kiosco.git .

# Ejecutar Maven para construir el proyecto
RUN mvn clean package

# Etapa de producción
FROM openjdk:17-jdk-slim-buster

# Establecer un directorio de trabajo
WORKDIR /app

# Exponer el puerto que utilizará la aplicación
EXPOSE 8081

# Copiar el archivo JAR construido desde la etapa anterior
COPY --from=build /app/target/alquileres_api-0.0.1-SNAPSHOT.jar /app/alquileres_api-0.0.1-SNAPSHOT.jar

# Establecer el punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/alquileres_api-0.0.1-SNAPSHOT.jar"]
