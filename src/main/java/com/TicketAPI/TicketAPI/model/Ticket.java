package com.TicketAPI.TicketAPI.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class Ticket {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "clienteId", nullable = false)
    private Cliente cliente;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "moduloId", nullable = false)
    private Modulo modulo;

    @NotNull
    private String descricao;

    @NotNull
    private LocalDate dataAbertura;

    @Nullable
    private LocalDate dataFechamento;
}
