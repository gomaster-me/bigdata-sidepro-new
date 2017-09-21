FROM java:8

RUN mkdir /app
WORKDIR /app

ADD build/libs/myapp-0.0.1-SNAPSHOT.jar /app
RUN ln -s /app/myapp-0.0.1-SNAPSHOT.jar /app/myapp-latest.jar

RUN java -jar /app/myapp-latest.jar

