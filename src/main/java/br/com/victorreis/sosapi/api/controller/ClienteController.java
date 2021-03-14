package br.com.victorreis.sosapi.api.controller;

import br.com.victorreis.sosapi.api.dto.request.ClienteInput;
import br.com.victorreis.sosapi.api.dto.response.ClienteResponse;
import br.com.victorreis.sosapi.domain.model.Cliente;
import br.com.victorreis.sosapi.domain.repository.ClienteRepository;
import br.com.victorreis.sosapi.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<ClienteResponse> adicionar(@Valid @RequestBody ClienteInput clienteInput) {
        Cliente novoCliente = clienteInput.toModel();
        clienteService.salvar(novoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ClienteResponse(novoCliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listar() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(ClienteResponse.toCollection(clientes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscar(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarOuFalhar(id);
        return ResponseEntity.ok(new ClienteResponse(cliente));
    }
}
