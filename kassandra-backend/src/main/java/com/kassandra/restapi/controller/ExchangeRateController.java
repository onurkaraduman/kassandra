package com.kassandra.restapi.controller;

import com.kassandra.repository.domain.ExchangeRate;
import com.kassandra.restapi.model.Response;
import com.kassandra.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Onur Karaduman
 * @since 15.07.17
 */
@RestController
@RequestMapping("/exchangerate")
public class ExchangeRateController implements Controller {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @RequestMapping(value = "/{currency1}/{referenceCurrency}", method = RequestMethod.GET)
    public Response getExchangeRates(@PathVariable String currency1,
                                     @PathVariable String referenceCurrency,
                                     @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

        List<ExchangeRate> exchangeRatesByDate = exchangeRateService.getExchangeRatesByDate(currency1, referenceCurrency, date);
        return new Response(exchangeRatesByDate);
    }
}
