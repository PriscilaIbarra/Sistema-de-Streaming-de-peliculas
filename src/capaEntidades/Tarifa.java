package capaEntidades;
import java.util.*;

public class Tarifa
{
	private Integer idTarifa;
	private Calendar fechaVi;
	private Double importe;
	
	public void setIdTarifa(Integer idt)
	{
		this.idTarifa=idt;
	}
	public Integer getIdTarifa()
	{
		return this.idTarifa;
	}
	public Calendar getFechaVi() 
	{
		return fechaVi;
	}
	public void setFechaVi(Calendar fechaVi)
	{
		this.fechaVi = fechaVi;
	}
	public Double getImporte()
	{
		return importe;
	}
	public void setImporte(Double importe)
	{
		this.importe = importe;
	} 
	
}
