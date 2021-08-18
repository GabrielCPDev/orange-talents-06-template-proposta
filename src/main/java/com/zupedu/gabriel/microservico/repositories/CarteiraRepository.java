package com.zupedu.gabriel.microservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zupedu.gabriel.microservico.entities.Carteira;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

}
