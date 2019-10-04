package com.app.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.app.socialbooks.client.AutorClient;
import com.app.socialbooks.client.domain.Autor;
import com.app.socialbooks.client.domain.Livro;

public class Aplicacao {
		
	public static void main(String[] args) throws ParseException {
						
		AutorClient cliente = new AutorClient();
		List<Autor> listaAutores = cliente.listar();
        
        //Verifica se resposta tem corpo
        if(!listaAutores.isEmpty()) {
        	//Verifica se há itens na lista para interação        	
        		for(Autor item : listaAutores)
        			System.out.println(item.getNome());//escreve nome de cada autor no console
        }
        
        /*Salvar Autor*/
        Autor autor= new Autor();
        autor.setNome("Edwin Oliveira");
        SimpleDateFormat dataNascimento = new SimpleDateFormat("dd/MM/yyyy");
        autor.setDataNascimento(dataNascimento.parse("16/05/1988"));        
        autor.setNacionalidade("Brasileira");
        List<Livro> listaLivros = new ArrayList();
        autor.setListaLivros(listaLivros);
        
        String locationAutor = cliente.salvar(autor);
        
        if(locationAutor != null)
        	System.out.println(locationAutor);
 
	}
}
