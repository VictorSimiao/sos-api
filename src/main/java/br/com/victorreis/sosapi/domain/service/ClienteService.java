package br.com.victorreis.sosapi.domain.service;

import br.com.victorreis.sosapi.api.dto.request.ClienteAtualizaInput;
import br.com.victorreis.sosapi.domain.exception.ClienteNaoEncontradoException;
import br.com.victorreis.sosapi.domain.exception.EntidadeEmUsoException;
import br.com.victorreis.sosapi.domain.model.Cliente;
import br.com.victorreis.sosapi.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }


    public Cliente buscarOuFalhar(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException(id));
    }

    public void excluir(Long id) {
        try {
            clienteRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ClienteNaoEncontradoException(id);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Cliente de código %d não pode ser removido, pois está em uso", id));
        }
    }

    @Transactional
    public Cliente atualizar(Long id, ClienteAtualizaInput cliente) {
        Cliente clienteDB = buscarOuFalhar(id);
        clienteDB.setNome(cliente.getNome());
        clienteDB.setTelefone(cliente.getTelefone());
        return clienteDB;
    }
}
