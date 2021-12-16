package com.bcp.exchange.application.domains.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ExchangeResponse {
    Long id;
    String originCurrency;
    Double amount;
    String targetCurrency;
    Double amountExchanged;
    Double rate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginCurrency() {
        return originCurrency;
    }

    public void setOriginCurrency(String originCurrency) {
        this.originCurrency = originCurrency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public Double getAmountExchanged() {
        return amountExchanged;
    }

    public void setAmountExchanged(Double amountExchanged) {
        this.amountExchanged = amountExchanged;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
