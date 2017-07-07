package capaDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import capaEntidades.Pelicula;
import capaEntidades.Usuario;
import util.ApplicationException;
import util.Fecha;

public class AlquilerData
{
   public Integer getCantDeAlquileres(Usuario u) throws ApplicationException
   {
	String mesS="";
   	String fechaActual=Fecha.GetFecha();
   	String añoA=fechaActual.subSequence(0,3).toString();
   	String mesA=fechaActual.subSequence(5,6).toString();
   	String feContrSer="201-07-07";//u.getFeContratacion();<--nula ver
   	String diaContrSer=feContrSer.subSequence(8,9).toString();
   	if(Integer.parseInt(mesA)<9)
   	{ mesS="0"+String.valueOf((Integer.parseInt(mesA)+1));}
   	else{mesS=String.valueOf((Integer.parseInt(mesA)+1));}
   	String iniciomes=añoA+"-"+mesA+"-"+diaContrSer;
   	String finmes=añoA+"-"+mesS+"-"+diaContrSer;
  	
   	 PreparedStatement stmt=null;
  	 ResultSet rta=null;
  	 Integer numAl=0;
  	 try
  	 {
  		 stmt=FabricaDeConexion.getFabrica().getConexion().prepareStatement("select * from usuarios us "
  				   +" inner join peliculasplan pp on us.idPlan=pp.idPlan "
                     +" inner join alquileres a on pp.idPeliculasPlan=a.idPeliculasPlan"
                     +" where us.idUsuario=? and a.fechaAlquiler >=? and a.fechaAlquiler<=? ");
  		 stmt.setLong(1,u.getNroUsuario());
  		 stmt.setString(2,iniciomes);
  		 stmt.setString(3,finmes);
  		 rta=stmt.executeQuery();
  		
  		 while(rta.next())
  		 {
  			 numAl=numAl+1;
  		 }
  	 }
  	 catch(SQLException e)
  	 {e.printStackTrace();}
  	 finally
  	 { if(stmt!=null)
  	   {try {stmt.close();}
  	    catch (SQLException e) {e.printStackTrace();}
  	   }
  	   if(rta!=null)
  	   {try {rta.close();} 
  	   catch (SQLException e) {e.printStackTrace();}
  	   }
  	   FabricaDeConexion.getFabrica().releaseConn();
  	 }
  	 return numAl;
   }

   
   
   
     public Boolean esPeliculaAlquilada(Usuario u,Pelicula p) throws ApplicationException, SQLException
     {   String mesS="";
  	   String fechaActual=Fecha.GetFecha();
  	   String añoA=fechaActual.subSequence(0,3).toString();
  	   String mesA=fechaActual.subSequence(5,6).toString();
  	   String feContrSer="201-07-07";//u.getFeContratacion();
  	   String diaContrSer=feContrSer.subSequence(8,9).toString();
  	   if(Integer.parseInt(mesA)<9)
  	   { mesS="0"+String.valueOf((Integer.parseInt(mesA)+1));}
  	   else{mesS=String.valueOf((Integer.parseInt(mesA)+1));}
  	   String iniciomes=añoA+"-"+mesA+"-"+diaContrSer;
  	   String finmes=añoA+"-"+mesS+"-"+diaContrSer;
  	   Boolean res=false;
  	   PreparedStatement stmt=null;
  	   ResultSet rta=null;
  	   try
  	   {  stmt=FabricaDeConexion.getFabrica().getConexion().prepareStatement("select * from usuarios us "
                    +" inner join peliculasplan pp on us.idPlan=pp.idPlan "
                    +" inner join alquileres a on pp.idPeliculasPlan=a.idPeliculasPlan"
                    +" where us.idUsuario=? and a.fechaAlquiler >= ? and a.fechaAlquiler<=? and pp.idPelicula=?");
  	      stmt.setLong(1,u.getNroUsuario());
  	      stmt.setString(2,iniciomes );
  	      stmt.setString(3, finmes);
  	      stmt.setLong(4,p.getCodPelicula());
  	      rta=stmt.executeQuery();
  	      if(rta.next())
  	      {res=true;}
  	   }
  	   catch(SQLException e)
  		 {e.printStackTrace();}
  		 finally
  		 {
  			 if(stmt!=null)
  			 { stmt.close();}
  			 if(rta!=null)
  			 { rta.close();}
  			 FabricaDeConexion.getFabrica().releaseConn();
  		 }
         return res;
     }
     
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   public Boolean grabarAlquiler(Usuario us,Pelicula p) throws ApplicationException, SQLException
   {   PreparedStatement stmt=null;
	   Boolean rta=false;
	  
	   try
	   { stmt=FabricaDeConexion.getFabrica().getConexion().prepareStatement("insert into alquileres (idPeliculasPlan,idUsuario,fechaAlquiler) values "
			   +" ((select idPeliculasPlan from peliculasplan where idPelicula=? and idPlan=?),?,?)");
         stmt.setLong(1, p.getCodPelicula());
         stmt.setInt(2,us.getPlan().getIdPlan());
         stmt.setLong(3,us.getNroUsuario());
         stmt.setString(4,Fecha.GetFechaHora());
         if(stmt.executeUpdate()>0)
         {rta=true;}	 
	   }
	   catch(SQLException e)
		 {e.printStackTrace();}
		 finally
		 {
			 if(stmt!=null)
			 { stmt.close();}
			 FabricaDeConexion.getFabrica().releaseConn();
		 }
	   
	   return rta;
   
   }
}
