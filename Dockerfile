#FROM ubuntu:latest
#LABEL authors="USER"
#
#ENTRYPOINT ["top", "-b"]

FROM openjdk:17-jdk-slim
COPY ./target/TaxiPrices-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","TaxiPrices-0.0.1-SNAPSHOT.jar"]