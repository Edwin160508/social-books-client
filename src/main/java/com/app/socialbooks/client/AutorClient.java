package com.app.socialbooks.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.app.socialbooks.client.domain.Autor;

/**
 * 
 * Classe respons�vel por consumir todo o recurso referente a Autor, da api. 
 * 
 * @author edwin
 *
 */
public class AutorClient {

	static final String URL_AUTORES = "http://localhost:8080/app/api/autores";
	
	/**
	 * 
	 *  M�todo respons�vel por listar todos os autores
	 * 
	 * @return List<Autor>
	 */
	public List<Autor> listar(){
				
		HttpEntity<String> entity = new HttpEntity<String>(Login.jsonComunication());
        
		RestTemplate restTemplate = new RestTemplate();
		
		// Envia request do tipo GET e Headers.
        ResponseEntity<Autor[]> response = restTemplate.exchange(URL_AUTORES, //
                HttpMethod.GET, entity, Autor[].class);
		
		return Arrays.asList(response.getBody());
	}
}