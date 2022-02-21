package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Carga 
{
	public static ArrayList<String> variables;
	public static ArrayList<String> funciones;
	private Condicion condicion;
	private String archivo;
	public static String[] direcciones = {":left",":right",":around"};
	public static String[] cardinales = {":north",":south",":east",":west"};
	private static String[] comandos = {"defvar","=","move","turn","face","put","pick","move-dir","run-dirs","move-face","skip"};
	private static String[] estructuras = {"if","loop","repeat","defun"};

	
	public Carga(String archivo)
	{
		this.archivo = archivo;
	}
	public boolean leerTXT() throws IOException,FileNotFoundException
	{
		
		FileReader file = new FileReader(archivo);
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
	        				if (!(comprobar(sentencia))) 
	        				{
	        					return false;
	        				}
	        				sentencia = "";
	        			}
	        		}
	        	}
	        }
		}
		System.out.println(message);
		br.close();
		if (parentInicio != parentFinal)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	private boolean comprobar(String sentencia)
	{
		String sentencia2 = sentencia.substring(1, sentencia.length() - 1);
		String[] palabras = sentencia2.split(" ");
		for (String comando: comandos)
		{
			if (palabras[0].equals(comando))
			{
				return !(Comandos.comprobar(palabras));
				
			}
			
		}
		
		if (palabras[0].equals("if"))
		{
			return !(IfCondition.comprobar(sentencia));
		}
			
		
		return true;
	}
}
