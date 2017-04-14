function validarNombre()
{ alert("hollalsdfalsd");
   var cadena=document.getElementById("nombre").value;
   var nopermitido=["0","1","2","3","4","5","6","7","8","9","*","!","<",">","-","_",".",";","+","@"];
   for(var i ;i<=cadena.length;i++)
   {
	  for(var e;e<=nopermitido.length;e++)
		  {
		  if(cadena[i]==nopermitido[e])
		  {
			  document.getElementById("nombre").style.color="red";
		  }
		  else{document.getElementById("nombre").style.color="green";}  
		  }
   }
}