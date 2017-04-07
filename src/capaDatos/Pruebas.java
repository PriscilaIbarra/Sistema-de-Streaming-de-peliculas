package capaDatos;
import capaNegocio.*;
import util.ApplicationException;

import java.util.*;
import capaEntidades.*;
public class Pruebas {

	public static void main(String[] args) throws ApplicationException
	{
		ControladorPlanes cp=new ControladorPlanes();
		    ArrayList<Plan> pls=cp.buscarPlanes();
			if( pls != null)
			{System.out.println("pasa");
				for(int i=0 ; i < pls.size();i=i+1)
				{
					System.out.print(pls.get(i).getDescPlan());
				}
			}
			else
			{   System.out.println("sin planes");}
			

	}

}
