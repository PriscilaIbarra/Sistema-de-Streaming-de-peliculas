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
				p.setIdP(rta.getInt("idProvincia"));
				p.setDescP(rta.getString("descripcion"));
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
	
	
	
	public ArrayList<Ciudad> buscarCds(Integer idPro) throws ApplicationException
	{
		ArrayList<Ciudad>lisc=null;
		PreparedStatement stmt=null;
		ResultSet rta=null;
		try
		{   lisc=new ArrayList<Ciudad>();
			stmt=FabricaDeConexion.getFabrica().getConexion().prepareStatement(
					"select * from ciudades where idProvincia=?");
			stmt.setInt(1,idPro);
			rta=stmt.executeQuery();
			while(rta.next())
			{
				Ciudad c=new Ciudad();
				c.setIdCiudad(rta.getLong("idCiudad"));
				c.setDescripcion(rta.getString("descripcion"));
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
