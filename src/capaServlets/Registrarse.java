package capaServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import capaEntidades.*;

@WebServlet("/Registrarse")
public class Registrarse extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
      
   public Registrarse() 
   {
        super();
       
   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{   //en java el valor ingresado en el form se recupera con el atributo name de la etiqueta no con el id
		doGet(request, response);
		Localidad l =new Localidad();
		l.setIdLocalidad(Integer.parseInt(request.getParameter("idLocalidad").trim()));
		Calle ca=new Calle();
		ca.setDescripcion(request.getParameter("calle").trim());
		ca.setLoc(l);
		Domicilio dom=new Domicilio();
		dom.setCa(ca);
		dom.setNroCa(Integer.parseInt(request.getParameter("nroCalle").trim()));
		Tarifa t =new Tarifa();
		t.setIdTarifa(Integer.parseInt(request.getParameter("idTarifa").trim()));
		TipoTarjeta tpj=new TipoTarjeta();
		tpj.setIdTipTar(Integer.parseInt(request.getParameter("tipoTarjeta").trim()));
		Tarjeta tar=new Tarjeta();
		tar.setTt(tpj);
		tar.setNroTar(Long.parseLong(request.getParameter("nroTarjeta").trim()));
		Usuario us= new Usuario();
		us.setNombre(request.getParameter("nombre").trim());
		us.setApellido(request.getParameter("apellido").trim());
		us.setTelefono(request.getParameter("tel").trim());
		us.setFechaNacimiento(request.getParameter("fechaNaci").trim());
		
		
	
	}

}
