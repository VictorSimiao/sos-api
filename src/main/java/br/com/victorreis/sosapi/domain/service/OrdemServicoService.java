package br.com.victorreis.sosapi.domain.service;

import br.com.victorreis.sosapi.domain.exception.OrdemServicoNaoEncontradaException;
import br.com.victorreis.sosapi.domain.model.OrdemServico;
import br.com.victorreis.sosapi.domain.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;


    public OrdemServico salvar(OrdemServico ordemServico) {
        return ordemServicoRepository.save(ordemServico);
    }

    public OrdemServico buscarOuFalhar(Long id){
        return ordemServicoRepository.findById(id).orElseThrow(() -> new OrdemServicoNaoEncontradaException(id));
    }

}
