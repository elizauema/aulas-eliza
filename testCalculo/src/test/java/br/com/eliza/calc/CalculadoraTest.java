package br.com.eliza.calc;

import org.junit.Assert;
import org.junit.Test;

import br.com.eliza.calc.Calculadora;

public class CalculadoraTest {
	@Test
	public void somarTest() {
		double resultado = Calculadora.somar(25.0, 30.0);
		double resultadoEsperado = 55.0;
		Assert.assertEquals(resultadoEsperado, resultado, 0.01);
	}
	
	@Test
	public void subtrairTest() {
		double resultado = Calculadora.subtrair(50.0, 30.0);
		double resultadoEsperado = 20.0;
		Assert.assertEquals(resultadoEsperado, resultado, 0.01);
	}
	
	@Test
	public void multiplicarTest() {
		double resultado = Calculadora.multiplicar(5.0, 30.0);
		double resultadoEsperado = 150.0;
		Assert.assertEquals(resultadoEsperado, resultado, 0.01);
	}
	
	@Test
	public void dividirTest() {
		double resultado = Calculadora.dividir(50.0, 25.0);
		double resultadoEsperado = 2.0;
		Assert.assertEquals(resultadoEsperado, resultado, 0.01);
	}
}
