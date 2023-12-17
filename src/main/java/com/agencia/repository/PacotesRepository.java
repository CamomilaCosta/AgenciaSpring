package com.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencia.model.Pacotes;

@Repository
public interface PacotesRepository extends JpaRepository<Pacotes, Long>{

}
