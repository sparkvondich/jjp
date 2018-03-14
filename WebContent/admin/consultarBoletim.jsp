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
	<jsp:useBean id="alunosBean" class="br.com.fiap.sct.bean.AlunosBean" />
	
	<div class="container">
		<div class="panel panel-primary"> 
			<div class="panel-heading">
				<h5 class="panel-title">
					<span class="glyphicon glyphicon-info-sign"></span>&nbsp;Informações do Aluno
				</h5>
			</div>
			<div class="panel-body">
			
  				<div class="form-group col-md-8">
					<label class="control-label" for="nome">Nome do Aluno</label>  
  		 			<input id="nome" name="nome" type="text" value="${aluno.nome}" class="form-control input-md" readonly maxlength="80" />
  				</div>
  					  
  				<div class="form-group col-md-4">
					<label class="control-label" for="ra">Registro do Aluno (RA) </label>  
  		 			<input id="ra" name="ra" type="text" value="${aluno.ra}" placeholder="Digite o Endereço" class="form-control input-md" readonly maxlength="100" />
  				</div>
  					  
  				<div class="form-group col-md-12">
					<label class="control-label" for="telefone">Curso</label>  
  		 			<input id="curso" name="curso" type="text" value="${aluno.curso.nome}" class="form-control input-md" readonly maxlength="14" />
  				</div>
					    	
			  	<br><br><br><br><br><br><br><br><br><br>
		  	
			<div class="panel panel-danger">
			  <div class="panel-heading">
			  	<h5 class="panel-title">
					<span class="glyphicon glyphicon-check"></span>&nbsp;Boletim
				</h5>
			  </div>
			  <div class="panel-body">
			     <table class="table table-bordered table-hover">
				    <thead>
				    	<tr>
					    	<th>Disciplina</th>
					    	<th>Projeto 1 (30%)</th>
					    	<th>Atividade Prática (30%)</th>
					    	<th>Projeto 2 (40%)</th>
					    	<th>Média</th>
					    	<th>Status</th>
					    	<th></th>
					    </tr>	
				    </thead>
				    <tbody>
				    	<jsp:setProperty name="alunosBean" property="codigoAluno" value="${aluno.id}"/>
				    	<c:forEach var="boletim" items="${alunosBean.consultarBoletim}">
							<tr>
								<td><c:out value="${boletim.descricaoDisciplina}"/></td>
								<td style="text-align: center;"><c:out value="${boletim.nota.projeto1}"/></td>
								<td style="text-align: center;"><c:out value="${boletim.nota.atividadePratica}"/></td>
								<td style="text-align: center;"><c:out value="${boletim.nota.projeto2}"/></td>
								<td style="text-align: center;"><c:out value="${boletim.media}"/></td>
								<td style="text-align: center;"><span>${boletim.status}</span></td>
								<td>
									<c:choose>
										<c:when test="${sessionScope.usuarioAutenticado.perfil eq 'PROFESSOR'}">
											<a href="cadastrarNota?codigoAluno=${boletim.codigoAluno}&codigoDisciplina=${boletim.codigoDisciplina}">Avaliar</a>
										</c:when>
										<c:otherwise>
											<span class="glyphicon glyphicon-lock" title="Apenas Professores podem avaliar"></span>
										</c:otherwise>
									</c:choose>
								</td>
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
				$('#menuEscola').addClass('active');
			});
		});
	</script>
</body>
</html>
