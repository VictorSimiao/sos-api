package br.com.victorreis.sosapi.api.dto.response;

import br.com.victorreis.sosapi.domain.model.Cliente;
import br.com.victorreis.sosapi.domain.model.OrdemServico;
import br.com.victorreis.sosapi.domain.model.StatusOrdemServico;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrdemServicoResponse {

    private Long id;

    private String nomeCliente;

    private String descricao;

    private BigDecimal preco;

    private StatusOrdemServico status;

    private LocalDateTime dataAbertura;

    private LocalDateTime dataFinalizacao;

    public OrdemServicoResponse(OrdemServico ordemServico) {
        this.id = ordemServico.getId();
        this.nomeCliente = ordemServico.getCliente().getNome();
        this.descricao = ordemServico.getDescricao();
        this.preco = ordemServico.getPreco();
        this.status = ordemServico.getStatus();
        this.dataAbertura = ordemServico.getDataAbertura();
        this.dataFinalizacao = ordemServico.getDataFinalizacao();
    }

    public Long getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public StatusOrdemServico getStatus() {
        return status;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public LocalDateTime getDataFinalizacao() {
        return dataFinalizacao;
    }
}
