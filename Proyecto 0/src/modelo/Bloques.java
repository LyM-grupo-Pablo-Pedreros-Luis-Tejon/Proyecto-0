package modelo;

import java.util.ArrayList;

public class Bloques
{
	public static boolean comprobar(String sentencia,String[] palabras)
	{
		ArrayList<String> bloques = hallarBloques(sentencia);
		if (bloques.size() > 1)
		{
			for (String instruccion: bloques)
			{
				if (!(Bloques.comprobar(instruccion, instruccion.substring(1, instruccion.length() - 1).split(" "))))
				{
					return false;
				}
			}
			return true;
		}
		else if (hallarBloques(sentencia.substring(1, sentencia.length() - 1)).size() > 1)
		{
			bloques = hallarBloques(sentencia.substring(1, sentencia.length() - 1));
			for (String instruccion: bloques)
			{
				if (!(Bloques.comprobar(instruccion, instruccion.substring(1, instruccion.length() - 1).split(" "))))
				{
					return false;
				}
			}
			return true;
		}
		else
		{
		for (String comando: Carga.comandos)
		{
			if (palabras[0].equals(comando))
			{
				return (Comandos.comprobar(palabras));
			}
			
		}
		if (palabras[0].equals("if"))
		{
			return (IfCondition.comprobar(sentencia));
		}
		else if (palabras[0].equals("loop"))
		{
			return (Loop.comprobar(sentencia));
		}
		else if (palabras[0].equals("repeat"))
		{
			return (Repeat.comprobar(sentencia));
		}
		for (String funcion: Carga.funciones) 
		{
			if (palabras[0].equals(funcion))
			{
				return (Funciones.comprobar(palabras));
			}
		}
		
		return Condicion.comprobar(palabras);
		}
	}
	
	public static ArrayList<String> hallarBloques(String sentencia)
	{
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
	        				fBlock = false;
	        			}
	        		}
	        	}
        	}
        	
        }
        
        return bloques;
	}
}