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
	   ppc=new ArrayList<Pelicula>();
	   while(rta.next())
	   {   Pelicula p=new Pelicula();
		   p.setCodPelicula(rta.getLong("idPelicula"));
		   p.setTitulo(rta.getString("titulo"));
		   p.setDescripcion(rta.getString("sinopsis"));
		   p.setDuracion(rta.getTime("duracion"));
		   p.setImagen(rta.getString("imagen"));
		   p.setVideo(rta.getString("video"));
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
   
   
   public ArrayList<Pelicula> getPeliculas(Integer idG,String descp,Integer idUs) throws ApplicationException, SQLException
   {   ArrayList<Pelicula> lp=null;
   	   PreparedStatement stmt=null;//cuando uso like en la consulta tengo q concatenar los % a los parametros del stmt
   	   ResultSet rta=null;
   	   if(descp.compareToIgnoreCase("")==0)
   	   {descp="+";}
   	   try{
   		   stmt=FabricaDeConexion.getFabrica().getConexion().prepareStatement("select distinct pe.idPelicula as idPelicula,titulo,pe.descripcion as descripcion,duracion,imagen,video from usuarios us " 
						  +" inner join planes p on us.idPlan=p.idPlan "
						  +" inner join peliculasplan pp on p.idPlan=pp.idPlan "
                          +" inner join peliculas pe on pp.idPelicula=pe.idPelicula "
                          +" where idUsuario=? and (titulo like ? or pe.descripcion like ? or idGenero=?)");
   	   		stmt.setInt(1,idUs);
   	   		stmt.setString(2,"%"+descp+"%");
   	   		stmt.setString(3,"%"+descp+"%");
	   		stmt.setInt(4,idG);
   	   		rta=stmt.executeQuery();
   	   		lp=new ArrayList<Pelicula>();
   	   		while(rta.next())
   	   		{
   	   			Pelicula p=new Pelicula();
   	   			p.setCodPelicula(rta.getLong("idPelicula"));
   	   			p.setDescripcion(rta.getString("descripcion"));
   	   			p.setDuracion(rta.getTime("duracion"));
   	   			p.setImagen(rta.getString("imagen"));
   	   			p.setTitulo(rta.getString("titulo"));
   	   			p.setVideo(rta.getString("video"));
   	   			lp.add(p);
   	   		}
   	   }
   	   
   	   catch(SQLException e)
   	   {e.printStackTrace();}
   	   finally{if(stmt!=null)
   		       {stmt.close();}
   	   		   if(rta!=null)
   	   		   {rta.close();
   	   		   FabricaDeConexion.getFabrica().releaseConn();}
   	   		   }
   	   return lp;
	   
   }
}
