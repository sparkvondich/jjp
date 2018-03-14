<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>SCT - Cadastro de Cursos</title>
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
	 
 	<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
</head>
<body>
	
	<jsp:include page="menu.jsp"></jsp:include>
	<script>
		$(function(){
			$('.menu').click(function(){
				$('.menu').removeClass('active');
				$('#menuCurso').addClass('active');
			});
		});
	</script>
	<jsp:useBean id="escolaBean" class="br.com.fiap.sct.bean.EscolasBean" />
	<jsp:useBean id="cursoBean" class="br.com.fiap.sct.bean.CursosBean" />
	
	<div class="container">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h5 class="panel-title">
					<span class="glyphicon glyphicon-flag"></span>&nbsp;Cadastro de Cursos
				</h5>
			</div>
			<div class="panel-body">
			
				<form action="cadastrarCurso" method="post">
					<div>${mensagem}</div>
					  <div class="form-group col-md-12">
					  	
					  	<label class="control-label" for="escola">Escola</label>
					    <select id="escola" name="escolaSelecionada" class="form-control" required>
					      <option value="">Selecione</option>
					      <c:forEach var="escola" items="${escolaBean.consultarEscolas}">
							<option value="${escola.id}">${escola.nome}</option>					      
					      </c:forEach>
					    </select>
					    
					  </div>
					  
  					  <div class="form-group col-md-12">
						  <label class="control-label" for="nome">Nome</label>  
  		 				  <input id="nome" name="nome" type="text" placeholder="Digite o nome do Curso" class="form-control input-md" required />
  					  </div>
  					  
					  <div class="pull-right">
						<button class="btn btn-primary"><span class="glyphicon glyphicon-saved"></span> Incluir</button>
					  </div>
					    	
				 </form>
		  		<br><br><br><br><br><br><br><br>
		  		<br><br>
				<div class="panel panel-info">
				  
				  <div class="panel-heading">Lista de Cursos</div>
				  <div class="panel-body">
				     <table class="table">
					    <thead>
					    	<tr>
					    		<th>Escola</th>
						    	<th>Nome</th>
						    	<th>Disciplinas</th>
						    	<th>Alunos</th>
						    	<th></th>
						    </tr>	
					    </thead>
					    <tbody>
					    	<c:forEach var="curso" items="${cursoBean.consultarCursos}">
								<tr>
									<td><c:out value="${curso.escola.nome}"/></td>
									<td><c:out value="${curso.nome}"/></td>
									<td>
										<c:forEach var="disciplina" items="${curso.disciplinas}">
											* ${disciplina.nome} <br>
										</c:forEach>
									</td>
									<td>
										<c:forEach var="aluno" items="${curso.alunos}">
											* ${aluno.nome} <br>
										</c:forEach>
									</td>
									<td><a href="excluirCurso?codigo=${curso.id}"><span class="glyphicon glyphicon-trash"></span></a>
								</tr>
							</c:forEach>
					    </tbody>
					  </table>
				  </div>
				
				</div>
			</div>  
		</div>
	</div>
		
</body>
</html>
