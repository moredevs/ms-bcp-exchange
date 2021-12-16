package com.bcp.exchange.application.domains.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ConvertExchangeResponse {
    String originCurrency;
    Double amount;
    String targetCurrency;
    Double amountExchanged;
    Double rate;

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

    public ConvertExchangeResponse(Double amount, String originCurrency, String targetCurrency, Double amountExchanged, Double rate) {
        this.amount = amount;
        this.originCurrency = originCurrency;
        this.targetCurrency = targetCurrency;
        this.amountExchanged = amountExchanged;
        this.rate = rate;
    }
}
