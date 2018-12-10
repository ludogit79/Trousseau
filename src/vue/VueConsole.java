package vue;

import java.util.Scanner;

import bean.Clef;
import bean.Employe;
import bean.Personne;
import bean.SousTraitant;

public class VueConsole
{
	// Variable 
	Scanner sc = new Scanner(System.in);
	
	// Traitement
	public char menuPrincipal(int nbrClef)
	{
		char[] repValident = {'1','2','3','4', '5','Q'};
		String rep = "";
		
		System.out.println();
		do
		{
			System.out.println("Bienvenue à GestTrousseau (" + nbrClef + ")");
			System.out.println("-------------------------");
			System.out.println("1 - Ajouter une clef");
			System.out.println("2 - modifier une clef");
			System.out.println("3 - Supprimer une clef");
			System.out.println("4 - Afficher clefs par propriétés");
			System.out.println("5 - Afficher trousseau");
			System.out.println("Q - Quitter");
	
			rep = sc.nextLine().toUpperCase();
		
		}while(!Validation.isValide(repValident, rep));
		
		return rep.charAt(0);		
	}
	
	public Clef menuAjouter(Clef clef, int nbrClef)	
	{
		clef = new Clef();
		
		System.out.println("Bienvenue à GestTrousseau (" + nbrClef + ")");
		System.out.println("-------Ajouter-----------");

		System.out.print("Entrez la référence de la clef : ");
		clef.setReference(sc.nextLine());
		
		System.out.print("Entrez la porte : ");
		clef.setPorte(sc.nextLine());
		
		char personnefonct = menuEmployeSoustraitant();
		
		if(personnefonct == '1') // choix Employe
		{
			Employe employe = new Employe();
			
			System.out.print("Nom : ");
			employe.setNom(sc.nextLine());
			System.out.print("Prénom : ");
			employe.setPrenom(sc.nextLine());
			System.out.print("ID : ");
			employe.setId(sc.nextLine());
			System.out.print("email : ");		
			employe.setEmail(sc.nextLine());
			System.out.print("fonction : ");		
			employe.setFonction(sc.nextLine());
			
			clef.setPersonne(employe); //On va chercher employe dans Personne

			 //castage de objet personne au type Employe pour accès à la propriété fonction
			System.out.println(" Afficher fonction employé :" + ((Employe)clef.getPersonne()).getFonction());
				
			if(clef.getPersonne().getNom() != "")
			{
				clef.setDisponible(false);
			}
		}
		
		else if(personnefonct == '2')
		{
			SousTraitant soustraitant = new SousTraitant();
			
			System.out.print("Nom : ");
			soustraitant.setNom(sc.nextLine());
			System.out.print("Prénom : ");
			soustraitant.setPrenom(sc.nextLine());
			System.out.print("ID : ");
			soustraitant.setId(sc.nextLine());
			System.out.print("email : ");		
			soustraitant.setEmail(sc.nextLine());
			System.out.print("Entreprise : ");		
			soustraitant.setEntreprise(sc.nextLine());
			
			clef.setPersonne(soustraitant); //On va chercher soustraitant dans Personne

			soustraitant = (SousTraitant)clef.getPersonne(); //castage de objet personne au type SousTraitant pour accès à la propriété Entreprise
			System.out.println(" Afficher entreprise soustraitant :" + soustraitant.getEntreprise());
				
			if(clef.getPersonne().getNom() != "")
			{
				clef.setDisponible(false);
			}
		}
		
		
		return clef;
	}
	
	
	public char menuEmployeSoustraitant()
	{
		char[] repValident = {'1','2','Q'};
		String rep = "";
		
		System.out.println();
		do
		{
			
			System.out.println("Affectation de la clef à : ");
			System.out.println("1 - pour employe");
			System.out.println("2 - pour SousTraitant");		
			System.out.println("Q - pour Quitter sans affecter de personne");
			
			rep = sc.nextLine().toUpperCase();
		
		}while(!Validation.isValide(repValident, rep));
		
		return rep.charAt(0);		
	}
	
	
	public char menuRechercher(int nbrClef)
	{
		char[] repValident = {'1','2','3','Q'};
		String rep = "";
		
		System.out.println();
		do
		{
			System.out.println("Bienvenue à GestTrousseau (" + nbrClef + ")");
			System.out.println("-----Menu Rechercher-----");
			System.out.println("1 - Par référence");
			System.out.println("2 - porte");
			System.out.println("3 - personne");
			System.out.println("Q - quitter");			
	
			rep = sc.nextLine().toUpperCase();
		
		}while(!Validation.isValide(repValident, rep));
		
		return rep.charAt(0);		
	}
	
	public char menuListePersonne()
	{
		char[] repValident = {'1','2','3','4','5','Q'};
		String rep = "";
		
		System.out.println();
		do
		{
			
			System.out.println("-----Menu Rechercher Personne-----");
			System.out.println("1 - Par Nom");
			System.out.println("2 - Par Prenom");
			System.out.println("3 - Par ID");
			System.out.println("4 - Par Fonction pour les employés");
			System.out.println("5 - Par Entreprise pour les soustraitant");
			System.out.println("Q - quitter");			
	
			rep = sc.nextLine().toUpperCase();
		
		}while(!Validation.isValide(repValident, rep));
		
		return rep.charAt(0);		
	}
	
