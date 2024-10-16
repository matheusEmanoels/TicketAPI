package com.TicketAPI.TicketAPI;

import com.TicketAPI.TicketAPI.model.Cliente;
import com.TicketAPI.TicketAPI.model.Modulo;
import com.TicketAPI.TicketAPI.model.Ticket;
import com.TicketAPI.TicketAPI.repository.ClienteRepository;
import com.TicketAPI.TicketAPI.repository.ModuloRepository;
import com.TicketAPI.TicketAPI.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class TicketControllerTests {
    private static final String API_TICKETS = "/tickets";


    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    private ModuloRepository moduloRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void postTicket_whenUserIsValid_receiveOk() {
        Ticket ticket = createTicket();

        ResponseEntity<Object> response = testRestTemplate.postForEntity(API_TICKETS, ticket, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


    private Ticket createTicket() {
        Modulo modulo = new Modulo();
        modulo.setId(1);
        modulo.setNome("Modulo 1");

        moduloRepository.save(modulo);

        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNome("Cliente 1");

        clienteRepository.save(cliente);

        Ticket ticket = new Ticket();
        ticket.setModulo(modulo);
        ticket.setCliente(cliente);
        ticket.setDescricao("Testes Unitarios");

        return ticket;

    }
}
