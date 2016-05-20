package Controle;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;


import javax.swing.JOptionPane;


import Modele.CarteAllie;
import Modele.CarteIngredient;

import Modele.JoueurPhysique;
import Modele.Partie;
import Modele.PartieAvance;
import Modele.PartieSimple;
import Modele.TaupeGeante;
import Modele.TourSimple;
import Vue.PanelJeu;

/**
 * The Class Controller. Elle s'utilise par pattern MVC, qui est controleur
 * @author WinWave
 */
public class Controller implements Observer{
	
	/** Les variables */
	private Partie model;
	private PanelJeu panel;
	private String Name;
	private int partie;
	private int NbrJoueur;
	private String actChoisi;
	public static int saisonInt=0;
	public static int Manche=0;
	public Thread t;
	public boolean DejaJouer; 
	public boolean Atour;
	public boolean Attaque;
	/** Liste joueur. */
	private static LinkedList<JoueurPhysique> tabJ = new LinkedList<JoueurPhysique>();
	   
	   
	public void setAttaque(){
		Attaque = true;
	}
	public boolean getAttaque(){
		return Attaque;
	}
	public void setATour(){
		Atour = true;
	}
	public boolean getAtour(){
		return Atour;
	}
	
	public void setDejaJouer(){
		this.DejaJouer = true;
	}
	public boolean DejaJouerA;
	public void setDejaJouerA(){
		this.DejaJouerA = true;
	}
    public static LinkedList<JoueurPhysique> getTabJ() {
        return tabJ;
    }

    public static void setTabJ() {
        tabJ.clear();
		for (int i = 0; i < Partie.getTabJoueurs().size(); i++) {
			tabJ.add(Partie.getTabJoueurs().get(i));
		}
    }

	/**
	 * Instantialiser controleur.
	 *
	 * @param model the model
	 * @param vue the vue
	 * @return 
	 */
    
	
    public Thread getThread() {
		return t;
	}
	public void demarrerPartie(){
		
		int n = NbrJoueur;
		
		
		System.out.println(n);
		
		
		if(this.partie==0){
			model = new PartieAvance();
			model.setNbJoueurs(n);
			model.instancierCartes();
			model.instancierJoueurs(n);
			nommerJoueurs(model.getTabJoueurs(), Name);
			model.addObserver(this);
			
		((PartieAvance) model).MessageChoisirCarteA();
		
		System.out.println("Partie Avance");
		
		
		t = new Thread((PartieAvance)model);
		}else{
			model = new PartieSimple();
			model.setNbJoueurs(n);
			model.instancierCartes();
			model.instancierJoueurs(n);
			
			nommerJoueurs(model.getTabJoueurs(), Name);
			model.addObserver(this);
			System.out.println("Partie Simple");
			t = new Thread((PartieSimple)model);
		}
		t.start();
	model.addObserver(panel);
		
	}

	/**
	 * Gets the joueur.
	 *
	 * @param i the i
	 * @return the joueur
	 */
	public JoueurPhysique getJoueur(int i) {
		setTabJ();
		tabJ.remove(model.getTabJoueurs().get(i));
		return tabJ.get(i);
	}
	
	public void changePosition(){
		
	}
	/**
	 * Gets the joueur actuel.
	 *
	 * @return the joueur actuel
	 */
	public JoueurPhysique getJoueurActuel() {
           
		return model.getTabJoueurs().get(TourSimple.getTourJoueur());
	}
	
	public void nommerJoueurs (LinkedList<JoueurPhysique> liste, String nom){

		liste.get(model.getPosition()).setNomJoueur(nom);
		
		for (int i= 0; i<liste.size(); i++){
			if(i!= model.getPosition() ){
				switch(i){
				case 0:
					liste.get(i).setNomJoueur("Dupont");
					break;
				case 1:
					liste.get(i).setNomJoueur("Steven");
					break;
				case 2:
					liste.get(i).setNomJoueur("Nicolas");
					break;
				case 3:
					liste.get(i).setNomJoueur("Alex");
					break;
				case 4:
					liste.get(i).setNomJoueur("Mathieu");
					break;
				case 5:
					liste.get(i).setNomJoueur("LE");
					break;
				}
			System.out.print("nom de l'adversaire n¤"+(i)+" : " +liste.get(i).getNomJoueur() +"\n" );
			
			}
		}
	}
	
