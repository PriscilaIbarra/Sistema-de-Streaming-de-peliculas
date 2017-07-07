package capaNegocio;

import java.sql.SQLException;

import capaDatos.AlquilerData;
import capaEntidades.*;
import util.ApplicationException;

public class CatalogoDeAlquileres
{
   public Integer getCantAlquileres(Usuario u) throws ApplicationException
   {
	   AlquilerData ad=new AlquilerData();
	   return ad.getCantDeAlquileres(u);
   }
   
   public Boolean fueAlquilada(Usuario u,Pelicula p) throws ApplicationException, SQLException
   { 
	   AlquilerData ad=new AlquilerData();
	   return ad.esPeliculaAlquilada(u, p);
   }
   
   public Boolean agregarAlquiler(Usuario u, Pelicula p) throws ApplicationException, SQLException
   {  
	   AlquilerData ad=new AlquilerData();
	   return ad.grabarAlquiler(u, p);
   }
}
