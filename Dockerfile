FROM openjdk:17-jdk-bullseye

RUN apt-get update && apt-get install -y findutils && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY ./gradlew ./settings.gradle.kts ./build.gradle.kts /app/
COPY ./gradle /app/gradle

RUN chmod +x ./gradlew

COPY ./src /app/src

RUN ./gradlew build --no-daemon -x test

CMD ["java", "-jar", "build/libs/AKSPprac4-0.0.1-SNAPSHOT.jar"]
