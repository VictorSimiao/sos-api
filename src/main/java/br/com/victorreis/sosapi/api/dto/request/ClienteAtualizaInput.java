package br.com.victorreis.sosapi.api.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ClienteAtualizaInput {

    @NotBlank
    private String nome;

    @NotBlank
    private String telefone;

    public ClienteAtualizaInput(@NotBlank String nome, @NotBlank String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }


    public String getTelefone() {
        return telefone;
    }
}
