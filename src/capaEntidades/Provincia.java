package capaEntidades;
import java.util.*;
public class Provincia 
{
	private Integer idP;
	private String descP;
	private ArrayList<Ciudad>ciudades;

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
	public ArrayList<Ciudad> getCiudades() 
	{
		return ciudades;
	}
	public void setCiudades(ArrayList<Ciudad> ciudades) 
	{
		this.ciudades = ciudades;
	}
	
}
