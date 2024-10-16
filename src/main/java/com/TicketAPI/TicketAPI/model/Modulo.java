package com.TicketAPI.TicketAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Modulo {

    @Id
    @GeneratedValue
    private long id;
    private String nome;
}
