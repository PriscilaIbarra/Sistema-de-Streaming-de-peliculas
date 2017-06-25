package util;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Formatter;

public class Encriptador 
{
	public static String Encriptar(String cad)
	{   String caden="";
		try {
			  MessageDigest encrip=MessageDigest.getInstance("SHA-1");
			  encrip.reset();
			  encrip.update(cad.getBytes("UTF-8"));
			  caden=ByteToHex(encrip.digest());
			 } 
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		} 
		catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
	   return caden;
	}
	
	private static String ByteToHex(final byte[] paencripbytes)
	{
	    Formatter convertidor = new Formatter();
	    for (byte b : paencripbytes)
	    {
	        convertidor.format("%02x", b);
	    }
	    String rta = convertidor.toString();
	    convertidor.close();
	    return rta;
	}
}
