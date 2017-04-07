package capaEntidades;

public class Calle 
{
	private Integer idCalle;
	private String descripcion;
	private Ciudad c;
	
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
	public Ciudad getP()
	{
		return c;
	}
	
	public void setC(Ciudad c)
	{
		this.c = c;
	}
}
