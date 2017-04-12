package capaEntidades;

import java.util.ArrayList;

public class Localidad 
{
	private int idLocalidad;
	private String descripcion;
	private Provincia pro;
	private ArrayList<Calle> lc=null;
	
	public void setIdLocalidad(int id)
	{this.idLocalidad=id;}
	public int getIdLocalidad()
	{return this.idLocalidad;}
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
