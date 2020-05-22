package com.srik.currencyexcahngeservices;

public class CurrencyExchangeRateRequest {

	private String fromCurrency;
	private String toCurrency;
	
	
	public CurrencyExchangeRateRequest() {
		super();
	}
	public CurrencyExchangeRateRequest(String fromCurrency, String toCurrency) {
		super();
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
	}
	public String getFromCurrency() {
		return fromCurrency;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	
	
}
