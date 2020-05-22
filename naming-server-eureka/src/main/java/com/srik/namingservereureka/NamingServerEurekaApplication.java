package com.srik.namingservereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
/*
 * Enable eureka naming for Service Registry and discovery all new instances created will be registered here 
 * with reference to spring application name and disovered by caller
 * 
 * Exercise : to make CCS to get an instance of CES by calling Eureka.
 * 			  Register CCS and CES in Eureka server to fetch for caller
 * 
 * Some propertiees to set in application.prop.. file
 * 
 * 1] server.client.register-with-eureka=false
 * 2] server.client.fetch.registry = false
 */
@EnableEurekaServer
public class NamingServerEurekaApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(NamingServerEurekaApplication.class, args);
	}

}
