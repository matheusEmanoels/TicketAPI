package com.TicketAPI.TicketAPI.controller;

import com.TicketAPI.TicketAPI.service.TicketService;
import com.TicketAPI.TicketAPI.dto.TicketDTO;
import com.TicketAPI.TicketAPI.model.Ticket;
import com.TicketAPI.TicketAPI.shared.GenericResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    private final ModelMapper modelMapper;

    public TicketController(ModelMapper modelMapper, TicketService ticketService) {
        this.modelMapper = modelMapper;
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PostMapping
    public ResponseEntity<GenericResponse> createTicket(@RequestBody TicketDTO ticketDTO){
        Ticket ticketEntity = modelMapper.map(ticketDTO, Ticket.class);
        ticketService.save(ticketEntity);
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setMessage("Ticket saved successfully");
        return ResponseEntity.ok(genericResponse);
    }
}