	public String menuRechercherByReference()
	{
		System.out.println();
		System.out.println("Saisir la référence");
		System.out.print("--> ");
		String rep = sc.nextLine();
		
		return rep;
	}
	
	public String menuRechercherByPorte()
	{
		System.out.println();
		System.out.println("Saisir la porte");
		System.out.print("--> ");
		String rep = sc.nextLine();
		
		return rep;
	}	
	
	public String menuRechercherByPersonne()
	{
		System.out.println();
		
		System.out.print("--> ");		
		String rep = sc.nextLine();
		
		return rep;
	}

	public String menuRechercherByDisponibilite()
	{
		System.out.println();
		System.out.println("Saisir 'O/N' pour afficher les clef disponible ou non");
		System.out.print("--> ");
		String rep = sc.nextLine();
		
		return rep;
	}	
	

	public Clef menuModifierClef(Clef clef, int nbrClef)
	{
		// Variables
		String reference = "";
		String porte = "";
		String personne = "";
		char rep = '\0';

		// Traitement
		System.out.println();
		System.out.println("Bienvenue à GestTrousseau (" + nbrClef + ")");
		
		if(clef != null)
		{
			System.out.println("Modification de la clef : " + clef.getId() );
			System.out.println();
			
			System.out.print("Référence '"+ clef.getReference() +"' --> ");
			reference = sc.nextLine();
			if(!reference.equals(""))
			{
				clef.setReference(reference);
			}

			System.out.print("Porte '"+ clef.getPorte() +"' --> ");
			porte = sc.nextLine();			
			if(!porte.equals(""))
			{
				clef.setPorte(porte);
			}
			
			rep = menuEmployeSoustraitant();
			boolean sortie = false;
			do
			{
				
				if(rep =='1')  
				{
					if(clef.getPersonne() instanceof Employe)
					{
						System.out.print("fonction de l'employé: ");		
						((Employe)clef.getPersonne()).setFonction(sc.nextLine());
						sortie = true ;
					}
					else {
						System.out.print("Vous ne pouvez pas tranformer un employé en soustraitant ");
					}
				}
				else if(rep =='2')
				{
					if(clef.getPersonne() instanceof SousTraitant)
					{
						System.out.print("L'entreprise du soustraitant: ");		
						((SousTraitant)clef.getPersonne()).setEntreprise(sc.nextLine());
						sortie = true ;
					}
					else {
						System.out.print("Vous ne pouvez pas tranformer un soustraitant en employé ");
					}
				}
			}while(sortie);
			
			System.out.print("Nom '"+ clef.getPersonne().getNom() +"' --> ");
			personne = sc.nextLine();			
			if(!personne.equals(""))
			{
				clef.getPersonne().setNom(personne);
			}
			System.out.print("Prénom '"+ clef.getPersonne().getPrenom() +"' --> ");
			personne = sc.nextLine();	
			System.out.print("Id '"+ clef.getPersonne().getId() +"' --> ");
			personne = sc.nextLine();
			
		}
		else
		{
			System.out.println("Erreur saisie! -----------");
			System.out.println("                          ");				
			System.out.println("     Clef non trouvé !    ");
			System.out.println("--------------------------");			
		}
		
		return clef;
	}
	
	public char menuSupprimerClef(int nbrClef)
	{
		char[] repValident = {'1','2','3','Q'};
		String rep = "";
		
		System.out.println();
		do
		{
			System.out.println("Bienvenue à GestTrousseau (" + nbrClef + ")");
			System.out.println("-----Menu Supprimer------");
			System.out.println("1 - Par référence");
			System.out.println("2 - porte");
			System.out.println("3 - personne");
			System.out.println("Q - quitter");			
	
			rep = sc.nextLine().toUpperCase();
		
		}while(!Validation.isValide(repValident, rep));
		
		return rep.charAt(0);		
	}
	
	public char menuAfficherClef(int nbrClef)
	{			
		char[] repValident = {'1','2','3','4','Q'};
		String rep = "";
		
		System.out.println();
		do
		{
			System.out.println("Bienvenue à GestTrousseau (" + nbrClef + ")");
			System.out.println("------Afficher clef------");
			System.out.println("1 - Par référence");
			System.out.println("2 - porte");
			System.out.println("3 - personne");
			System.out.println("4 - disponibilité");
			System.out.println("Q - quitter");			
	
			rep = sc.nextLine().toUpperCase();
			
		
		}while(!Validation.isValide(repValident, rep));
		
		return rep.charAt(0);	
	}	
	
	
	
	
	public void menuAfficherListe(Clef[] trousseau, int nbrClef)
	{			
		System.out.println();
		System.out.println("Bienvenue à GestTrousseau (" + nbrClef + ")");
		System.out.println("----Liste des clefs------");
		
		int cptClef = 0;
		
		for(Clef clef : trousseau)
		{
			if( clef != null)
			{
				System.out.println(this.afficheOneClef(clef));
				cptClef++;
			}
		}
		
		System.out.println();
		System.out.println("Le trousseau contient : " + cptClef + " clef(s)");
		System.out.println();
	}
	
