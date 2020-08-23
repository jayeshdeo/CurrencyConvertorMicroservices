package com.microservice.currencyconversionservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.currencyconversionservice.bean.CurrencyConversionModel;

//@FeignClient(name = "currency-exchange-service", url="localhost:8000")
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "zuul-api-gateway")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeFeignProxy {
	
	//@GetMapping("/currency-exchange-service/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange-service/from/{from}/to/{to}")
	public CurrencyConversionModel getCurrencyExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to);

}
