package capaDatos;
import java.sql.*;
import util.ApplicationException;

public class FabricaDeConexion 
{
	private String dbDriver="com.mysql.jdbc.Driver";
	private String host="localhost";
	private String port="3306";
	private String user="Admin";
	private String pass="sisAdminABCD";
	private String db="sistemadestreaming";
	private String dbType="mysql";
	
	private Connection con;
	private int cantCon;
	
	//Crea un constructor privado
	private FabricaDeConexion() throws ApplicationException
	{
		try
		{ Class.forName(dbDriver);}
		catch(ClassNotFoundException e)
		{
			throw new ApplicationException("Error del Driver",e);
		}
	}
	
	private static FabricaDeConexion f;
	
	public static FabricaDeConexion getFabrica() throws ApplicationException
	{
		if(f==null)
		{f = new FabricaDeConexion(); }
		return f;
	}
	
	public Connection getConexion()
	{
		try
		{
			if(con==null || con.isClosed())
			{
				con=DriverManager.getConnection("jdbc:"+dbType+"://"+host+":"+port+"/"+
						db+"?user="+user+"&password="+pass);
				cantCon=cantCon+1;
			}	
		}
		catch(SQLException e)
		{
			new ApplicationException("Error al conectar a la DB",e);
		}
		return con;
	}
	
	public void releaseConn() throws ApplicationException
	{
		try {
			cantCon--;
			if(cantCon==0)
			{
				con.close();
			}
		    } 
		catch (SQLException e)
		{
			throw new ApplicationException("Error al cerrar conexión",e);
		}
	}	
}
