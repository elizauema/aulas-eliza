package br.com.eliza.matematica;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

public class ExecutorDeOperacoesMatematicasTest {
	@Test
	public void deveriaSomarDoisNumerosCorretamente() {
		double resultadoDaSoma = new ExecutorDeOperacoesMatematicas().somar(50.0, 50.0);
		double resultadoEsperado = 100.0;
		Assert.assertEquals(resultadoEsperado, resultadoDaSoma,0.01);
	}
	
	@Test
	public void deveriaSomarDoisNumerosAleatoriosCorretamente() {
		//GeradorDeDoisNumerosAleatorios gerador = new GeradorDeDoisNumerosAleatorios();
		GeradorDeNumerosAleatorios gerador = mock(GeradorDeNumerosAleatorios.class);
		when(gerador.gerarNumero(anyDouble(), anyDouble())).thenReturn(5.0);
		
		double resultadoDaSoma = new ExecutorDeOperacoesMatematicas(gerador).somarNumerosAleatorios(1.0, 10.0);
		
		double resultadoEsperado = 10.0;
		
		Assert.assertEquals(resultadoEsperado, resultadoDaSoma, 0.01);
				
				
	}
	
}
