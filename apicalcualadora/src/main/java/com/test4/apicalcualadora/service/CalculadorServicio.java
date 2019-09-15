package com.test4.apicalcualadora.service;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.test4.apicalcualadora.dto.ResultadoDTO;
import com.test4.apicalcualadora.excepciones.OperationException;
import com.test4.apicalcualadora.modelo.Resultado;

import io.corp.calculator.TracerImpl;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CalculadorServicio {

	public ResultadoDTO calcular(String operation, Float n1, Float n2) {
		TracerImpl tracer = new TracerImpl();

		Resultado resultado = new Resultado();
		ModelMapper mapper = new ModelMapper();
		if (StringUtils.isNotBlank(operation) && n1 != null && n2 != null) {

			if (operation.equals("S")) {
				resultado.setResultado(n1 + n2);

			} else if (operation.equals("R")) {
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
