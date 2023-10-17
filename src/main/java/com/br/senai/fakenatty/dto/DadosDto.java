package com.br.senai.fakenatty.dto;

public class DadosDto {

	DietaDto dietaDto;
	PessoaDto pessoadDto;

	private DadosDto() {
		super();
	}

	private DadosDto(DietaDto dietaDto, PessoaDto pessoadDto) {
		super();
		this.dietaDto = dietaDto;
		this.pessoadDto = pessoadDto;
	}

	public DietaDto getDietaDto() {
		return dietaDto;
	}

	public void setDietaDto(DietaDto dietaDto) {
		this.dietaDto = dietaDto;
	}

	public PessoaDto getPessoadDto() {
		return pessoadDto;
	}

	public void setPessoadDto(PessoaDto pessoadDto) {
		this.pessoadDto = pessoadDto;
	}

}
