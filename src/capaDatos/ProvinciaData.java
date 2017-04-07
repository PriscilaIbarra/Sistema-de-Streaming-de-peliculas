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
			stmt=FabricaDeConexion.getFabrica().getConexion().prepareStatement(
					"select pro.idProvincia as idProvincia,pro.descripcion as descP, "
					+"ciu.idCiudad as idCiudad,"
					+"ciu.descripcion as descCi, ca.idCalle as idCalle,"
					+" ca.descripcion as descCa"
					+" from provincias pro "
					+" inner join ciudades ciu on pro.idProvincia=ciu.idProvincia "
					+"inner join calles ca on ciu.idCiudad=ca.idCiudad order by idProvincia");
			
			rta=stmt.executeQuery();
			
			int c=1;
			while(c<=rta.getFetchSize())
			{	rta.getRowId(c);
				Provincia p=new Provincia();
				p.setIdP(rta.getRowId(c).g);
				p.setDescP(rta.getString("descP"));
				String pa=rta.p
				Ciudad c=new Ciudad();
				c.setIdCiudad(rta.getLong("idCiudad"));
				c.setDescripcion(rta.getString("descCi"));
				Calle ca=new Calle();
				ca.setIdCalle(rta.getInt("idCalle"));
				ca.setDescripcion(rta.getString("desCa"));
				Domicilio dom= new Domicilio();
				c.setProvincia(p);
				ca.setC(c);
				dom.setCa(ca);
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
		return pcc;
	}
}
