package capaNegocio;
import capaEntidades.*;
import capaDatos.*;
public class CatalogoDeUsuarios
{
   public static Boolean AgregarUsuario(Usuario u )
   {
	   UsuarioData ud=new UsuarioData();
	   if(ud.registrarUs(u))
	   {return true;}
	   else{return false;}
   }
}
