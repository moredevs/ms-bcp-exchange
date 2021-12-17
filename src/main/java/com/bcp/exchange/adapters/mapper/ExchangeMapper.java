package com.bcp.exchange.adapters.mapper;

import com.bcp.exchange.application.domains.requests.CreateExchangeRequest;
import com.bcp.exchange.application.domains.responses.ExchangeResponse;
import com.bcp.exchange.infrastructure.repository.entities.Exchange;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.userdetails.User;

import java.util.Objects;


@Mapper
public interface ExchangeMapper {

    ExchangeMapper INSTANCE = Mappers.getMapper( ExchangeMapper.class );

    Exchange createExchangeRequestToExchange(CreateExchangeRequest limit);

    ExchangeResponse exchangeToExchangeResponse(Exchange exchange);

}
