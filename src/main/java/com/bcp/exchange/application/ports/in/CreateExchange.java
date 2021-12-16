package com.bcp.exchange.application.ports.in;

import com.bcp.exchange.application.domains.requests.CreateExchangeRequest;
import com.bcp.exchange.application.domains.responses.ConvertExchangeResponse;
import com.bcp.exchange.application.domains.responses.ExchangeResponse;
import io.reactivex.Single;

public interface CreateExchange {
    Single<ExchangeResponse> createExchangeRate(CreateExchangeRequest createExchangeRequest);
}
