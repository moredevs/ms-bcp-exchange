package com.bcp.exchange.infrastructure.repository.entities;

import com.bcp.exchange.adapters.persistance.enums.RolEnum;
import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "role")
public class Role   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private RolEnum name;

}
