package br.com.kushi.springdatarest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private String sobreNome;
	
	public Pessoa() {}
	
	public Pessoa(String nome, String sobreNome) {
		this.nome = nome;
		this.sobreNome = sobreNome;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
}
