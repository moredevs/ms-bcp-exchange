package com.bcp.exchange.infrastructure.web;

import com.bcp.exchange.application.domains.requests.CreateExchangeRequest;
import com.bcp.exchange.application.domains.requests.ExchangeRequest;
import com.bcp.exchange.application.domains.responses.ConvertExchangeResponse;
import com.bcp.exchange.application.domains.responses.ExchangeResponse;
import com.bcp.exchange.application.ports.in.CalculateExchange;
import com.bcp.exchange.application.ports.in.CreateExchange;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ExchangeController {

    private final CalculateExchange calculateExchange;

    private final CreateExchange createExchange;

    @Autowired
    AuthenticationManager authenticationManager;

    public ExchangeController(CalculateExchange calculateExchange, CreateExchange createExchange){
        this.calculateExchange = calculateExchange;
        this.createExchange = createExchange;
    }

    @PostMapping("/convert")
    public Single<ConvertExchangeResponse> convertExchangeRate(@RequestBody ExchangeRequest request) {
        return calculateExchange.convertExchangeRate(request);
    }

    @RequestMapping
    public Single<ExchangeResponse> createExchangeRate(@RequestBody CreateExchangeRequest request) {
        return createExchange.createExchangeRate(request);
    }


}
