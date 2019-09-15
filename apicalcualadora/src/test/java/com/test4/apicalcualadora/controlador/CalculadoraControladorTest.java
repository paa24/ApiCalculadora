package com.test4.apicalcualadora.controlador;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test4.apicalcualadora.controller.CalculadoraController;
import com.test4.apicalcualadora.dto.ResultadoDTO;
import com.test4.apicalcualadora.service.CalculadorServicio;
import com.test4.apicalcualadora.util.constantes.OperacionesConstanstes;

import lombok.extern.log4j.Log4j2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.assertj.core.api.Assertions;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Log4j2
public class CalculadoraControladorTest {
	@InjectMocks
	CalculadoraController calculadoraController;
	@Mock
	CalculadorServicio calculadorServicio;
	@Autowired
	MockMvc mockMvc;

	/**
	 * Cumple la condicion: operacion ="S", nun1 != null y nun2!=null
	 */
	@Test
	public void calcualdoraSumaController() {
		ResultadoDTO resultdadoSeteado = new ResultadoDTO();
		resultdadoSeteado.setResultado(6F);
		when(calculadorServicio.calcular(OperacionesConstanstes.SUMA, 3F, 3F)).thenReturn(resultdadoSeteado);

		ResultadoDTO resultDto = calculadoraController.Calculadora(OperacionesConstanstes.SUMA, 3F, 3F);
		assertTrue(resultDto.getResultado().equals(6F));
	}

	/**
	 * Cumple la condicion: operacion ="R", nun1 != null, nun2!=null
	 */
	@Test
	public void calcualdoraRestaController() {
		ResultadoDTO resultdadoSeteado = new ResultadoDTO();
		resultdadoSeteado.setResultado(0F);
		when(calculadorServicio.calcular(OperacionesConstanstes.RESTA, 3F, 3F)).thenReturn(resultdadoSeteado);
		ResultadoDTO resultDto = calculadoraController.Calculadora(OperacionesConstanstes.RESTA, 3F, 3F);
		assertTrue(resultDto.getResultado().equals(0F));
	}

	/**
	 * No Cumple la condicion: operacion ="R" o "S" cumple nun1 = !null nun2
	 * !=null,
	 */
	@Test
	public void calcualdoraSumaRestaController3() {
		ResultadoDTO resultdadoSeteado = new ResultadoDTO();
		resultdadoSeteado.setResultado(0F);
		ResultadoDTO res = calculadoraController.Calculadora(null, 3F, 3F);

		ObjectMapper mapper = new ObjectMapper();
		String contenido = "";
		MockHttpServletResponse response = new MockHttpServletResponse();
		try {
			contenido = mapper.writeValueAsString(res);
		} catch (JsonProcessingException e) {

			log.error("JsonProcessingException", e);
		}
		try {
			response = mockMvc
					.perform(post("/calculadora".concat("/operaciones"))
							.contentType(MediaType.MULTIPART_FORM_DATA_VALUE).content(contenido))
					.andDo(print()).andReturn().getResponse();
		} catch (Exception e) {

			log.error("Response error", e);
		}

		Assertions.assertThat(response.getStatus()).isEqualTo(400);

	}

	/**
	 * Cumple la condicion: operacion ="R" y nun2 !=null, no cumple nun1 = !null
	 */
	@Test
	public void calcualdoraRestaController3() {
		ResultadoDTO resultdadoSeteado = new ResultadoDTO();
		resultdadoSeteado.setResultado(0F);

		ResultadoDTO res = calculadoraController.Calculadora(OperacionesConstanstes.RESTA, null, 3F);

		ObjectMapper mapper = new ObjectMapper();
		String contenido = "";
		MockHttpServletResponse response = new MockHttpServletResponse();
		try {
			contenido = mapper.writeValueAsString(res);
		} catch (JsonProcessingException e) {

			log.error("JsonProcessingException", e);
		}
		try {
			response = mockMvc
					.perform(post("/calculadora".concat("/operaciones"))
							.contentType(MediaType.MULTIPART_FORM_DATA_VALUE).content(contenido))
					.andDo(print()).andReturn().getResponse();
		} catch (Exception e) {

			log.error("Response error", e);
		}

		Assertions.assertThat(response.getStatus()).isEqualTo(400);

	}

	/**
	 * Cumple la condicion: operacion ="S" y nun2 !=null, no cumple nun1 = !null
	 */
	@Test
	public void calcualdoraSumaController3() {
		ResultadoDTO resultdadoSeteado = new ResultadoDTO();
		resultdadoSeteado.setResultado(0F);

		ResultadoDTO res = calculadoraController.Calculadora(OperacionesConstanstes.SUMA, null, 3F);

		ObjectMapper mapper = new ObjectMapper();
		String contenido = "";
		MockHttpServletResponse response = new MockHttpServletResponse();
		try {
			contenido = mapper.writeValueAsString(res);
		} catch (JsonProcessingException e) {

			log.error("JsonProcessingException", e);
		}
		try {
			response = mockMvc
					.perform(post("/calculadora".concat("/operaciones"))
							.contentType(MediaType.MULTIPART_FORM_DATA_VALUE).content(contenido))
					.andDo(print()).andReturn().getResponse();
		} catch (Exception e) {

			log.error("Response error", e);
		}

		Assertions.assertThat(response.getStatus()).isEqualTo(400);

	}

