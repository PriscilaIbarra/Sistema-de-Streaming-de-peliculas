package capaServlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import capaEntidades.*;
import capaNegocio.*;


@WebServlet("/IniciarSesion")
public class IniciarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
      public IniciarSesion()
      {
        super();
      }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{//El archivo jsp no puede tener el mismo nombre que el servlet porque tira error
		String rta=null;
		doGet(request, response);
		Usuario u=new Usuario();
		u.setEmail(request.getParameter("email").trim());
		u.setPassword(u.encriptar(request.getParameter("pass").trim()));
		ControladorServicioUs c =new ControladorServicioUs();
		Long res=c.iniciarSesion(u);
		if(res==-1)
		{rta="Email o Contraseña incorrectos!!";
		request.getSession().setAttribute("rta",rta);
		response.sendRedirect("IniSesion.jsp");}
		else{  if(res==-2)
			   {rta="Usuario inhabilitado!!";
			    request.getSession().setAttribute("rta",rta);
				response.sendRedirect("IniSesion.jsp");}
		       else{ request.getSession(true).setAttribute("idUsuario",res);
		       		 response.sendRedirect("PanelPrincipal.jsp");} 
		       			
		    }	
	}
		
		 
  		 	
	

}
