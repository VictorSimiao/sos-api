package br.com.victorreis.sosapi.domain.service;

import br.com.victorreis.sosapi.domain.model.Cliente;
import br.com.victorreis.sosapi.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
