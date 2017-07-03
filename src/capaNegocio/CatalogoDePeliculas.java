package capaNegocio;
import java.util.ArrayList;
import capaEntidades.Pelicula;
import capaEntidades.Usuario;
import util.ApplicationException;
import capaDatos.*;
public class CatalogoDePeliculas
{
	public static ArrayList<Pelicula> buscarPelPlan(Usuario u) throws ApplicationException
	{
		PeliculaData pd=new PeliculaData();
		return pd.getPeliculasPlanCli(u);
	}

}
