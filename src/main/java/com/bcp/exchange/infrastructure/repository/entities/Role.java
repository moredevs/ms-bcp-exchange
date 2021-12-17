package com.bcp.exchange.infrastructure.repository.entities;

import com.bcp.exchange.adapters.persistance.enums.RolEnum;
import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

}
