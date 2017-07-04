package capaNegocio;
import java.sql.SQLException;
import java.util.ArrayList;
import capaDatos.GeneroData;

import capaEntidades.*;
import util.ApplicationException;
public class CatalogoDeGeneros
{
	static public  ArrayList<Genero> listarGeneros() 
	{
		GeneroData gd=new GeneroData();
		ArrayList<Genero> lg=null;
		try {lg=gd.getGeneros();} 
		catch (ApplicationException | SQLException e)
		{ e.printStackTrace();}
		return lg;		
	}
}
