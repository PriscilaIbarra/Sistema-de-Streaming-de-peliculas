package capaEntidades;
import java.util.*;

public class Tarifa
{
	private Calendar fechaVi;
	private Double importe;
	
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
