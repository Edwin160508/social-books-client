package com.app.socialbooks.client;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.app.socialbooks.client.domain.Autor;

/**
 * 
 * Classe responsável por consumir todo o recurso referente a Autor, da api. 
 * 
 * @author edwin
 *
 */
public class AutorClient {

	static final String URL_AUTORES = "http://localhost:8080/app/api/autores";
	
	/**
	 * 
	 *  Método responsável por listar todos os autores
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
	
	public String salvar(Autor autor) {
		RestTemplate restTemplate = new RestTemplate();		
		JSONObject parseJsonObject = new JSONObject();
		parseJsonObject.put("nome", autor.getNome());
		parseJsonObject.put("dataNascimento", autor.getDataNascimento());
		parseJsonObject.put("nacionalidade", autor.getNacionalidade());				
		HttpEntity request = new HttpEntity(parseJsonObject,Login.jsonComunication());
		ResponseEntity response = restTemplate.exchange(URL_AUTORES, HttpMethod.POST, request, Autor.class); 
		return response.getHeaders().getLocation().toString();

	}
}
