FROM ubuntu:latest
LABEL authors="USER"

ENTRYPOINT ["top", "-b"]

FROM bellsoft/liberica-openjdk-alpine-musl
COPY ./target/YandexTaxiScheduler-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","TaxiPrices-0.0.1-SNAPSHOT.jar"]