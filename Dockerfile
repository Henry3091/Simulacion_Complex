# Usa Java 21 con Alpine
FROM eclipse-temurin:21-jdk-alpine

# Carpeta de trabajo
WORKDIR /app

# Copia tu .jar dentro del contenedor
COPY target/simuladorexa-app-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto que Render asignará
EXPOSE 8080

# Ejecuta tu aplicación
CMD ["java", "-jar", "app.jar"]