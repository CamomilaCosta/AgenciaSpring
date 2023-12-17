package com.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencia.model.Voos;

@Repository
public interface VoosRepository extends JpaRepository<Voos, Long>{

}
