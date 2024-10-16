package com.TicketAPI.TicketAPI.repository;

import com.TicketAPI.TicketAPI.model.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuloRepository extends JpaRepository<Modulo, Long> {
    Modulo findById(long id);
}
