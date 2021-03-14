package br.com.victorreis.sosapi.api.controller;

import br.com.victorreis.sosapi.api.dto.request.ClienteInput;
import br.com.victorreis.sosapi.api.dto.response.ClienteResponse;
import br.com.victorreis.sosapi.domain.model.Cliente;
import br.com.victorreis.sosapi.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponse> adicionar(@Valid @RequestBody ClienteInput clienteInput) {
        Cliente novoCliente = clienteInput.toModel();
        clienteService.salvar(novoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ClienteResponse(novoCliente));
    }
}
