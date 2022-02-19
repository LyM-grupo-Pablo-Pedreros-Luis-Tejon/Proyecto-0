package modelo;

import java.util.ArrayList;

public class IfCondition
{
	
	
	
	public static ArrayList<String> hallarBloques(String sentencia)
	{
		sentencia = sentencia.substring(1, sentencia.length() - 1);
		char[] caracteres = sentencia.toCharArray();
		
		ArrayList<String> bloques = new ArrayList<String>();
		String bloque = "";
		boolean fBlock = false;
		int parentInicio = 0;
		int parentFinal = 0;
		
        for (char caracter: caracteres)
        {
        	if (caracter == '(')
        	{
        		fBlock = true;
        	}
        	if (fBlock == true)
        	{
        		if ( (parentInicio == 0) || (parentInicio > parentFinal))
	        	{
	        		bloque += Character.toString(caracter);
	        		if (caracter == '(')
	        		{
	        			parentInicio ++;
	        			
	        		}
	        		else if (caracter == ')')
	        		{
	        			parentFinal ++;
	        			if (parentInicio == parentFinal)
	        			{
	        				parentInicio = 0;
	        				parentFinal = 0;
	        				bloques.add(bloque);
	        				bloque = "";
	        			}
	        		}
	        	}
        	}
        	
        }
        
        return bloques;
	}
	
	public static boolean comprobar(String sentencia)
	{
		ArrayList<String> bloques= hallarBloques(sentencia);
		String sentencia1 = bloques.get(1).substring(1, bloques.get(1).length() - 1);
		String[] palabras1 = sentencia1.split(" ");
		String sentencia2 = bloques.get(2).substring(1, bloques.get(2).length() - 1);
		String[] palabras2 = sentencia2.split(" ");
		String sentencia0 = bloques.get(0).substring(1, bloques.get(0).length() - 1);
		String[] palabras0 = sentencia0.split(" ");
		return Condicion.comprobar(palabras0) && Comandos.comprobar(palabras1) && Comandos.comprobar(palabras2);
		
	}
}
