<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>SCT - Cadastro de Alunos</title>
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
		<div class="panel panel-success">
			<div class="panel-heading">
				<h5 class="panel-title">
					<span class="glyphicon glyphicon-education"></span>&nbsp;Cadastro de Alunos
				</h5>
			</div>
			<div class="panel-body">
			
				<form action="cadastrarAluno" method="post">
					<div>${mensagem}</div>
					<div class="form-group col-md-12">
					  	
					  	<label class="control-label" for="curso">Curso</label>
					    <select id="curso" name="cursoSelecionado" class="form-control" required>
					      <option value="">Selecione</option>
					      <c:forEach var="curso" items="${cursoBean.consultarCursos}">
							<option value="${curso.id}">${curso.nome}</option>					      
					      </c:forEach>
					    </select>
					    
					 </div>
					  
  					  <div class="form-group col-md-8">
						  <label class="control-label" for="nome">Nome</label>  
  		 				  <input id="nome" name="nome" type="text" placeholder="Digite o nome do Aluno" class="form-control input-md" required />
  					  </div>
  					  
  					   <div class="form-group col-md-4">
						  <label class="control-label" for="ra">Registro do ALuno (RA)</label>  
  		 				  <input id="ra" name="ra" type="number" placeholder="Digite o RA do Aluno" class="form-control input-md" required />
  					  </div>
  					  
  					  <div class="form-group col-md-4">
						  <label class="control-label" for="login">Login</label>  
  		 				  <input id="login" name="login" type="text" placeholder="Digite o Login do Aluno" class="form-control input-md" required />
  		 				  <span class="help-block">Este Login será usado para entrar no sistema</span>  
  					  </div>
  					  
  					  <div class="form-group col-md-4">
						  <label class="control-label" for="senha">Senha</label>  
  		 				  <input id="senha" name="senha" type="password" placeholder="Digite a senha" class="form-control input-md" required />
  					  </div>
  					  
  					  <div class="form-group col-md-4">
						  <label class="control-label" for="confirmacaoSenha">Confirmar senha</label>  
  		 				  <input id="confirmacaoSenha" name="confirmacaoSenha" type="password" placeholder="Confirme a senha" class="form-control input-md" required />
  					  </div>
  					  
   					  <c:if test="${sessionScope.usuarioAutenticado.perfil eq 'ADMINISTRADOR'}">
						  <div class="pull-right">
							<button class="btn btn-primary"><span class="glyphicon glyphicon-saved"></span> Incluir</button>
						  </div>
					  </c:if>
					    	
				 </form>
		  		<br><br><br><br><br><br><br><br><br><br><br><br>
		  		<br><br>
				<div class="panel panel-info">
				  
				  <div class="panel-heading">Lista de Alunos</div>
				  <div class="panel-body">
				     <table class="table">
					    <thead>
					    	<tr>
					    		<th>Curso</th>
						    	<th>RA</th>
						    	<th>Nome</th>
						    	<th>Notas</th>
						    	<th></th>
						    </tr>	
					    </thead>
					    <tbody>
					    	<c:forEach var="aluno" items="${alunoBean.consultarAlunos}">
								<tr>
									<td><c:out value="${aluno.curso.nome}"/></td>
									<td><c:out value="${aluno.ra}"/></td>
									<td><c:out value="${aluno.nome}"/></td>
									<td><a href="consultarBoletim?codigoAluno=${aluno.id}">Consultar Notas</a></td>
									<td><a href="excluirAluno?codigo=${aluno.ra}"><span class="glyphicon glyphicon-trash"></span></a></td>
									
								</tr>
							</c:forEach>
					    </tbody>
					  </table>
				  </div>
				
				</div>
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
