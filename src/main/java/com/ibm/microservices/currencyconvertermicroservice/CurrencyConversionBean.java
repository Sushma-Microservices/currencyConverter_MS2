package com.ibm.microservices.currencyconvertermicroservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {

	private Long id;
	private String fromCtry;
	private String toCtry;
	private BigDecimal conversionFactor;
	private BigDecimal amount;
	private BigDecimal convertedAmount;
	private String port;
	
	public String getPort() {
		return port;
	}


	public void setPort(String port) {
		this.port = port;
	}


	public CurrencyConversionBean()
	{
		
	}
	
	
	public Long getId() {
		return id;
	}

	public CurrencyConversionBean(Long id, String fromCtry, String toCtry, BigDecimal conversionFactor,
			BigDecimal amount, BigDecimal convertedAmount, String port) {
		super();
		this.id = id;
		this.fromCtry = fromCtry;
		this.toCtry = toCtry;
		this.conversionFactor = conversionFactor;
		this.amount = amount;
		this.convertedAmount = convertedAmount;
		this.port = port;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getFromCtry() {
		return fromCtry;
	}

	public void setFromCtry(String fromCtry) {
		this.fromCtry = fromCtry;
	}

	public String getToCtry() {
		return toCtry;
	}

	public void setToCtry(String toCtry) {
		this.toCtry = toCtry;
	}

	public BigDecimal getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(BigDecimal conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(BigDecimal convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

	
	
	
	
}
