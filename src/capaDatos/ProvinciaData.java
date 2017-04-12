package capaDatos;
import java.util.*;
import capaEntidades.*;
import util.*;
import java.sql.*;

public class ProvinciaData 
{
	public ArrayList<Provincia> buscarPCC() throws ApplicationException
	{   ArrayList<Provincia> ps=null;
		PreparedStatement stmt=null;
		ResultSet rta=null;
		try
		{   ps=new ArrayList<Provincia>();
			stmt=FabricaDeConexion.getFabrica().getConexion().prepareStatement("select * from provincias");
			rta=stmt.executeQuery();
			while(rta.next())
			{
				Provincia p=new Provincia();
				p.setIdP(rta.getInt("id"));
				p.setDescP(rta.getString("nombre"));
				ps.add(p);
			}
		}
		catch(Exception e)
		{
			if(stmt!=null)
			{	try 
				{stmt.close();
				 FabricaDeConexion.getFabrica().releaseConn();
				 rta.close();
				} 
				catch (SQLException e1)
				{e1.printStackTrace();}	
			}
		}
		return ps;
	}
	
	
	
	public ArrayList<Localidad> buscarCds(Integer idPro) throws ApplicationException
	{
		ArrayList<Localidad>lisc=null;
		PreparedStatement stmt=null;
		ResultSet rta=null;
		try
		{   lisc=new ArrayList<Localidad>();
			stmt=FabricaDeConexion.getFabrica().getConexion().prepareStatement(
					"select loc.id as idLocalidad,loc.nombre as desL from provincias pro"
							+"  inner join departamentos dpto on pro.id=dpto.provincia_id" 
							+"  inner join localidades loc on dpto.id=loc.departamento_id"
							+"  where pro.id=?");
			stmt.setInt(1,idPro);
			rta=stmt.executeQuery();
			while(rta.next())
			{
				Localidad c=new Localidad();
				c.setIdLocalidad(rta.getInt("idLocalidad"));
				c.setDescripcion(rta.getString("desL"));
				lisc.add(c);
			}
			
			
		}
		catch(Exception e)
		{
			if(stmt!=null)
			{	try 
				{stmt.close();
				 FabricaDeConexion.getFabrica().releaseConn();
				 rta.close();
				} 
				catch (SQLException e1)
				{e1.printStackTrace();}	
			}
		}
		return lisc;		
	}
	
}
