package Modele;

import java.util.LinkedList;

public class JoueurVirtuel extends JoueurPhysique{
	
	/**
	 * Reflechir a attaquer quel joueur
	 */
	public JoueurVirtuel (int pos){
		super(pos);
	}
	
	public int reflechirJoueurAAttaquer(int act,int pos  ) {
		
		int i,j;
		if(pos==0){
			j=1;
		}
		else{
		j=0;	
		}
		LinkedList<JoueurPhysique> table = Partie.getTabJoueurs();
		int nb= Partie.getNbJoueurs();
		JoueurPhysique joueurChoisi= null;
		switch (act) {
		case 1:				
			for (i=0;i<nb;i++){
				if (table.get(i).getCompteur().getNbMenhir()>table.get(j).getCompteur().getNbMenhir()){
					if (i!=pos){
						j=i;
					}
				}
				//joueurChoisi= table.get(j);
				
			}
		break;
		case 2: 
			
			for (i=0;i<nb;i++){
				if (table.get(i).getCompteur().getNbGraine()>table.get(j).getCompteur().getNbGraine()){
					if (i!=pos){
						j=i;
					}
				}
			//	joueurChoisi= table.get(j);
				

			}
		break;
		default :
			//joueurChoisi= table.get(j);
		j=pos+1;
		}
		if(j==pos){
			j=pos+1;
		}
		joueurChoisi= table.get(j);
		return  joueurChoisi.getPosJoueur();


		

	}

	/**
	 * Reflechir a faire quelle action
	 */
	public int[] reflechirAct(int saison) {
		
		
		
		int[] resultat= new int[2];
		LinkedList<CarteIngredient> tabCarte = new LinkedList<CarteIngredient>();
		boolean possibleEngrais = false;
		int posForceEngraisPlusProche = 0;
		for (int i = 0; i < this.getCarteI().size(); i++){
			tabCarte.add(this.getCarteI().get(i));
		}
		int nbGraineRestant = this.getCompteur().getNbGraine();
		if (nbGraineRestant!=0){
			
			
			//tester s'il existe une carte dont la force d'Engrais > 0
			for (int i = 0; i < this.getCarteI().size(); i++){
				if (tabCarte.get(i).getEstValable() && (tabCarte.get(i)).calForce(1, saison)>0){
					possibleEngrais = true;
					//trouver ainsi la premiere position dans laquelle la force d'Engrais > 0
					posForceEngraisPlusProche = i;
					break;
				}
			}
		}
			//chercher la force d'Engrais le plus proche (et > si possible) a nb Graine restant
			if (possibleEngrais && nbGraineRestant>0){
				
				int difMin = tabCarte.get(posForceEngraisPlusProche).calForce(1, saison) - nbGraineRestant;
				if (difMin!=0){
					for (int i = posForceEngraisPlusProche + 1; i < this.getCarteI().size(); i++){
						if (tabCarte.get(i).getEstValable()){
							int dif = tabCarte.get(i).calForce(1, saison) - nbGraineRestant;
							if (((difMin < 0) && (dif > difMin)) || ((difMin > 0)  && (difMin > Math.abs(dif)))){
								difMin = dif;
								posForceEngraisPlusProche = i;
							}
						}
					}
				}
				resultat[0]=posForceEngraisPlusProche;//carte
				resultat[1]=1;//action
			}
			else {
				
				int geantMax = 0;
				int farfadetMax = 0;
				int posGeantMax=0, posFarfadetsMax=0;
				for (int i = 0; i < this.getCarteI().size(); i++) {
					if (tabCarte.get(i).getEstValable()) {
						geantMax=tabCarte.get(i).calForce(0, saison);
						farfadetMax=tabCarte.get(i).calForce(2, saison);
						posFarfadetsMax=i;
						posGeantMax=i;
						break;
						
					}
				}
				for (int i = 0; i <this.getCarteI().size(); i++) {
					if (tabCarte.get(i).getEstValable()) {
						if (tabCarte.get(i).calForce(0, saison)>geantMax) {
							posGeantMax=i;
							geantMax=tabCarte.get(i).calForce(0, saison);
						}
						if (tabCarte.get(i).calForce(2, saison)>farfadetMax) {
							posFarfadetsMax=i;
							farfadetMax=tabCarte.get(i).calForce(2, saison);
						}
					
				}
					
				}
				if (geantMax>2*farfadetMax){
					resultat[0]=posGeantMax;
					resultat[1]=0;
				}
				else {
					resultat[0]=posFarfadetsMax;
					resultat[1]=2;
				}
				
				
			}
		

		return resultat;

	}
	
	

	/**
	 * Reflechir a deposer la carte Allie
	 */
	public boolean reflechirCarteAllie(int saison) {
		boolean choisi = false;
		Carte carte = this.getCarteA();
		if (carte.getEstValable()){
		
		if (carte instanceof TaupeGeante){
			if(((TaupeGeante) carte).getSaisonMax()==saison){
				choisi=true;
			}
			
		}
		else if (carte instanceof ChienDeGarde ){
			if (((ChienDeGarde) carte).calForce(saison)!=0){
				choisi=true;
			}
		}
			
		}
		return (choisi);

	}

	/**
	 * Reflechir a deposer la carte Ingredient
	 */
		public void choisiCarteA(){
			double a = Math.random();
			if (a>0.5){
				this.choisiCarteA = true;
			}else{
				this.choisiCarteA = false;
			}
			
		}
}
