package capaNegocio;
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
    
    public Long iniciarSesion(Usuario us)
    {	
    	if(us==null)
    	{return (long) -1;}
    	else
    	{   if(us.getEstado().compareToIgnoreCase("habilitado")==0)
    		{
    			return us.getNroUsuario();
    		}
    	   else{return (long)-2;}
    	}
    }
}
