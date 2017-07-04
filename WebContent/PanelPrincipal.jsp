<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="capaNegocio.*" %> 
<%@ page import="capaEntidades.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
   
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
		<% ControladorServicioUs cu=new ControladorServicioUs();
		   ArrayList<Pelicula>lp=cu.pelPlanCliente(Long.parseLong(session.getAttribute("idUsuario").toString()));
		
		%>
</head>
<body>
  <h1 id="titulo"> GMOVIES</h1>  
 <div id="menu">
         <ul class="nav" style="color:#5cb85c;">
            <li class="active"><a href="#"><span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>&nbsp; Mis Peliculas</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp; Catálogo </a></li>
            <li><a href="#"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>&nbsp; Contacto</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>&nbsp; Cerrar Sessión</a></li>
          </ul>
 </div>
 <br>
 <form id="formb" action="BuscarPeliculas" method="post" class="form-inline col-md-8">
 <div  class="form-group">
 	<select class="form-control" name="idGenero">
 	<option>Género</option>
 	<% ArrayList<Genero>lg=CatalogoDeGeneros.listarGeneros();
 	  if(lg!=null)
 	  { for(Genero g:lg)
 	  	{ %>
 		  <option value="<%=g.getIdGenero() %>"><%=g.getDescripcion() %></option>
 		  <% 
 	  	}  
 	  } 
 	
 	%>
  	</select>
  </div> 
 <div class="form-group">
    <input type="text" class="form-control" name="titodesc" placeholder="título o descripción">
  </div>
  <button type="submit" class="btn btn-success">Buscar</button>
 </form>
 
 
<br><br><br>

    <div style="margin-left:270px;">   
    <% 	 if(lp!=null)
   		 {  		
 	 		  for(Pelicula p:lp)
 	 		  {%>		
 			  <div style="margin-bottom:30px;" class="container-fluid col-md-6"> 
 			  <div><h4> <%=p.getTitulo() %></h4></div>
 			  <img style="width:215px;height:250px;" class="img-rounded col-md-4" align="left" src="<%=p.getImagen() %>">
 			  <textarea disabled style="background-color:#404040;border:none;" class="img-thumbnail" rows="12" ><%=p.getDescripcion() %></textarea>
 		      <br>
 			  <div class="col-md-6">
 		      <button class="btn btn-primary">Reproducir</button>
 			  <button class="btn btn-primary" style="width:90px;">Agregar</button>
 			  </div>
 			  </div><%	
 			  }
    		
 	      }
   	%>
	</div>

</body>
</html>