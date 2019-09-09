package com.test4.apicalcualadora.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class Test4ApplicationTests {
	@Autowired
	CalculadorServicice calculadorServicice;

	@Test
	public void calcualdoraSuma() {
		Float result = calculadorServicice.calcular("S", 1F, 2F);
		assertTrue(result == 3);

	}
	
	@Test
	public void calcualdoraSuma2() {
		Float result = calculadorServicice.calcular(null, null, null);
		assertNull(result);

	}
	@Test
	public void calcualdoraSuma3() {
		Float result = calculadorServicice.calcular("S", 1F, null);
		assertNull(result);

	}
	
	@Test
	public void calcualdoraSuma4() {
		Float result = calculadorServicice.calcular("S", null,1F);
		assertNull(result);

	}
	
	@Test
	public void calcualdoraSuma5() {
		Float result = calculadorServicice.calcular(" ", 44F,1F);
		assertNull(result);

	}
	
	@Test
	public void calcualdoraSuma6() {
		Float result = calculadorServicice.calcular("", 44F,1F);
		assertNull(result);

	}
	
	@Test
	public void calcualdoraSuma7() {
		Float result = calculadorServicice.calcular("D", 44F,1F);
		assertNull(result);

	}
}
