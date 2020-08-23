package com.microservices.limitservice.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.limitservice.bean.ConfigrationLimitProperties;
import com.microservices.limitservice.bean.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitConfigrationController {

	@Autowired
	private ConfigrationLimitProperties p;

	@GetMapping("/limits")
	public LimitConfiguration getLimitConfiguration() {
		return new LimitConfiguration(p.getMin(), p.getMax());
	}

	@GetMapping("/fault-tolerant-example")
	@HystrixCommand(fallbackMethod = "fallBackGetLimitConfigurationFault")
	public LimitConfiguration getLimitConfigurationFault() {
		throw new RuntimeException("no availbale");
	}

	public LimitConfiguration fallBackGetLimitConfigurationFault() {
		return new LimitConfiguration(7, 887);

	}
}
