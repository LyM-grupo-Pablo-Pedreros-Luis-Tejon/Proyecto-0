package modelo;



public class Condicion
{
	public static String[] condiciones = {"facing-p","can-put-p","can-pick-p", "can-move-p", "not"};
	
	public static boolean comprobar(String[] palabras)
	{
		String comienzo = palabras[0];
		if (comienzo.equals("facing-p"))
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
		else if (comienzo.equals("can-put-p"))
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
		else if (comienzo.equals("can-pick-p"))
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
		else if (comienzo.equals("can-move-p"))
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
			if (comprobar(palabras1))
			{
				return false;
			}
			else
			{
				return true;
			}

		}
		else 
		{
			return false;
		}
	}
}