	/**
	 * Cumple la condicion: operacion ="R" y nun2 !=null, no cumple nun1 = !null
	 */
	@Test
	public void calcualdoraRestaController4() {
		ResultadoDTO resultdadoSeteado = new ResultadoDTO();
		resultdadoSeteado.setResultado(0F);

		ResultadoDTO res = calculadoraController.Calculadora(OperacionesConstanstes.RESTA, 3F, null);

		ObjectMapper mapper = new ObjectMapper();
		String contenido = "";
		MockHttpServletResponse response = new MockHttpServletResponse();
		try {
			contenido = mapper.writeValueAsString(res);
		} catch (JsonProcessingException e) {

			log.error("JsonProcessingException", e);
		}
		try {
			response = mockMvc
					.perform(post("/calculadora".concat("/operaciones"))
							.contentType(MediaType.MULTIPART_FORM_DATA_VALUE).content(contenido))
					.andDo(print()).andReturn().getResponse();
		} catch (Exception e) {

			log.error("Response error", e);
		}

		Assertions.assertThat(response.getStatus()).isEqualTo(400);

	}

	/**
	 * No Cumple la condicion: operacion ="R" ni nun2 !=null ni cumple nun1 =
	 * !null
	 */
	@Test
	public void calcualdoraSumaRestaController5() {
		ResultadoDTO resultdadoSeteado = new ResultadoDTO();
		resultdadoSeteado.setResultado(0F);

		ResultadoDTO res = calculadoraController.Calculadora(null, null, null);

		ObjectMapper mapper = new ObjectMapper();
		String contenido = "";
		MockHttpServletResponse response = new MockHttpServletResponse();
		try {
			contenido = mapper.writeValueAsString(res);
		} catch (JsonProcessingException e) {

			log.error("JsonProcessingException", e);
		}
		try {
			response = mockMvc
					.perform(post("/calculadora".concat("/operaciones"))
							.contentType(MediaType.MULTIPART_FORM_DATA_VALUE).content(contenido))
					.andDo(print()).andReturn().getResponse();
		} catch (Exception e) {

			log.error("Response error", e);
		}

		Assertions.assertThat(response.getStatus()).isEqualTo(400);

	}

	/**
	 * No Cumple la condicion: operacion ="R" ni nun2 !=null ni cumple nun1 =
	 * !null
	 */
	@Test
	public void calcualdoraSumaRestaController6() {
		ResultadoDTO resultdadoSeteado = new ResultadoDTO();
		resultdadoSeteado.setResultado(0F);

		ResultadoDTO res = calculadoraController.Calculadora("", 3F, 3F);

		ObjectMapper mapper = new ObjectMapper();
		String contenido = "";
		MockHttpServletResponse response = new MockHttpServletResponse();
		try {
			contenido = mapper.writeValueAsString(res);
		} catch (JsonProcessingException e) {

			log.error("JsonProcessingException", e);
		}
		try {
			response = mockMvc
					.perform(post("/calculadora".concat("/operaciones"))
							.contentType(MediaType.MULTIPART_FORM_DATA_VALUE).content(contenido))
					.andDo(print()).andReturn().getResponse();
		} catch (Exception e) {

			log.error("Response error", e);
		}

		Assertions.assertThat(response.getStatus()).isEqualTo(400);

	}

	/**
	 * No Cumple la condicion: operacion ="R" ni nun2 !=null ni cumple nun1 =
	 * !null
	 */
	@Test
	public void calcualdoraSumaRestaController7() {
		ResultadoDTO resultdadoSeteado = new ResultadoDTO();
		resultdadoSeteado.setResultado(0F);

		ResultadoDTO res = calculadoraController.Calculadora(" ", 3F, 3F);

		ObjectMapper mapper = new ObjectMapper();
		String contenido = "";
		MockHttpServletResponse response = new MockHttpServletResponse();
		try {
			contenido = mapper.writeValueAsString(res);
		} catch (JsonProcessingException e) {

			log.error("JsonProcessingException", e);
		}
		try {
			response = mockMvc
					.perform(post("/calculadora".concat("/operaciones"))
							.contentType(MediaType.MULTIPART_FORM_DATA_VALUE).content(contenido))
					.andDo(print()).andReturn().getResponse();
		} catch (Exception e) {

			log.error("Response error", e);
		}

		Assertions.assertThat(response.getStatus()).isEqualTo(400);

	}
}
