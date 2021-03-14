package br.com.victorreis.sosapi.api.dto.response;

import br.com.victorreis.sosapi.domain.model.Cliente;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteResponse {

    private Long id;

    private String nome;

    private String email;

    private String telefone;

    public ClienteResponse(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
    }

    public static List<ClienteResponse> toCollection(List<Cliente> clientes) {
        return clientes.stream().map(ClienteResponse::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
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
