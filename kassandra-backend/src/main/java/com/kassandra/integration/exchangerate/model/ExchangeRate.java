
package com.kassandra.integration.exchangerate.model;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRate {

    private String base;
    private String date;
    private Map<String, Object> rates = new HashMap<String, Object>();
    //    private Rates rates;
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

//    public Rates getRates() {
//        return rates;
//    }
//
//    public void setRates(Rates rates) {
//        this.rates = rates;
//    }

    public Map<String, Object> getRates() {
        return this.rates;
    }

    public void setRates(String name, Object value) {
        this.rates.put(name, value);
    }

}
