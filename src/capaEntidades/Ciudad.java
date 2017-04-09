package capaEntidades;

import java.util.ArrayList;

public class Ciudad 
{
	private long idCiudad;
	private String descripcion;
	private Provincia pro;
	private ArrayList<Calle> lc=null;
	
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
	
	public void setCalles(ArrayList<Calle>lc)
	{
		this.lc=lc;
	}
	public ArrayList<Calle> getCalles()
	{
		return this.lc;
	}
	
}
