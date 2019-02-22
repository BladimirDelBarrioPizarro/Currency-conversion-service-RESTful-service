package com.bladi.currencyconversionservice.controller;

import com.bladi.currencyconversionservice.model.CurrencyConversionBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public interface CurrencyConversionController{

    @GetMapping(path="/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity);

    @GetMapping(path="/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity);

}
