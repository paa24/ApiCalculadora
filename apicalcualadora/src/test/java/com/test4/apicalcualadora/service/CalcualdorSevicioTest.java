package com.test4.apicalcualadora.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test4.apicalcualadora.dto.ResultadoDTO;
import com.test4.apicalcualadora.excepciones.OperationException;
import com.test4.apicalcualadora.modelo.Resultado;
import com.test4.apicalcualadora.service.CalculadorServicio;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalcualdorSevicioTest {
	@Autowired
	CalculadorServicio calculadorServicice;
	ResultadoDTO resultdadoOperación = new ResultadoDTO();

	@Test
	public void calcualdoraSuma() {
	
		resultdadoOperación = calculadorServicice.calcular("S", 1F, 2F);
		assertTrue(resultdadoOperación.getResultado() == 3);

	}

	@Test
	public void calcualdoraSuma2() {
		try {
			resultdadoOperación = calculadorServicice.calcular(null, null, null);
			assertNotNull(resultdadoOperación.getResultado());
		} catch (OperationException e) {
			assertNull(resultdadoOperación.getResultado());

		}

	}

	@Test
	public void calcualdoraSuma3() {
		try {
			resultdadoOperación = calculadorServicice.calcular("S", null, 1F);
			assertNotNull(resultdadoOperación.getResultado());
		} catch (OperationException e) {
			assertNull(resultdadoOperación.getResultado());

		}

	}
		

	@Test
	public void calcualdoraSuma4() {
		try{
		resultdadoOperación = calculadorServicice.calcular("S", 2F, null);
		assertNotNull(resultdadoOperación.getResultado());
	} catch (OperationException e) {
		assertNull(resultdadoOperación.getResultado());

	}
	}

	@Test
	public void calcualdoraSuma5() {
		try{
		resultdadoOperación = calculadorServicice.calcular(" ", 44F, 1F);
		assertNull(resultdadoOperación.getResultado());
		
	} catch (OperationException e) {
		assertNull(resultdadoOperación.getResultado());

	}
	}

	@Test
	public void calcualdoraSuma6() {
		try{
		resultdadoOperación = calculadorServicice.calcular("", 44F, 1F);
		assertNotNull(resultdadoOperación.getResultado());
	}catch (OperationException e) {
		assertNull(resultdadoOperación.getResultado());

	}
	}

	@Test
	public void calcualdoraSuma7() {
		try{
		resultdadoOperación = calculadorServicice.calcular("D", 44F, 1F);
		assertNotNull(resultdadoOperación);
		}catch (OperationException e) {
			assertNull(resultdadoOperación.getResultado());

		}

	}
	
	@Test
	public void calcualdoraSuma8() {
		try{
		resultdadoOperación = calculadorServicice.calcular("S", 44.33F, 1.44F);
		assertNotNull(resultdadoOperación);
		}catch (OperationException e) {
			assertNull(resultdadoOperación.getResultado());

		}

	}
}
