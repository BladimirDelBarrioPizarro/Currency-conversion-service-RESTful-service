package com.bladi.currencyconversionservice.controllerImpl;

import com.bladi.currencyconversionservice.controller.CurrencyConversionController;
import com.bladi.currencyconversionservice.model.CurrencyConversionBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public class CurrencyConversionControllerImpl implements CurrencyConversionController {

    @Override
    public ResponseEntity<CurrencyConversionBean> convertCurrency(String from, String to, BigDecimal quantity) {
        CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean(1L,from,to,BigDecimal.ONE,BigDecimal.ONE,quantity,0);
        return new ResponseEntity<>(currencyConversionBean,HttpStatus.OK);
    }
}
