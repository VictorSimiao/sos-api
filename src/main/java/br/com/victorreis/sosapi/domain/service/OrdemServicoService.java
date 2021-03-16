package br.com.victorreis.sosapi.domain.service;

import br.com.victorreis.sosapi.domain.exception.OrdemServicoNaoEncontradaException;
import br.com.victorreis.sosapi.domain.model.OrdemServico;
import br.com.victorreis.sosapi.domain.model.StatusOrdemServico;
import br.com.victorreis.sosapi.domain.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;


    public OrdemServico salvar(OrdemServico ordemServico) {
        return ordemServicoRepository.save(ordemServico);
    }

    @Transactional
    public OrdemServico finalizar(Long id){
        OrdemServico ordemServicoDB = buscarOuFalhar(id);
        ordemServicoDB.setStatus(StatusOrdemServico.FINALIZADA);
        ordemServicoDB.setDataFinalizacao(LocalDateTime.now());
        return ordemServicoDB;
    }
    public OrdemServico buscarOuFalhar(Long id){
        return ordemServicoRepository.findById(id).orElseThrow(() -> new OrdemServicoNaoEncontradaException(id));
    }




}
