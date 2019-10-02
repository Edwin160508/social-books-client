package com.app.socialbooks.aplicacao;

import java.util.List;

import com.app.socialbooks.client.AutorClient;
import com.app.socialbooks.client.domain.Autor;

public class Aplicacao {
		
	public static void main(String[] args) {
						
		AutorClient cliente = new AutorClient();
		List<Autor> listaAutores = cliente.listar();
        
        //Verifica se resposta tem corpo
        if(!listaAutores.isEmpty()) {
        	//Verifica se há itens na lista para interação        	
        		for(Autor item : listaAutores)
        			System.out.println(item.getNome());//escreve nome de cada autor no console
        }
 
	}
}
