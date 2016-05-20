package Modele;

public class CarteIngredient extends Carte{
	
	public CarteIngredient(int id, String nom, int[][] tab) {
		super(id, nom);
		tabForce = tab;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Le tableau de la "force". 3 lignes correspondants Geant (1), Engrais
	 * (2) et Farfadet (3). 4 colonnes correspondants Printemps (1), Ete
	 * (2), Autumn (3) et Hiver (4).
	 */
	private int[][] tabForce;
	public static int  different;
	public int[][] getTabForce() {
		return tabForce;
	}

	/**
	 * Voler des Graines d'un joueur. Ne pas pouvoir voler ceux qui sont
	 * proteges par ChienDeGarde. La force entree est le nombre de Graines possibles a voler (appliquer a la fois TourSimple et TourAvance)
	 */
	public static int getDifferent(){
		return different;
	}
	public void actFarfadet(int force, JoueurPhysique joueurAAttaquer) {
		JoueurPhysique voleur = this.getProprietaire();
		this.getProprietaire().numCarte(idCarte);
		this.getProprietaire().setAct("FAFADET : "+joueurAAttaquer.getNomJoueur());
		Compteur compteurDeVoleur = voleur.getCompteur();
		Compteur compteurDeVictime = joueurAAttaquer.getCompteur();
		
		 this.different = force - compteurDeVictime.getNbGraine();
		 int a=Math.min(force,compteurDeVictime.getNbGraine() );
		
		compteurDeVictime.diminuerGraine(a);
		compteurDeVoleur.augmenterGraine(a);
		
		joueurAAttaquer.forceEstAttaque = force;
		joueurAAttaquer.estAttaquePar = voleur;
		
	}

	/**
	 * Faire pousser des Graines aux Menhirs.
	 */
	public void actEngrais(int force) {
		Compteur compteur = this.getProprietaire().getCompteur();
		this.getProprietaire().numCarte(idCarte);
		this.getProprietaire().setAct("ENGRAIS");

		int nbGrainesAPousser = Math.min(compteur.getNbGraine(),force);
		compteur.diminuerGraine(nbGrainesAPousser);
		compteur.augmenterMenhir(nbGrainesAPousser);
	}

	/**
	 * Recevoir des Graines.
	 */
	public void actGeant(int force) {
		this.getProprietaire().getCompteur().augmenterGraine(force);
		this.getProprietaire().numCarte(idCarte);
		this.getProprietaire().setAct("GEANT");

	}

	/**
	 * Calculer la "force" d'une action dans une saison donnee.
	 */
	public int calForce(int typeDeAct, int saison) {

		return tabForce[typeDeAct][saison];

	}
	
	public String toString(){
		String maChaine="\t   *****"+this.getNomCarte()+"*****\n";
		maChaine+="\tPrintemps\tEte\tAutomme\tHiver\n";
		for (int i=0; i<tabForce.length; i++){
			switch (i){
			case 0 :
				maChaine+="Geant\t\t";
				break;
			case 1 :
				maChaine+="Engrais\t\t";
				break;
			case 2 :
				maChaine+="Farfadets\t";
				break;
			
			}

			
			for (int j=0; j<tabForce[0].length; j++){
				
				
									
				maChaine+=tabForce[i][j]+"\t";
			}
			maChaine+="\n";
		}
		return maChaine;
	}

}
