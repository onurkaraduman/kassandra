package com.kassandra.service.currency;

import com.kassandra.repository.CurrencyRepository;
import com.kassandra.repository.ExchangeRateRepository;
import com.kassandra.repository.Repository;
import com.kassandra.repository.domain.Currency;
import com.kassandra.repository.domain.ExchangeRate;
import com.kassandra.service.AbstractService;
import com.kassandra.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Onur Karaduman
 * @since 15.07.17
 */
@Service("ExchangeRateDbService")
public class ExchangeRateDbService extends AbstractService<ExchangeRate> implements ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public Repository getRepository() {
        return this.exchangeRateRepository;
    }

    @Override
    public List<ExchangeRate> getExchangeRatesByDate(String currency,
                                                     String referenceCurrency,
                                                     Date date) {
        Currency requestedCurrency = currencyRepository.findByName(currency);
        Currency requestedRefCurrency = currencyRepository.findByName(referenceCurrency);
        return this.exchangeRateRepository.findByCurrencyAndReferenceCurrencyAndDate(requestedCurrency, requestedRefCurrency, date);
    }

    @Override
    public List<ExchangeRate> getExchangeRatesBetweenDates(String currency,
                                                           String referenceCurrency,
                                                           Date startDate,
                                                           Date endDate) {
        Currency requestedCurrency = currencyRepository.findByName(currency);
        Currency requestedRefCurrency = currencyRepository.findByName(referenceCurrency);
        return this.exchangeRateRepository.findByCurrencyAndReferenceCurrencyAndDateBetween(requestedCurrency,
                requestedRefCurrency,
                startDate,
                endDate);
    }

    @Override
    public List<ExchangeRate> getExchangeRatesByYearAndMonth(String currency,
                                                             String referenceCurrency,
                                                             Integer year,
                                                             Integer month) {
        Currency requestedCurrency = currencyRepository.findByName(currency);
        Currency requestedRefCurrency = currencyRepository.findByName(referenceCurrency);
        Date firstDayOfMonth = DateUtil.getFirstDayOfMonth(year, month);
        Date lastDayOfMonth = DateUtil.getLastDayOfMonth(year, month);

        return this.exchangeRateRepository.findByCurrencyAndReferenceCurrencyAndDateBetween(requestedCurrency,
                requestedRefCurrency,
                firstDayOfMonth,
                lastDayOfMonth);
    }

    @Override
    public List<ExchangeRate> getLastNMonthExchangeRates(String currency,
                                                         String referenceCurrency,
                                                         Integer monthBefore) {
        Currency requestedCurrency = currencyRepository.findByName(currency);
        Currency requestedRefCurrency = currencyRepository.findByName(referenceCurrency);
        Date firstDayOfMonth = DateUtil.getNMonthAgo(monthBefore);
        Date now = DateUtil.getNow();

        return this.exchangeRateRepository.findByCurrencyAndReferenceCurrencyAndDateBetween(requestedCurrency,
                requestedRefCurrency,
                firstDayOfMonth,
                now);
    }

    @Override
    public Date getLastUpdateDate() {
        return this.exchangeRateRepository.getLastUpdateDate();
    }

    @Override
    public void saveExchangeRate(String refCurrencyName, Map<String, Object> currencyMap, Date date) {
        Currency refCurrency = currencyRepository.findByName(refCurrencyName);
        if (refCurrency == null) {
            refCurrency = new Currency();
            refCurrency.setName(refCurrencyName);
        }
        for (Map.Entry<String, Object> cur : currencyMap.entrySet()) {
            Currency currency = currencyRepository.findByName(cur.getKey());
            if (currency == null) {
                currency = new Currency();
                currency.setName(cur.getKey());
            }
            ExchangeRate exchangeRate = new ExchangeRate();
            exchangeRate.setCurrency(currency);
            exchangeRate.setReferenceCurrency(refCurrency);
            exchangeRate.setDate(date);
            exchangeRate.setValue((Double) cur.getValue());
            this.exchangeRateRepository.save(exchangeRate);
        }
    }
}
