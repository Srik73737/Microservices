package com.srik.apigatewayzull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableDiscoveryClient  // regiter and mark as discoverable to eureka server
@EnableZuulProxy       // enable zull proxy to call other micros
@SpringBootApplication
public class ApiGatewayZullApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayZullApplication.class, args);
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
