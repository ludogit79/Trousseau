package bean;

public class SousTraitant extends Personne
{
	
	// Attributs
	private String entreprise; 
	
	public String getEntreprise()
	{
		return entreprise;
	}

	public void setEntreprise(String entreprise)
	{
		this.entreprise = entreprise;
	}
	
	// Surcharge
		@Override
		public String toString()
		{
			return  " Nom : " + this.getNom() + " Prenom : " + this.getPrenom() + " Id : "+ this.getId()  + " Entreprise : " + this.getEntreprise();
			
		}
	
}
