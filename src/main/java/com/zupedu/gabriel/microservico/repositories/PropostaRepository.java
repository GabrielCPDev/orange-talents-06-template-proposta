package com.zupedu.gabriel.microservico.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zupedu.gabriel.microservico.entities.Proposta;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {
	
	@Transactional
	Optional<Proposta>findByCpfOuCnpj(String cpfOuCnpj);

}
