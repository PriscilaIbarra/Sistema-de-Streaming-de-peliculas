package capaDatos;
import capaEntidades.*;
import util.ApplicationException;
import java.sql.*;

public class UsuarioData 
{
   public Boolean registrarUs(Usuario u) throws ApplicationException
   {   PreparedStatement stmt=null;
	   Boolean rta=false;
       try { Integer idC=UsuarioData.GrabarCalle(u.getDomicilio().getCa());		
   			if(idC!=-1)	         
   		    {   u.getDomicilio().getCa().setIdCalle(idC);
   				Integer idD=UsuarioData.GrabarDomicilio(u.getDomicilio());
   				if(idD!=-1)
	          {      Integer idTar=UsuarioData.GrabarTarjeta(u.getTarjeta());	   
   		    	       if(idTar!=-1)
   		    	      {	 Integer idP=UsuarioData.GetIdPlan(u.getPlan()); 
   		    	      	 if(idP!=-1)
	            		 {stmt=FabricaDeConexion.getFabrica().getConexion().prepareStatement("INSERT INTO usuarios (password,nombre,apellido,idDomicilio,telefono,mail,fechaNacimiento,idTarjeta,idPlan,estado) values(?,?,?,?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
     		        	  stmt.setString(1,u.getPassword());
     		        	  stmt.setString(2,u.getNombre());
     		        	  stmt.setString(3,u.getApellido());
     		        	  stmt.setInt(4,idD);
     		        	  stmt.setString(5,u.getTelefono());
     		        	  stmt.setString(6, u.getEmail());
     		        	  stmt.setString(7,u.getFechaNacimiento());
     		        	  stmt.setInt(8,idTar);
     		        	  stmt.setInt(9,idP);
     		        	  stmt.setString(10,u.getEstado());
     		        	  if(stmt.executeUpdate()>0)
     		        	  {rta=true;}
	            		 }
     		          }
	           }
	      }
	   }
	  catch(SQLException e)
	  {e.printStackTrace();}
	  finally{
	            try{ if(stmt!=null){stmt.close();}
			         FabricaDeConexion.getFabrica().releaseConn();}   
	            catch (ApplicationException e)
	            { e.printStackTrace();}
		        catch(SQLException e)
		        {e.printStackTrace();}
		 	   }
	 return rta;        
	}
	    
	  
	  
   private static Integer GrabarCalle(Calle c) throws ApplicationException
   {   PreparedStatement stmt1=null;
       Integer idC=-1;
	   try {  stmt1=FabricaDeConexion.getFabrica().getConexion().prepareStatement("INSERT INTO calles (descripcion,idLocalidad) values(?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
		      stmt1.setString(1,c.getDescripcion());
		      stmt1.setInt(2,c.getLoc().getIdLocalidad());
		      if(stmt1.executeUpdate()>0)
		      { ResultSet r=stmt1.getGeneratedKeys();//Me devuelve el nuevo idCalle generado
		        while(r.next())
		        {idC=r.getInt(1);}		      
		      }
		   }  
		 catch(SQLException e)
		 {e.printStackTrace();}
		 finally{
	            try{FabricaDeConexion.getFabrica().releaseConn();}   
	            catch (ApplicationException e)
	            { e.printStackTrace();}
		   	   }
	   return idC;}
   
private static Integer GrabarDomicilio(Domicilio d) throws ApplicationException
{   PreparedStatement stmt3=null;
	Integer idD=-1;
	try {  stmt3=FabricaDeConexion.getFabrica().getConexion().prepareStatement("INSERT INTO domicilios (idCalle,nroCalle) values(?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
           stmt3.setInt(1,d.getCa().getIdCalle());
           stmt3.setInt(2,d.getNroCa());
           if(stmt3.executeUpdate()>0)
           { ResultSet r=stmt3.getGeneratedKeys();
              while(r.next())
             {idD=r.getInt(1);}
           }
         }
    catch(SQLException e)
		 {e.printStackTrace();}
   finally{
	       try{ FabricaDeConexion.getFabrica().releaseConn();}   
	       catch (ApplicationException e)
	          { e.printStackTrace();} 
	       }
	return idD;
}

private static Integer GrabarTarjeta(Tarjeta t) throws ApplicationException
{   PreparedStatement stmt5=null;
    Integer idT=-1;
    try {  stmt5=FabricaDeConexion.getFabrica().getConexion().prepareStatement("INSERT INTO tarjetas (idTipoTarjeta,nroTarjeta) values(?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
 		   stmt5.setInt(1,t.getTt().getIdTipTar());
 		   stmt5.setString(2,t.getNroTar());
 		   if(stmt5.executeUpdate()>0)
 		   { ResultSet r=stmt5.getGeneratedKeys();
 		     while(r.next())
 		     {idT=r.getInt(1);}
 		   }
		 } 
	   catch(SQLException e)
	   {e.printStackTrace();}
	   finally{
	            try{FabricaDeConexion.getFabrica().releaseConn();}   
	            catch(ApplicationException e)
	            {e.printStackTrace();}
		       }
	   return idT;
}


private static Integer GetIdPlan(Plan p) throws ApplicationException
{   PreparedStatement stmt7=null;
	Integer idP=-1;
	ResultSet rta=null;
    try {  stmt7=FabricaDeConexion.getFabrica().getConexion().prepareStatement("select idPlan from tarifas where idTarifa=?");
	       stmt7.setInt(1,p.getLt().get(0).getIdTarifa());
           rta=stmt7.executeQuery(); 
           while(rta.next())
           {idP=rta.getInt("idPlan");}
        }
   catch(SQLException e)
		{e.printStackTrace();}
   finally{
	        try{FabricaDeConexion.getFabrica().releaseConn();}   
	        catch (ApplicationException e)
	        { e.printStackTrace();}
		   }
	return idP;
}



public Usuario getUsuario(Usuario u) throws SQLException, ApplicationException
{
  PreparedStatement stmt=null;
  ResultSet rs=null;
  Usuario ub=null;
  try {
	  	stmt=FabricaDeConexion.getFabrica().getConexion().prepareStatement("select idUsuario,estado from usuarios where mail=? and password=?");
	  	stmt.setString(1,u.getEmail());
	  	stmt.setString(2,u.getPassword());
	  	rs=stmt.executeQuery();
	  	while(rs.next())
	  	{
	  		ub=new Usuario();
	  		ub.setNroUsuario((long) rs.getInt("idUsuario"));
	  		ub.setEstado(rs.getString("estado"));
	  	}
	 } 
  catch (SQLException e)
  {e.printStackTrace();} 
  catch (ApplicationException e)
  {e.printStackTrace();}
  finally{	if(stmt!=null)
  			{stmt.close();}
            if(rs!=null)
            {rs.close();}
            FabricaDeConexion.getFabrica().releaseConn();
         }
  return ub;
}



}


	   


