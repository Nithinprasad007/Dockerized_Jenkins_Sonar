# Dockerized Jenkins + SonarQube

In this project we define a simple jenkins pipeline with sonarqube quality gate in-place in Docker.

## Structure 🧊

In our docker-compose file we define 3 services:
* jenkinsserv
* sonarserv
* postgreserv

### jenkinsserv

This service runs jenkins image then we should install the (**Sonar Scanner** and **Pipeline Maven Integration**) plugins. 
On the jenkins instance.

The pipeline is defined in the Jenkinsfile.

### sonarserv
This service runs sonar image and to make it communicate with jenkins we need to define a webhook to our jenkins instance.

### postgreserv
To make the containers' data survive removal/recreation volumes are defined and also the default in-memory db used by sonar
(H2) is replaced with on disk db. 
[Sonar no longer supports MySQL](https://community.sonarsource.com/t/end-of-life-of-mysql-support/8667) so we resulted 
to the only availbe open source option (Postgresql)  


## How to run  🚀

Execute the docker-compose file 

    docker docker-compose up

and
jenkins server will be accessible at: [http://localhost:8080/](http://localhost:8080/)
sonar server will be accessible at: [http://localhost:9000/](http://localhost:9000/)
