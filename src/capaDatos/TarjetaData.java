package capaDatos;
import capaEntidades.*;
import util.*;
import java.util.*;
import java.sql.*;

public class TarjetaData
{
	public ArrayList<TipoTarjeta> buscarTipTarjetas() throws ApplicationException
	{  	
		ArrayList<TipoTarjeta> tpt=null;
		PreparedStatement stmt=null; 
		ResultSet rta=null;
		try
		{ 
			stmt=FabricaDeConexion.getFabrica().getConexion().prepareStatement("select * from tipostarjetas");
			rta=stmt.executeQuery();
			tpt=new ArrayList<TipoTarjeta>();
			while(rta.next())
			{
				TipoTarjeta tt= new TipoTarjeta();
				tt.setIdTipTar(rta.getInt("idTipo"));
				tt.setDescripcion(rta.getString("descripcion"));
				tt.setEntCrediticia(rta.getString("entidadFinanciera"));
				tpt.add(tt);
			}
		}
		catch(SQLException e)
		{	e.printStackTrace();}
		finally
		{ try
			{
				if(stmt!=null)
				{
					stmt.close();
				}
				rta.close();
				FabricaDeConexion.getFabrica().releaseConn();
			}
		  catch(ApplicationException e){e.printStackTrace();}
		  catch(SQLException a){a.printStackTrace();}
		}
		return tpt;
	}
}
