package Modele;

import java.util.Observable;
import java.util.Observer;
import java.util.LinkedList;
import java.util.Scanner;

public class JoueurPhysique extends Observable{
	public boolean choisiCarteA;
	public boolean Ajoue = false;
	private LinkedList<CarteIngredient> mesCartes = new LinkedList<CarteIngredient>();
	private CarteAllie maCarte;
	private LinkedList<Observer> listObs = new LinkedList<Observer>();
	/**
	 * Nom du joueur
	 */
	public JoueurPhysique estAttaquePar;
	
	public int forceEstAttaque;
	private String nomJoueur;
	public String Act;
	/**
	 * Position a determiner l'ordre a jouer
	 */
	private int posJoueur;

	/*
	 * (non-javadoc)
	 */
	public boolean utiliserCarteAllie = false;

	/*
	 * (non-javadoc)
	 */
	private Compteur compteur;
	private int numCarte;
	private int posJA;
	private int actJ;

	/*
	 * (non-javadoc)
	 */

	/**
	 * Getter of the property <tt>carte</tt>
	 * 
	 * @return Returns the carte.
	 * 
	 */
	
	public void notifyObservers(Object arg){
		for (int i=0; i<listObs.size(); i++){
			listObs.get(i).update(this, null);
		}
	}
	
	public void addObserver(Observer o){
		listObs.add(o);
	}
	
	public JoueurPhysique (int pos){
		posJoueur = pos;
	}
	
	public LinkedList<CarteIngredient> getCarteI() {
		return this.mesCartes;
	}
	
	public CarteAllie getCarteA(){
		return maCarte;
	}
	

	public void setCarteA (CarteAllie carte){
		maCarte = carte;
	}
	/**
	 * Getter of the property <tt>posJoueur</tt>
	 * 
	 * @return Returns the posJoueur.
	 * 
	 */

	public int getPosJoueur() {
		return posJoueur;
	}

	/**
	 * Setter of the property <tt>posJoueur</tt>
	 * 
	 * @param posJoueur
	 *            The posJoueur to set.
	 * 
	 */
	public void setPosJoueur(int posJoueur) {
		this.posJoueur = posJoueur;
	}

	/**
	 * Getter of the property <tt>nomJoueur</tt>
	 * 
	 * @return Returns the nomJoueur.
	 * 
	 */

	public String getNomJoueur() {
		return nomJoueur;
	}

	/**
	 * Setter of the property <tt>nomJoueur</tt>
	 * 
	 * @param nomJoueur
	 *            The nomJoueur to set.
	 * 
	 */
	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	/**
	 * Indiquer le joueur que vous voulez attaquer (voler des
	 * Graines/detruire des Menhirs)
	 */
	public int choisirJoueurAAttaquer() {
		int pos; 
		Scanner post = new Scanner(System.in); 
		System.out.print("posJoueurAAtaque: ");
		pos = post.nextInt(); 			

		return  pos ;

	}

	/**
	 * Deposer la carte Allie
	 */
	public CarteAllie  jouerCarteAllie() {
		
			return maCarte;
		}
		 

	

	/**
	 * Choisir l'action dans la carte Ingredient
	 */
	public int choisirAct() {
		int act; 
		Scanner data = new Scanner(System.in); 
		System.out.print("Act Choisir: ");
		act = data.nextInt(); 			

		return act;

	}

	/**
	 * Deposer la carte Ingredient
	 */
	public int jouerCarteIngredient() {
		int posDeCarte; 
		Scanner data = new Scanner(System.in); 
		System.out.print("Choisir Carte: ");
		posDeCarte = data.nextInt();
		return posDeCarte;

	}

	/**
	 * Getter of the property <tt>utiliserChienDeGarde</tt>
	 * 
	 * @return Returns the utiliserChienDeGarde.
	 * 
	 */

	

	/**
	 * Setter of the property <tt>utiliserChienDeGarde</tt>
	 * 
	 * @param utiliserChienDeGarde
	 *            The utiliserChienDeGarde to set.
	 * 
	 */
	

	/**
	 * Getter of the property <tt>compteur</tt>
	 * 
	 * @return Returns the compteur.
	 * 
	 */

	public Compteur getCompteur() {
		return compteur;
	}

	/**
	 * Setter of the property <tt>compteur</tt>
	 * 
	 * @param compteur
	 *            The compteur to set.
	 * 
	 */
	public void setCompteur(Compteur compteur) {
		this.compteur = compteur;
	}
	
	public void accordUtilAllie(CarteAllie carteA){
		int ok;
		Scanner post = new Scanner(System.in); 
		System.out.print("D'accord d'utiliser "+ carteA.getNomCarte()+": entre 1 si d'accord et 2 sinon: ");
		 ok = post.nextInt();
		 if(ok ==1){
			 System.out.print("vous etes d'accord de jouer votre carte \n ");
		this.utiliserCarteAllie = true;
		 }else{
			 this.utiliserCarteAllie = false;
			 System.out.print("vous n'etes pas d'accord de jouer carte \n");
		 }
	}
	
	public void choisiCarteA(int ok){
		//int ok;
		//Scanner post = new Scanner(System.in); 
		//System.out.print("entre 1 si vous choisiez carte Allie et 2 si vous choisiez 2 graines: ");
		 //ok = post.nextInt();
		if(ok ==1){
			 //System.out.print("vous etes d'accord de choisir carte Allie \n");
		this.choisiCarteA = true;
		 }else{
			 this.choisiCarteA = false;
			 //System.out.print("vous recevez 2 graines \n");
		 }
	}

	public void numCarte(int k) {
		// TODO Auto-generated method stub
		this.numCarte = k;
	}

	public int getNumCarte() {
		// TODO Auto-generated method stub
		return numCarte;
	}

	public boolean isAjoue() {
		return Ajoue;
	}

	public void setAjoue(boolean ajoue) {
		Ajoue = ajoue;
	}

	public void setAct(String string) {
		// TODO Auto-generated method stub
		Act = string;
	}

	public String getAct() {
		// TODO Auto-generated method stub
		return Act;
	}
	
}
