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
		 <script>
		 function validarMail()
 		{
			 var mail=document.getElementById("email").value;
			 var expresionRegular=/^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,3})$/;
			 if(expresionRegular.test(mail))
			 {document.getElementById("email").style.color='#00cc00';}
			 else{document.getElementById("email").style.color='#ff0000';
			 	  document.getElementById("boton").disabled = true;}
		 }
		 </script>
		 <script>
 		function validarpass()
 		{
		  var p=document.getElementById("pass").value;
		  if(p.length<=45)
		  {document.getElementById("pass").style.color='#00cc00';
		  	document.getElementById("boton").disabled = false;}
		  else{document.getElementById("pass").style.color='#ff0000';}
		 }
 		</script>
 		
 		<script>
 		function recargar()
 		{
 			mensaje.parentNode.removeChild(mensaje);
 			<% response.reset(); %>
 		}
 		</script>		
 </head>
	<body>
	 <%
	 	String rta=(String)session.getAttribute("rta");
	 	if(rta!=null)
		{
	 		%><div id="mensaje" width="300px" height="150px" class="alert alert-danger">
  				<%=rta %><a href="#" onclick="recargar()" class="close" data-dismiss="alert" aria-label="close">x</a></div>
	 		<%	
	 	}
	 	session.removeAttribute("rta");//remueve la var pasada por sesion
	 %>
		<h1 id="titulo"> &nbsp; &nbsp; GMOVIES</h1> 
			<div id="contenedor" class="container col-md-8">
				<form  action="IniciarSesion" method="post" class="col-md-8">
					<h1>Iniciar Sesión</h1>
						<div class="form-group">
							<label>Email:</label>
							<input class="form-control col-md-6" type="text" name="email" oninput="validarMail()" required id="email">
						</div>
						<div class="form-group">
							<label>Contraseña:</label>
							<input class="form-control col-md-6"  type="password" name="pass" oninput="validarpass()" id="pass" required>
						</div>
						<div id="lrc">
						<a href="">Olvidaste tu contraseña?</a>
						</div>
						<div>
						<input type="submit" value="Ingresar"  id="boton" class="btn btn-primary col-md-6">
						</div>
				</form> 
			</div>
	</body>
</html>