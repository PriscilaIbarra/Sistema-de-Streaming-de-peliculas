package capaNegocio;
import capaEntidades.*;
import util.ApplicationException;

import java.sql.SQLException;

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
   
   public static Usuario BuscarUsuario(Usuario u)
   {   UsuarioData ud=new UsuarioData();
	   Usuario ub=null;
	   try {ub=ud.getUsuario(u);} 
	   catch (SQLException e) 
	   {e.printStackTrace();}
	   catch (ApplicationException e)
	   {e.printStackTrace();}
	return ub;
   }
}
