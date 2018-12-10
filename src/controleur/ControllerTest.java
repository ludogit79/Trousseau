package controleur;

import bean.Clef;
import bean.Employe;
import bean.Personne;

public class ControllerTest
{
	public static void main(String[] args)
	{
		Clef clef = new Clef();
		System.out.println(clef.toString());
		System.out.println(clef);
		
		
		Employe emp1 = new Employe();
		System.out.println(emp1);
	}
	
}
