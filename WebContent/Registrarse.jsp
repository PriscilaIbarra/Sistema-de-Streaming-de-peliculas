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
		<form  class="col-md-8">
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
					<div class="input-group">
 					 <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-earphone"></span></span>
  						<input class="form-control" type="text" id="tel" required>
					</div>
				</div>
				<div class="form-group">
					<label>Nacimiento:</label>
					<input class="form-control" type="date" id="fechaNaci" required>
				</div>
				   <div>
					<label>Ubicación:</label>
					<div class="form-inline">
							   <select name="provincia"  class="form-control" id="idprovincia" required>
								<% ContPro cpc= new ContPro();
						  		   ArrayList<Provincia> pcias=cpc.buscarPcias();
						  		   for(Provincia pro:pcias)
						  		   {
						  			   pro.setLocalidades(ContPro.buscaCiu(pro.getIdP()));
						  		       for(Localidad c:pro.getLocalidades())
						  		       {
						  		    	   c.setCalles(ContPro.buscaCa(c.getIdLocalidad()));
						  		       }
						  		   }
						  		 
						  		    for(Provincia p:pcias)
						  		   { %><optgroup  label="<%=p.getDescP()%>"><% 
						  					 for(Localidad l:p.getLocalidades())
						  					{%>	<option id="idLocalidad" value="<%=l.getIdLocalidad()%>"><%=l.getDescripcion() %></option><%}
						  			 %></optgroup><% 
						  		   }
						  			  %></select><% 
						  		%>
				   	</div>
				   	<div class="form-group">
				   		<input type="text" class="form-control" id="calle">
				   	</div> 
				   	<div class="form-group">
				   	    <input type="text" class="form-control" id="nroCalle" placeholder="n° calle">
				   	</div>
					<br> 
				<div class="form-group">
					<label>Email:</label>
					<div class="input-group">
					 <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-envelope"></span></span>
					<input class="form-control" type="email" id="mail"required>
					</div>
				</div>
				<div class="form-group">
					<label>Contraseña:</label>
					<input class="form-control"  type="password" id="mail"required>
				</div>
				<label>Plan:</label>
				<div class="form-inline">
							<%   
							  try
							   {   ControladorPlanes cp=new ControladorPlanes();
	 				   			   ArrayList<Plan> pls=cp.buscarPlanes();
							   	   if( pls != null)
		 						   {   %><div class="input-group"> 
		 							   <div class="input-group-addon">$</div>
		 						       <select class="form-control" name="plan"  required>
		 						      <% for(Plan p:pls)
		 							    { %>
		 							       		<optgroup id="idPlan" value="<%=p.getIdPlan() %>" label="<%=p.getDescPlan() %>"> 
     												  <option id="idTarifa" value="<%=p.getLt().get(0).getIdTarifa() %>"><%=p.getLt().get(0).getImporte()%></option> 
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
	 						           <select class="form-control" name="plan" id="tarifa" required>
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
							<select class="form-control" name="tipoTarjeta" id="tipoTarjeta">
								<% try
								   {ControladorTarjetas ct=new ControladorTarjetas();
								   ArrayList<TipoTarjeta>tpt=ct.buscarTipoTajetas();
								   if(tpt!=null)
								   {	for(TipoTarjeta tt : tpt)
								   		{   
									   		String dt=tt.getDescripcion()+" "+ tt.getEntCrediticia();
									   		%><option value="<%=tt.getIdTipTar()%>"><%=dt%></option><%
								   		}	 
								   }}
									catch(ApplicationException e){}
								%>
							</select>
							<input class="form-control" type="text" placeholder="número" name="nroTarjeta" id="nroTarjeta">
					</div>
					
					<div class="checkbox"><label><input type="checkbox" required><a href="">Aceptar Términos y Condiciones</a></label></div>
						<div class="button">
							<input type="submit" class="btn btn-primary" value="Registrarse">
						</div>
			</form>
		</div>
</div>
</body>
</html>