	public void jouerCarteIJP(CarteIngredient carte, ArrayList<JoueurPhysique> list){
		
		String[] chaine1 = {"Geant","Engrais", "Farfadet"};
		actChoisi = (String)JOptionPane.showInputDialog(null,"Choississez une Action à éffectuer", "Acte",JOptionPane.QUESTION_MESSAGE, null, chaine1, chaine1[0]);
		
		if (actChoisi == "Geant"){
			carte.actGeant(carte.calForce(0, this.saisonInt));
		}else if (actChoisi == "Engrais"){
			carte.actEngrais(carte.calForce(1, this.saisonInt));
		}else if (actChoisi == "Farfadet"){
			String[] chaine2 = new String[5];
			for (int i=0; i<list.size(); i++){
				chaine2[i]=list.get(i).getNomJoueur();
			}
			String nomJ = (String)JOptionPane.showInputDialog(null,"Choississez le joueur à attaquer", "Acte",JOptionPane.QUESTION_MESSAGE, null, chaine2, chaine2[0]);
			JoueurPhysique joueurA = null;
			for (int i=0; i<list.size(); i++){
				if (nomJ == list.get(i).getNomJoueur()){
					joueurA = list.get(i);
				}
			}
			carte.actFarfadet(carte.calForce(2, this.saisonInt), joueurA);
		}
		
		this.setDejaJouer();
	}
	
	public void jouerCarteAJP(CarteAllie carte, ArrayList<JoueurPhysique> list){
		
			String[] chaine2 = new String[5];
			for (int i=0; i<list.size(); i++){
				chaine2[i]=list.get(i).getNomJoueur();
			}
			
			String nomJ = (String)JOptionPane.showInputDialog(null,"Choississez le joueur à attaquer", "Acte",JOptionPane.QUESTION_MESSAGE, null, chaine2, chaine2[0]);
			System.out.println(nomJ);
			JoueurPhysique joueurA = null;
			for (int i=0; i<list.size(); i++){
				if (nomJ == list.get(i).getNomJoueur()){
					joueurA = list.get(i);
				}
			}
			
			((TaupeGeante) carte).detruireMenhir(carte.calForce(this.saisonInt), joueurA);
			
			panel.updateScrore();
	}
			
	public void nouvelleManche(int i){
		JOptionPane.showMessageDialog(null, "Nous allons démarrer une nouvelle Manche"+" Manche: "+i);
		panel.newManche();
	}
	
	public void updateScore(){
		panel.updateScrore();
	}
	public void afficherGagnant (LinkedList<JoueurPhysique> liste){
		int idGagnant=0;
		int nbre=0;
		
		for (int i=0; i<liste.size(); i++){
			if (liste.get(i).getCompteur().getNbMenhir() >= nbre){
				nbre = liste.get(i).getCompteur().getNbMenhir();
				idGagnant = i;
			}
		}
		String resultat = "";
		resultat += "Le Gagnant est : "+liste.get(idGagnant).getNomJoueur();
		resultat += "Avec un total de "+nbre+" Menhir Adulte !\nBravo !!!";
		
		JOptionPane.showMessageDialog(null, resultat);
		 
		System.out.println("Le Gagnant est : "+liste.get(idGagnant).getNomJoueur());
		System.out.println("Avec un total de "+nbre+" Menhir Adulte !\nBravo !!!");
	}

	public Partie getPartie() {
		// TODO Auto-generated method stub
		return model;
	}

	public void setPartie(int mnemonic) {
		// TODO Auto-generated method stub
		partie = mnemonic;
	}

	public void setNBJ(int i) {
		// TODO Auto-generated method stub
		NbrJoueur = i;
	}

	public void setNom(String text) {
		// TODO Auto-generated method stub
		Name = text;
	}

	public PanelJeu getPanel() {
		return panel;
	}

	public void setPanel(PanelJeu panel) {
		this.panel = panel;
	}

	@Override
	public void update(Observable o, Object arg) {
		panel.update(null, null);;
	}

	public void changerSaison() {
		this.saisonInt++;
		if(this.saisonInt==4){
			this.saisonInt=0;
		}
		panel.changerSaison();
	}
	
	public void changerManche(){
		this.Manche++;
		panel.changerManche();
	}
	public String getNom(){
		return Name;
	}
	
}
                        