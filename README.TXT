-- OCC Interview Coding Assignment

Implemented as a Spring Boot ApplicationRunner and other opensource libraries.
Character values are defined in file application.propertes

-- Project Dependencies

JDK 8
Spring Boot
Apache Commons lang3
Apache Commons CSV
Google Guava
Lombok


-- How to Build

At the root of project, execute
  ./gradlew clean build -x test

Gradle build script (gradlew) will download dependencies.


-- How to Run

At the root of project, execute
  java -jar build/libs/score-0.0.1-SNAPSHOT.jar  names.txt
  
  java -jar build/libs/score-0.0.1-SNAPSHOT.jar [datafile]


--  Contact

Po-Chuan LIN
214-699-8882
pclin.java@gmail.com
