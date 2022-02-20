package modelo;

public class Comandos implements Sentencia
{
	private String name;
	
	public Comandos(String nombre)
	{
		name = nombre;
	}

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
			for (String cardinal: Carga.cardinales)
			{
				if (cardinal.equals(palabras[1]))
				{
					return true;
				}
			}
			return false;
		}
		else if (comienzo.equals("put") || comienzo.equals("pick"))
		{
			if ((palabras[1].equals("Balloons")) || (palabras[1].equals("Chips")))
			{
				try
				{
					Integer.parseInt(palabras[2]);
					return true;
				}
				catch (Exception e)
				{
					for (String variable: Carga.variables)
					{
						if (variable.equals(palabras[2]))
						{
							return true;
						}
					}
					return false;
				}
			}
			return false;	
		}
		else if (comienzo.equals("move-dir"))
		{
			for (String direccion: Carga.direcciones)
			{	
				if (palabras[2].equals(direccion))
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
			}
			return false;
		}
		else if (comienzo.equals("run-dirs"))
		{
			for ( int i = 1; i < palabras.length - 1; i++)
			{
				boolean dir = false;
				for (String direccion: Carga.direcciones)
				{
					if (palabras[i].equals(direccion))
					{
						dir = true;
						break;
					}
				}
				if (!(dir))
				{
					return false;
				}
			}
			return true;
		}
		else if (comienzo.equals("move-face"))
		{
			for (String cardinal: Carga.cardinales)
			{	
				if (palabras[2].equals(cardinal))
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
			}
			return false;
		}
		else if (comienzo.equals("skip"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public String getName() 
	{
		return name;
	}

}
