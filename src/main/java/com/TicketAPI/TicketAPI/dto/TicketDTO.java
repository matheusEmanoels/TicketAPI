package com.TicketAPI.TicketAPI.dto;

import com.TicketAPI.TicketAPI.model.Ticket;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {

    private long id;

    @NotNull
    private long clienteId;

    @NotNull
    private long moduloId;

    @NotNull
    private String descricao;

    @NotNull
    private LocalDate dataAbertura;

    private LocalDate dataFechamento;

    private TicketDTO(Ticket ticket) {
        this.id = ticket.getId();
        this.clienteId = ticket.getCliente().getId();
        this.moduloId = ticket.getModulo().getId();
        this.descricao = ticket.getDescricao();
        this.dataAbertura = ticket.getDataAbertura();
        this.dataFechamento = ticket.getDataFechamento();
    }
}
