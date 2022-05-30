package br.com.bruno.service;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CalculadoraDeImpostosServiceTest {
	
	@InjectMocks
	CalculadoraDeImpostosService calculadora;
	
	@Test
	public void calcularPis() {
		double valorCalcular=0;
		double resultado = calculadora.calcularPis(valorCalcular);
		double deveriaSer = valorCalcular * 0.10;
		assertEquals (deveriaSer, resultado,0.01);
	}
	
	@Test
	public void calcularCofins() {
		double valorCalcular=0;
		double resultado = calculadora.calcularCofins(valorCalcular);
		double deveriaSer = valorCalcular * 0.15;
		assertEquals (deveriaSer, resultado,0.01);
	}
	
}
