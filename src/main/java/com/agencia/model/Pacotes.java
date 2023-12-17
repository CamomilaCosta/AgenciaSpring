package com.agencia.model;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "hoteis")
public class Pacotes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String destino;
	private String origem;
	private LocalDate data_ida;
	private LocalDate data_volta;
	private float preco;
	private int dias_pacote;
	
	@ManyToOne
	@JoinColumn(name = "voo_ida_id")
	Voos voo_ida;
	
	@ManyToOne
	@JoinColumn(name = "voo_volta_id")
	Voos voo_volta;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	Hoteis hotel;
	
	
	

	public Pacotes() {
		super();
	}




	public Pacotes(String destino, String origem, LocalDate data_ida, LocalDate data_volta, float preco,
			int dias_pacote, Voos voo_ida, Voos voo_volta, Hoteis hotel) {
		super();
		this.destino = destino;
		this.origem = origem;
		this.data_ida = data_ida;
		this.data_volta = data_volta;
		this.preco = preco;
		this.dias_pacote = dias_pacote;
		this.voo_ida = voo_ida;
		this.voo_volta = voo_volta;
		this.hotel = hotel;
	}




	public Pacotes(Long id, String destino, String origem, LocalDate data_ida, LocalDate data_volta, float preco,
			int dias_pacote, Voos voo_ida, Voos voo_volta, Hoteis hotel) {
		super();
		this.id = id;
		this.destino = destino;
		this.origem = origem;
		this.data_ida = data_ida;
		this.data_volta = data_volta;
		this.preco = preco;
		this.dias_pacote = dias_pacote;
		this.voo_ida = voo_ida;
		this.voo_volta = voo_volta;
		this.hotel = hotel;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getDestino() {
		return destino;
	}




	public void setDestino(String destino) {
		this.destino = destino;
	}




	public String getOrigem() {
		return origem;
	}




	public void setOrigem(String origem) {
		this.origem = origem;
	}




	public LocalDate getData_ida() {
		return data_ida;
	}




	public void setData_ida(LocalDate data_ida) {
		this.data_ida = data_ida;
	}




	public LocalDate getData_volta() {
		return data_volta;
	}




	public void setData_volta(LocalDate data_volta) {
		this.data_volta = data_volta;
	}




	public float getPreco() {
		return preco;
	}




	public void setPreco(float preco) {
		this.preco = preco;
	}




	public int getDias_pacote() {
		return dias_pacote;
	}




	public void setDias_pacote(int dias_pacote) {
		this.dias_pacote = dias_pacote;
	}




	public Voos getVoo_ida() {
		return voo_ida;
	}




	public void setVoo_ida(Voos voo_ida) {
		this.voo_ida = voo_ida;
	}




	public Voos getVoo_volta() {
		return voo_volta;
	}




	public void setVoo_volta(Voos voo_volta) {
		this.voo_volta = voo_volta;
	}




	public Hoteis getHotel() {
		return hotel;
	}




	public void setHotel(Hoteis hotel) {
		this.hotel = hotel;
	}




	@Override
	public String toString() {
		
		return "Pacote: id = " + id + ", destino = " + destino + ", origem = " + origem + ", data de ida=" + data_ida
				+ ", data de volta=" + data_volta + ", preço = " + preco + ", dias de viagem = " + dias_pacote + ";\n Voo de ida = "
				+ voo_ida + ";\n Voo de volta = " + voo_volta + ";\n Hotel = " + hotel + ";";
	}
	
	
}
