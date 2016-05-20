package Modele;

import java.util.LinkedList;
import java.util.Observable;

import javax.swing.JOptionPane;

import Controle.Controller;

public class TourSimple extends Observable{

	private static int noTour = -1;
        private static int tourJoueur = 0;

    public static int getTourJoueur() {
        return tourJoueur;
    }
    
    protected Controller ctrl;
    
    public static void setTourJoueur(int tourJoueur) {
        TourSimple.tourJoueur = tourJoueur;
    }
	/**
	 * Getter of the property <tt>noTour</tt>
	 * 
	 * @return Returns the noTour.
	 * 
	 */
	public TourSimple (Controller ct){
		ctrl = ct;
		noTour++;
		if (noTour == 4){
			noTour=0;
		}
	}
	public static int getNoTour() {
		return noTour;
	}

	/**
	 * Setter of the property <tt>noTour</tt>
	 * 
	 * @param noTour
	 *            The noTour to set.
	 * 
	 */
	public String saison (){
		switch (noTour){
		case 0 :
			return "Printemps";
		case 1 :
			return "Ete";
		case 2 :
			return "Automne";
		case 3 :
			return "Hiver";
		default :
			return "";
		}
	}
	public void gererTour(LinkedList<JoueurPhysique> joueurs) {
		//LinkedList<JoueurPhysique> liste = new LinkedList<JoueurPhysique>();
		
		int posJP=Partie.getPosition();
		System.out.println("Votre carte Allie\n " + joueurs.get(posJP).getCarteA());
		
		System.out.println("Saison "+this.saison()+"\n");
		for (int i=0; i<joueurs.get(posJP).getCarteI().size(); i++){
			
			System.out.println(" CARTE "+i +joueurs.get(posJP).getCarteI().get(i).toString());
		}
		for (int i=0; i<joueurs.size(); i++){
			int act;
			int carteChoix;
			int postEstAttaque =0;
			
			LinkedList<CarteIngredient> tabCarte = joueurs.get(i).getCarteI();
				if(i!= posJP){
					int[] carteEtAction = ((JoueurVirtuel) joueurs.get(i)).reflechirAct(this.getNoTour());
					
					System.out.println("Joueur"+i +" joue");
					System.out.println(tabCarte.get(carteEtAction[0]).toString());
					act = carteEtAction[1];
					carteChoix = carteEtAction[0];
					switch (act){
					case 0 :
						tabCarte.get(carteChoix).actGeant(tabCarte.get(carteChoix).calForce(act, this.getNoTour()));
						System.out.println("Avec acte GEANT");
						joueurs.get(i).notifyObservers(null);
						break;
					case 1 :
						tabCarte.get(carteChoix).actEngrais(tabCarte.get(carteChoix).calForce(act, this.getNoTour()));
						System.out.println("Avec acte ENGRAIS");
						joueurs.get(i).notifyObservers(null);
						break;
					case 2 :
						
						if(i!= posJP){
							postEstAttaque= ((JoueurVirtuel) joueurs.get(i)).reflechirJoueurAAttaquer(2,joueurs.get(i).getPosJoueur());
							tabCarte.get(carteChoix).actFarfadet(tabCarte.get(carteChoix).calForce(act, this.getNoTour()), joueurs.get(postEstAttaque));	
						}else{
							postEstAttaque = joueurs.get(posJP).choisirJoueurAAttaquer();
							tabCarte.get(carteChoix).actFarfadet(tabCarte.get(carteChoix).calForce(act, this.getNoTour()), joueurs.get(postEstAttaque));
							
						}
						System.out.println("Avec acte FARFADET et post du joueur est choisi: "+postEstAttaque);
						joueurs.get(i).notifyObservers(null);			
						
						
						break;
					}
					joueurs.get(i).getCarteI().remove(tabCarte.get(carteChoix));
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}else{
			//ici pour joueur physique	
				JOptionPane.showMessageDialog(null, "A vous de jouer ! \nAttention vous perdez la main après avoir joué une Carte Ingrédient !");

				
			ctrl.setATour();
						ctrl.DejaJouer = false;
				while (ctrl.DejaJouer==false) {
					try {
						Thread.sleep(1000);
						
						//System.out.println(ctrl.DejaJouer);
						Thread.sleep(1000);
					} catch (Exception e) {
			System.out.println("interruption joueur Reel");
					}
				}
				ctrl.Atour= false;
			}
			}
			
                        
			
		
		for (int i =0;i< joueurs.size();i++){
			System.out.println("Joueur "+i + "  nombre Menhir: "+joueurs.get(i).getCompteur().toString());
			
		}
		
		ctrl.changerSaison();
		
	}
	
	
}
