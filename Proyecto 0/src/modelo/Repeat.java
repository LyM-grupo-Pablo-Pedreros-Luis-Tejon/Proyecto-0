package modelo;

import java.util.ArrayList;

public class Repeat 
{
	public static ArrayList<String> hallarBloques(String sentencia)
	{
		sentencia = sentencia.substring(1, sentencia.length() - 1);
		char[] caracteres = sentencia.toCharArray();
		
		ArrayList<String> bloques = new ArrayList<String>();
		String bloque = "";
		boolean fBlock = false;
		boolean vBlock = false;
		String variable = "";
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
	        				fBlock = false;
	        			}
	        		}
	        	}
        	}
        	if (caracter == ' ') 
        	{
        		vBlock = true;
        	}
        	else if ( caracter == ' ' && vBlock)
        	{
        		vBlock = false;
        		bloques.add(variable);
        	}
        	if (vBlock = true);
        	{
        		variable += Character.toString(caracter);
        		
        		
        	}
        }
        
        return bloques;
	}
	
	public static boolean comprobar(String sentencia)
	{
		ArrayList<String> bloques= hallarBloques(sentencia);
		String sentencia1 = bloques.get(1).substring(1, bloques.get(1).length() - 1);
		String[] palabras1 = sentencia1.split(" ");
		String variable = bloques.get(0);
		return Variable.comprobar(variable) && Comandos.comprobar(palabras1);
		
	}
	
}
