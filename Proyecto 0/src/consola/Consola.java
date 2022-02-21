package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import modelo.Carga;

public class Consola 
{

	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		//*String ex = "elemento 20 gracias";
		//*String[] ex2 = ex.split(" ");
		//*System.out.println(ex2);
		//*System.out.println(ex2.length);
		final String file = input("Escriba el nombre del archivo de instrucciones");
		Carga modelo = new Carga(file);
		modelo.leerTXT();
	}

	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
}
