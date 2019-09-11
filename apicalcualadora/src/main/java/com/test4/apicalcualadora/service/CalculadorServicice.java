package com.test4.apicalcualadora.service;

import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Service;

import com.test4.apicalcualadora.excepciones.OperationException;
import com.test4.apicalcualadora.modelo.Resultado;

@Service
public class CalculadorServicice {

	public Resultado calcular(String operation, Float n1, Float n2) {

		Resultado resultado = new Resultado();

		if (StringUtils.isNotBlank(operation) && n1 != null && n2 != null) {

			if (operation.equals("S")) {
				resultado.setResultado(n1 + n2);

			} else if (operation.equals("R")) {
				resultado.setResultado(n1 - n2);

			}

		}

		else {

			throw new OperationException("Operación inválida");

		}
		return resultado;
	}

}
