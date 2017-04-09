package capaDatos;
import capaNegocio.*;
import util.ApplicationException;

import java.util.*;
import capaEntidades.*;
public class Pruebas
{

	public static void main(String[] args) throws ApplicationException
	{
		Integer a=1;
		ArrayList<Ciudad> lc=ContPro.buscaCiu(a);
		if(lc!=null)
		{for(Ciudad c:lc)
		{System.out.println("entra");
			System.out.println(c.getDescripcion().toString());
		}
		}else{System.out.println("array vacio");}
	}
			

}


