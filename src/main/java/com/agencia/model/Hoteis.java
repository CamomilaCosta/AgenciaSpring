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
	
	


	public Hoteis() {
		super();
	}




	public Hoteis(String nome, float preco_diaria, String cidade, String bairro, String rua) {
		super();
		this.nome = nome;
		this.preco_diaria = preco_diaria;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
	}




	public Hoteis(Long id, String nome, float preco_diaria, String cidade, String bairro, String rua) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco_diaria = preco_diaria;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public float getPreco_diaria() {
		return preco_diaria;
	}




	public void setPreco_diaria(float preco_diaria) {
		this.preco_diaria = preco_diaria;
	}




	public String getCidade() {
		return cidade;
	}




	public void setCidade(String cidade) {
		this.cidade = cidade;
	}




	public String getBairro() {
		return bairro;
	}




	public void setBairro(String bairro) {
		this.bairro = bairro;
	}




	public String getRua() {
		return rua;
	}




	public void setRua(String rua) {
		this.rua = rua;
	}




	@Override
	public String toString() {
		return "Hotel: id = " + id + ", nome = " + nome + ", preço da diária = " + preco_diaria + ", cidade = " + cidade
				+ ", bairro = " + bairro + ", rua = " + rua + ";";
	}
	
	
	
}
