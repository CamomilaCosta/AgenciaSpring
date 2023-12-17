package com.agencia.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "voos")
public class Voos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String empresa;
	private String cidade_origem;
	private String cidade_destino;
	private String aeroporto_decolagem;
	private String aeroporto_pouso;
	private String hora_decolagem;
	private String hora_pouso;
	private LocalDate dia_decolagem;
	private LocalDate dia_pouso;
	private float preco;

	


	public Voos() {
		super();
	}




	public Voos(String empresa, String cidade_origem, String cidade_destino, String aeroporto_decolagem,
			String aeroporto_pouso, String hora_decolagem, String hora_pouso, LocalDate dia_decolagem,
			LocalDate dia_pouso, float preco) {
		super();
		this.empresa = empresa;
		this.cidade_origem = cidade_origem;
		this.cidade_destino = cidade_destino;
		this.aeroporto_decolagem = aeroporto_decolagem;
		this.aeroporto_pouso = aeroporto_pouso;
		this.hora_decolagem = hora_decolagem;
		this.hora_pouso = hora_pouso;
		this.dia_decolagem = dia_decolagem;
		this.dia_pouso = dia_pouso;
		this.preco = preco;
	}




	public Voos(Long id, String empresa, String cidade_origem, String cidade_destino, String aeroporto_decolagem,
			String aeroporto_pouso, String hora_decolagem, String hora_pouso, LocalDate dia_decolagem,
			LocalDate dia_pouso, float preco) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.cidade_origem = cidade_origem;
		this.cidade_destino = cidade_destino;
		this.aeroporto_decolagem = aeroporto_decolagem;
		this.aeroporto_pouso = aeroporto_pouso;
		this.hora_decolagem = hora_decolagem;
		this.hora_pouso = hora_pouso;
		this.dia_decolagem = dia_decolagem;
		this.dia_pouso = dia_pouso;
		this.preco = preco;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getEmpresa() {
		return empresa;
	}




	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}




	public String getCidade_origem() {
		return cidade_origem;
	}




	public void setCidade_origem(String cidade_origem) {
		this.cidade_origem = cidade_origem;
	}




	public String getCidade_destino() {
		return cidade_destino;
	}




	public void setCidade_destino(String cidade_destino) {
		this.cidade_destino = cidade_destino;
	}




	public String getAeroporto_decolagem() {
		return aeroporto_decolagem;
	}




	public void setAeroporto_decolagem(String aeroporto_decolagem) {
		this.aeroporto_decolagem = aeroporto_decolagem;
	}




	public String getAeroporto_pouso() {
		return aeroporto_pouso;
	}




	public void setAeroporto_pouso(String aeroporto_pouso) {
		this.aeroporto_pouso = aeroporto_pouso;
	}




	public String getHora_decolagem() {
		return hora_decolagem;
	}




	public void setHora_decolagem(String hora_decolagem) {
		this.hora_decolagem = hora_decolagem;
	}




	public String getHora_pouso() {
		return hora_pouso;
	}




	public void setHora_pouso(String hora_pouso) {
		this.hora_pouso = hora_pouso;
	}




	public LocalDate getDia_decolagem() {
		return dia_decolagem;
	}




	public void setDia_decolagem(LocalDate dia_decolagem) {
		this.dia_decolagem = dia_decolagem;
	}




	public LocalDate getDia_pouso() {
		return dia_pouso;
	}




	public void setDia_pouso(LocalDate dia_pouso) {
		this.dia_pouso = dia_pouso;
	}




	public float getPreco() {
		return preco;
	}




	public void setPreco(float preco) {
		this.preco = preco;
	}




	@Override
	public String toString() {
		return "Voos: id = " + id + ", empresa = " + empresa + ", cidade de origem = " + cidade_origem + ", cidade de destino = "
				+ cidade_destino + ", aeroporto de origem = " + aeroporto_decolagem + ", aeroporto de destino="
				+ aeroporto_pouso + ", horário de decolagem = " + hora_decolagem + ", horário de pouso = " + hora_pouso
				+ ", data de saída=" + dia_decolagem + ", data de chagada = " + dia_pouso + ", preço = " + preco + ";";
	}
	
	
	
}
