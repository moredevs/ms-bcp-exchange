package com.bcp.exchange.application.ports.in;

import com.bcp.exchange.application.domains.requests.ExchangeRequest;
import com.bcp.exchange.application.domains.responses.ConvertExchangeResponse;
import io.reactivex.Single;

public interface CalculateExchange {
    Single<ConvertExchangeResponse> convertExchangeRate(ExchangeRequest exchangeRequest);
}
