package com.agencia.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "compras")
public class Compras {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date data_compra;
	private float valor_total;
	private String tipo_pagamento;
	private int parcelas;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	Clientes cliente;
	
	@ManyToOne
	@JoinColumn(name = "pacote_id")
	Pacotes pacote;	

	@Override
	public String toString() {
		return "Compra: id = " + id + ", data da compra = " + data_compra + ", valor total = " + valor_total
				+ ", tipo de pagamento=" + tipo_pagamento + ", quantidade de parcelas = " + parcelas + ";\n cliente = " + cliente + ";\n pacote = "
				+pacote + ";";
	}
	
	
	
}
