package com.kassandra.restapi.controller;

import com.kassandra.repository.domain.ExchangeRate;
import com.kassandra.restapi.model.Response;
import com.kassandra.service.currency.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("ExchangeRateDbService")
    private ExchangeRateService exchangeRateService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{currency1}/{referenceCurrency}", params = {"date"}, method = RequestMethod.GET)
    public Response getExchangeRates(@PathVariable String currency1,
                                     @PathVariable String referenceCurrency,
                                     @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

        List<ExchangeRate> exchangeRatesByDate = exchangeRateService.getExchangeRatesByDate(currency1, referenceCurrency, date);
        return new Response(exchangeRatesByDate);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/{currency1}/{referenceCurrency}", params = {"startDate", "endDate"}, method = RequestMethod.GET)
    public Response getExchangeRatesBetweenDates(@PathVariable String currency1,
                                                 @PathVariable String referenceCurrency,
                                                 @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                 @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

        List<ExchangeRate> exchangeRatesByDate = exchangeRateService.getExchangeRatesBetweenDates(currency1, referenceCurrency, startDate, endDate);
        return new Response(exchangeRatesByDate);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value = "/{currency1}/{referenceCurrency}", params = {"year", "month"}, method = RequestMethod.GET)
    public Response getExchangeRatesByYearAndMonth(@PathVariable String currency1,
                                                   @PathVariable String referenceCurrency,
                                                   @RequestParam("year") Integer year,
                                                   @RequestParam("month") Integer month) {

        List<ExchangeRate> exchangeRatesByDate = exchangeRateService.getExchangeRatesByYearAndMonth(currency1, referenceCurrency, year, month);
        return new Response(exchangeRatesByDate);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value = "/{currency1}/{referenceCurrency}", params = {"monthBefore"}, method = RequestMethod.GET)
    public Response getLastExchangeRates(@PathVariable String currency1,
                                         @PathVariable String referenceCurrency,
                                         @RequestParam("monthBefore") Integer month) {


        List<ExchangeRate> lastNMonthExchangeRates = exchangeRateService.getLastNMonthExchangeRates(currency1, referenceCurrency, month);
        return new Response(lastNMonthExchangeRates);
    }
}
