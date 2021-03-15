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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/ordens-servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<OrdemServicoResponse> criar(@Valid @RequestBody OrdemServicoInput input){
        OrdemServico novaOrdemServico = input.toModel(clienteRepository);
        ordemServicoService.salvar(novaOrdemServico);
        return ResponseEntity.status(HttpStatus.CREATED).body(new OrdemServicoResponse(novaOrdemServico));
    }


}
