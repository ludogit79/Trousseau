package dao;

import bean.Clef;

public class DaoClef
{
	public void add(Clef[] trousseau, Clef nouvelleClef)
	{
		for(int i = 0 ; i < trousseau.length ; i++ )
		{
			if(trousseau[i] == null)
			{
				trousseau[i] = nouvelleClef;
				i = trousseau.length;
			}
		}
	}
	
	public void update(Clef[] trousseau, Clef clefModifie)
	{
		for(int i = 0 ; i < trousseau.length ; i++ )
		{
			if(trousseau[i] != null)
			{
				if(trousseau[i] == clefModifie)
				{
					trousseau[i] = clefModifie;
					i = trousseau.length;
				};
			}
		}		
	}
	
	public void delete(Clef[] trousseau, Clef clefSupprime)
	{
		for(int i = 0 ; i < trousseau.length ; i++ )
		{
			if(trousseau[i] != null)
			{
				if(trousseau[i] == clefSupprime)
				{
					trousseau[i] = null;
					clefSupprime.decrementId();
					i = trousseau.length;
				};
			}
		}
	}
	
	public Clef search(Clef[] trousseau, char proprieteRecherche, String valeurRecherche)
	{
		// Constante
		final char RECHERCHER_REFEFERENCE = '1';
		final char RECHERCHER_PORTE = '2';
		final char RECHERCHER_PERSONNE = '3';
		
		// Variable
		Clef clefTrouve = null;
		
		switch (proprieteRecherche)
		{
			case RECHERCHER_REFEFERENCE: 
				for(Clef clef : trousseau)
				{
					if(clef != null)
					{
						if(clef.getReference().equals(valeurRecherche))
						{
							clefTrouve = clef;
						}
					}
				}
				break;
				
			case RECHERCHER_PORTE:
				for(Clef clef : trousseau)
				{
					if(clef != null)
					{
						if(clef.getPorte().equals(valeurRecherche))
						{
							clefTrouve = clef;
						}
					}
				}
				break;
				
			case RECHERCHER_PERSONNE:
				for(Clef clef : trousseau)
				{
					if(clef != null)
					{
						if(clef.getPersonne().getNom().equals(valeurRecherche))
						{
							clefTrouve = clef;
						}
					}
				}
				break;	
		}
		
		return clefTrouve;
	}
	
	public int getNbrClef()
	{
		return Clef.compteur;
	}
}
