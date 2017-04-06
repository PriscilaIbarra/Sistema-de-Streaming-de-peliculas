package capaDatos;
import java.sql.*;
import capaDatos.FabricaDeConexion;
import capaEntidades.*;
import util.*;
import java.util.*;

public class PlanData
{
	public ArrayList<Plan> buscarPlanes() throws ApplicationException
	{	
		ArrayList<Plan> planes= new ArrayList<Plan>();
		PreparedStatement stmt=null;
		ResultSet rta=null;
		try
		{
			stmt=FabricaDeConexion.getFabrica().getConexion().prepareStatement(
					"SELECT pla.idPlan as idPlan,pla.descripcion as descripcion,"+
							"ta.idTarifa as idTarifa,ta.importe as importe,"
							+"ta.fechaVigencia as fechaVigencia"
							+" FROM planes pla "
							+"INNER JOIN tarifas ta ON pla.idPlan=ta.idPlan "
							+"WHERE ? >= ta.fechaVigencia AND ? <ta.fechaFinVigencia;");
		 
		  String fhoy=Fecha.GetFechaHora();
		  stmt.setString(1,fhoy);
		  stmt.setString(2,fhoy);
		  rta=stmt.executeQuery();
		  while(rta.next())
		  { Plan p=new Plan();
		  	p.setIdPlan(rta.getInt("idPlan"));
		  	p.setDescPlan(rta.getString("descripcion"));
		  	Tarifa t=new Tarifa();
		  	t.setIdTarifa(rta.getInt("idTarifa"));
		    t.setImporte(rta.getDouble("importe"));
		    ArrayList<Tarifa> lisT= new ArrayList<Tarifa>();
		    lisT.add(t);
		    p.setLt(lisT);
		    planes.add(p);
		  }
			
		}
		catch(SQLException e)
		{
			 e.printStackTrace();
		}
		finally{
				try{	            	    
						if(stmt!=null){stmt.close();}
						FabricaDeConexion.getFabrica().releaseConn();
						rta.close();
					}   
            	catch (ApplicationException e)
            	{
            		e.printStackTrace();
            	}
            	catch(SQLException e)
            	{
		         e.printStackTrace();
            	}
				
				
	 	   		}
		
		return planes;	
	}
}
