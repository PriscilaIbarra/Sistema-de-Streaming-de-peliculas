<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="capaNegocio.*" %> 
<%@ page import="capaEntidades.*" %>
<%@ page import="java.util.*" %>

   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" href="Style/icons/favicon.ico">
<link rel="stylesheet" href="Style/css/bootstrap.min.css">
<script src="Style/js/bootstrap.js"></script>
<script src="Style/js/jquery-3.2.0.js"></script>
<script src="Style/js/jquery-3.1.1.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Panel Principal.</title>
<style type="text/css" > 
		@import "Style/css/PanelPrincipal.css"; 
		 </style>
 		<style type="text/css">
 			 @font-face {
		 				   font-family:Vtks Revolt ;
   						   src: url("Style/fonts/Vtks Revolt.ttf");
						}
		</style>
</head>
<body>
  <h1 id="titulo"> GMOVIES</h1>  
 <div id="menu">
         <ul class="nav" style="color:#5cb85c;">
            <li class="active"><a href="#"><span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>&nbsp; Mis Peliculas</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp; Cat�logo </a></li>
            <li><a href="#"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>&nbsp; Contacto</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>&nbsp; Cerrar Sessi�n</a></li>
          </ul>
 </div>
 
 <form id="formb" class="form-inline col-md-8">
 <div  class="form-group">
 	<select class="form-control">
  	<option>G�nero</option>
  	<option>2</option>
  	<option>3</option>
  	<option>4</option>
  	<option>5</option>
 	</select>
  </div> 
 <div class="form-group">
    <input type="text" class="form-control" placeholder="t�tulo o descripci�n">
  </div>
  <button type="submit" class="btn btn-success">Buscar</button>
 </form>
<br>

</body>
</html>