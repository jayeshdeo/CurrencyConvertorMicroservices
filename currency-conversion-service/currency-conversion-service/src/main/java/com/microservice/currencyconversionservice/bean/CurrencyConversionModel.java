package com.microservice.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversionModel {

	private int id;
	private BigDecimal totalCalculation;
	private String from;
	private String to;
	private BigDecimal conversionRate;
	private BigDecimal quantity;
	private int port;

	public CurrencyConversionModel() {
		super();
	}

	public CurrencyConversionModel(int id, BigDecimal totalCalculation, String from, String to,
			BigDecimal conversionRate, BigDecimal quantity) {
		super();
		this.id = id;
		this.totalCalculation = totalCalculation;
		this.from = from;
		this.to = to;
		this.conversionRate = conversionRate;
		this.quantity = quantity;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getTotalCalculation() {
		return totalCalculation;
	}

	public void setTotalCalculation(BigDecimal totalCalculation) {
		this.totalCalculation = totalCalculation;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}
