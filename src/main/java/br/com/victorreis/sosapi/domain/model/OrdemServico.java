package br.com.victorreis.sosapi.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @NotBlank
    private String descricao;

    @NotNull
    @Positive
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    private StatusOrdemServico status;

    @NotNull
    private LocalDateTime dataAbertura;

    private LocalDateTime dataFinalizacao;

    @Deprecated
    public OrdemServico() {
    }

    public OrdemServico(Cliente cliente, @NotBlank String descricao, @NotNull @Positive BigDecimal preco, StatusOrdemServico status, @NotNull LocalDateTime dataAbertura) {
        this.cliente = cliente;
        this.descricao = descricao;
        this.preco = preco;
        this.status = status;
        this.dataAbertura = dataAbertura;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public StatusOrdemServico getStatus() {
        return status;
    }

    public void setStatus(StatusOrdemServico status) {
        this.status = status;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }
}
