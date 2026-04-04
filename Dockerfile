# Usa Java 21
FROM eclipse-temurin:21-jdk-alpine

# Carpeta de trabajo
WORKDIR /app

# Copia todo el proyecto
COPY . .

# Construye el .jar usando Maven
RUN ./mvnw clean package -DskipTests || mvn clean package -DskipTests

# Exponer el puerto que Render asignará
EXPOSE 8080

# Ejecuta la app
CMD ["java", "-jar", "target/simuladorexa-app-0.0.1-SNAPSHOT.jar"]