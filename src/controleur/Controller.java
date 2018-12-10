package controleur;

import bean.Clef;
import bean.Employe;
import bean.Personne;
import bean.SousTraitant;
import dao.DaoClef;
import vue.VueConsole;

public class Controller
{

	public static void main(String[] args)
	{
		// Constante
		final char AJOUTER_CLEF = '1'; 
		final char MODIFIER_CLEF = '2'; 
		final char SUPPRIMER_CLEF = '3'; 
		final char AFFICHER_CLEF = '4'; 
		final char AFFICHER_TROUSSEAU = '5'; 
		final char QUITTER_TROUSSEAU = 'Q';
		
		final char RECHERCHER_REF = '1';
		final char RECHERCHER_PORTE = '2';
		final char RECHERCHER_PERSONNE = '3';
		final char RECHERCHER_DISPONIBILITE = '4';
		final char RECHERCHER_QUITTER = 'Q';
		
		// Variable
		Clef[] trousseau = new Clef[50];
		Clef clef = null;
		Employe employe = null;
		SousTraitant soustraitant= null;
		char rep = '\0';
		String valeurRecherche = "";
		int nbrClef;
		
		//MVC
		VueConsole vc = new VueConsole();
		DaoClef daoClef = new DaoClef();
						
		//Traitement
		boolean encoreApplication = true;
		do
		{
			nbrClef = daoClef.getNbrClef();
			rep = vc.menuPrincipal(nbrClef);
			
			char valeurChoix;
			char valeurChoixPersonne;
			switch (rep)
			{
				case AJOUTER_CLEF:
					clef = vc.menuAjouter(clef, nbrClef);
					daoClef.add(trousseau, clef);
					break;
					
				case MODIFIER_CLEF:
					
					// Variables
					boolean encoreModifier = true;
					valeurRecherche = "";
					// do-while
					do
					{	
						char menuRecherche = vc.menuRechercher(daoClef.getNbrClef());
						
						switch (menuRecherche)
						{
							case RECHERCHER_REF:
								valeurRecherche = vc.menuRechercherByReference();
								clef = daoClef.search(trousseau, RECHERCHER_REF, valeurRecherche);
								clef = vc.menuModifierClef(clef, nbrClef);
								daoClef.update(trousseau, clef);
								break;

							case RECHERCHER_PORTE:
								valeurRecherche = vc.menuRechercherByPorte();
								clef = daoClef.search(trousseau, RECHERCHER_PORTE, valeurRecherche);
								clef = vc.menuModifierClef(clef, nbrClef);
								daoClef.update(trousseau, clef);
								break;
								
							case RECHERCHER_PERSONNE:
								valeurRecherche = vc.menuRechercherByPersonne();
								clef = daoClef.search(trousseau, RECHERCHER_PERSONNE, valeurRecherche);
								clef = vc.menuModifierClef(clef, nbrClef);
								daoClef.update(trousseau, clef);
								break;								
								
							case RECHERCHER_QUITTER:
								encoreModifier = false;
								break;
						}
						
					}while(encoreModifier);
					break;
					
				case SUPPRIMER_CLEF:
					
					// Variables
					boolean encoreSupprimer = true;

					
					// do-while
					do
					{
						char menuSupprimer = vc.menuSupprimerClef(daoClef.getNbrClef());
						
						switch (menuSupprimer)
						{
							case RECHERCHER_REF:
								valeurRecherche = vc.menuRechercherByReference();
								clef = daoClef.search(trousseau, RECHERCHER_REF, valeurRecherche);
								daoClef.delete(trousseau, clef);
								break;

							case RECHERCHER_PORTE:
								valeurRecherche = vc.menuRechercherByPorte();
								clef = daoClef.search(trousseau, RECHERCHER_PORTE, valeurRecherche);
								daoClef.delete(trousseau, clef);
								break;
								
							case RECHERCHER_PERSONNE:
								valeurRecherche = vc.menuRechercherByPersonne();
								clef = daoClef.search(trousseau, RECHERCHER_PERSONNE, valeurRecherche);
								daoClef.delete(trousseau, clef);
								break;								
								
							case RECHERCHER_QUITTER:
								encoreSupprimer = false;
								break;
						}						
						
					}while(encoreSupprimer);
					break;
					
				case AFFICHER_CLEF:
					
					// Variables
					boolean encoreAfficher = true;
					valeurRecherche = "";
					valeurChoix = '\0';
					valeurChoixPersonne = '\0';
					// do-while
					do
					{
						char menuAfficher = vc.menuAfficherClef(nbrClef);
						
						switch (menuAfficher)
						{
							case RECHERCHER_REF:
								valeurRecherche = vc.menuRechercherByReference();
								vc.menuAfficherListe(trousseau, RECHERCHER_REF, valeurRecherche, nbrClef,valeurChoix,valeurChoixPersonne);
								break;

							case RECHERCHER_PORTE:
								valeurRecherche = vc.menuRechercherByPorte();
								vc.menuAfficherListe(trousseau, RECHERCHER_PORTE, valeurRecherche, nbrClef,valeurChoix,valeurChoixPersonne);
								break;
								
							case RECHERCHER_PERSONNE:
								//valeurChoixPersonne = vc.menuEmployeSoustraitant();
								valeurChoix = vc.menuListePersonne();
								valeurRecherche = vc.menuRechercherByPersonne();
								vc.menuAfficherListe(trousseau, RECHERCHER_PERSONNE, valeurRecherche, nbrClef,valeurChoix,valeurChoixPersonne);
								break;		
								
							case RECHERCHER_DISPONIBILITE:
								valeurRecherche = vc.menuRechercherByDisponibilite();
								vc.menuAfficherListe(trousseau, RECHERCHER_DISPONIBILITE, valeurRecherche, nbrClef, valeurChoix,valeurChoixPersonne);
								break;									
								
							case RECHERCHER_QUITTER:
								encoreAfficher = false;
								break;
						}						
						
					}while(encoreAfficher);
					break;					
					
				case AFFICHER_TROUSSEAU:
					vc.menuAfficherListe(trousseau, nbrClef);
					break;
					
				case QUITTER_TROUSSEAU:
					vc.menuQuitterApplication();
					encoreApplication = false;
					break;
			}
			
		}while(encoreApplication);
	}


}
