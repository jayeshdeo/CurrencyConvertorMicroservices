package com.microservices.currencyexchangeservice.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class CurrencyExchangeModel {
	@Id
	private int id;
	@Column(name = "from_currency")
	private String from;
	@Column(name = "to_currency")
	private String to;
	@Column
	private BigDecimal conversionRate;
	@Column
	private int port;

	public CurrencyExchangeModel() {
		super();
	}

	public CurrencyExchangeModel(int id, String from, String to, BigDecimal conversionRate) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionRate = conversionRate;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "CurrencyExchangeModel [id=" + id + ", from=" + from + ", to=" + to + ", conversionRate="
				+ conversionRate + ", port=" + port + "]";
	}

}
