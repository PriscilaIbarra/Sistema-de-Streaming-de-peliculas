package capaNegocio;
import java.sql.SQLException;
import java.util.ArrayList;

import capaEntidades.*;
import util.ApplicationException;

public class ControladorServicioUs 
{
    public static Boolean RegistrarUsuario(Usuario us) throws ApplicationException
    {
	   	if(CatalogoDeUsuarios.AgregarUsuario(us))
    	{ return true;}
    	else
    	{ return false;}
    }
    
    public Usuario iniciarSesion(Usuario usu)
    {	
        Usuario us=CatalogoDeUsuarios.BuscarUsuario(usu);
       	return us;
    }
    
    public ArrayList<Pelicula> pelPlanCliente(Usuario u) throws ApplicationException
    { 
    	return CatalogoDePeliculas.buscarPelPlan(u);
    }
    
    public static Integer AlquilarPel(Usuario u, Pelicula p) throws ApplicationException, SQLException
    {   Integer rta=0;
    	CatalogoDeAlquileres ca=new CatalogoDeAlquileres();
    	if(ca.getCantAlquileres(u)<u.getPlan().getCantPel())
    	{
    		if(ca.fueAlquilada(u, p))
    		{rta=1;}	
    		else
    		{  if(ca.agregarAlquiler(u, p))
    		   {rta=2;}
    		   else{rta=3;}
    		}	
    	}
    	
    	return rta;
    	
    	
    	
    	//0-excede cantidad permitida de pel para alquilar
		//1-pelicula ya alquilada en el mes
		//2-Pelicula Alquilada con exito
			//3-Error al alquilar pelicula
    }
}
