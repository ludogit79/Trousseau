package vue;

public class Validation
{
	public static boolean isValide(char[] repValident, String rep)
	{
		boolean valide = false;
		char reponse;
		if(!rep.equals(""))
		{
			for(char repValide : repValident)
			{
				reponse = rep.charAt(0);
					if(repValide == reponse ) 
					{
						valide = true;
					}
					
			}
		}
		return valide;
	}
}







