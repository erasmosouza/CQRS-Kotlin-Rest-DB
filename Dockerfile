FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD /build/libs/CQRS-Kotlin-Rest-DB-1.0-SNAPSHOT.jar CQRS-Kotlin-Rest-DB-1.0.jar
ENTRYPOINT ["java", "-jar", "CQRS-Kotlin-Rest-DB-1.0.jar"]