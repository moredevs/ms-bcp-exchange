package com.bcp.exchange.adapters.persistance;

import com.bcp.exchange.adapters.mapper.ExchangeMapper;
import com.bcp.exchange.application.domains.requests.CreateExchangeRequest;
import com.bcp.exchange.application.domains.responses.ExchangeResponse;
import com.bcp.exchange.application.ports.out.ExchangeRepositoryPort;
import com.bcp.exchange.infrastructure.repository.ExchangeRepository;
import com.bcp.exchange.infrastructure.repository.entities.Exchange;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Component
public class ExchangeRepositoryImpl implements ExchangeRepositoryPort {

    @Autowired
    private ExchangeRepository exchangeRepository;


    @Override
    public Single<Exchange> generateExchangeRate(String originCurrency, String targetCurrency) {
        return Single.create(singleEmitter -> {
            Optional<Exchange> exchangeRate = exchangeRepository.findByOriginCurrencyAndTargetCurrency(originCurrency, targetCurrency);
            exchangeRate.ifPresentOrElse(singleEmitter::onSuccess, () -> {
                singleEmitter.onError(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Exchange Rate not found"));
            });
        });
    }

    @Override
    public Single<ExchangeResponse> createExchangeRate(CreateExchangeRequest createExchangeRequest) {
        return Single.create(singleEmitter -> {
            Optional<Exchange> exchangeRate = exchangeRepository.findByOriginCurrencyAndTargetCurrency(createExchangeRequest.getOriginCurrency(), createExchangeRequest.getTargetCurrency());
            if (exchangeRate.isPresent()) {
                singleEmitter.onError(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Exchange Rate exist"));
            }else {
                Exchange exchange = exchangeRepository.save(ExchangeMapper.INSTANCE.createExchangeRequestToExchange(createExchangeRequest));
                singleEmitter.onSuccess(ExchangeMapper.INSTANCE.exchangeToExchangeResponse(exchange));
            }
        });
    }

}
