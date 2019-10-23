package com.app.socialbooks.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
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
	
	public String salvar(Autor autor) throws JSONException, ParseException {
		RestTemplate restTemplate = new RestTemplate();		
		/*JSONObject parseJsonObject = new JSONObject();
		parseJsonObject.put("nome", autor.getNome());
		parseJsonObject.put("dataNascimento", "16/05/1988");
		parseJsonObject.put("nacionalidade", autor.getNacionalidade());				
		HttpEntity request = new HttpEntity(parseJsonObject,Login.jsonComunication());*/
		Autor result = restTemplate.postForObject(URL_AUTORES, autor, Autor.class);
		//ResponseEntity response = restTemplate.exchange(URL_AUTORES, HttpMethod.POST, request, Autor.class); 
		return result.getNome();

	}
}
