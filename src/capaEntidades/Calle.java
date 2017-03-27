package capaEntidades;

public class Calle 
{
	private Integer idCalle;
	private String descripcion;
	private Provincia p;
	
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
	public Provincia getP()
	{
		return p;
	}
	
	public void setP(Provincia p)
	{
		this.p = p;
	}
}
