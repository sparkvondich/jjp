<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>SCT - Login</title>
	 <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	 <meta charset="utf-8" />
	 <meta name="viewport" content="width=device-width, initial-scale=1"/>
	 <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	 <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	 <meta http-equiv="Pragma" content="no-cache" />
	 <meta http-equiv="Expires" content="-1" />
	 <meta http-equiv="Cache-Control" content="no-cache" />
	 <link rel="shortcut icon" href="imagens/logo.jpg" />
	 <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	 <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	 <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
	 <link rel="stylesheet" type="text/css" href="css/sct.css" />
</head>
<body>
	<br><br>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4" style="background-color: #d9edf7;">
				<br>
				<img src="imagens/logo.jpg" width="210" height="70" alt="Sistema de Cadastro de Trabalhos" title="Sistema de Cadastro de Trabalhos" class="center-block img-responsive" />
				<hr>
				<form action="${pageContext.request.contextPath}/login" method="POST">
					<label for="perfil">Perfil</label>
					<div class="form-group">
						<select id="perfil" name="perfil" class="form-control">
						   <option value="" label="--- Selecione ---"/>
						   <option value="0" label="ADMINISTRADOR" />
						   <option value="1" label="PROFESSOR" />
						   <option value="2" label="ALUNO" />
						</select>
					</div>
					<label for="usuario">Usuário</label>
					<div class="input-group">
						<input id="login" name="login" class="form-control" />
						<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
					</div>
					<br />
					<label for="senha">Senha</label>
					<div class="input-group">
						<input type="password" id="senha" name="senha" class="form-control"  />
						<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
					</div>
					<br>
					<button type="submit" class="btn btn-block btn-lg btn-success"> Entrar </button>
					<br>
					<div class="alert alert-success alert-dismissable">
						<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
						O campo usuário deverá ser informado apenas números. Caso o usuário seja INTERNO incluir a matrícula do funcionário, caso seja CORRETOR incluir o código ACSEL!
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>