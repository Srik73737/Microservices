package com.srik.currencycaluculationservices;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/*
 * 1] without ribbon
 * 
 * spring application name of calling micro and server url are 2 paramtres to be passed
 * the abstract method is just definiton of the called micro
 * when feign is used if url has path variable then the path variable name needs to be defined explicitly since
 * feign doesnt take method variables automatically
 * ex: @pathVariable("userId") String userId
 * 
 * Cons : url is hardcoded below which wont be handy for dynamic load balancing scenarios
 *        to over come this we use ribbon along with Feign
 *        ex: @FeignClient(name="currency-excahnge-service",url="http://localhost:8100")
 */

/*
@FeignClient(name="currency-excahnge-service",url="http://localhost:8100")
public interface CurrencyExchangeSvcProxy {

	@PostMapping("/currency/exchangerates")
	public CurrencyExchangeDetailsResponse getCurrencyExchangeRates(@RequestBody CurrencyExchangeRateRequest request);
	
}
*/


/*
 * 2] with ribbon 
 * no url is required in this case ribbon wil handle automatically
 * by using configuration class refered below where instances are registerd
 */
@RibbonClient(name="currency-excahnge-service" ,configuration = LocalRibbonClientConfiguration.class)
@FeignClient(name="currency-excahnge-service")
public interface CurrencyExchangeSvcProxy {

	@PostMapping("/currency/exchangerates")
	public CurrencyExchangeDetailsResponse getCurrencyExchangeRates(@RequestBody CurrencyExchangeRateRequest request);
	
}
