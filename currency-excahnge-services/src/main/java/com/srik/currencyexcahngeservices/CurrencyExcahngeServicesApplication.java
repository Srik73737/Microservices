package com.srik.currencyexcahngeservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient // to register with eureka server mark the component as discoverable
/*
 * add an entry of eureka server listener path to communicate with eureka server in application.properties
 */
public class CurrencyExcahngeServicesApplication {

	/*
	 * create and expose currency exchange service by confiugring dat.sql to insert static records
	 * made use of h2 db with jpa repository
	 */
	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(CurrencyExcahngeServicesApplication.class, args);
	}

	/*
	 * Bean used by sleuth to create a unique request id for each and every http request
	 * 	 * which will be hepful for debugging or log analysis
	 */
	@Bean
	public Sampler defaultSampler()
	{
		return Sampler.ALWAYS_SAMPLE;
	}
}
