package br.com.victorreis.sosapi.api.dto.request;

import br.com.victorreis.sosapi.domain.exception.ClienteNaoEncontradoException;
import br.com.victorreis.sosapi.domain.model.Cliente;
import br.com.victorreis.sosapi.domain.model.OrdemServico;
import br.com.victorreis.sosapi.domain.model.StatusOrdemServico;
import br.com.victorreis.sosapi.domain.repository.ClienteRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrdemServicoInput {

    @NotNull
    private Long clienteId;

    @NotBlank
    private String descricao;

    @NotNull
    @Positive
    private BigDecimal preco;

    public OrdemServicoInput(@NotNull Long clienteId, @NotBlank String descricao, @NotNull @Positive BigDecimal preco) {
        this.clienteId = clienteId;
        this.descricao = descricao;
        this.preco = preco;
    }

    public OrdemServico toModel(ClienteRepository clienteRepository) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new ClienteNaoEncontradoException(clienteId));
        return new OrdemServico(cliente,descricao,preco,StatusOrdemServico.ABERTA,LocalDateTime.now());
    }


}
