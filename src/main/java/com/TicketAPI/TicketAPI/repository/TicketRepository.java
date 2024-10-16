package com.TicketAPI.TicketAPI.repository;

import com.TicketAPI.TicketAPI.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByOrderByClienteNomeAscModuloNomeAsc();
}
