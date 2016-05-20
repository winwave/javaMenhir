package Modele;

public class CarteAllie extends Carte{
	

	public CarteAllie(int id, String nom, int[] tab) {
		super(id, nom);
		tabForce = tab;
		// TODO Auto-generated constructor stub
	}
	/**
	 * Le tableau de la "force". 1 ligne; 4 colonnes correspondants aux 4
	 * saisons respectivement.
	 */
	private int[] tabForce = new int[4];

	public int[] getTabForce() {
		return tabForce;
	}

	public void setTabForce(int[] tabForce) {
		this.tabForce = tabForce;
	}

	/**
	 * Calculer la "force" dans une saison donnee.
	 */
	public int calForce(int saison) {

		return tabForce[saison];

	}
	public int getSaisonMax(){
		int saisonMax = 0;
		int[] tabForce = this.getTabForce();
		for (int i = 1; i < tabForce.length; i++){
			if (tabForce[i] > tabForce[saisonMax]){
				saisonMax = i;
			}
		}
		return saisonMax;
	}
	public String toString (){
		
		String chaine="*****"+this.getNomCarte()+"*****\n";
		chaine+="Printemps\tEte\tAutomme\tHiver\n";
		for (int i=0; i<tabForce.length; i++){
			chaine+= "\t"+tabForce[i];
		}
		chaine+="\n";
		return chaine;
	}
}

