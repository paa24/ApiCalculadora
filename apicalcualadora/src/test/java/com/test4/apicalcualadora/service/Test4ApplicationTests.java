package com.test4.apicalcualadora.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test4.apicalcualadora.modelo.Resultado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test4ApplicationTests {
	@Autowired
	CalculadorServicice calculadorServicice;
	Resultado resultdadoOperación= new Resultado();
	@Test
	public void calcualdoraSuma() {
		
		
		
		resultdadoOperación= calculadorServicice.calcular("S", 1F, 2F);
		assertTrue(resultdadoOperación.getResultado() == 3);

	}

	@Test
	public void calcualdoraSuma2() {
		resultdadoOperación = calculadorServicice.calcular(null, null, null);
		assertNull(resultdadoOperación);

	}

	@Test
	public void calcualdoraSuma3() {
		resultdadoOperación = calculadorServicice.calcular("S", 1F, null);
		assertNull(resultdadoOperación);

	}

	@Test
	public void calcualdoraSuma4() {
		resultdadoOperación= calculadorServicice.calcular("S", null, 1F);
		assertNull(resultdadoOperación);

	}

	@Test
	public void calcualdoraSuma5() {
		resultdadoOperación = calculadorServicice.calcular(" ", 44F, 1F);
		assertNull(resultdadoOperación);

	}

	@Test
	public void calcualdoraSuma6() {
		resultdadoOperación = calculadorServicice.calcular("", 44F, 1F);
		assertNull(resultdadoOperación);

	}

	@Test
	public void calcualdoraSuma7() {
		resultdadoOperación = calculadorServicice.calcular("D", 44F, 1F);
		assertNull(resultdadoOperación);

	}
}
