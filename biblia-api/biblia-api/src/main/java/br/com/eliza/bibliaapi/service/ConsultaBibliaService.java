package br.com.eliza.bibliaapi.service;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.eliza.bibliaapi.dto.entrada.Abreviacao;
import br.com.eliza.bibliaapi.dto.entrada.ParteDaBiblia;
import br.com.eliza.bibliaapi.dto.entrada.UnicoVerso;
import br.com.eliza.bibliaapi.dto.entrada.Versiculo;
import br.com.eliza.bibliaapi.dto.saida.AbreviacaoSaida;
import br.com.eliza.bibliaapi.dto.saida.BibliaApiExibe;
import br.com.eliza.bibliaapi.dto.saida.VersiculoSaida;

@Service
public class ConsultaBibliaService {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public BibliaApiExibe consultarBiblia(String livro, String capitulo) {
		try {
			ParteDaBiblia parteDaBiblia = chamarApiBibilia(livro, capitulo);
            String nome = parteDaBiblia.getLivro().getNome();
			String autor = parteDaBiblia.getLivro().getAutor();
            String grupo = parteDaBiblia.getLivro().getGrupo();
            String traducao = parteDaBiblia.getLivro().getTraducao();
            Abreviacao abreviacao = parteDaBiblia.getLivro().getAbreviacao();
            double numero = parteDaBiblia.getCapitulo().getNumero();
            double qtdeVerso = parteDaBiblia.getCapitulo().getQtdeVerso();
            List<Versiculo> versiculos = parteDaBiblia.getVersiculos();
            List<VersiculoSaida> versiculosSaida = new ArrayList<VersiculoSaida>();
            
            AbreviacaoSaida abreviacaoSaida = new AbreviacaoSaida();
            abreviacaoSaida.setEn(abreviacao.getEn());
            abreviacaoSaida.setPt(abreviacao.getPt());
            
            for (int i = 0; i < versiculos.size(); i++) {
            	//VersiculoSaida versiculoSaida = new VersiculoSaida(versiculos.get(i).getNumero(),versiculos.get(i).getTexto());
            	//versiculosSaida.add(versiculoSaida);
            	// estas duas linhas é igual as 4 abaixo
            	VersiculoSaida versiculoSaida = new VersiculoSaida();
            	versiculoSaida.setNumero(versiculos.get(i).getNumero());
            	versiculoSaida.setTexto(versiculos.get(i).getTexto());
            	versiculosSaida.add(versiculoSaida);
            	
            }
            
            // criar com todos os dados
            // transforma lista de versiculo em uma lista de versiculo saida e passar no construtor na linha 41
            //return new BibliaApiExibe(nome, autor, grupo, traducao, abreviacaoSaida, numero, qtdeVerso, List<VersiculoSaida> versiculosSaida);
            return new BibliaApiExibe(nome, autor, grupo, traducao, abreviacaoSaida, numero, qtdeVerso, versiculosSaida);

		}catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao recuperar dados da bibilia");
		}
	}
	
	private ParteDaBiblia chamarApiBibilia(String livro, String capitulo) throws IOException, InterruptedException {
		String urlApiBiblia = "https://www.abibliadigital.com.br/api/verses/nvi/" + livro + "/" + capitulo;
		// 1-terminar este metodo(chamada da api da biblia)
		// 2-criar as classes que representam o retorno(colocar as classes no pcte DTO)
		RequisicaoHttpService requisicaoHttpService = new RequisicaoHttpService();
		HttpResponse<String> response = requisicaoHttpService.fazerChamadaHttp(urlApiBiblia);
		return objectMapper.readValue(response.body(), ParteDaBiblia.class);
	}
	
	// fazer consulta por livro,capitulo e versiculo
	// duplicar os metodos
	
	private UnicoVerso chamarApiBibiliaVersiculo(String livro, String capitulo,String numVersiculo ) throws IOException, InterruptedException {
		String urlApiBiblia = "https://www.abibliadigital.com.br/api/verses/nvi/" + livro + "/" + capitulo + "/" + numVersiculo;
		RequisicaoHttpService requisicaoHttpService = new RequisicaoHttpService();
		HttpResponse<String> response = requisicaoHttpService.fazerChamadaHttp(urlApiBiblia);
		return objectMapper.readValue(response.body(), UnicoVerso.class);
	}
	
	public BibliaApiExibe consultarBibliaVersiculo(String livro, String capitulo, String numVersiculo ) {
		try {
			UnicoVerso unicoVerso = chamarApiBibiliaVersiculo(livro, capitulo, numVersiculo);
			String nome = unicoVerso.getLivro().getNome();
			String autor = unicoVerso.getLivro().getAutor();
            String grupo = unicoVerso.getLivro().getGrupo();
            String traducao = unicoVerso.getLivro().getTraducao();
            Abreviacao abreviacao = unicoVerso.getLivro().getAbreviacao();
            double numero = Double.parseDouble(capitulo);
            double qtdeVerso = 1;
            AbreviacaoSaida abreviacaoSaida = new AbreviacaoSaida();
            abreviacaoSaida.setEn(abreviacao.getEn());
            abreviacaoSaida.setPt(abreviacao.getPt());

            List<VersiculoSaida> versiculosSaida = new ArrayList<VersiculoSaida>();
             
        	VersiculoSaida versiculoSaida = new VersiculoSaida();
        	versiculoSaida.setNumero(unicoVerso.getNumeroVersiculo());
        	versiculoSaida.setTexto(unicoVerso.getTextoVersiculo());
        	versiculosSaida.add(versiculoSaida);
           
            return new BibliaApiExibe(nome, autor, grupo, traducao, abreviacaoSaida, numero, qtdeVerso, versiculosSaida);

		}catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao recuperar dados da bibilia");
		}
	}
}
