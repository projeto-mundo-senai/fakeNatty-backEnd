package com.br.senai.fakenatty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.senai.fakenatty.dto.DietaDto;
import com.br.senai.fakenatty.model.Dieta;
import com.br.senai.fakenatty.repository.DietaRepository;

@Service
public class DietaService {

	@Autowired
	private DietaRepository dietaRepository;

	public Dieta salvaDieta(DietaDto dietaDto) {
		Dieta dieta = new Dieta(dietaDto);
		return dietaRepository.save(dieta);
	}

	public Dieta buscaDieta(DietaDto dietaDto, char pretencaoFisica) {
		Dieta dieta = new Dieta(dietaDto);
		//INFLUENCIA DA PRETENCAO FISICA INFLUENCIA NA DIETA
	
		if (pretencaoFisica == 'G' || pretencaoFisica == 'g') {
			return dietaRepository.findByNumeroCaloriasGreaterThanAndVeganoAndVegetarianoAndLactoseAndGlutem(
					dieta.getNumeroCalorias(), dieta.getVegano(), dieta.getVegetariano(), dieta.getLactose(),
					dieta.getGlutem()).orElse(null);
		} else {
			return dietaRepository
					.findByNumeroCaloriasLessThanAndVeganoAndVegetarianoAndLactoseAndGlutem(dieta.getNumeroCalorias(),
							dieta.getVegano(), dieta.getVegetariano(), dieta.getLactose(), dieta.getGlutem())
					.orElse(null);
		}

	}
}
