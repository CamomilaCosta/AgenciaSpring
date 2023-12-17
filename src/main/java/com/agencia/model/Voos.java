package com.agencia.model;

import java.util.Calendar;
import java.util.Date;

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
	private Date dia_decolagem;
	private Date dia_pouso;
	private float preco;

	
	public static String formatDate(Date datavoo) {
		if (datavoo != null) {
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(datavoo);

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
		String data_decolagem_formatada = formatDate(dia_decolagem);
		String data_pouso_formatada = formatDate(dia_pouso);
		return "Voos: id = " + id + ", empresa = " + empresa + ", cidade de origem = " + cidade_origem + ", cidade de destino = "
				+ cidade_destino + ", aeroporto de origem = " + aeroporto_decolagem + ", aeroporto de destino="
				+ aeroporto_pouso + ", horário de decolagem = " + hora_decolagem + ", horário de pouso = " + hora_pouso
				+ ", data de saída=" + data_decolagem_formatada + ", data de chagada = " + data_pouso_formatada + ", preço = " + preco + ";";
	}
	
	
	
}
