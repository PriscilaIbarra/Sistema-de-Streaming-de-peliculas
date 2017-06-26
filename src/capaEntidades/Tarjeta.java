package capaEntidades;

public class Tarjeta
{
	private Integer idTarj;
	private String nroTar;
	private TipoTarjeta tt;
	
	public Integer getIdTarj() 
	{
		return idTarj;
	}
	public void setIdTarj(Integer idTarj) 
	{
		this.idTarj = idTarj;
	}
	public String getNroTar()
	{
		return nroTar;
	}
	public void setNroTar(String nroTar)
	{
		this.nroTar = nroTar;
	}
	public TipoTarjeta getTt() 
	{
		return tt;
	}
	public void setTt(TipoTarjeta tt) 
	{
		this.tt = tt;
	}
	
	
}
