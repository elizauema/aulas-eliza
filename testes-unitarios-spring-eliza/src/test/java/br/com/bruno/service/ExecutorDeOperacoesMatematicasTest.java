package br.com.bruno.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
public class ExecutorDeOperacoesMatematicasTest {

	@InjectMocks
	ExecutorDeOperacoesMatematicas executor;

	@Mock
	GeradorDeNumerosAleatorios gerador;

	@Test
	public void deveriaSomarDoisNumerosAleatoriosCorretamente() {

		when(gerador.gerarNumero(anyDouble(), anyDouble())).thenReturn(5.0);

		double resultadoDaSoma = executor.somarNumerosAleatorios(1.0, 10.0);

		double resultadoEsperado = 10.0;

		Assert.assertEquals(resultadoEsperado, resultadoDaSoma, 0.01);
		verify(gerador, times(2)).gerarNumero(anyDouble(), anyDouble());
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveriaLancarIllegalArgumentExceptionQuandoMinEMaxSaoMaioresQue1000() {

		GeradorDeNumerosAleatorios gerador = new GeradorDeNumerosAleatorios();
		ExecutorDeOperacoesMatematicas executor = new ExecutorDeOperacoesMatematicas();
		executor.setGerador(gerador);

		executor.somarNumerosAleatorios(1001.0, 1050.0);
	}

	@Test
	public void deveriaLancarIllegalArgumentExceptionQuandoMinEMaxSaoMaioresQueMil() {

		GeradorDeNumerosAleatorios gerador = new GeradorDeNumerosAleatorios();
		ExecutorDeOperacoesMatematicas executor = new ExecutorDeOperacoesMatematicas();
		executor.setGerador(gerador);

		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			executor.somarNumerosAleatorios(1001.0, 1050.0);
		});

		assertEquals("Numero nao pode ser maior que 1000", e.getMessage());
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveriaLancarIllegalArgumentExceptionQdoMaxEhMaiorQue1000() {
		doThrow(new IllegalArgumentException("Numero nao pode ser maior que 1000")).when(gerador)
				.gerarNumero(anyDouble(), anyDouble());
		executor.somarNumerosAleatorios(1.0, 1001.0);

		verify(gerador, times(1)).gerarNumero(anyDouble(), anyDouble());
	}

	public void deveriaDividirCorretamente() {
		int resultadoDaDivisao = executor.dividir(10, 5);
		assertEquals(2, resultadoDaDivisao);
	}

	@Test(expected = ArithmeticException.class)
	public void deveriaLancarArithmeticException() {
		executor.dividir(10, 0);
	}

	@Test
	public void deveriaImprimirONumeroMaiorCorretamente() {
		Matematica matematica = Mockito.mock(Matematica.class);
		when(matematica.max(anyInt(), anyInt())).thenReturn(6);

		executor.imprimirMaior(matematica, 2, 6);

		verify(matematica, times(1)).max(anyInt(), anyInt());
		verify(matematica, times(1)).max(2, 6);
	}

}
