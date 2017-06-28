<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" href="Style/icons/favicon.ico">
	<link rel="stylesheet" href="Style/css/bootstrap.min.css">
		<title>Iniciar Sesión</title>
		<style type="text/css" > 
		@import "Style/css/IniciarSesion.css"; 
		 </style>
 		<style type="text/css">
 			 @font-face {
		 				   font-family:Vtks Revolt ;
   						   src: url("Style/fonts/Vtks Revolt.ttf");
						}
		</style>
</head>
	<body>
		<h1 id="titulo"> &nbsp; &nbsp; GMOVIES</h1> 
			<div id="contenedor" class="container col-md-8">
				<form action="IniciarSesion" method="POST" class="col-md-8">
					<h1>Iniciar Sesión</h1>
						<div class="form-group">
							<label>Email:</label>
							<input class="form-control col-md-6" type="text" name="email" required>
						</div>
						<div class="form-group">
							<label>Contraseña:</label>
							<input class="form-control col-md-6" type="password" name="pass" required>
						</div>
						<br><br>
						<div>
						<input type="submit" value="Ingresar" class="btn btn-primary col-md-6">
						</div>
				</form>
			</div>
	</body>
</html>