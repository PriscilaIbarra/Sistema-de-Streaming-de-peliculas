package capaEntidades;
import java.sql.Time;


public class Pelicula 
{ 
	private Long codPelicula;
	private String titulo;
	private String descripcion;
	private Time duracion;
    private Genero genP;
    
	public Long getCodPelicula() 
	{
		return codPelicula;
	}
	public void setCodPelicula(Long codPelicula) 
	{
		this.codPelicula = codPelicula;
	}
	public String getTitulo() 
	{
		return titulo;
	}
	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}
	public String getDescripcion()
	{
		return descripcion;
	}
	public void setDescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	}
	public Time getDuracion()
	{
		return duracion;
	}
	public void setDuracion(Time duracion)
	{
		this.duracion = duracion;
	}
	public Genero getGenP() 
	{
		return genP;
	}
	public void setGenP(Genero genP)
	{
		this.genP = genP;
	}	
}
