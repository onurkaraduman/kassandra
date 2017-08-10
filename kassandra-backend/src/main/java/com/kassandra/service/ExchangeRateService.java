package com.kassandra.service;

import com.kassandra.repository.CurrencyRepository;
import com.kassandra.repository.ExchangeRateRepository;
import com.kassandra.repository.Repository;
import com.kassandra.repository.domain.Currency;
import com.kassandra.repository.domain.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Onur Karaduman
 * @since 15.07.17
 */
@Service
public class ExchangeRateService extends AbstractService<ExchangeRate> {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public Repository getRepository() {
        return this.exchangeRateRepository;
    }

    public List<ExchangeRate> getExchangeRatesByDate(String currency,
                                                     String referenceCurrency,
                                                     Date date) {
        Currency requestedCurrency = currencyRepository.findByName(currency);
        Currency requestedRefCurrency = currencyRepository.findByName(referenceCurrency);
        return this.exchangeRateRepository.findByCurrencyAndReferenceCurrencyAndDate(requestedCurrency, requestedRefCurrency, date);
    }

    public Date getLastUpdateDate() {
        return this.exchangeRateRepository.getLastUpdateDate();
    }

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
