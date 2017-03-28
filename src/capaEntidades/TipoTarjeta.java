package capaEntidades;

public class TipoTarjeta 
{
	private Integer idTipTar;
	private String descripcion;
	private String entCrediticia;
	
	public Integer getIdTipTar()
	{
		return idTipTar;
	}
	public void setIdTipTar(Integer idTipTar)
	{
		this.idTipTar = idTipTar;
	}
	public String getDescripcion() 
	{
		return descripcion;
	}
	public void setDescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	}
	
	public void setEntCrediticia(String ec)
	{
		this.entCrediticia=ec;
	}
	
	public String getEntCrediticia()
	{
		return this.entCrediticia;
	}
}
