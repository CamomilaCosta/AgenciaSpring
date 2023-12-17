package com.agencia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hoteis")
public class Hoteis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private float preco_diaria;
	private String cidade;
	private String bairro;
	private String rua;
	


	@Override
	public String toString() {
		return "Hotel: id = " + id + ", nome = " + nome + ", preço da diária = " + preco_diaria + ", cidade = " + cidade
				+ ", bairro = " + bairro + ", rua = " + rua + ";";
	}
	
	
	
}
