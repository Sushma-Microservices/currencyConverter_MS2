package com.ibm.microservices.currencyconvertermicroservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CurrencyConversionController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public ConversionFactorProxy proxy;
	
	/*@GetMapping("/currency-converter/fromCtry/{fromCtry}/toCtry/{toCtry}/amount/{amount}")
	public CurrencyConversionBean convertCurrency(@PathVariable String fromCtry,@PathVariable String toCtry,@PathVariable BigDecimal amount)
	{
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("fromCtry", fromCtry);
		uriVariables.put("toCtry", toCtry);
		
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/cf/from/{fromCtry}/to/{toCtry}", 
				CurrencyConversionBean.class, 
				uriVariables);
		CurrencyConversionBean response = responseEntity.getBody();
	
		logger.info("response -->{}",response.toString());
		return new CurrencyConversionBean(response.getId(),fromCtry,toCtry,response.getConversionFactor(),amount,amount.multiply(response.getConversionFactor()));
	}*/
	
	
	
	//With Feign
	@GetMapping("/currency-converter/fromCtry/{fromCtry}/toCtry/{toCtry}/amount/{amount}")
	@HystrixCommand(fallbackMethod="sendFallbackValue")
	public CurrencyConversionBean convertCurrency(@PathVariable String fromCtry,@PathVariable String toCtry,@PathVariable BigDecimal amount)
	{
		CurrencyConversionBean response = proxy.retrieveConversionfactor(fromCtry, toCtry);
	
		logger.info("response -->{}",response.toString());
		return new CurrencyConversionBean(response.getId(),fromCtry,toCtry,response.getConversionFactor(),amount,amount.multiply(response.getConversionFactor()),response.getPort());
	}
	
	public CurrencyConversionBean sendFallbackValue(@PathVariable String fromCtry,@PathVariable String toCtry,@PathVariable BigDecimal amount)
	{
		
		return new CurrencyConversionBean(9L,fromCtry,toCtry,new BigDecimal("65"),amount,new BigDecimal("5000"),"fallback");
	}
	
	
	
	
}
