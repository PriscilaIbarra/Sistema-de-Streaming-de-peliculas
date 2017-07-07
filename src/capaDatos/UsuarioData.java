package capaDatos;
import capaEntidades.*;
import util.ApplicationException;
import util.Fecha;
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
	            		 {stmt=FabricaDeConexion.getFabrica().getConexion().prepareStatement("INSERT INTO usuarios (password,nombre,apellido,idDomicilio,telefono,mail,fechaNacimiento,idTarjeta,idPlan,estado,feContratacionServicio) values(?,?,?,?,?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
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
     		        	  stmt.setString(11,Fecha.GetFecha());
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
	  	stmt=FabricaDeConexion.getFabrica().getConexion().prepareStatement("select idUsuario,us.idPlan as idPlan,p.cantPeliculas as cantPeliculas,estado from usuarios us inner join planes p on us.idPlan=p.idPlan where mail=? and password=?");
	  	stmt.setString(1,u.getEmail());
	  	stmt.setString(2,u.getPassword());
	  	rs=stmt.executeQuery();
	  	while(rs.next())
	  	{
	  		ub=new Usuario();
	  		ub.setNroUsuario(rs.getLong("idUsuario"));
	  		ub.setEstado(rs.getString("estado"));
	  		Plan p=new Plan();
	  		p.setIdPlan(rs.getInt("idPlan"));
	  		p.setCantPel(rs.getInt("cantPeliculas"));
	  		ub.setPlan(p);
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


 public Integer getCantPelAlq(Usuario u) throws ApplicationException  
 {  String mesS="";
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

 
 public Plan recuperarPlan(Usuario us) throws ApplicationException, SQLException
 {
	 PreparedStatement stmt=null;
	 ResultSet rta=null;
	 Plan p=new Plan();
	 try
	 { stmt=FabricaDeConexion.getFabrica().getConexion().prepareStatement("select cantPeliculas from usuarios us "
				+"	inner join planes p on us.idPlan=p.idPlan"
				+"	where us.idUsuario=?");
	   stmt.setLong(1, us.getNroUsuario());
	   rta=stmt.executeQuery();
	   
	   while(rta.next())
	   {  p.setCantPel(rta.getInt("cantPeliculas"));}
	   
		 
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
	 return p;
	 
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
   
   
   
   public String getFechaContratacion(Usuario u) throws ApplicationException, SQLException
   {   String fechaContratacion=null;	 
	   PreparedStatement stmt=null;
	   ResultSet rta=null;
	   try
	   {
		   stmt=FabricaDeConexion.getFabrica().getConexion().prepareStatement("select feContratacionServicio from usuarios where idUsuario =?");
		   stmt.setLong(1, u.getNroUsuario());
		   rta=stmt.executeQuery();
		   while(rta.next())
		   {
			  fechaContratacion=rta.getString("feContratacionServicio"); 
		   }
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
	  return fechaContratacion; 
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


	   


