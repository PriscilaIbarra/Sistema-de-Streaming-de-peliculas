package capaDatos;
import capaEntidades.*;
import util.ApplicationException;

import java.sql.*;
import java.util.ArrayList;

public class PeliculaData
{  
   public ArrayList<Pelicula> getPeliculasPlanCli(Usuario u) throws ApplicationException
   {   ArrayList<Pelicula> ppc=null;
	   PreparedStatement stmt=null;
	   ResultSet rta=null;
	   try{
	   stmt=FabricaDeConexion.getFabrica().getConexion().prepareStatement("select pe.idPelicula as idPelicula,titulo,pe.descripcion as sinopsis,g.descripcion as genero,duracion,imagen,video from "
			   			+ " usuarios us inner join planes p on us.idPlan=p.idPlan"
						+ " inner join peliculasplan pp on p.idPlan=pp.idPlan"
                        + " inner join peliculas pe on pp.idPelicula=pe.idPelicula"
                        + " inner join generos g on pe.idGenero=g.idGenero"
                        + " where idUsuario=?");
	   stmt.setLong(1,u.getNroUsuario());
	   rta=stmt.executeQuery();
	   while(rta.next())
	   {   ppc=new ArrayList<Pelicula>();
		   Pelicula p=new Pelicula();
		   p.setCodPelicula(rta.getLong("idPelicula"));
		   p.setTitulo(rta.getString("titulo"));
		   p.setDescripcion(rta.getString("sinopsis"));
		   p.setDuracion(rta.getTime("duracion"));
		   Genero g=new Genero();
		   g.setDescripcion(rta.getString("genero"));
		   p.setGenP(g);
		   ppc.add(p);
	   }
	   }
	   catch(SQLException e)
	   {
		   e.printStackTrace();
	   }
	   finally{ try {
		   		if(stmt!=null)
	   			{stmt.close();}
	   			if(rta!=null)
	   			{rta.close();}
	    		  FabricaDeConexion.getFabrica().releaseConn();}
				    
	   			catch (SQLException | ApplicationException e)
	   			{
					e.printStackTrace();
				}
	   		  }
	  return ppc;		   
   }
}
