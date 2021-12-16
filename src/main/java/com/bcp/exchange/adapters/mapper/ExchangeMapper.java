package com.bcp.exchange.adapters.mapper;

import com.bcp.exchange.application.domains.requests.CreateExchangeRequest;
import com.bcp.exchange.application.domains.responses.ExchangeResponse;
import com.bcp.exchange.infrastructure.repository.entities.Exchange;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ExchangeMapper {

    ExchangeMapper INSTANCE = Mappers.getMapper( ExchangeMapper.class );

    Exchange createExchangeRequestToExchange(CreateExchangeRequest limit);

    ExchangeResponse ExchangeToExchangeReponse(Exchange exchange);

}
