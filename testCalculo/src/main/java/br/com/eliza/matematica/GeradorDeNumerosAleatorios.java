package br.com.eliza.matematica;

public class GeradorDeNumerosAleatorios {
	public double gerarNumero(double min,double max) {
		return (double) Math.floor(Math.random()* (max - min + 1) + min);
	}
	//public static void main(String[] args) {
	//	System.out.println(gerarNumero(1.0, 10.0));
	//}
}
