package com.srik.currencyexcahngeservices;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="CURRENCYEXCHANGEDETAILSRESPONSE")
public class CurrencyExchangeDetailsResponse {

	@Id
//	@GeneratedValue
	private int id;
	@Column(name="fromCurrency")
	private String fromCurrency;
	@Column(name="toCurrency")
	private String toCurrency;
	@Column(name="exchangeRates")
	private BigDecimal exchangeRates;
	
	
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
