package com.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencia.model.Compras;

@Repository
public interface ComprasRepository extends JpaRepository<Compras, Long>{

}
