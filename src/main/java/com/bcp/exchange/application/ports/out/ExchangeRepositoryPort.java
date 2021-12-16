package com.bcp.exchange.application.ports.out;

import com.bcp.exchange.application.domains.requests.CreateExchangeRequest;
import com.bcp.exchange.application.domains.responses.ExchangeResponse;
import com.bcp.exchange.infrastructure.repository.entities.Exchange;
import io.reactivex.Single;
import org.springframework.web.bind.annotation.RequestBody;

public interface ExchangeRepositoryPort {
    public Single<Exchange> generateExchangeRate(String originCurrency, String targetCurrency);

    public Single<ExchangeResponse> createExchangeRate(@RequestBody CreateExchangeRequest createExchangeRequest);
}
