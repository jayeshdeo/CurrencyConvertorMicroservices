package com.microservice.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.currencyconversionservice.bean.CurrencyConversionModel;
import com.microservice.currencyconversionservice.proxy.CurrencyExchangeFeignProxy;

@RestController
public class ConversionController {

	@Autowired
	Environment environment;

	@Autowired
	private CurrencyExchangeFeignProxy proxy;

	// private Logger logger;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionModel currencyConvert(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionModel> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange-service/from/{from}/to/{to}", CurrencyConversionModel.class,
				uriVariables);
		CurrencyConversionModel response = responseEntity.getBody();

		CurrencyConversionModel model = new CurrencyConversionModel(response.getId(),
				response.getConversionRate().multiply(quantity), from, to, response.getConversionRate(), quantity);

		// model.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		model.setPort(response.getPort());
		return model;
	}

	@GetMapping("/currency-feign-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionModel currencyConvertFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversionModel response = proxy.getCurrencyExchangeValue(from, to);

		CurrencyConversionModel model = new CurrencyConversionModel(response.getId(),
				response.getConversionRate().multiply(quantity), from, to, response.getConversionRate(), quantity);

		// model.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		model.setPort(response.getPort());
		// logger.info("{}", model);
		return model;
	}

}
