package com.srik.currencyexcahngeservices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrenyExchangeRepo extends JpaRepository<CurrencyExchangeDetailsResponse, Integer>{

	public CurrencyExchangeDetailsResponse findByFromCurrencyAndToCurrency(String fromCurrency,String toCurrency);
}
