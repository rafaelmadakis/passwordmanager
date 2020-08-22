package br.com.password.manager.domain.repository;

import br.com.password.manager.domain.model.Dado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadoRepository extends JpaRepository<Dado, Long> {
}
