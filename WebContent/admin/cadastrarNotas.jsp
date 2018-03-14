<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>SCT - Notas</title>
	 <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	 <meta charset="utf-8" />
	 <meta name="viewport" content="width=device-width, initial-scale=1"/>
	 <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	 <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	 <meta http-equiv="Pragma" content="no-cache" />
	 <meta http-equiv="Expires" content="-1" />
	 <meta http-equiv="Cache-Control" content="no-cache" />
	 <link rel="shortcut icon" href="${pageContext.request.contextPath}/imagens/logo.jpg" />
	 <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	 <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	 <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
	 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sct.css" />

</head>
<body>
	
	<jsp:include page="menu.jsp"></jsp:include>
	<jsp:useBean id="alunoBean" class="br.com.fiap.sct.bean.AlunosBean" />
	<jsp:useBean id="professorBean" class="br.com.fiap.sct.bean.ProfessoresBean" />
	<jsp:useBean id="cursoBean" class="br.com.fiap.sct.bean.CursosBean" />
	
	<div class="container">
		<div class="panel panel-warning">
			<div class="panel-heading">
				<h5 class="panel-title">
					<span class="glyphicon glyphicon-warning-sign"></span>&nbsp;Avaliação do Aluno
				</h5>
			</div>
			<div class="panel-body">
			
  				<div class="form-group col-md-8">
					<label class="control-label" for="nome">Nome do Aluno</label>  
  		 			<input id="nome" name="nome" type="text" value="${aluno.nome}" class="form-control input-md" readonly />
  				</div>
  				
  				<div class="form-group col-md-12">
					<label class="control-label" for="curso">Curso</label>
					<input id="curso" name="curso" type="text" value="${aluno.curso.nome}" class="form-control input-md" readonly />
				</div>
  					  
  				<div class="form-group col-md-12">
					<label class="control-label" for="ra">Disciplina</label>  
  		 			<input id="disciplina" name="disciplina" type="text" value="${disciplina.nome}" class="form-control input-md" readonly />
  				</div>
  					  
		  		<br><br><br><br>
		  		
		  		<form action="cadastrarNota" method="post">
		  			  
		  			  <input id="codigoAluno" name="codigoAluno" value="${aluno.id}" hidden=true />
		  			  <input id="codigoDisciplina" name="codigoDisciplina" value="${disciplina.id}" hidden=true />
		  				
  					  <div class="form-group col-md-4">
						  <label class="control-label" for="projeto1">Projeto 1</label>  
  		 				  <input id="projeto1" name="projeto1" type="number" value="${nota.projeto1}" class="form-control input-md" required />
  					  </div>
  					  
  					  <div class="form-group col-md-4">
						  <label class="control-label" for="atividadePratica">Atividade Prática</label>  
  		 				  <input id="atividadePratica" name="atividadePratica" value="${nota.atividadePratica}" type="number" class="form-control input-md" required />
  					  </div>
  					  
  					  <div class="form-group col-md-4">
						  <label class="control-label" for="projeto2">Projeto 2</label>  
  		 				  <input id="projeto2" name="projeto2" type="number" value="${nota.projeto2}" class="form-control input-md" required />
  					  </div>
  					  
					  <div class="pull-right">
						<button class="btn btn-primary"><span class="glyphicon glyphicon-saved"></span> Salvar </button>
					  </div>
					    	
				 </form>
		  		
			</div>  
		</div>
	</div>
		
	<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
	<script>
		$(function(){
			$('.menu').click(function(){
				$('.menu').removeClass('active');
				$('#menuAlunor').addClass('active');
			});
		});
	</script>
</body>
</html>
