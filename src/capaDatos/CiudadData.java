package capaDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ApplicationException;
import capaEntidades.*;

public class CiudadData 
{
	public ArrayList<Calle> buscarCa(Integer idCi) throws ApplicationException
	{   ArrayList<Calle> cal=null;
		PreparedStatement stmt=null;
		ResultSet rta=null;
		try
		{   cal=new ArrayList<Calle>();
			stmt=FabricaDeConexion.getFabrica().getConexion().prepareStatement("select * from calles where idCiudad=?;");
			stmt.setInt(1,idCi);
			rta=stmt.executeQuery();
			while(rta.next())
			{
				Calle ca=new Calle();
				ca.setIdCalle((rta.getInt("idCalle")));
				ca.setDescripcion((rta.getString("descripcion")));
				cal.add(ca);
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
		return cal;
	}
	
	
}
