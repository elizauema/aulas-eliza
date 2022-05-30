package br.com.eliza.alexa;

import br.com.eliza.matematica.GeradorDeNumerosAleatorios;

public class Alexa {
	public String perguntar(String pergunta) {
		if(pergunta.equals("Como vai voce?")) {
			String[] respostas = new String[3];
			respostas[0] = "Vou muito bem,obrigado";
			respostas[1] = "Estou bem e voce?";
			respostas[2] = "Vou bem nas alturas";
			return respostas[(int) new GeradorDeNumerosAleatorios().gerarNumero(0,2)];
		}else {
			return "Nao conheco essa";
		}
	}
}
