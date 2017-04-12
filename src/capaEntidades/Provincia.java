package capaEntidades;
import java.util.*;
public class Provincia 
{
	private Integer idP;
	private String descP;
	private ArrayList<Localidad>localidades;

	public Integer getIdP()
	{
		return idP;
	}
	public void setIdP(Integer idP)
	{
		this.idP = idP;
	}
	public String getDescP()
	{
		return descP;
	}
	public void setDescP(String descP)
	{
		this.descP = descP;
	}
	public ArrayList<Localidad> getLocalidades() 
	{
		return localidades;
	}
	public void setLocalidades(ArrayList<Localidad> ciudades) 
	{
		this.localidades = ciudades;
	}
	
}
