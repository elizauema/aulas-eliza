package br.com.eliza.bibliaapi.service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import br.com.eliza.bibliaapi.dados.HttpRequestDados;
import br.com.eliza.bibliaapi.dados.HttpResponseDados;

public class HttpRequestService {

	protected String endpoint;
	protected HttpRequestDados requestDados;
	private HttpClient httpClient;
	protected HttpResponse response;
	
//	public final HttpResponseDados executarRequest(String endpoint, HttpRequestDados requestDto) {
//		this.endpoint = endpoint;
//		this.requestDados = requestDto;
//		HttpResponseDados responseDto = null;
//		
//		try {
//			criarHttpClient();
//			executarRequest();
//			responseDto = tratarReponse();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return responseDto;
//	}
//	protected void criarHttpClient() {
//		this.httpClient = HttpClientFactory.criarHttpClient();
//	}
//	protected void executarRequest() throws ClientProtocolException, IOException {
//		this.response = this.httpClient.execute();
//	}
	
}
