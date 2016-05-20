package Modele;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;



public class Partie extends Observable {
	

	
	
	/**
	 * 
	 */
	protected ArrayList<Observer> list = new ArrayList<Observer>();

	protected static final long serialVersionUID = 1L;

	protected static int nbJoueurs;
	protected static LinkedList<CarteIngredient> cartesI = new LinkedList<CarteIngredient>();
	protected static LinkedList<CarteAllie> cartesA = new LinkedList<CarteAllie>();
	protected LinkedList<Compteur> compteurs = new LinkedList<Compteur>();
	protected static LinkedList<JoueurPhysique> tabJ = new LinkedList<JoueurPhysique>();
	public static Partie instance;
	public static int saisonInt = 0;
	
	public void addObserver(Observer o){
		list.add(o);
	}
	
	public void notifyObservers(){
		for (int i = 0; i < list.size(); i++) {
			list.get(i).update(this, null);
		}
	}
	
	public static Partie getInstance() {
		if (instance == null) {
			instance = new Partie();
		}
		return instance;
	}
	

	public static   LinkedList<JoueurPhysique> getTabJoueurs() {
		return tabJ;
	}

	public static int getNbJoueurs() {
		return nbJoueurs;
	}

	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

	public void instancierCartes() {
		
				
		if (cartesI.isEmpty()){
				// Les cartes Ingrédients
				cartesI.add(new CarteIngredient(1, "RAYON DE LUNE", new int[][]{{1,1,1,1},{2,0,1,1},{2,0,2,0}}));
				cartesI.add(new CarteIngredient(2, "RAYON DE LUNE", new int[][]{{2,0,1,1},{1,3,0,0},{0,1,2,1}}));
				cartesI.add(new CarteIngredient(3, "RAYON DE LUNE", new int[][]{{0,0,4,0},{0,2,2,0},{0,0,1,3}}));
				cartesI.add(new CarteIngredient(4, "CHAMP DE SIRENES", new int[][]{{1,3,1,0},{1,2,1,1},{0,1,4,0}}));
				cartesI.add(new CarteIngredient(5, "CHAMP DE SIRENES", new int[][]{{2,1,1,1},{1,0,2,2},{3,0,0,2}}));
				cartesI.add(new CarteIngredient(6, "CHAMP DE SIRENES", new int[][]{{1,2,2,0},{1,1,2,1},{2,0,1,2}}));
				cartesI.add(new CarteIngredient(7, "LARMES DE DRYADE", new int[][]{{2,1,1,2},{1,1,1,3},{2,0,2,2}}));
				cartesI.add(new CarteIngredient(8, "LARMES DE DRYADE", new int[][]{{0,3,0,3},{2,1,3,0},{1,1,3,1}}));
				cartesI.add(new CarteIngredient(9, "LARMES DE DRYADE", new int[][]{{1,2,1,2},{1,0,1,4},{2,4,0,0}}));
				cartesI.add(new CarteIngredient(10, "FONTAINE D'EAU PURE", new int[][]{{1,3,1,2},{2,1,2,2},{0,0,3,4}}));
				cartesI.add(new CarteIngredient(11, "FONTAINE D'EAU PURE", new int[][]{{2,2,0,3},{1,1,4,1},{1,2,1,3}}));
				cartesI.add(new CarteIngredient(12, "FONTAINE D'EAU PURE", new int[][]{{2,2,3,1},{2,3,0,3},{1,1,3,3}}));
				cartesI.add(new CarteIngredient(13, "POUDRE D'OR", new int[][]{{2,2,3,1},{2,3,0,3},{1,1,3,3}}));
				cartesI.add(new CarteIngredient(14, "POUDRE D'OR", new int[][]{{2,2,2,2},{0,4,4,0},{1,3,2,2}}));
				cartesI.add(new CarteIngredient(15, "POUDRE D'OR", new int[][]{{3,1,3,1},{1,4,2,1},{2,4,1,1}}));
				cartesI.add(new CarteIngredient(16, "RACINES D'ARC-EN-CIEL", new int[][]{{4,1,1,1},{1,2,1,3},{1,2,2,2}}));
				cartesI.add(new CarteIngredient(17, "RACINES D'ARC-EN-CIEL", new int[][]{{2,2,3,0},{1,1,1,4},{2,0,3,2}}));
				cartesI.add(new CarteIngredient(18, "RACINES D'ARC-EN-CIEL", new int[][]{{2,3,2,0},{0,4,3,0},{2,1,1,3}}));
				cartesI.add(new CarteIngredient(19, "ESPRIT DE DOLMEN", new int[][]{{3,1,4,1},{2,1,3,3},{2,3,2,2}}));
				cartesI.add(new CarteIngredient(20, "ESPRIT DE DOLMEN", new int[][]{{2,4,1,2},{2,2,2,3},{1,4,3,1}}));
				cartesI.add(new CarteIngredient(21, "ESPRIT DE DOLMEN", new int[][]{{3,3,3,0},{1,3,3,2},{2,3,1,3}}));
				cartesI.add(new CarteIngredient(22, "RIRES DE FEES", new int[][]{{1,2,2,1},{1,2,3,0},{0,2,2,2}}));
				cartesI.add(new CarteIngredient(23, "RIRES DE FEES", new int[][]{{4,0,1,1},{1,1,3,1},{0,0,3,3}}));
				cartesI.add(new CarteIngredient(24, "RIRES DE FEES", new int[][]{{2,0,1,3},{0,3,0,3},{1,2,2,1}}));

		}
		
		if (cartesA.isEmpty()){
				// Les cartes Alliés
				cartesA.add(new TaupeGeante (25, "TAUPE GEANTE", new int[] {1,1,1,1}));
				cartesA.add(new TaupeGeante (26, "TAUPE GEANTE", new int[] {0,2,2,0}));
				cartesA.add(new TaupeGeante (27, "TAUPE GEANTE", new int[] {0,1,2,1}));
				cartesA.add(new ChienDeGarde (28, "CHIEN DE GARDE", new int[] {2,0,2,0}));
				cartesA.add(new ChienDeGarde (29, "CHIEN DE GARDE", new int[] {1,2,0,1}));
				cartesA.add(new ChienDeGarde (30, "CHIEN DE GARDE", new int[] {0,1,3,0}));
		}
	}
	
