package capaEntidades;
import java.sql.SQLException;
import java.util.*;

import util.ApplicationException;
import util.Encriptador;
import capaDatos.UsuarioData;

public class Usuario
{ 
	private Long nroUsuario;
	private String password;
	private String nombre;
	private String apellido;
	private Domicilio dom;
	private String telefono;
	private String mail;
	private String fechaNacimiento;
	private Tarjeta tarUs;
	private Plan planUs;
	private ArrayList<Pelicula> peliculasPlan;
	private String estado;
	private String feContratacion;

	
	public void setNroUsuario(Long nroU)
	{
		this.nroUsuario=nroU;
	}
	
	public Long getNroUsuario()
	{
		return this.nroUsuario;
	}

	public void setPassword(String pass)
	{
		this.password=pass;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setNombre(String nom)
	{
		this.nombre=nom;
	}

    public String getNombre()
    {
     return this.nombre;
    }

    public void setApellido(String ap)
    {
    	this.apellido=ap;
    }
   
    public String getApellido()
    {
    	return this.apellido;
    }

    public void setDomicilio(Domicilio domi)
    {
    	this.dom=domi;
    }
    
    public Domicilio getDomicilio()
    {
    	return this.dom;
    }

    public void setTelefono(String tel)
    {
    	this.telefono=tel;
    }
    
    public String getTelefono()
    {
    	return this.telefono;
    }

    public void setEmail(String email)
    {
    	this.mail=email;
    }
    
    public String getEmail()
    {
    	return this.mail;
    }
    
    public void setFechaNacimiento(String fe)
    {
    	this.fechaNacimiento=fe;
    }
    
    public String getFechaNacimiento()
    {
    	return this.fechaNacimiento;
    }
    
    public void setTarjeta(Tarjeta t)
    {
    	this.tarUs=t;
    }
    
    public Tarjeta getTarjeta()
    {
    	return this.tarUs;
    }

    public void setPlan(Plan p)
    {
    	this.planUs=p;
    }

    public Plan getPlan()
    {
    	return this.planUs;
    }

    public void setPeliculasPl(ArrayList<Pelicula>lp)
    {
    	this.peliculasPlan=lp;
    }

    public ArrayList<Pelicula>getLP()
    {
    	return this.peliculasPlan;
    }
    
    
    public void setEstado(String e)
    {
    	this.estado=e;
    }
    
    public String getEstado()
    {
    	return this.estado;
    }
    
    public String encriptar(String str)
    {   
    	String pass=Encriptador.Encriptar(str);  	
    	return pass;
    }
    
    public Integer getCantPelAlqEnMes()
    {   Integer cantPelAlMes=0;
    	UsuarioData ud=new UsuarioData();
    	try {cantPelAlMes=ud.getCantPelAlq(this);}
    	catch (ApplicationException e)
    	{e.printStackTrace();}
    	return cantPelAlMes;
    }
    
    public void recordar()
    {
    	UsuarioData ud=new UsuarioData();
    	try {this.setPlan(ud.recuperarPlan(this));}
    	catch (ApplicationException e)
    	{e.printStackTrace();}
    	catch (SQLException e) 
    	{e.printStackTrace();}
    }
    
    public Boolean fueAlquiladaEnMes(Pelicula p)
    {       Boolean rta=false;
         	UsuarioData ud=new UsuarioData();
         	try {
				if(ud.esPeliculaAlquilada(this,p))
				{rta=true;}
         		} 
         	catch (ApplicationException | SQLException e) 
         	{e.printStackTrace();}
         	return rta;
    }
    
    public Boolean alquilarPelicula(Pelicula p)
    {   Boolean rta=false;
    	UsuarioData ud=new UsuarioData();
    	try {if(ud.grabarAlquiler(this,p))
				{rta=true;}} 
    	catch (ApplicationException | SQLException e)
    	{e.printStackTrace();}
     return rta;
    }

	public String getFeContratacion()
	{
		return feContratacion;
	}

	public void setFeContratacion() 
	{   UsuarioData u=new UsuarioData();
		try {this.feContratacion = u.getFechaContratacion(this);}
		catch (ApplicationException |SQLException  e)
		{e.printStackTrace();} 
	}
    
    
}




