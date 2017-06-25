package capaNegocio;
import capaEntidades.*;

public class ControladorServicioUs 
{
    public static Boolean RegistrarUsuario(Usuario us)
    {
	   	if(CatalogoDeUsuarios.AgregarUsuario(us))
    	{ return true;}
    	else
    	{ return false;}
    }
}
