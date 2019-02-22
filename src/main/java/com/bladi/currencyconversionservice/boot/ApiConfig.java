package com.bladi.currencyconversionservice.boot;

import com.bladi.currencyconversionservice.controller.CurrencyConversionController;
import com.bladi.currencyconversionservice.controllerImpl.CurrencyConversionControllerImpl;
import com.bladi.currencyconversionservice.feign.CurrencyExchangeServiceProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public CurrencyConversionController currencyConversionController(CurrencyExchangeServiceProxy CurrencyExchangeServiceProxy){return new CurrencyConversionControllerImpl(CurrencyExchangeServiceProxy);}

}
