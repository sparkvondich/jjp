<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/home.jsp">Sistema de Cadastro de Trabalhos</a>
	    </div>
	
	    <div class="collapse navbar-collapse" id="menu">
	      <ul class="nav navbar-nav">
	      <c:if test="${sessionScope.usuarioAutenticado.perfil eq 'ADMINISTRADOR'}">
	        <li id="menuEscola" class="menu"><a href="${pageContext.request.contextPath}/admin/cadastrarEscolas.jsp">Escolas</a></li>
	        <li id="menuCurso" class="menu"><a href="${pageContext.request.contextPath}/admin/cadastrarCursos.jsp">Cursos</a></li>
	        <li id="menuDisciplina" class="menu"><a href="${pageContext.request.contextPath}/admin/cadastrarDisciplinas.jsp">Disciplinas</a></li>
	        <li id="menuProfessor" class="menu"><a href="${pageContext.request.contextPath}/admin/cadastrarProfessores.jsp">Professores</a></li>
	       </c:if>
	        
	        <li id="menuAluno" class="menu dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Alunos <span class="caret"></span></a>
	          <ul class="dropdown-menu">
		          <c:choose>
		          	<c:when test="${sessionScope.usuarioAutenticado.perfil eq 'ALUNO'}">
		          		<li><a href="${pageContext.request.contextPath}/admin/consultarBoletim?codigoAluno=${sessionScope.codigoAluno}">Consultar Notas</a></li>
		          	</c:when>
		          	<c:otherwise>
		          		<li><a href="${pageContext.request.contextPath}/admin/cadastrarAlunos.jsp">Consultar Alunos</a></li>
		          	</c:otherwise>
		          </c:choose>
	            <li>
	          </ul>
	        </li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <li><a href="#" onclick="javascript: return false;" >
	        		Usuário Logado: <c:out value="${sessionScope.usuarioAutenticado.login}" />
	        		Perfil: <c:out value="${sessionScope.usuarioAutenticado.perfil}" />  
	        	</a>
	        </li>
	        <li><a href="${pageContext.request.contextPath}/login.jsp"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
	      </ul>
	    </div>
	  </div>
</nav>