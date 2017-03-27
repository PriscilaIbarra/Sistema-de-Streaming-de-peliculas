package capaEntidades;
import java.util.*;
public class Plan 
{
	private Integer idPlan;
	private String descPlan;
	private ArrayList<Tarifa> lt;
	private Integer cantPel;
	
	public Integer getIdPlan()
	{
		return idPlan;
	}
	public void setIdPlan(Integer idPlan)
	{
		this.idPlan = idPlan;
	}
	public String getDescPlan() 
	{
		return descPlan;
	}
	public void setDescPlan(String descPlan)
	{
		this.descPlan = descPlan;
	}
	public ArrayList<Tarifa> getLt() {
		return lt;
	}
	public void setLt(ArrayList<Tarifa> lt) 
	{
		this.lt = lt;
	}
	public Integer getCantPel() 
	{
		return cantPel;
	}
	public void setCantPel(Integer cantPel) 
	{
		this.cantPel = cantPel;
	}
}
