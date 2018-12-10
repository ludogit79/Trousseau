package bean;

public class Clef
{
	// Constant 
	public final char ANALOGIQUE = 'a';
	public final char NUMERIQUE = 'n';
	
	// Variables
	public static int compteur;
	
	// Attributs
	private int id;
	private String reference = "";
	private String porte = "";
	private boolean disponible = true;
	private Personne personne;

	
	// Constructeur
	public Clef(){
		this.id = ++Clef.compteur;
		
	}
	
	public Clef(String reference, String porte, Personne personne, boolean disponible )
	{
		this.id = ++Clef.compteur;
		this.reference = reference;
		this.porte = porte;
		this.personne = personne;
		this.disponible = disponible;
	}	
	
	// Getters et Setters
	public int getId()
	{
		return id;
	}
	
	public void decrementId()
	{
		Clef.compteur = Clef.compteur -1;
	}

	public String getReference()
	{
		return reference;
	}

	public void setReference(String reference)
	{
		this.reference = reference;
	}

	public String getPorte()
	{
		return porte;
	}

	public void setPorte(String porte)
	{
		this.porte = porte;
	}

	public boolean isDisponible()
	{
		return disponible;
	}

	public void setDisponible(boolean disponible)
	{
		this.disponible = disponible;
	}

	public Personne getPersonne()
	{
		return personne;
	}

	public void setPersonne(Personne personne)
	{
		this.personne = personne;
	}

	public static int getCompteur()
	{
		return compteur;
	}

	public char getANALOGIQUE()
	{
		return ANALOGIQUE;
	}

	public char getNUMERIQUE()
	{
		return NUMERIQUE;
	}

//	@Override
//	public String toString()
//	{
//		return this.getPersonne().getId() + " : Nom : " + this.getPersonne().getNom() + " : Prénom :  " + this.getPersonne().getPrenom() + "  : email :  " + this.getPersonne().getEmail();
//	}
//	
	
}
