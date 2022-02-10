package br.com.eliza.bibliaapi.service;

import java.io.IOException;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.eliza.bibliaapi.dados.BibliaApiExibe;
import br.com.eliza.bibliaapi.model.ParteDaBiblia;

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
            // criar com todos os dados
			return new BibliaApiExibe(nome, autor, grupo);
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
}
