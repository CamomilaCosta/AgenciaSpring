package com.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencia.model.Hoteis;

@Repository
public interface HoteisRepository extends JpaRepository<Hoteis, Long>{

}
