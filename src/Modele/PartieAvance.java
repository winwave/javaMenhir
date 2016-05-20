package Modele;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import Vue.Fenetre;
import Controle.Controller;

public class PartieAvance extends Partie implements Runnable{

	

	private LinkedList<Manche> tabManche = new LinkedList<Manche>() ;
	private int numManche = 0;
	/**
	 * Getter of the property <tt>tabManche</tt>
	 * 
	 * @return Returns the tabManche.
	 * 
	 */	
	
	public LinkedList<Manche> getTabManche() {
		return tabManche;
	}

	/**
	 * Setter of the property <tt>tabManche</tt>
	 * 
	 * @param tabManche
	 *            The tabManche to set.
	 * 
	 */
	public void gererPartieAvance(){
		
		
			for (int i = 0; i<this.getNbJoueurs(); i++){
				System.out.println("Manche : " + (i+1));
				if (i>0){
					
					JoueurPhysique jp = this.getTabJoueurs().pop();
					this.getTabJoueurs().add(jp);
					this.position--;
					if(this.getPosition()<0){
						this.position = this.getNbJoueurs()-1;
						
						
					}
					this.MessageChoisirCarteA();
					System.out.println("vous etes joueur "+this.getPosition()+" eme dans ce manche");
					for(int m=0;m<this.getTabJoueurs().size();m++){
						this.getTabJoueurs().get(m).setCarteA(null);
						System.out.println(this.getTabJoueurs().get(m).getCarteA());
					}
				}
				
				this.melangerCarteA();
				this.distribuerCartesAetGraine();
				this.melangerCarteI();
				this.distribuerCartesI();
				int ind=0;
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j) instanceof Controller){
						ind = j;
						}
					numManche = 1+j;
				}
				((Controller)(list.get(ind))).nouvelleManche(i+1);
				//Fenetre.getInstance()
				for (int k=0; k<this.getNbJoueurs(); k++){
					System.out.println(" joueur "+k+this.getTabJoueurs().get(k).getCompteur().toString());
					}

				
				tabManche.add(new Manche((Controller)(list.get(ind))));
				tabManche.get(i).gererManche(this.getTabJoueurs());
				
				//this.distribuerCartesAetGraine();
				for(int m=0;m<this.getTabJoueurs().size();m++){
					System.out.println(this.getTabJoueurs().get(m).getCarteA());
				}
			System.out.println("--------------------------------------------------------------");
			}
			int ind=0;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j) instanceof Controller){
					ind = j;
					}
				
			}
			((Controller)(list.get(ind))).afficherGagnant(this.getTabJoueurs());
	
	}
	public void melangerCarteA(){
		for (int i=0; i<this.getTabCarteA().size(); i++){
			int position = (int) Math.round((this.getTabCarteA().size()-1)*Math.random());
			CarteAllie carte = this.getTabCarteA().pop();
			this.getTabCarteA().add(position, carte);
		}
	}
	public void MessageChoisirCarteA(){
		int i = this.getPosition();
		String[] chaine = {"1 Carte Allié", "Deux Graines"};
		String choix = (String)JOptionPane.showInputDialog(null,"Preferiez-vous des graines ou voulez-vous piocher une carte allié ?", "Acte",JOptionPane.QUESTION_MESSAGE, null, chaine, chaine[0]);
		if(choix == "1 Carte Allié"){
			this.getTabJoueurs().get(i).choisiCarteA(1);
		}else{
			this.getTabJoueurs().get(i).choisiCarteA(2);
		}
	}
	public void distribuerCartesAetGraine() {	
	
	for (int i=0; i<this.getNbJoueurs(); i++){
		if(i!= this.getPosition()){
		((JoueurVirtuel) this.getTabJoueurs().get(i)).choisiCarteA();
		System.out.println(" Joueur "+i+ " choisi carte Allie: "+((JoueurVirtuel) this.getTabJoueurs().get(i)).choisiCarteA );

		}
		
	}
		
	int j=0;
		
			for (int k = 0; k < this.getTabJoueurs().size(); k++) {
				if(this.getTabJoueurs().get(k).choisiCarteA == true){
				this.getTabJoueurs().get(k).setCarteA(this.getTabCarteA().get(j));
				this.getTabCarteA().get(j).setProprietaire(this.getTabJoueurs().get(k));
				j++;
				}else{
					this.getTabJoueurs().get(k).getCompteur().augmenterGraine(2);;
				}
			}
		}

	public int getNumManche() {
		return numManche;
	}

	public void setNumManche(int numManche) {
		this.numManche = numManche;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.gererPartieAvance();
	}

	
	
	
}
