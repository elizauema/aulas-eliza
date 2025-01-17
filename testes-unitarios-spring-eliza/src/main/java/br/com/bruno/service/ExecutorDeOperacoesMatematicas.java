package br.com.bruno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ExecutorDeOperacoesMatematicas {
	@Autowired
	GeradorDeNumerosAleatorios gerador;

	public double somar(double numero1, double numero2) {
		return numero1 + numero2;
	}
	
	public double somarNumerosAleatorios(double min, double max) {
		return gerador.gerarNumero(min, max) + gerador.gerarNumero(min, max);
	}
	
	public int dividir(int numero1, int numero2) {
		return numero1 / numero2;
	}
	public void imprimirMaior(Matematica matematica,int a, int b) {
		int maior = matematica.max(a, b);
		System.out.println("########### maior:"+ maior+ " ###########");
	}

	public GeradorDeNumerosAleatorios getGerador() {
		return gerador;
	}

	public void setGerador(GeradorDeNumerosAleatorios gerador) {
		this.gerador = gerador;
	}
	
	
}
