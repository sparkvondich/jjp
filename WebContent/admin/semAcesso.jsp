<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
 <title>SSC - Sem Acesso </title>
 <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
 <meta charset="utf-8" />
 <meta name="viewport" content="width=device-width, initial-scale=1"/>
 <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
 <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
 <meta http-equiv="Pragma" content="no-cache" />
 <meta http-equiv="Expires" content="-1" />
 <meta http-equiv="Cache-Control" content="no-cache" />
 <link rel="shortcut icon" href="${cdn.publico}/padrao/${cdn.versao}/images/ico/favicon.ico" />
 <link rel="stylesheet" type="text/css" href="${cdn.publico}/padrao/${cdn.versao}/css/bootstrap.min.css"/>
 <link rel="stylesheet" type="text/css" href="${cdn.publico}/padrao/${cdn.versao}/css/bootstrap-theme.min.css"/>
 <link rel="stylesheet" type="text/css" href="${cdn.publico}/padrao/${cdn.versao}/font-awesome/css/font-awesome.min.css"/>
 <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${cdn.publico}/padrao/${cdn.versao}/images/ico/apple-touch-icon-144x144.png">
</head>
<body>
	<div class="container">
  		<div class="jumbotron text-center">
   			<span class="fa fa-exclamation-triangle fa-5x text-danger"></span>
   			<h2 class="text-danger"><strong>SEM ACESSO</strong></h2>
   			<c:if test="${tipoUsuario == 2}">
   				<h4>Corretor não encontrado ou inativo no sistema!</h4>
  	 			<h4 class="text-info">Para solicitar acesso, entre em contato com o Help Desk do Corretor - 0300 33 TOKIO ou via Chat!</h4>
  			</c:if>
			<c:if test="${tipoUsuario == 1}">
				<h4>Usuário não encontrado ou inativo no sistema!</h4>
   				<h4 class="text-info">Para solicitar acesso, entre em contato com o Help Desk Tokio Marine através da Intranet ou através do Ramal: 6000!</h4>
   			</c:if>
  		</div>
 	</div>
</body>
</html>
