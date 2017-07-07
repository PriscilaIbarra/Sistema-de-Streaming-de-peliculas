package capaServlets;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import capaEntidades.*;
import capaNegocio.*;
import util.ApplicationException;

@WebServlet("/Alquilar")
public class Alquilar extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public Alquilar()
    {
        super();
        
    }

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
		Usuario u=new Usuario();
		u.setNroUsuario(Long.parseLong(request.getSession(false).getAttribute("idUsuario").toString()));
		u.setFeContratacion(request.getSession(false).getAttribute("feContratacionServicio").toString());
		Plan pl=new Plan();
		pl.setIdPlan(Integer.parseInt(request.getSession(false).getAttribute("idPlan").toString()));
		pl.setCantPel(Integer.parseInt(request.getSession(false).getAttribute("cantPeliculas").toString()));
		u.setPlan(pl);
		Pelicula p =new Pelicula();
		p.setCodPelicula(Long.parseLong(request.getParameter("btnAlquilar").toString().trim()));
		Integer rta=0;
		try {rta = ControladorServicioUs.AlquilarPel(u, p);}
		catch (ApplicationException | SQLException e)
		{e.printStackTrace();}
	    request.getSession(false).setAttribute("rta",rta);
	    response.sendRedirect(request.getSession(false).getAttribute("pagAc").toString());
		
	}

}
