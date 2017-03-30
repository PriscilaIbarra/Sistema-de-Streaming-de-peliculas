<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" href="Style/icons/favicon.ico">
<title>Registrarse</title>
 <link href="Style/css/bootstrap.min.css" rel="stylesheet">
 <style type="text/css"> 
	@import "Style/css/Registrarse.css"; 
 </style>
 <style type="text/css">
 @font-face {
		    font-family:Vtks Revolt ;
   			src: url("Style/fonts/Vtks Revolt.ttf");
				}
 </style>
 </head>
<body>
<h1 id="titulo"> &nbsp; &nbsp;GMOVIES</h1>
<div> 
		<div id="cont1" class="container col-md-8" >
		<form class="col-md-8">
		<h1>Registrarse</h1>
				<div class="form-group">
					<label>Nombre:</label>
					<input class="form-control" type="text" id="nombre" required>
				</div>
				<div class="form-group">
					<label>Apellido:</label>
					<input class="form-control" type="text" id="apellido" required>
				</div>
				<div class="form-group" >
					<label>Teléfono:</label>
					<input class="form-control" type="text" id="tel" required>
				</div>
				<div class="form-group">
					<label>Nacimiento:</label>
					<input class="form-control" type="date" id="fechaNaci" required>
				</div>
				
					<label>Domicilio:</label>
					<div class="form-inline">
						<select name="provincia" class="form-control" id="provincia" required>
						<option>Provincia</option>
						</select>
						  		<select name="ciudad" class="form-control" id="ciudad" required>
								<option>Ciudad</option>
								</select>
									<select name="calle" class="form-control" id="calle" required >
										<option>Calle</option>
										</select>
										<input type="text" class="form-control" name="nroCalle" id="nroCalle" placeholder="número" > 
					</div>
					<br>
				<div class="form-group">
					<label>Email:</label>
					<input class="form-control" type="email" id="mail"required>
				</div>
				<div class="form-group">
					<label>Contraseña:</label>
					<input class="form-control"  type="password" id="mail"required>
				</div>
				<label>Plan:</label>
				<div class="form-inline">
						<select class="form-control"name="plan" id="plan" required>
						<option>Plan</option>
						</select>
						<div class="input-group">
						<div class="input-group-addon">$</div>
						<input class="form-control" type="text" placeholder="tarifa">
						<div class="input-group-addon">ARS</div>
						</div>
				</div>
				<br>
				<label>Tarjeta de Crédito:</label>
					<div class="form-inline">
							<select class="form-control" name="tipoTarjeta" id="tipoTarjeta">
								<option>Tipo</option>
							</select>
							<input class="form-control" type="text" placeholder="número" name="nroTarjeta" id="nroTarjeta">
					</div>
					
					<div class="checkbox"><label><input type="checkbox"><a href="">Aceptar Términos y Condiciones</a></label></div>
						<div class="button">
							<input type="submit" class="btn btn-primary" value="Registrarse">
						</div>
			</form>
		</div>
</div>
</body>
</html>