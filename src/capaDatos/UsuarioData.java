package capaDatos;
import capaEntidades.*;
import util.ApplicationException;
import java.sql.*;
import capaDatos.FabricaDeConexion;

public class UsuarioData 
{
   public Boolean registrarUs(Usuario u)
   {  PreparedStatement stmt1=null;
	  PreparedStatement stmt2=null;
	  PreparedStatement stmt3=null;
	  PreparedStatement stmt4=null;
	  PreparedStatement stmt5=null;
	  PreparedStatement stmt6=null;
	  PreparedStatement stmt7=null;
	  PreparedStatement stmt8=null;
	  
	  try { 
	     	stmt1=FabricaDeConexion.getFabrica().getConexion().prepareStatement("INSERT INTO  sistemadestreaming.calles (descripcion,idLocalidad) values(?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
	        stmt1.setString(1,u.getDomicilio().getCa().getDescripcion());
	        stmt1.setInt(2,u.getDomicilio().getCa().getLoc().getIdLocalidad());
	        if(stmt1.execute())
	        {
	           stmt1.close();
	           stmt2=FabricaDeConexion.getFabrica().getConexion().prepareStatement("select idCalle from sistemadestreaming.calles order by idCalle desc LIMIT 1");
	           ResultSet rta=stmt2.executeQuery(); 
	           if(rta!=null)
	           {
	        	   Integer idCa=rta.getInt("idCalle");
	        	   rta.close();
	        	   stmt3=FabricaDeConexion.getFabrica().getConexion().prepareStatement("INSERT INTO  sistemadestreaming.domicilios (idCalle,nroCalle) values(?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
	               stmt3.setInt(1,idCa);
	               stmt3.setInt(2,u.getDomicilio().getNroCa());
	               if(stmt3.execute())
	               {
	            	   stmt3.close();
	            	   stmt4=FabricaDeConexion.getFabrica().getConexion().prepareStatement("select idDomicilio from sistemadestreaming.domicilios order by idDomicilio desc LIMIT 1");
	            	   ResultSet rta2=stmt4.executeQuery();
	            	   if(rta2!=null)
	            	   {
	            		  Integer idDo=rta2.getInt("idDomicilio");
	            		  rta2.close();
	            		  stmt4.close();
	            		  stmt5=FabricaDeConexion.getFabrica().getConexion().prepareStatement("INSERT INTO  sistemadestreaming.tarjetas (idTipoTarjeta,nroTarjeta) values(?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
	            		  stmt5.setInt(1,u.getTarjeta().getTt().getIdTipTar());
	            		  stmt5.setLong(2,u.getTarjeta().getNroTar());
	            		  if(stmt5.execute())
	            		  {
	            			  stmt5.close();
	            			  stmt6=FabricaDeConexion.getFabrica().getConexion().prepareStatement("select idTarjeta from sistemadestreaming.tarjetas order by idTarjeta desc LIMIT 1");
	            			  ResultSet rta3=stmt6.executeQuery();
	            			  if(rta3!=null)
	            			  {
	            				  Integer idTar=rta3.getInt("idTarjeta");
	            				  rta3.close();
	            				  stmt7=FabricaDeConexion.getFabrica().getConexion().prepareStatement("select idPlan from tarifas where idTarifa=?;");
	            				  stmt7.setInt(1,u.getPlan().getLt().get(0).getIdTarifa());
	            		          ResultSet rta4=stmt7.executeQuery(); 
	            		          if(rta4!=null)
	            		          {
	            		        	  Integer idP=rta4.getInt("idPlan");
	            		        	  stmt7.close();
	            		        	  rta4.close();
	            		        	  stmt8=FabricaDeConexion.getFabrica().getConexion().prepareStatement("INSERT INTO  sistemadestreaming.usuarios (password,nombre,apellido,idDomicilio,telefono,mail,fechaNacimiento,idTarjeta,idPlan,estado) values(?,?,?,?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
	            		        	  stmt8.setString(1,u.getPassword());
	            		        	  stmt8.setString(2,u.getNombre());
	            		        	  stmt8.setString(3,u.getApellido());
	            		        	  stmt8.setInt(4,idDo);
	            		        	  stmt8.setString(5,u.getTelefono());
	            		        	  stmt8.setString(6, u.getEmail());
	            		        	  stmt8.setString(7,u.getFechaNacimiento());
	            		        	  stmt8.setInt(8,idTar);
	            		        	  stmt8.setInt(9, idP);
	            		        	  stmt8.setString(10,u.getEstado());
	            		        	  stmt8.execute();
	            		        	  stmt8.close();
	            		          }
	            			  }
	            		  }
	            		  
	            	   }
	            	   
	               }	   
	           }
	        }
	      } 
	  catch (SQLException e)
	  {	e.printStackTrace();
	  return false;} 
	  catch (ApplicationException e)
	  {
		e.printStackTrace();
		return false;
	  }
	  finally
	  {	  try{FabricaDeConexion.getFabrica().releaseConn();}
		  catch (ApplicationException e) 
		  {	e.printStackTrace();}
	  }
	  
	  return true;
   }
}
