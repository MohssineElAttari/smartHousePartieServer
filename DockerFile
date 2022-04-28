FROM openjdk:11
EXPOSE 8080
ADD target/smartHousePartieServer.jar smartHousePartieServer.jar
ENTRYPOINT ["java","-jar","/smartHousePartieServer.jar"]