	public static int position; 
	
	public void setPosition(int a){
		this.position =a;
	}
	
	public static int getPosition(){
		return position;
	}
	
	public void instancierJoueurs(int nbJoueurs) {
		
		if (tabJ.isEmpty()){
			
		}else{
			
		}
			setPosition((int) Math.round((nbJoueurs -1)*Math.random()));
			
			System.out.println("vous etes "+ this.getPosition() +"eme Joueur");
			
			for (int i=0; i<nbJoueurs; i++){
				if(i!=position){
				tabJ.add(new JoueurVirtuel (i));
				
			}else{
				tabJ.add(new JoueurPhysique (i));
				
			}
				compteurs.add(new Compteur ());
				tabJ.get(i).setCompteur (compteurs.get(i));
			}
		
	}
	
	
	public  LinkedList<CarteIngredient> getTabCarteI() {
		return cartesI;
	}

	public LinkedList<CarteAllie> getTabCarteA() {
		return cartesA;
	}
	
	public void melangerCarteI(){
		for (int i=0; i<this.getTabCarteI().size(); i++){
			int position = (int) Math.round((this.getTabCarteI().size()-1)*Math.random());
			CarteIngredient carte = this.getTabCarteI().pop();
			this.getTabCarteI().add(position, carte);
		}
	}
	public void distribuerCartesI() {
		
		int j=0;
		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < this.getTabJoueurs().size(); k++) {

				this.getTabJoueurs().get(k).getCarteI().add(this.getTabCarteI().get(j));
				this.getTabCarteI().get(j).setProprietaire(this.getTabJoueurs().get(k));
				j++;
				
			}
		}
	}
	
	
	public static boolean dejaJouer;
	public void setDejaJouer() {
		dejaJouer = true;
	}

	
}
