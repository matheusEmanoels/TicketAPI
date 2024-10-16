package com.TicketAPI.TicketAPI.repository;

import com.TicketAPI.TicketAPI.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findById(long id);
}
