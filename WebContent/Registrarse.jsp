<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" href="Style/icons/favicon.ico">
<title>Registrarse</title>
 <link href="Style/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div>
		<div class="container">
			<form>
				<div class="form-group col-xs-12 col-sm-6 col-md-8">
					<label>Nombre:</label>
					<input type="text" id="nombre" required>
				</div>
				<div class="form-group col-xs-12 col-sm-6 col-md-8">
					<label>Apellido:</label>
					<input type="text" id="apellido" required>
				</div>
				<div class="form-group col-xs-12 col-sm-6 col-md-8" >
					<label>Teléfono:</label>
					<input type="text" id="tel" required>
				</div>
				<div class="form-group col-xs-12 col-sm-6 col-md-8">
					<label>Email:</label>
					<input type="email" id="mail"required>
				</div>
				<div class="form-group">
					<label>Nacimiento:</label>
					<input type="date" id="fechaNaci" required>
				</div>
			</form>
		</div>
</div>
</body>
</html>