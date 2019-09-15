package com.test4.apicalcualadora.service;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.test4.apicalcualadora.dto.ResultadoDTO;
import com.test4.apicalcualadora.excepciones.OperationException;
import com.test4.apicalcualadora.service.CalculadorServicio;
import com.test4.apicalcualadora.util.constantes.OperacionesConstanstes;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalcualdorSevicioTest {
	@Autowired
	CalculadorServicio calculadorServicice;
	ResultadoDTO resultdadoOperación = new ResultadoDTO();

	/**
	 * Cumple la condicion: operacion ="S", nun1 != null, nun2!=null
	 */
	@Test
	public void calcualdoraSuma() {

		resultdadoOperación = calculadorServicice.calcular(OperacionesConstanstes.SUMA, 1F, 2F);
		assertTrue(resultdadoOperación.getResultado() == 3);

	}

	/**
	 * Cumple la condicion: operacion ="R", nun1 != null, nun2!=null
	 */
	@Test
	public void calcualdoraResta() {

		resultdadoOperación = calculadorServicice.calcular("R", 1F, 2F);
		assertTrue(resultdadoOperación.getResultado() == -1F);

	}

	/**
	 * No Cumple las condiciones: operacion ="S" o "R", nun1 != null, nun2!=null
	 */
	@Test
	public void calcualdoraSumaResta2() {
		try {
			resultdadoOperación = calculadorServicice.calcular(null, null, null);
			assertNotNull(resultdadoOperación.getResultado());
		} catch (OperationException e) {
			assertNull(resultdadoOperación.getResultado());

		}

	}

	/**
	 * Cumple la condicion: operacion ="S" y nun2!=null no cumple nun1 != null,
	 */
	@Test
	public void calcualdoraSuma3() {
		try {
			resultdadoOperación = calculadorServicice.calcular(OperacionesConstanstes.SUMA, null, 1F);
			assertNotNull(resultdadoOperación.getResultado());
		} catch (OperationException e) {
			assertNull(resultdadoOperación.getResultado());

		}

	}

	/**
	 * Cumple la condicion: operacion ="R" y nun2!=null no cumple nun1 != null,
	 */
	@Test
	public void calcualdoraResta3() {
		try {
			resultdadoOperación = calculadorServicice.calcular(OperacionesConstanstes.RESTA, null, 1F);
			assertNotNull(resultdadoOperación.getResultado());
		} catch (OperationException e) {
			assertNull(resultdadoOperación.getResultado());

		}

	}

	/**
	 * Cumple la condicion: operacion ="S" y nun1 != null, no cumple nun2!=null
	 */
	@Test
	public void calcualdoraSuma4() {
		try {
			resultdadoOperación = calculadorServicice.calcular(OperacionesConstanstes.SUMA, 2F, null);
			assertNotNull(resultdadoOperación.getResultado());
		} catch (OperationException e) {
			assertNull(resultdadoOperación.getResultado());

		}
	}

	/**
	 * Cumple la condicion: operacion ="R" y nun1 != null, no cumple nun2!=null
	 */
	@Test
	public void calcualdoraResta4() {
		try {
			resultdadoOperación = calculadorServicice.calcular(OperacionesConstanstes.RESTA, 2F, null);
			assertNotNull(resultdadoOperación.getResultado());
		} catch (OperationException e) {
			assertNull(resultdadoOperación.getResultado());

		}
	}

	/**
	 * No Cumple la condicion: operacion ="S" o "R" ,cumple nun1 != null,
	 * nun2!=null
	 */
	@Test
	public void calcualdoraSumaResta5() {
		try {
			resultdadoOperación = calculadorServicice.calcular(" ", 44F, 1F);
			assertNull(resultdadoOperación.getResultado());

		} catch (OperationException e) {
			assertNull(resultdadoOperación.getResultado());

		}
	}

	/**
	 * No Cumple la condicion: operacion ="S" o "R", cumple nun1 != null,
	 * nun2!=null
	 */
	@Test
	public void calcualdoraSumaResta6() {
		try {
			resultdadoOperación = calculadorServicice.calcular("", 44F, 1F);
			assertNotNull(resultdadoOperación.getResultado());
		} catch (OperationException e) {
			assertNull(resultdadoOperación.getResultado());

		}
	}

	/**
	 * No Cumple la condicion: operacion ="S" o "R" ,cumple nun1 != null,
	 * nun2!=null
	 */
	@Test
	public void calcualdoraSumaResta7() {
		try {
			resultdadoOperación = calculadorServicice.calcular("D", 44F, 1F);
			assertNotNull(resultdadoOperación);
		} catch (OperationException e) {
			assertNull(resultdadoOperación.getResultado());

		}

	}

	/**
	 * Cumple la condicion: operacion ="S", nun1 != null, nun2!=null
	 */
	@Test
	public void calcualdoraSuma8() {
		try {
			resultdadoOperación = calculadorServicice.calcular(OperacionesConstanstes.SUMA, 44.33F, 1.44F);
			assertNotNull(resultdadoOperación);
		} catch (OperationException e) {
			assertTrue(resultdadoOperación.getResultado() == 45.77F);

		}

	}

	/**
	 * Cumple la condicion: operacion ="R", nun1 != null, nun2!=null
	 */
	@Test
	public void calcualdoraResta8() {
		try {
			resultdadoOperación = calculadorServicice.calcular(OperacionesConstanstes.RESTA, 44.33F, 1.44F);
			assertNotNull(resultdadoOperación);
		} catch (OperationException e) {
			assertTrue(resultdadoOperación.getResultado() == 42.89F);

		}

	}
}
