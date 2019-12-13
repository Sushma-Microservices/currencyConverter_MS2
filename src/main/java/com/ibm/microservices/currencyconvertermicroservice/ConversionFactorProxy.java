package com.ibm.microservices.currencyconvertermicroservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-conversion-factor-service",url="localhost:8000")

@FeignClient(name="currency-conversion-factor-service")
@RibbonClient(name="currency-conversion-factor-service")
public interface ConversionFactorProxy {
	@GetMapping("/cf/from/{fromCtry}/to/{toCtry}")
	public CurrencyConversionBean retrieveConversionfactor(@PathVariable("fromCtry") String fromCtry,@PathVariable("toCtry") String toCtry);
}
