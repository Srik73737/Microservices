package com.srik.currencyexcahngeservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CurrencyExchangeController {
	
	private static Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

	@Autowired
	private CurrenyExchangeRepo currenyExchangeRepo;

	@PostMapping("/currency/exchangerates")
	public CurrencyExchangeDetailsResponse getCurrencyExchangeRates(@RequestBody CurrencyExchangeRateRequest request)
	{
		logger.info("Call db to fetch exchange rates");
		return currenyExchangeRepo.findByFromCurrencyAndToCurrency(request.getFromCurrency(), request.getToCurrency());
	}
}
