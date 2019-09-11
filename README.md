# Eureka-server-demo-app ![enter image description here](https://travis-ci.org/4sujittiwari/eureka-server-demo-app.svg?branch=master)
A demo Spring boot application implementing the Eureka Server and client connectivity. Whole application is ready to be deployed on Docker

This application will give you a taste of implementing your own Eureka Discovery Server with a client. With Netflix Eureka each client can simultaneously act as a server, to replicate its status to a connected peer. In other words, a client retrieves a list of all connected peers of a service registry and makes all further requests to any other services through a load-balancing algorithm.   

To be informed about the presence of a client, they have to send a heartbeat signal to the registry.

To achieve the goal of this write-up, we'll implement two microservices:

1. a service registry `(Eureka Server)`,
2. a REST service which registers itself at the registry `(Eureka Client)`

## What you'll need

1. IDE
2. JDK 1.8+
3. Maven


## Eureka Server

Below are the dependencies used for Eureka server

	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
	</dependency>

You can use Spring Cloud’s @EnableEurekaServer to stand up a registry that other applications can talk to. This is a regular Spring Boot application with one annotation added to enable the service registry.

## Eureka Client

Below are the dependencies used for Eureka Client

	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
	</dependency>
  
Now that we’ve stood up a service registry, let’s stand up a client that both registers itself with the registry and uses the Spring Cloud DiscoveryClient abstraction to interrogate the registry for it’s own host and port. The @EnableDiscoveryClient activates the Netflix Eureka DiscoveryClient 


## Running the Application

The Spring Boot Maven plugin includes a run goal that can be used to quickly compile and run your application. Applications run in an exploded form, as they do in your IDE. The following example shows a typical Maven command to run a Spring Boot application:

     $ mvn spring-boot:run


## Running on Dokcer

You will need docker installed on your machine and in running state. Lets see the steps for running it on docker.

1. First step is to build both the image to run it on docker(Both projects contains the DockerFile). Run both the commands in their respective directory.
  
        docker build --no-cache=true -t image/eureka-server .
  
        docker build --no-cache=true -t image/customer .
2. Then run `docker-compose up` command to start the containers in docker.
3. Head to `http://localhost:7070` on your browser and wait to get the client up and get registered to Eureka registry.
