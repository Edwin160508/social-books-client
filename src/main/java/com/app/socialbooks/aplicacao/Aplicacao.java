package com.app.socialbooks.aplicacao;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;
import org.apache.commons.codec.binary.Base64;

public class Aplicacao {
	
	public static final String USER_NAME = "admin";
	public static final String PASSWORD = "admin";
	 
	    static final String URL_AUTORES = "http://localhost:8080/app/api/autores";
	public static void main(String[] args) {
		
		// HttpHeaders
        HttpHeaders headers = new HttpHeaders();
        StringBuilder concat = new StringBuilder();
        concat.append(USER_NAME);
        concat.append(":");
        concat.append(PASSWORD);
        String auth = concat.toString();
        byte[] encodedAuth =  Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        headers.set("Authorization", authHeader);
        // 
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("my_other_key", "my_other_value");
        
     // HttpEntity<String>: To get result as String.
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        
		RestTemplate restTemplate = new RestTemplate();
		
		// Send request with GET method, and Headers.
        ResponseEntity<String> response = restTemplate.exchange(URL_AUTORES, //
                HttpMethod.GET, entity, String.class);
 
        String result = response.getBody();
 
        System.out.println(result);
	}
}
