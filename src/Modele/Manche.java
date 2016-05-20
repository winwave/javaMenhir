package Modele;

import java.util.LinkedList;
import java.util.Observable;

import Controle.Controller;

public class Manche  extends Observable {

	/*
	 * (non-javadoc)
	 */
	private Controller ctrl;
	private static int noManche = -1;

	/*
	 * (non-javadoc)
	 */
	private LinkedList<TourAvance> tabTourAvance = new LinkedList<TourAvance>();
	
	public Manche(Controller ct){
		ctrl = ct;
		noManche++;
	}

	public LinkedList<TourAvance> getTabTourAvance() {
		return tabTourAvance;
	}

	public void gererManche(LinkedList<JoueurPhysique> joueurs) {

		for (int i = 0; i<4; i++){
			tabTourAvance.add(new TourAvance(ctrl));
			tabTourAvance.get(i).gererTour(joueurs);
			Partie.saisonInt = i;
			
		}
		for (int i=0; i<joueurs.size(); i++){
			if(!(joueurs.get(i) instanceof JoueurVirtuel)){
				for(int j=0;j<4;j++){
			
				
			joueurs.get(i).getCarteI().remove(0);
			
			}
				joueurs.get(i).setCarteA(null);
			}
			
		}
		ctrl.changerManche();
	}
	



	/**
	 * Getter of the property <tt>noManche</tt>
	 * 
	 * @return Returns the noManche.
	 * 
	 */

	public static int getNoManche() {
		return noManche;
	}	
	

	/**
	 * Setter of the property <tt>noManche</tt>
	 * 
	 * @param noManche
	 *            The noManche to set.
	 * 
	 */
	public static void setNoManche(int noManche) {
		Manche.noManche = noManche;
	}
}
