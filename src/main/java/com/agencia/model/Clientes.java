package com.agencia.model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "clientes")
public class Clientes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private LocalDate datanasc;
	private String email;
	
	
	public Clientes() {
		super();
	}

	public Clientes(String nome, LocalDate datanasc, String email) {
		super();
		this.nome = nome;
		this.datanasc = datanasc;
		this.email = email;
	}

	public Clientes(Long id, String nome, LocalDate datanasc, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.datanasc = datanasc;
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(datanasc, email, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clientes other = (Clientes) obj;
		return Objects.equals(datanasc, other.datanasc) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
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

	public LocalDate getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(LocalDate datanasc) {
		this.datanasc = datanasc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static String formatDate(Date datanasc) {
		if (datanasc != null) {
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(datanasc);

	        // Extrair dia, mês e ano
	        int dia = calendar.get(Calendar.DAY_OF_MONTH);
	        int mes = calendar.get(Calendar.MONTH) + 1; // Os meses em Calendar começam em 0 (janeiro é 0)
	        int ano = calendar.get(Calendar.YEAR);
	        String dataformatada = String.format("%02d", dia) + "/" + String.format("%02d", mes) + "/"+ ano;
	        return dataformatada;
		} else {
			return "Data não especificada";
		}
		
	}
	
	@Override
	public String toString() {
		return "Cliente: id = " + id + ", nome = " + nome + ", data de nascimento = " + datanasc + ", email = " + email + ";";
	}
	
}
