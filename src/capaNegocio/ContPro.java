package capaNegocio;
import java.util.*;
import capaEntidades.*;
import capaDatos.*;
import util.*;

public class ContPro
{
	public ArrayList<Provincia> buscarPcias() throws ApplicationException
	{
		ProvinciaData dt=new ProvinciaData();
		ArrayList<Provincia> pcias=dt.buscarPCC();
		return pcias;
	}
	
	public static ArrayList<Ciudad> buscaCiu(Integer idP) throws ApplicationException
	{
		ProvinciaData dt=new ProvinciaData();
		ArrayList<Ciudad> lc=dt.buscarCds(idP);
		return lc;
	}
	
	public static ArrayList<Calle> buscaCa(Long idC) throws ApplicationException
	{
		CiudadData cd=new CiudadData();
		Integer idCi=Integer.valueOf(idC.intValue());
		ArrayList<Calle>lca=cd.buscarCa(idCi);
		return lca;
	}
}
