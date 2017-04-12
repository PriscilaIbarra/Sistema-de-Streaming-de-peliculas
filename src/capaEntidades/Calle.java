package capaEntidades;

public class Calle 
{
	private Integer idCalle;
	private String descripcion;
	private Localidad c;
	
	public Integer getIdCalle() 
	{
		return idCalle;
	}
	public void setIdCalle(Integer idCalle)
	{
		this.idCalle = idCalle;
	}
	public String getDescripcion()
	{
		return descripcion;
	}
	
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	public Localidad getLoc()
	{
		return c;
	}
	
	public void setLoc(Localidad c)
	{
		this.c = c;
	}
}
