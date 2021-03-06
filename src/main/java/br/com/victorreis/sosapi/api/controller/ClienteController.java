package br.com.victorreis.sosapi.api.controller;

import br.com.victorreis.sosapi.api.dto.request.ClienteAtualizaInput;
import br.com.victorreis.sosapi.api.dto.request.ClienteInput;
import br.com.victorreis.sosapi.api.dto.response.ClienteResponse;
import br.com.victorreis.sosapi.domain.model.Cliente;
import br.com.victorreis.sosapi.domain.repository.ClienteRepository;
import br.com.victorreis.sosapi.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        clienteService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> atualizar(@PathVariable Long id, @Valid @RequestBody ClienteAtualizaInput input) {
        Cliente clienteAtualizado = clienteService.atualizar(id, input);
        return ResponseEntity.ok(new ClienteResponse(clienteAtualizado));
    }

}