	public void menuAfficherListe(Clef[] trousseau, char critere, String valeurRecherche, int nbrClef, char choix, char choixPersonne) {
		
		final char RECHERCHER_REFERENCE = '1';
		final char RECHERCHER_PORTE = '2';
		final char RECHERCHER_PERSONNE = '3';
		final char RECHERCHER_DISPONIBILITE = '4';
		final char RECHERCHER_NOM = '1';
		final char RECHERCHER_PRENOM = '2';
		final char RECHERCHER_ID = '3';
		final char RECHERCHER_FONCTION = '4';
		final char RECHERCHER_SOUSTRAITANT = '5';
		
		System.out.println();
		System.out.println("Bienvenue à GestTrousseau (" + nbrClef + ")");
		
		switch(critere)
		{
			case RECHERCHER_REFERENCE:
				System.out.println("Liste des clefs dont la référence est '" + valeurRecherche + "'");	
				for(Clef clef : trousseau)
				{
					if(clef != null)
					{
						if(clef.getReference().equals(valeurRecherche))
						{
							System.out.println(this.afficheOneClef(clef));
						}
					}
				}		
				break;
				
			case RECHERCHER_PORTE:
				System.out.println("Liste des clefs attaché à la porte n° '" + valeurRecherche + "'");	
				for(Clef clef : trousseau)
				{
					if(clef != null)
					{
						if(clef.getPorte().equals(valeurRecherche))
						{
							System.out.println(this.afficheOneClef(clef));
						}
					}
				}		
				break;	
				
			case RECHERCHER_PERSONNE:
							
							switch (choix)
							{
								case RECHERCHER_NOM:
								
									System.out.println("Liste des clefs confié à '" + valeurRecherche + "'");					
									for(Clef clef : trousseau)
									{
										if(clef != null)
										{
											if(clef.getPersonne().getNom().equals(valeurRecherche))
											{
												System.out.println(this.afficheOneClef(clef));
											}
										}
									}
								break;
								
								case RECHERCHER_PRENOM:
									
									System.out.println("Liste des clefs confié à '" + valeurRecherche + "'");					
									for(Clef clef : trousseau)
									{
										if(clef != null)
										{
											if(clef.getPersonne().getPrenom().equals(valeurRecherche))
											{
												System.out.println(this.afficheOneClef(clef));
											}
										}
									}
								break;
								case RECHERCHER_ID:
									
									System.out.println("Liste des clefs confié à '" + valeurRecherche + "'");					
									for(Clef clef : trousseau)
									{
										if(clef != null)
										{
											if(clef.getPersonne().getId().equals(valeurRecherche))
											{
												System.out.println(this.afficheOneClef(clef));
											}
										}
									}
								break;
								case RECHERCHER_FONCTION:
									System.out.println("Liste des clefs confié à '" + valeurRecherche + "'");					
									for(Clef clef : trousseau)
									{
										if(clef != null)
										{	
											if(clef.getPersonne() instanceof Employe)
											{
												
												if (((Employe) clef.getPersonne()).getFonction().equals(valeurRecherche))
												{
													System.out.println(this.afficheOneClef(clef));
												}
											}
										}
									}
									
									
									break;
								case RECHERCHER_SOUSTRAITANT:
									System.out.println("Liste des clefs confié à '" + valeurRecherche + "'");					
									for(Clef clef : trousseau)
									{
										if(clef != null)
										{	
											if(clef.getPersonne() instanceof SousTraitant)
											{
												
												if (((SousTraitant) clef.getPersonne()).getEntreprise().equals(valeurRecherche))
												{
													System.out.println(this.afficheOneClef(clef));
												}
											}
										}
									}
									break;
							}
				break;		
				
			case RECHERCHER_DISPONIBILITE:
				boolean disponible = valeurRecherche.toUpperCase().charAt(0) == 'O' ? true : false;
				System.out.printf("Liste des clefs qui sont '%s",  disponible ? "disponible'\n" : "indisponible'\n");	
				for(Clef clef : trousseau)
				{
					if(clef != null)
					{
						if(clef.isDisponible() == disponible)
						{
							System.out.println(this.afficheOneClef(clef));
						}
					}
				}		
				break;					
		}
	}
	
	public void menuQuitterApplication()
	{
		System.out.println();
		System.out.println("Application fermé, bonne journées");
		
	}
	// méthodes privés
	private String afficheOneClef(Clef clef)
	{
			return "Id : " + clef.getId() + 
			   " Réf : " + clef.getReference() +
			   " Porte : " + clef.getPorte()+
			   " Affecté à : " + clef.getPersonne();
	}
}
