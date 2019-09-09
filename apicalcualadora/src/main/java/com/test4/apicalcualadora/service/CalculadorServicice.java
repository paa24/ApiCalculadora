package com.test4.apicalcualadora.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class CalculadorServicice {

	public Float calcular(String operation, Float n, Float n1) {

		Float result = null;
		if (StringUtils.isNotBlank(operation) && n != null && n1 != null) {

			if (operation.equals("S")) {
				result = n + n1;
			} else if (operation.equals("R")) {
				result = n - n1;

			}

		}

		return result;
	}

}
