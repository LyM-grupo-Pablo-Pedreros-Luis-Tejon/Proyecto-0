package modelo;

public class Variable 
{
	
	public static boolean comprobar(String v)
	{
		
		for (String variable: Carga.variables)
		{
			if (variable.equals(v))
			{
				return true;
			}
		}
		return false;
	}
}
