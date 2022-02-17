package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Carga 
{
	private Comandos comando;
	private ArrayList<Variable> variables;
	private Condicion condicion;
	private Estructura estructura;
	
	private void leerTXT(String codigo) throws IOException,FileNotFoundException
	{
		
		FileReader file = new FileReader(codigo);
		BufferedReader br = new BufferedReader(file);
		String message = "";
		String line = br.readLine();
		int parentInicio = 0;
		int parentFinal = 0;
		String sentencia = "";
		while(line != null)
		{
			char[] caracteres = line.toCharArray();
	        for (char caracter: caracteres)
	        {
	        	if ( (parentInicio == 0) || (parentInicio > parentFinal))
	        	{
	        		sentencia += Character.toString(caracter);
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
	        				comprobar(sentencia);
	        				sentencia = "";
	        			}
	        		}
	        	}
	        }
		}
		System.out.println(message);
		br.close();
		
	}
	
	private boolean comprobar(String sentencia)
	{
		return true;
	}
}
