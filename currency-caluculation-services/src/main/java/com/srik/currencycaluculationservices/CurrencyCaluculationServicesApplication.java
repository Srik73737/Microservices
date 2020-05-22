package com.srik.currencycaluculationservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.DirtiesContext;

import brave.sampler.Sampler;

/*
 * Enable feign client and scan for the proxy in provided package
 */
@EnableFeignClients("com.srik.currencycaluculationservices")
@SpringBootApplication
@EnableDiscoveryClient // to register with eureka server mark the component as discoverable
public class CurrencyCaluculationServicesApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");

		SpringApplication.run(CurrencyCaluculationServicesApplication.class, args);
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
