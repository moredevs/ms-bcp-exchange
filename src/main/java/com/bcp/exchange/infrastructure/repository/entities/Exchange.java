package com.bcp.exchange.infrastructure.repository.entities;

import com.bcp.exchange.application.domains.responses.ConvertExchangeResponse;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "exchanges")
public class Exchange {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "originCurrency", nullable = false)
    String originCurrency;
    @Column(name = "targetCurrency", nullable = false)
    String targetCurrency;
    @Column(name = "rate", nullable = false)
    Double rate;


    public ConvertExchangeResponse convertExchange(Double amount){
        return new ConvertExchangeResponse(
                amount,
                this.originCurrency,
                this.targetCurrency,
                amount*this.rate,
                this.rate
        );
    }
}
