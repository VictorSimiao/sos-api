package br.com.victorreis.sosapi.api.controller;

import br.com.victorreis.sosapi.api.dto.request.OrdemServicoInput;
import br.com.victorreis.sosapi.api.dto.response.OrdemServicoResponse;
import br.com.victorreis.sosapi.domain.model.OrdemServico;
import br.com.victorreis.sosapi.domain.repository.ClienteRepository;
import br.com.victorreis.sosapi.domain.repository.OrdemServicoRepository;
import br.com.victorreis.sosapi.domain.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ordens-servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<OrdemServicoResponse> criar(@Valid @RequestBody OrdemServicoInput input) {
        OrdemServico novaOrdemServico = input.toModel(clienteRepository);
        ordemServicoService.salvar(novaOrdemServico);
        return ResponseEntity.status(HttpStatus.CREATED).body(new OrdemServicoResponse(novaOrdemServico));
    }

    @GetMapping
    public ResponseEntity<List<OrdemServicoResponse>> listar() {
        List<OrdemServico> ordemServicos = ordemServicoRepository.findAll();
        return ResponseEntity.ok(OrdemServicoResponse.toCollection(ordemServicos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemServicoResponse> buscar(@PathVariable Long id){
        OrdemServico ordemServico = ordemServicoService.buscarOuFalhar(id);
        return ResponseEntity.ok(new OrdemServicoResponse(ordemServico));
    }

    @PutMapping("/{id}/finalizacao")
    public ResponseEntity<OrdemServicoResponse> finalizar(@PathVariable Long id){
        OrdemServico ordemServico = ordemServicoService.finalizar(id);
        return ResponseEntity.ok(new OrdemServicoResponse(ordemServico));
    }

}
