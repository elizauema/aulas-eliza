package br.com.eliza.bibliaapi.dto.entrada;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VersiculoTest {
	Versiculo versiculo;
	
	@Before
	public void inicializar() {
		versiculo = new Versiculo();
		versiculo.setNumero(16);
		versiculo.setTexto("Porque Deus amou ao mundo de tal maneira que deu o seu Filho unigênito, para que todo o que nele crê não pereça, mas tenha a vida eterna.");
	}
	
	@Test
	public void deveTestarConstrutorPadraoEGettersESetters() {
		assertEquals(16, versiculo.getNumero());
		assertEquals("Porque Deus amou ao mundo de tal maneira que deu o seu Filho unigênito, para que todo o que nele crê não pereça, mas tenha a vida eterna.", versiculo.getTexto());
	}
	@Test
	public void deveTestarToString() {
		//System.out.println(versiculo.toString());
		assertEquals("Versiculo [numero=16, texto=Porque Deus amou ao mundo de tal maneira que deu o seu Filho unigênito, para que todo o que nele crê não pereça, mas tenha a vida eterna.]", versiculo.toString());
	
	}
	
}
