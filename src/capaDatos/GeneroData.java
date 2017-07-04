package capaDatos;
import capaEntidades.*;
import util.ApplicationException;

import java.util.*;
import java.sql.*;
public class GeneroData 
{
	public ArrayList<Genero>getGeneros() throws ApplicationException, SQLException
	{   ArrayList<Genero>lg=null;
		PreparedStatement stmt=null;
		ResultSet rta=null;
		try{stmt=FabricaDeConexion.getFabrica().getConexion().prepareStatement("select * from generos");
		    rta=stmt.executeQuery();
		    lg=new ArrayList<Genero>();
		    while(rta.next())
		    { Genero g=new Genero();
		      g.setIdGenero(rta.getInt("idGenero"));
		      g.setDescripcion(rta.getString("descripcion"));
		      lg.add(g);
		    }
		 
		}
		catch(SQLException e)
		{e.printStackTrace();}
		finally{if(stmt!=null)
				  {stmt.close();}
				if(rta!=null)
				{rta.close();}
				FabricaDeConexion.getFabrica().releaseConn();}
		return lg;
	}
}
