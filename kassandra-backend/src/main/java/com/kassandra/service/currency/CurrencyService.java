package com.kassandra.service.currency;

import com.kassandra.repository.CurrencyRepository;
import com.kassandra.repository.Repository;
import com.kassandra.repository.domain.Currency;
import com.kassandra.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Onur Karaduman
 * @since 15.07.17
 */
@Service
public class CurrencyService extends AbstractService<Currency> {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public Repository getRepository() {
        return this.currencyRepository;
    }

    public void saveCurrencies(List<String> currencies) {
        for (String currency : currencies) {
            Currency cur = new Currency();
            cur.setName(currency);
            try {
                currencyRepository.save(cur);
            } catch (Exception exception) {
                continue;
            }
        }
    }
}
