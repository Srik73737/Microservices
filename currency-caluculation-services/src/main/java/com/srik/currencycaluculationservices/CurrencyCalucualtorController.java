package com.srik.currencycaluculationservices;

import java.math.BigDecimal;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyCalucualtorController {
	
	/*
	 * Using Resttemplate to call micro 
	 * cons: url need to be speciied explicitly and too many lines of code
	 */
	private static Logger logger = LoggerFactory.getLogger(CurrencyCalucualtorController.class);
	@Autowired
	private CurrencyExchangeSvcProxy currencyExchangeSvcProxy;
	
	@PostMapping("/currncy/caluculation")
	public CurrencyExchangeDetailsResponse getCurrencyCaluculation(@RequestBody CurrencyExchangeRateRequest request)
	{
		logger.info("start of method : getCurrencyCaluculation");
		
		String url = "http://localhost:8100/currency/exchangerates";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 HttpEntity<CurrencyExchangeRateRequest> requestEntity = new HttpEntity<>(request, requestHeaders);
		ResponseEntity<CurrencyExchangeDetailsResponse> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                CurrencyExchangeDetailsResponse.class
        );
		responseEntity.getBody().setCaluculatedAmt((responseEntity.getBody().getExchangeRates().multiply(new BigDecimal(request.getAmount()))));
		logger.info("End of method : getCurrencyCaluculation");
		return responseEntity.getBody();
	}
	
	@PostMapping("/currncy/caluculation-feign")
	public CurrencyExchangeDetailsResponse getCurrencyCaluculationFeign(@RequestBody CurrencyExchangeRateRequest request)
	{
		return currencyExchangeSvcProxy.getCurrencyExchangeRates(request);
	}

}
