package capaNegocio;
import capaEntidades.*;
import util.ApplicationException;
import capaDatos.*;
public class CatalogoDeUsuarios
{
   public static Boolean AgregarUsuario(Usuario u ) throws ApplicationException 
   {
	   UsuarioData ud=new UsuarioData();
	   if(ud.registrarUs(u))
	   {return true;}
	   else{return false;}
   }
}
