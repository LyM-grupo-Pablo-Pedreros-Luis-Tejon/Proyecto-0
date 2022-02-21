package modelo;



public class Condicion
{
	public static String[] condiciones = {"facing-p","can-put-p","can-pick-p", "can-move-p", "not"};
	
	public static boolean comprobar(String[] palabras)
	{
		String comienzo = palabras[0];
		if (palabras.length == 2)
		{
		if (comienzo.equals("facing-p"))
		{
			for (String direccion: Carga.cardinales)
			{
				if (direccion.equals(palabras[1]))
				{
					return true;
				}
			}
			return false;
		}
		
		else if (comienzo.equals("can-move-p"))
		{
			for (String direccion: Carga.cardinales)
			{
				if (direccion.equals(palabras[1]))
				{
					return true;
				}
			}
			return false;
		}
		else
		{
			return false;
		}
		}
		else if (comienzo.equals("not"))
		{
			String newCondition = "";
			for (String palabra: palabras)
			{
				if (palabra.equals(comienzo))
				{
					
				}
				else
				{
					if (newCondition.equals(""))
					{
						newCondition = palabra;
					}
					else
						newCondition = newCondition + " " + palabra;
				}
			}
			newCondition = newCondition.substring(1, newCondition.length() - 1);
			String[] palabras1 = newCondition.split(" ");
			if (Condicion.comprobar(palabras1))
			{
				return true;
			}
			else
			{
				return false;
			}

		}
		else if (palabras.length == 3)
		{
			if (comienzo.equals("can-put-p") || comienzo.equals("can-pick-p"))
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
			else
			{
				return false;
			}
		}
		
		else 
		{
			return false;
		}
	}
}
