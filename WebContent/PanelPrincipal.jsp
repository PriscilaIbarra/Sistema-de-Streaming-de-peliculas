<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
            <li class="active"><a href="#"><span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>&nbsp; Mis peliculas</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp; Catálogo </a></li>
            <li><a href="#"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>&nbsp; Contacto</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>&nbsp; Cerrar Sessión</a></li>
          </ul>
 </div>
  

<div id="contenedor" class="container" >
   <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="http://es.web.img3.acsta.net/medias/nmedia/18/89/85/69/20070008.jpg" align="left" style="width:50%;height:400px;">
        <h3> El Señor de los Anillos</h3>
        <textarea id="sinopsis" rows="10" cols="50">asdfasdfasdfasdfasdfasdf</textarea>
      </div>

      <div class="item">
        <img src="https://imagenes.gatotv.com/categorias/peliculas/posters/el_dia_despues_de_manana.jpg" align="left" style="width:50%;height:400px;">
        <h3> El dia Despues de mañana</h3>
        <textarea id="sinopsis" rows="10" cols="50">asdfasdfasdfasdfasdfasdf</textarea>
      </div>
    
    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Anterior</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Siguiente</span>
    </a>
  </div>
</div>
<br><br>
<center>
        <button type="button" style="color:#5cb85c;background-color:#404040;border:none;" ><span class="glyphicon glyphicon-play-circle" aria-hidden="true"></span></button>
        <button type="button" style="color:#5cb85c;background-color:#404040;border:none;"><span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span></button>
 </center>
</div>

</body>
</html>