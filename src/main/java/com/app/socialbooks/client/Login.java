package com.app.socialbooks.client;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * 
 * Classe responsável por conter credenciais de acesso a api.
 * 
 * @author edwin
 *
 */
public class Login {

	public static final String USER_NAME = "admin";
	public static final String PASSWORD = "admin";
	
	/**
	 * 
	 * Método responsável por retornar um HttpHeader no formato JSON.
	 * 
	 * @return HttpHeader
	 */
	public static HttpHeaders jsonComunication() {
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
        
        return headers;
		
	}
	
}
