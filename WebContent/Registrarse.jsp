<%@ page import="capaNegocio.*" %>
<%@ page import="capaEntidades.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" href="Style/icons/favicon.ico">
<title>Registrarse</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
 <link href="Style/css/bootstrap.min.css" rel="stylesheet">
 
 <script>
	function validarNombre()
	{ var nombre=document.getElementById("nombre").value;
	  var expresionRegular=/[A-Za-z\s]{4,45}$/i; //nombre valido:4 a 45 caracteres solo lestras Mayusculas o minuscula y espacios en blanco
	  if(expresionRegular.test(nombre))
	  {document.getElementById("nombre").style.color='#00cc00';}
	  else{document.getElementById("nombre").style.color='#ff0000';
	 }
 	} 
 </script>
 
 <script>
  function validarApellido()
  {	  var apellido=document.getElementById("apellido").value;
	  var expresionRegular=/[A-Za-z\s]{4,45}$/i; 
	  if(expresionRegular.test(apellido))
	  {document.getElementById("apellido").style.color='#00cc00';}
	  else{document.getElementById("apellido").style.color='#ff0000';}
  }
 </script>
 
 <script>
 function validarTel()
 {
	 var tel=document.getElementById("telefono").value;
 	 var expresionRegular=/^\+?\d{1,3}?[- .]?\(?(?:\d{2,3})\)?[- .]?\d\d\d[- .]?\d\d\d\d$/;
 	 if(expresionRegular.test(tel))
 	 {document.getElementById("telefono").style.color='#00cc00';}
	  else{document.getElementById("telefono").style.color='#ff0000';}
 }
 </script>
 
 
 <script>
 function validarFecha()
 {   var fa = new Date();
	 var fecha=document.getElementById("fecha").value;
	 var an=fecha.substring(0, 4);
	 var anoParaTener18=fa.getFullYear()-18;
	 var anoNac=parseInt(an);
	 if(anoNac>=anoParaTener18)
	 {
		 alert("Usted debe ser mayor de edad");
	 }
	 else{document.getElementById("fecha").style.color='#00cc00';}
}
</script>
 
 <script>
 function validarMail()
 {
	 var mail=document.getElementById("mail").value;
	 var expresionRegular=/^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,3})$/;
	 if(expresionRegular.test(mail))
	 {document.getElementById("mail").style.color='#00cc00';}
	 else{document.getElementById("mail").style.color='#ff0000';}
 }
 </script>
 
 <script>
 function validarpass()
 {
	  var p=document.getElementById("pass").value;
	  if(p.length<=45)
	  {document.getElementById("pass").style.color='#00cc00';}
	  else{document.getElementById("pass").style.color='#ff0000';}
 }
 </script>
 
 <script>
 	function confirmarCon()
 	{
 		var pass=document.getElementById("pass").value;
 		var p1=pass.trim();
 		var passc=document.getElementById("passConf").value;
 		var p2=passc.trim();
 		if(p1.localeCompare(p2)==0)
 		 {document.getElementById("passConf").style.color='#00cc00';}
 		 else{document.getElementById("passConf").style.color='#ff0000';}	
 	}
 </script>
 
 <script>
 function validarTarjeta()
 {
	 var nrot=document.getElementById("nroTar").value;
	 var expresionRegular=/^((67\d{2})|(4\d{3})|(5[1-5]\d{2})|(6011))(-?\s?\d{4}){3}|(3[4,7])\d{2}-?\s?\d{6}-?\s?\d{5}$/;
	 if(expresionRegular.test(nrot))
	 {document.getElementById("nroTar").style.color='#00cc00';}
	 else{document.getElementById("nroTar").style.color='#ff0000';}
 }
 </script>
 
 <script>
 function validarCalle()
 {
	  var calle=document.getElementById("calle").value;
	  var expresionRegular=/[A-Za-z\s]{4,45}$/i; 
	  if(expresionRegular.test(calle))
	  {document.getElementById("calle").style.color='#00cc00';}
	  else{document.getElementById("calle").style.color='#ff0000';}
 }
 </script>
 <script>
 function validarNC()
 {
	 var nroCalle=document.getElementById("nCalle").value.trim();
     var expresionRegular=/[0-9]/;
     if(expresionRegular.test(nroCalle)&& nroCalle.length<=5)
     {document.getElementById("nCalle").style.color='#00cc00';}
	 else{document.getElementById("nCalle").style.color='#ff0000';}	 
 }
 </script>
 
  
 <style type="text/css" > 
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
		<form action="Registrarse" method="POST"  class="col-md-8">
		<%
	 	String msj=(String)session.getAttribute("msj");
	 	if(msj!=null)
		{if(msj.compareTo("Usuario Registrado con exito!")==0)
		{	
			%><br><div id="mensaje"  class="alert alert-success">
  			<%=msj %><a href="IniSesion.jsp"  class="close" data-dismiss="alert" aria-label="close">x</a></div><br><%	
  			
	 	}
	 	else
	    {	%><br><div id="mensaje"  class="alert alert-danger">
				<%=msj %><a href="index.html"  class="close" data-dismiss="alert" aria-label="close">x</a></div><br><%
	    }
		}
	 	session.removeAttribute("msj");
	    %>
		<h1>Registrarse</h1>
				<div class="form-group">
					<label>Nombre:</label>
					<input oninput="validarNombre()" class="form-control" type="text" name="nombre" id="nombre" required>
				</div>
				<div class="form-group">
					<label>Apellido:</label>
					<input oninput="validarApellido()" class="form-control" type="text" name="apellido" id="apellido" required>
				</div>
				<div class="form-group" >
					<label>Teléfono:</label>
					<div class="input-group">
 					 <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-earphone"></span></span>
  						<input oninput="validarTel()" class="form-control" type="text" name="tel" id="telefono" required>
					</div>
				</div>
				<div class="form-group">
					<label>Nacimiento:</label>
					<input oninput="validarFecha()" class="form-control" type="date" placeholder="dd-mm-YYYY" name="fechaNaci" id="fecha" required>
				</div>
				   <div class="form-group">
					<label>Ubicación:</label>
							   <select  class="form-control col-md-4" name="idLocalidad" required>
								<% ContPro cpc= new ContPro();
						  		   ArrayList<Provincia> pcias=cpc.buscarPcias();
						  		   for(Provincia pro:pcias)
						  		   {
						  			   pro.setLocalidades(ContPro.buscaCiu(pro.getIdP()));
						  		      
						  		   }
						  		 
						  		    for(Provincia p:pcias)
						  		   { %><optgroup  label="<%=p.getDescP()%>"><% 
						  					 for(Localidad l:p.getLocalidades())
						  					{%>	<option  value="<%=l.getIdLocalidad()%>"><%=l.getDescripcion() %></option><%}
						  			 %></optgroup><% 
						  		   }
						  			%></select><% 
						  		%>
					</div>
						</br></br>
						  	<div class="form-inline">	
						  	<label>Calle:</label>
						  	<div>
				   			<input type="text" oninput="validarCalle()" class="form-control col-md-2" name="calle" required>
				   			</div>
				   			<div>
				   			<input type="text" oninput="validarNC()" class="form-control col-md-2" name="nroCalle" placeholder="N°" id="nCalle" required>
				   			</div>
				   			</div>
				   	</br></br>
				<div class="form-group">
					<label>Email:</label>
					<div class="input-group">
					 <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-envelope"></span></span>
					<input class="form-control" oninput="validarMail()" type="text" name="mail" id="mail" required>
					</div>
				</div>
				<div class="form-group">
					<label>Contraseña:</label>
					<input class="form-control" oninput="validarpass()"  type="password" name="pass" id="pass" required>
				</div>
				<div class="form-group">
					<label>Confirmar Contraseña:</label>
					<input oninput="confirmarCon()" class="form-control"  type="password" name="passConf" id="passConf" required>
				</div>
				<label>Plan:</label>
				<div class="form-inline">
							<%   
							  try
							   {   CatalogoPlanes cp=new CatalogoPlanes();
	 				   			   ArrayList<Plan> pls=cp.buscarPlanes();
							   	   if( pls != null)
		 						   {   %><div class="input-group"> 
		 							   <div class="input-group-addon">$</div>
		 						       <select class="form-control" name="idTarifa">
		 						     	 <% for(Plan p:pls)
		 							    	{ %>
		 							       		<optgroup  label="<%=p.getDescPlan() %>"> 
     												  <option value="<%=p.getLt().get(0).getIdTarifa() %>"><%=p.getLt().get(0).getImporte()%></option> 
      											</optgroup>
     										 <% 
		 							    	}
		 							     %>
		 							   <select/>
		 						       <div class="input-group-addon">ARS</div>
									   </div><%
		 					  	    }
							   	   else{%><div class="input-group">
	 							       <div class="input-group-addon">$</div>
	 						           <select class="form-control" name="plan"  required>
	 						           <option style="color:red">Sin planes disponibles</option>
	 						           <select/>
		 						       <div class="input-group-addon">ARS</div>
									   </div> 
	 						           <%}
		 					  }
							catch(ApplicationException e)
							{ %> <div class="alert alert-warning alert-dismissable fade in">
 								 <a href="index.html" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  								 <strong>Error!</strong>Imposible Conectar con base de datos!
 								 </div><%
							}
		 					%>
						
				</div>
				<br>
				<label>Tarjeta de Crédito:</label>
					<div class="form-inline">
							<select class="form-control" required name="tipoTarjeta">
								<% try
								   {CatalogoTarjetas ct=new CatalogoTarjetas();
								   ArrayList<TipoTarjeta>tpt=ct.buscarTipoTajetas();
								   if(tpt!=null)
								   {	for(TipoTarjeta tt : tpt)
								   		{   
									   		String dt=tt.getDescripcion()+" "+ tt.getEntCrediticia();
									   		%><option value="<%=tt.getIdTipTar()%>"><%=dt%></option><%
								   		}	 
								   }}
									catch(ApplicationException e){e.printStackTrace();}
								%>
							</select>
							<input class="form-control" oninput="validarTarjeta()" type="text" placeholder="número" name="nroTarjeta" id="nroTar" required>
					</div>
					
					<div class="checkbox"><label><input  id="chekc"  type="checkbox" required><a href="">Aceptar Términos y Condiciones</a></label></div>
						<div class="button">
							<input type="submit"  id="btnRegistrarse" class="btn btn-primary" value="Registrarse">
						</div>
			</form>
		</div>
</div>

</body>
</html>