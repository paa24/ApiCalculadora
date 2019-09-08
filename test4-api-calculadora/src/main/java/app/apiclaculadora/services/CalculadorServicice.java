package app.apiclaculadora.services;

import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class CalculadorServicice {

	public Float calcular(String operation, Float n, Float n1) {

		Float result = null;
		if (StringUtils.isNotBlank(operation)) {

			if (operation.equals("S")) {
				result = n + n1;
			} else if (operation.equals("N")) {
				result = n - n1;

			}

		}

		return result;
	}

}
