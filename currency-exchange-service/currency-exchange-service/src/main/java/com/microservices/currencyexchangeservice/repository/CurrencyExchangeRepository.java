package com.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.currencyexchangeservice.bean.CurrencyExchangeModel;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeModel, Integer> {

	CurrencyExchangeModel findByFromAndTo(String from, String to);
}
