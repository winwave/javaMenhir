package Modele;

import java.util.LinkedList;

import Controle.Controller;

public class PartieSimple extends Partie implements Runnable{

	public static PartieSimple finstance;
	
	public static PartieSimple getInstance() {
		if (finstance == null) {
			finstance = new PartieSimple();
		}
		return finstance;
	}

	private LinkedList<TourSimple> tabTourSimple = new LinkedList<TourSimple>();

	public LinkedList<TourSimple> getTabTourSimple() {
		return tabTourSimple;
	}
	
	public void gererPartieSimple() {
		this.melangerCarteI();
		this.distribuerCartesI();
		this.ditribuerGraines();
		int ind=0;
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j) instanceof Controller){
				ind = j;
				}
			
		}
		((Controller)(list.get(ind))).nouvelleManche(1);
		for (int i = 0; i<4; i++){
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j) instanceof Controller){
					tabTourSimple.add(new TourSimple((Controller)(list.get(j))));
					tabTourSimple.get(i).gererTour(this.getTabJoueurs());
					Partie.saisonInt = i;
				}
			}

		}
		((Controller)(list.get(ind))).afficherGagnant(this.getTabJoueurs());
	}
	
	public void ditribuerGraines(){
		for (int i =0; i <this.getNbJoueurs();i++){
			this.getTabJoueurs().get(i).getCompteur().augmenterGraine(2);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.gererPartieSimple();
		
	}
	
}
