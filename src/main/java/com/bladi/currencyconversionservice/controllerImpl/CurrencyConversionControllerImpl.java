package com.bladi.currencyconversionservice.controllerImpl;

import com.bladi.currencyconversionservice.controller.CurrencyConversionController;
import com.bladi.currencyconversionservice.feign.CurrencyExchangeServiceProxy;
import com.bladi.currencyconversionservice.model.CurrencyConversionBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConversionControllerImpl implements CurrencyConversionController {

    private static final Log logger = LogFactory.getLog(CurrencyConversionControllerImpl.class);
    CurrencyExchangeServiceProxy proxy;

    public CurrencyConversionControllerImpl(CurrencyExchangeServiceProxy proxy){
        this.proxy=proxy;

    }

    @Override
    public CurrencyConversionBean convertCurrency(String from, String to, BigDecimal quantity) {

        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        uriVariables.put("quantity", String.valueOf(quantity));

        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/api/currency-exchange/from/{from}/to/{to}",CurrencyConversionBean.class,uriVariables);
        CurrencyConversionBean response = responseEntity.getBody();
        logger.info(" -- GET /api/currency-converter "+responseEntity.getStatusCode());
        return new CurrencyConversionBean(response.getId(),from,to,response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());

    }

    @Override
    public CurrencyConversionBean convertCurrencyFeign(String from, String to, BigDecimal quantity) {

        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        uriVariables.put("quantity", String.valueOf(quantity));

        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/api/currency-exchange/from/{from}/to/{to}",CurrencyConversionBean.class,uriVariables);
        CurrencyConversionBean response = proxy.retrieveExchangeValue(from,to);


        logger.info(" -- GET /api/currency-converter "+responseEntity.getStatusCode());
        return new CurrencyConversionBean(response.getId(),from,to,response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());

    }


}


