FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# FIX: give execute permission to mvnw
RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline

COPY src src

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/student-course-registration-0.0.1-SNAPSHOT.jar"]
