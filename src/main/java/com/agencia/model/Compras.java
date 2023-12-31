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
	
	

	public Compras() {
		super();
	}



	public Compras(Date data_compra, float valor_total, String tipo_pagamento, int parcelas, Clientes cliente,
			Pacotes pacote) {
		super();
		this.data_compra = data_compra;
		this.valor_total = valor_total;
		this.tipo_pagamento = tipo_pagamento;
		this.parcelas = parcelas;
		this.cliente = cliente;
		this.pacote = pacote;
	}



	public Compras(Long id, Date data_compra, float valor_total, String tipo_pagamento, int parcelas, Clientes cliente,
			Pacotes pacote) {
		super();
		this.id = id;
		this.data_compra = data_compra;
		this.valor_total = valor_total;
		this.tipo_pagamento = tipo_pagamento;
		this.parcelas = parcelas;
		this.cliente = cliente;
		this.pacote = pacote;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getData_compra() {
		return data_compra;
	}



	public void setData_compra(Date data_compra) {
		this.data_compra = data_compra;
	}



	public float getValor_total() {
		return valor_total;
	}



	public void setValor_total(float valor_total) {
		this.valor_total = valor_total;
	}



	public String getTipo_pagamento() {
		return tipo_pagamento;
	}



	public void setTipo_pagamento(String tipo_pagamento) {
		this.tipo_pagamento = tipo_pagamento;
	}



	public int getParcelas() {
		return parcelas;
	}



	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}



	public Clientes getCliente() {
		return cliente;
	}



	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}



	public Pacotes getPacote() {
		return pacote;
	}



	public void setPacote(Pacotes pacote) {
		this.pacote = pacote;
	}



	@Override
	public String toString() {
		return "Compra: id = " + id + ", data da compra = " + data_compra + ", valor total = " + valor_total
				+ ", tipo de pagamento=" + tipo_pagamento + ", quantidade de parcelas = " + parcelas + ";\n cliente = " + cliente + ";\n pacote = "
				+pacote + ";";
	}
	
	
	
}
