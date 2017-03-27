package capaEntidades;

public class Tarjeta
{
	private Integer idTarj;
	private Long nroTar;
	private TipoTarjeta tt;
	
	public Integer getIdTarj() 
	{
		return idTarj;
	}
	public void setIdTarj(Integer idTarj) 
	{
		this.idTarj = idTarj;
	}
	public Long getNroTar()
	{
		return nroTar;
	}
	public void setNroTar(Long nroTar)
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
