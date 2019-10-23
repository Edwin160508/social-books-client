$(function (){
	$(".js-load-books").on("click", function (){
		$.ajax({
			url:"http://localhost:8080/app/api/livros",
			type:"get",
			headers: {
				"Authorization":"Basic YWRtaW46YWRtaW4="
			},
			success: function(response){				
				desenhaTabela(response);
			}
		});
	});
});

function desenhaTabela(dados){
	$(".js-books-table-body tr").remove();
	
	for(var i=0; i<dados.length; i++){
		desenhaLinha(dados[i]);
	}
}

function desenhaLinha(linha){
	var linhaTabela = $("<tr>");
	linhaTabela.append("<td>"+linha.id+"</td>");
	linhaTabela.append("<td>"+linha.nome+"</td>");
	linhaTabela.append("<td>"+linha.editora+"</td>");
	linhaTabela.append("<td>"+linha.publicacao+"</td>");
	linhaTabela.append("<td>"+linha.resumo+"</td>");
	
	$(".js-books-table-body").append(linhaTabela);
	
}