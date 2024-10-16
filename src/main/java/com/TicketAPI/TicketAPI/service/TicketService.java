package com.TicketAPI.TicketAPI.service;

import com.TicketAPI.TicketAPI.model.Ticket;
import com.TicketAPI.TicketAPI.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        super();
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAllByOrderByClienteNomeAscModuloNomeAsc();
    }

    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
