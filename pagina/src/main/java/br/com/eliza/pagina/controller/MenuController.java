package br.com.eliza.pagina.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.eliza.pagina.model.Produto;

@Controller
public class MenuController {
	@GetMapping("/pratoEntrada")
	public String pratoEntrada(Model model) {
		List<Produto> listaDeProdutos = List.of(new Produto("Salada Ceaser", new BigDecimal(25),
				"https://thumbs.dreamstime.com/z/salada-de-caesar-c…-p%C3%A3o-torrado-e-galinha-grelhada-68596870.jpg"),
				new Produto("Alcachofra", new BigDecimal(40),
						"https://pitadasepalpites.com.br/wp-content/uploads/2018/10/alchofra.jpg"));
		model.addAttribute("listaDeProdutos", listaDeProdutos);
		return "produtos";
	}

	@GetMapping("/pratoPrincipal")
	public String pratoPrinc(Model model) {
		List<Produto> listaDeProdutos = List.of(
				new Produto("Salmao Grelhado com legumes", new BigDecimal(35),
						"https://thumbs.dreamstime.com/z/fish-dish-grilled-salmon-cauliflower-24269402.jpg"),
				new Produto("Feijoada", new BigDecimal(50),
						"https://midiastm.gazetaonline.com.br/_midias/jpg/2019/07/25/prc240719gz202-6244036.jpg"),
				new Produto("Virado a Paulista", new BigDecimal(40),
						"https://www.comidaereceitas.com.br/img/sizeswp/1200x675/2020/01/virado_paulista.jpg"));
		model.addAttribute("listaDeProdutos", listaDeProdutos);
		return "produtos";
	}

	@GetMapping("/html-exemplos")
	public String html(Model model) {
		return "html-exemplos";
	}
}
