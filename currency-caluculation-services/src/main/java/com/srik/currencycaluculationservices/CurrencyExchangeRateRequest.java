package com.srik.currencycaluculationservices;

public class CurrencyExchangeRateRequest {

	private String fromCurrency;
	private String toCurrency;
	private int amount;
	
	
	public CurrencyExchangeRateRequest() {
		super();
	}
	public CurrencyExchangeRateRequest(String fromCurrency, String toCurrency,int amount) {
		super();
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.amount = amount;
	}
	public String getFromCurrency() {
		return fromCurrency;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public int getAmount() {
		return amount;
	}
	
	
	
	
}
