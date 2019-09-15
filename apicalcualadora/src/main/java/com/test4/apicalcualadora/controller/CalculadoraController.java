package com.test4.apicalcualadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.test4.apicalcualadora.dto.ResultadoDTO;

import com.test4.apicalcualadora.service.CalculadorServicio;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
	@Autowired
	private CalculadorServicio calculadora;

	@PostMapping(value = "/operaciones", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResultadoDTO Calculadora(@RequestParam(value = "operacion") String operacion,
			@RequestParam(value = "num1") Float num1, @RequestParam(value = "num2") Float num2) {

		return calculadora.calcular(operacion, num1, num2);
	}
}
