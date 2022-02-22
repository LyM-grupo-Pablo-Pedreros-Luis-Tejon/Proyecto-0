package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Funciones
{
	public static HashMap<String,ArrayList<String>> funciones = new HashMap<String,ArrayList<String>>(); 
	
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
	        			}
	        		}
	        	}
        	}	
        }
        return bloques;
	}
	
	public static boolean comprobarDef(String sentencia)
	{
		ArrayList<String> bloques = Funciones.hallarBloques(sentencia);
		String[] palabras = sentencia.split(" ");
		funciones.put(palabras[1], new ArrayList<String>());
		String[] parametros = bloques.get(0).substring(1, bloques.get(0).length() - 1).split(" ");
		for (String parametro: parametros)
		{
			funciones.get(palabras[1]).add(parametro);
			Carga.variables.add(parametro);
		}
		String sentencia1 = bloques.get(1).substring(1, bloques.get(1).length() - 1);
		String[] palabras1 = sentencia1.split(" ");
		boolean retorno = false;
		retorno = Bloques.comprobar(sentencia1,palabras1);
		ArrayList<String> temp = Carga.variables;
		for (int i = 0; i < Carga.variables.size(); i++)
		{
			try 
			{
			for (String parametro: parametros)
			{
				if (parametro.equals(Carga.variables.get(i)))
				{
					temp.remove(parametro);
				}
			}
			}
			catch (Exception e)
			{
				
			}
		}
		Carga.variables = temp;
		return retorno;
	}
	
	public static boolean comprobar(String[] palabras)
	{
		for (String funcion: funciones.keySet()) 
		 {
			if (palabras[0].equals(funcion))
			{
				if ((palabras.length - 1) == funciones.get(palabras[0]).size()) 
				{
					boolean retorno = false;
					for (int i = 1; i > palabras.length; i++)
					{
						try
						{
							Integer.parseInt(palabras[i]);
						}
						catch (Exception e)
						{
							for (String variable: Carga.variables)
							{
								if (variable.equals(palabras[i]))
								{
									retorno = true;
								}
							}
						}
					}
					return retorno;
				}
			}
		 }
		 return false;
	}
}
