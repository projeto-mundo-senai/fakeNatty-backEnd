package com.br.senai.fakenatty.model;

import java.util.List;

import com.br.senai.fakenatty.dto.PessoaDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String nome;
	Integer idade;
	Double altura;
	Double taxaMetabolica;
	Double peso;
	char pretencaoFisica;
	char genero;
	char nivelAtividadeFisica;
	String email;
	@ManyToMany
	@JoinTable(name = "pessoa_dieta", joinColumns = @JoinColumn(name = "pessoa_id"), inverseJoinColumns = @JoinColumn(name = "dieta_id"))
	List<Dieta> listaDieta;

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public List<Dieta> getListaDieta() {
		return listaDieta;
	}

	public void setListaDieta(List<Dieta> listaDieta) {
		this.listaDieta = listaDieta;
	}

	public Pessoa(PessoaDto pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.idade = pessoa.getIdade();
		this.taxaMetabolica = pessoa.getTaxaMetabolica();
		this.peso = pessoa.getPeso();
		this.pretencaoFisica = pessoa.getPretencaoFisica();
		this.genero = pessoa.getGenero();
		this.nivelAtividadeFisica = pessoa.getNivelAtividadeFisica();
		this.email = pessoa.getEmail();
		this.altura = pessoa.getAltura();
		this.calculaBasal();
	}

	public Pessoa() {
		super();
	}

	public Pessoa(Integer id, String nome, Integer idade, Double altura, Double taxaMetabolica, Double peso,
			char pretencaoFisica, char genero, char nivelAtividadeFisica, String email, List<Dieta> listaDieta) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
		this.taxaMetabolica = taxaMetabolica;
		this.peso = peso;
		this.pretencaoFisica = pretencaoFisica;
		this.genero = genero;
		this.nivelAtividadeFisica = nivelAtividadeFisica;
		this.email = email;
		this.listaDieta = listaDieta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Double getTaxaMetabolica() {
		return taxaMetabolica;
	}

	public void setTaxaMetabolica(Double taxaMetabolica) {
		this.taxaMetabolica = taxaMetabolica;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public char getPretencaoFisica() {
		return pretencaoFisica;
	}

	public void setPretencaoFisica(char pretencaoFisica) {
		this.pretencaoFisica = pretencaoFisica;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public char getNivelAtividadeFisica() {
		return nivelAtividadeFisica;
	}

	public void setNivelAtividadeFisica(char nivelAtividadeFisica) {
		this.nivelAtividadeFisica = nivelAtividadeFisica;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void calculaBasal() {
		//Levar em consideração nivel de atividade fisica
		
		if (this.genero == 'H') {

			this.taxaMetabolica = 88.36 + (13.4 * this.peso) + (4.8 * this.altura) - (5.7 * this.idade);

		} else {

			this.taxaMetabolica = 447.59 + (9.24 * this.peso) + (3.09 * this.altura) - (4.33 * this.idade);

		}

	}

}
