package com.srik.currencycaluculationservices;

import java.math.BigDecimal;



public class CurrencyExchangeDetailsResponse {

	
//	@GeneratedValue
	private int id;
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal exchangeRates;
	private BigDecimal caluculatedAmt;
	
	
	
	
	public void setCaluculatedAmt(BigDecimal caluculatedAmt) {
		this.caluculatedAmt = caluculatedAmt;
	}
	public BigDecimal getCaluculatedAmt() {
		return caluculatedAmt;
	}
	public CurrencyExchangeDetailsResponse() {
		super();
	}
	public CurrencyExchangeDetailsResponse(String fromCurrency, String toCurrency, BigDecimal exchangeRates) {
		super();
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.exchangeRates = exchangeRates;
	}
	public String getFromCurrency() {
		return fromCurrency;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public BigDecimal getExchangeRates() {
		return exchangeRates;
	}
	
	
}
