package capaNegocio;

import capaDatos.AlquilerData;
import capaEntidades.*;

public class CatalogoDeAlquileres
{
   public Integer getCantAlquileres(Usuario u)
   {
	   AlquilerData ad=new AlquilerData();
	   return ad.getCantDeAlquileres(u);
   }
}
