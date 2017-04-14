package util;
import java.text.SimpleDateFormat;
import java.util.*;

public class Fecha 
{
	public static String GetFechaHora()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone( TimeZone.getTimeZone( "GMT-3" ) );
		String fecha=sdf.format(new Date()).toString();
		fecha.trim();
		return fecha; 
	}
	
}
