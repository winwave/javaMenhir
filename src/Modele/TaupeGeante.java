package Modele;

public class TaupeGeante extends CarteAllie{
	
	public TaupeGeante(int id, String nom, int[] tab) {
		super(id, nom, tab);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Detruire des Menhirs d'autre personne
	 */
	public void detruireMenhir(int force, JoueurPhysique joueurAAttaquer) {
		Compteur compteurAAttaquer = joueurAAttaquer.getCompteur();
		joueurAAttaquer.getCompteur().diminuerMenhir(force);
		this.getProprietaire().numCarte(idCarte);
		this.getProprietaire().setAct("ATTAQUE : "+joueurAAttaquer.getNomJoueur());

		//n'est plus valable dans la manche actuelle
		this.setEstValable(false);

	}

}
