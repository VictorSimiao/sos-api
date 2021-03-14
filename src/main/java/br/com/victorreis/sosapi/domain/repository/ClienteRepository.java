package br.com.victorreis.sosapi.domain.repository;

import br.com.victorreis.sosapi.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
