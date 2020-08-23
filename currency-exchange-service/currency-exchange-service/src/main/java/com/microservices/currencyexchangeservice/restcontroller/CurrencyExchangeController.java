package com.microservices.currencyexchangeservice.restcontroller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currencyexchangeservice.bean.CurrencyExchangeModel;
import com.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	Environment environment;

	@Autowired
	private CurrencyExchangeRepository curRepository;

	// private Logger logger;

	@GetMapping("/currency-exchange-service/from/{from}/to/{to}")
	public CurrencyExchangeModel getCurnecyExchange(@PathVariable String from, @PathVariable String to) {
		CurrencyExchangeModel model = curRepository.findByFromAndTo(from, to);
		model.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
//		logger.info("{}", model);
		return model;
	}

}
