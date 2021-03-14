package br.com.victorreis.sosapi.api.dto.request;

import br.com.victorreis.sosapi.domain.model.Cliente;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ClienteInput {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String telefone;

    public ClienteInput(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Cliente toModel(){
        return new Cliente(nome,email,telefone);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
