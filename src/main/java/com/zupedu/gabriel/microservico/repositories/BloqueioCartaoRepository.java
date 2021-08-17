package com.zupedu.gabriel.microservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zupedu.gabriel.microservico.entities.BloqueiaCartao;

@Repository
public interface BloqueioCartaoRepository extends JpaRepository<BloqueiaCartao, Long>{

}
