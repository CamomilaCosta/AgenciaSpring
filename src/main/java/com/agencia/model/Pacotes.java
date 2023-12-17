package com.agencia.model;

import java.util.Calendar;
import java.util.Date;

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
	private Date data_ida;
	private Date data_volta;
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
	
	
	public static String formatDate(Date dataFormatada) {
		if (dataFormatada != null) {
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(dataFormatada);

	        int dia = calendar.get(Calendar.DAY_OF_MONTH);
	        int mes = calendar.get(Calendar.MONTH) + 1;
	        int ano = calendar.get(Calendar.YEAR);
	        String dataformatada = String.format("%02d", dia) + "/" + String.format("%02d", mes) + "/"+ ano;
	        return dataformatada;
		} else {
			return "Data não especificada";
		}
		
	}

	@Override
	public String toString() {
		String data_ida_formatada = formatDate(data_ida);
		String data_volta_formatada = formatDate(data_volta);
		return "Pacote: id = " + id + ", destino = " + destino + ", origem = " + origem + ", data de ida=" + data_ida_formatada
				+ ", data de volta=" + data_volta_formatada + ", preço = " + preco + ", dias de viagem = " + dias_pacote + ";\n Voo de ida = "
				+ voo_ida + ";\n Voo de volta = " + voo_volta + ";\n Hotel = " + hotel + ";";
	}
	
	
}
