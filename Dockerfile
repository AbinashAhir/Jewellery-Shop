FROM isahl/openjdk17:amd64
COPY target/Jewellery-Shop-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","/Jewellery-Shop-0.0.1-SNAPSHOT.jar"] 