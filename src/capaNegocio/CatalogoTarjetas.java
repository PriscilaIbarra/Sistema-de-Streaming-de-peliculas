package capaNegocio;
import capaDatos.*;
import capaEntidades.*;
import java.util.*;
import util.*;


public class CatalogoTarjetas
{
	public ArrayList<TipoTarjeta> buscarTipoTajetas() throws ApplicationException
	{
		TarjetaData td=new TarjetaData();
		ArrayList<TipoTarjeta>tpt=td.buscarTipTarjetas();
		return tpt;
	 
	}
}
