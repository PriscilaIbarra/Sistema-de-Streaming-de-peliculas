package capaNegocio;
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
    
    public Long iniciarSesion(Usuario usu)
    {	Long rta=(long)0;
        Usuario us=CatalogoDeUsuarios.BuscarUsuario(usu);
       	if(us==null)
    	{ rta=(long)-1;}
    	else
    	{   if(us.getEstado().compareToIgnoreCase("habilitado")==0)
    		{
    			rta=us.getNroUsuario();
    		}
    	   else{rta=(long)-2;}
    	}
       return rta;  
    }
    
    public ArrayList<Pelicula> pelPlanCliente(Usuario u) throws ApplicationException
    { 
    	return CatalogoDePeliculas.buscarPelPlan(u);
    }
    
    public static Integer Alquilar(Usuario u, Pelicula p)
    {
    	
    	return 0;
    }
}
