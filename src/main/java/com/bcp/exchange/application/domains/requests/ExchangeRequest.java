package com.bcp.exchange.application.domains.requests;


public class ExchangeRequest {
    String originCurrency;
    String targetCurrency;
    Double amount;

    public String getOriginCurrency() {
        return originCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public Double getAmount() {
        return amount;
    }
}
