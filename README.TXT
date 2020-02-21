OCC Interview Coding Exercise

Implemented as a Spring Boot ApplicationRunner, using open-source libraries.
Character values are defined in file application.propertes

-- Project Dependencies

JDK 8
Spring Boot
Apache Commons lang3
Apache Commons CSV
Google Guava
Lombok


-- How to Build

cd to the root of project, execute
  cd score_pclin
  chmod a+x gradlew
  ./gradlew clean build

Gradle build script (gradlew) will download dependencies.


-- How to Run

At the root of project, execute
  java -jar build/libs/score-0.0.1-SNAPSHOT.jar  names.txt
  or
  java -jar build/libs/score-0.0.1-SNAPSHOT.jar [datafile]


-- Limitions

This implementation assume the whole names list fit into the memory.
Currently, there is no test; yet to be done.


--  Contact

Po-Chuan LIN
214-699-8882
pclin.java@gmail.com
