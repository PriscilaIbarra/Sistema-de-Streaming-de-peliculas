package capaNegocio;
import capaDatos.*;
import capaEntidades.*;
import java.util.*;
import util.ApplicationException;

public class CatalogoPlanes 
{
    public ArrayList<Plan> buscarPlanes()throws ApplicationException
    {   
    	 ArrayList<Plan>planes=null;
    	 try
    	 {PlanData pd= new PlanData();
    	 planes=pd.buscarPlanes();}
    	 catch(Exception e)
    	 {throw new ApplicationException();}
       	 return planes;
    }
}
