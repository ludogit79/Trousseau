package bean;

public abstract class Personne 
{
	//Attributs
	private String id;
	private String prenom;
	private String nom;
	private String email;
	
	// Constructeur
	public Personne() {}
	
	public Personne(String id, String prenom, String nom, String email)
	{
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
	}
	
	//Getters Setters
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getPrenom()
	{
		return prenom;
	}
	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}
	public String getNom()
	{
		return nom;
	}
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	
	
}
