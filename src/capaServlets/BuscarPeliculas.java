package capaServlets;
import java.util.*;
import capaEntidades.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import capaNegocio.CatalogoDePeliculas;
import util.ApplicationException;

@WebServlet("/BuscarPeliculas")
public class BuscarPeliculas extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    
    public BuscarPeliculas()
    {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    doGet(request, response);
	    String desc=request.getParameter("titodesc").trim();
	    Integer idG=Integer.parseInt(request.getParameter("idGenero").trim());
	    try {
	    	ArrayList<Pelicula> lp=CatalogoDePeliculas.buscarPeliculas(idG, desc);
	    	request.getSession().setAttribute("lp", lp);
	    	response.sendRedirect("PanelSecundario.jsp");
			} 
	    catch (ApplicationException | SQLException e) 
	      		{	e.printStackTrace();}
		
	    
	}

}
