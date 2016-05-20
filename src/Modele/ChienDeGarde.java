package Modele;

public class ChienDeGarde extends CarteAllie{

	public ChienDeGarde(int id, String nom, int[] tab) {
		super(id, nom, tab);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Proteger des Graines. Retourner le nombre de Graines possibles a
	 * voler
	 */
	public int protegerGraine(int forceAttaquer, int saison) {
		this.getProprietaire().numCarte(idCarte);
		this.getProprietaire().setAct("Proteger");

		int forceDefensive = this.calForce(saison);
		
		int dif = CarteIngredient.getDifferent();
		if (dif >0){
			if (dif < forceDefensive){
				return forceDefensive - dif;
			}else{
				return 0;
			}
		}else{
			if(forceAttaquer >= forceDefensive){
				return forceDefensive;
			}else{
				return forceAttaquer;
			}
		}
//		if (nbGrainesRestants > (forceAttaquer - forceDefensive)){
//			return forceAttaquer - forceDefensive;
//		}
//		else {
//			return nbGrainesRestants;
//		}

	}
}
