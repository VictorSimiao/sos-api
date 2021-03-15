package br.com.victorreis.sosapi.domain.repository;

import br.com.victorreis.sosapi.domain.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico,Long> {
}
