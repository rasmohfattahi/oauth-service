FROM openjdk:11
ADD target/fattahi-oauth-service-1.1.1-RELEASE.jar docker-oauth.jar
ENTRYPOINT ["java", "-jar", "docker-oauth.jar"]

#docker build -f Dockerfile -t docker-image-oauth .
#docker images
#docker run -p 9999:9999 docker-image-oauth
#docker tag docker-image-oauth:latest docker-image-oauth-tag
#docker save -o image.tardocker-image-oauth
#docker image rm docker-image-oauth
#docker load --input image.tar