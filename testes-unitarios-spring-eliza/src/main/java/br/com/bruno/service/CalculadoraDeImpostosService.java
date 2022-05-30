package br.com.bruno.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraDeImpostosService {
	public double calcularPis(double valor) {
		return valor * 0.10;
		
	}
	
	public double calcularCofins(double valor) {
		return valor * 0.15;
	}
}
