package bean;

public class Employe extends Personne
{	
	// Attributs
		private String fonction;
	
		
		//Constructeur
		
	public String getFonction()
	{
		return fonction;
	}

	public void setFonction(String fonction)
	{
		this.fonction = fonction;
	}

	// Surcharge
	@Override
	public String toString()
	{
		
		return  " Nom : " + this.getNom() + " Prenom : " + this.getPrenom() + " Id : "+ this.getId()  + " Fonction : " + this.getFonction();
		
	} 
	
	
	
}
