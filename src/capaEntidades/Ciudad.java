package capaEntidades;

public class Ciudad 
{
	private long idCiudad;
	private String descripcion;
	private Provincia pro;
	
	public void setIdCiudad(long id)
	{this.idCiudad=id;}
	public long getIdCiudad()
	{return this.idCiudad;}
	public void setDescripcion(String des)
	{this.descripcion=des;}
	public String getDescripcion()
	{return this.descripcion;}
	public void setProvincia(Provincia p)
	{this.pro=p;}
	public Provincia getProvincia()
	{return this.pro;}
}
