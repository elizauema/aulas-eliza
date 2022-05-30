package br.com.eliza.bibliaapi.dto.entrada;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ParteDaBibliaTest {
	ParteDaBiblia parteDaBiblia;

	@Before
	public void inicializar() {
		parteDaBiblia = new ParteDaBiblia();
		parteDaBiblia.setLivro(new Livro());
		parteDaBiblia.setCapitulo(new Capitulo());
		parteDaBiblia.setVersiculos(new ArrayList<Versiculo>());
	}

	@Test
	public void testarGettersESetters() {
		assertNotNull(parteDaBiblia.getLivro());
		assertNotNull(parteDaBiblia.getCapitulo());
		assertNotNull(parteDaBiblia.getVersiculos());

	}

	@Test
	public void testarToString() {
		System.out.println(parteDaBiblia.toString());
		assertEquals("ParteDaBiblia [livro=Livro [nome=null, autor=null, grupo=null, traducao=null, abreviacao=null], capitulo=Capitulo [numero=0, qtdeVerso=0], versiculos=[]]",parteDaBiblia.toString());
	}
}
