<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>SCT - Home</title>
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
	
	<div class="container">
		<div class="row">
			<h3>Bem vindo <c:out value="${sessionScope.usuarioAutenticado.login}" /> !! </h3>
			Perfil Autenticado ==> <c:out value="${sessionScope.usuarioAutenticado.perfil}" />  
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>