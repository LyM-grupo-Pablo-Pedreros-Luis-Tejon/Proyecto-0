package modelo;

public class Comandos 
{

	public static boolean comprobar(String[] palabras) 
	{
		String comienzo = palabras[0];
		
		if (comienzo.equals("defvar"))
		{
			try
			{
				Integer.parseInt(palabras[2]);
				Carga.variables.add(palabras[1]);
				return true;
			}
			catch (Exception e)
			{
				return false;
			}
		}
		else if (comienzo.equals("="))
		{
			try
			{
				Integer.parseInt(palabras[2]);
				for (String variable: Carga.variables)
				{
					if (variable.equals(palabras[1]))
					{
						return true;
					}
				}
				return false;
			}
			catch (Exception e)
			{
				return false;
			}
		}
		else if (comienzo.equals("move"))
		{
			try
			{
				Integer.parseInt(palabras[1]);
				return true;
			}
			catch (Exception e)
			{
				for (String variable: Carga.variables)
				{
					if (variable.equals(palabras[1]))
					{
						return true;
					}
				}
				return false;
			}
		}
		else if (comienzo.equals("turn"))
		{
			for (String direccion: Carga.direcciones)
			{
				if (direccion.equals(palabras[1]))
				{
					return true;
				}
			}
			return false;
		}
		else if (comienzo.equals("face"))
		{
			
		}
	}

	

}
