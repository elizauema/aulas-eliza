package br.com.eliza.bibliaapi.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import org.springframework.http.HttpStatus;

public class RequisicaoHttpService {
	
	public HttpResponse<String> fazerChamadaHttp(String url) throws IOException, InterruptedException {

		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder().version(HttpClient.Version.HTTP_2).uri(URI.create(url))
				.headers("Accept", "application/json").build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

		if (response.statusCode() != HttpStatus.OK.value()) {
			throw new RuntimeException("Ocorreu um erro ao realizar requisição HTTP.");
		}

		return response;
	}

}
