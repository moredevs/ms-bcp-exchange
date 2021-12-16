package com.bcp.exchange.application.services;

import com.bcp.exchange.application.domains.requests.CreateExchangeRequest;
import com.bcp.exchange.application.domains.requests.ExchangeRequest;
import com.bcp.exchange.application.domains.responses.ConvertExchangeResponse;
import com.bcp.exchange.application.domains.responses.ExchangeResponse;
import com.bcp.exchange.application.ports.in.CalculateExchange;
import com.bcp.exchange.application.ports.in.CreateExchange;
import com.bcp.exchange.application.ports.out.ExchangeRepositoryPort;
import io.reactivex.Single;

public class ExchangeService implements CalculateExchange, CreateExchange {
    private final ExchangeRepositoryPort exchangeRepositoryPort;

    public ExchangeService(ExchangeRepositoryPort exchangeRepositoryPort) {
        this.exchangeRepositoryPort = exchangeRepositoryPort;
    }
    @Override
    public Single<ConvertExchangeResponse> convertExchangeRate(ExchangeRequest exchangeRequest) {
        return exchangeRepositoryPort
                .generateExchangeRate(exchangeRequest.getOriginCurrency(),exchangeRequest.getTargetCurrency())
                .map(exchangeRate -> exchangeRate.convertExchange(exchangeRequest.getAmount()));
    }


    @Override
    public Single<ExchangeResponse> createExchangeRate(CreateExchangeRequest createExchangeRequest) {
        return exchangeRepositoryPort.createExchangeRate(createExchangeRequest);
    }
}
