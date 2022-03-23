package br.tec.foxconsultoria.olinda.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.tec.foxconsultoria.olinda.domain.model.EntAgenteDadosAbertos;

@Repository
public interface DadosAbertosRepository extends JpaRepository<EntAgenteDadosAbertos, String> {

}
