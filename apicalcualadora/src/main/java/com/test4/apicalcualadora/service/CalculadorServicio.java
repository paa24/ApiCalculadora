package com.test4.apicalcualadora.service;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.test4.apicalcualadora.dto.ResultadoDTO;
import com.test4.apicalcualadora.excepciones.OperationException;
import com.test4.apicalcualadora.modelo.Resultado;
import com.test4.apicalcualadora.util.constantes.OperacionesConstanstes;

import io.corp.calculator.TracerImpl;

/**
 * Servicio de procesamiento que realiza las operaciones de la calcualdora
 */

@Service
public class CalculadorServicio {
	/**
	 * Realiza las operaciones de la Calculadora
	 * 
	 * @param operation
	 *            Operación a realizar "S"(Suma)o "R"(Resta).
	 * @param n1
	 *            Primer registro de la operación
	 * @param n2
	 *            Segundo registro de la operación.
	 */
	public ResultadoDTO calcular(String operation, Float n1, Float n2) {
		TracerImpl tracer = new TracerImpl();

		Resultado resultado = new Resultado();
		ModelMapper mapper = new ModelMapper();
		if (StringUtils.isNotBlank(operation) && n1 != null && n2 != null) {

			if (operation.equals(OperacionesConstanstes.SUMA)) {
				resultado.setResultado(n1 + n2);

			} else if (operation.equals(OperacionesConstanstes.RESTA)) {
				resultado.setResultado(n1 - n2);

			} else {
				throw new OperationException("Operación inválida");

			}
		} else {
			throw new OperationException("Número Incorrecto");

		}

		ResultadoDTO resulDTO = mapper.map(resultado, ResultadoDTO.class);
		tracer.trace(resulDTO.getResultado());
		return resulDTO;
	}

}
