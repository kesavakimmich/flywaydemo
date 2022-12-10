From eclipse-temurin:17.0.2_8-jre-alpine

RUN mkdir -p /flyway
WORKDIR /flyway
ENV JAVA_APP_JAR flywaydemo-0.0.1-SNAPSHOT.jar

COPY target/$JAVA_APP_JAR /flyway

CMD java -Xmx800m -jar $JAVA_APP_JAR