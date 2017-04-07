package capaNegocio;
import java.util.*;
import capaEntidades.*;
import capaDatos.*;
import util.*;

public class ControladorProCiuCalle
{
	public ArrayList<Domicilio> buscarProCiuCalle() throws ApplicationException
	{
		ProvinciaData dt=new ProvinciaData();
		ArrayList<Domicilio> pccas=dt.buscarPCC();
		return pccas;
	}
}
