package capaEntidades;

public class Domicilio 
{
	private Integer idDom;
	private Calle ca;
	private Integer nroCa;
	
	public Integer getIdDom()
	{
		return idDom;
	}
	public void setIdDom(Integer idDom)
	{
		this.idDom = idDom;
	}
	public Calle getCa()
	{
		return ca;
	}
	public void setCa(Calle ca)
	{
		this.ca = ca;
	}
	public Integer getNroCa() 
	{
		return nroCa;
	}
	public void setNroCa(Integer nroCa) 
	{
		this.nroCa = nroCa;
	}
	
}
