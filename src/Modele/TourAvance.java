package Modele;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import Controle.Controller;

public class TourAvance extends TourSimple  {
	
	public TourAvance(Controller ct){
		
		super(ct);
	}
	
	public void gererTour(LinkedList<JoueurPhysique> joueurs){
		//
		
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
						CarteAllie carteAJV = joueurs.get(postEstAttaque).jouerCarteAllie();
						if (carteAJV instanceof ChienDeGarde){
							boolean ok=false;
							if(postEstAttaque != posJP){
								ok = ((JoueurVirtuel) joueurs.get(postEstAttaque)).reflechirCarteAllie(this.getNoTour());
							}else{
								ctrl.setAttaque();
								int n = JOptionPane.showConfirmDialog(
							            null,
							            "Vous êtes attaqué, voulez-vous utiliser CHIEN DE GARDE! \n Si, click sur votre carte Chien De Garde",
							            "CHIEN DE GARDE",
							            JOptionPane.YES_NO_OPTION);							
								if(n== JOptionPane.YES_OPTION){
									ok = true;
								joueurs.get(posJP).utiliserCarteAllie= true;
								ctrl.DejaJouerA = false;
								while (ctrl.DejaJouerA==false) {
									try {
										Thread.sleep(500);
										
										//System.out.println(ctrl.DejaJouerA);
										//Thread.sleep(1500);
									} catch (Exception e) {
							System.out.println("interruption joueur Reel");
									}
								}
									}
								ctrl.Atour=false;
							}
							if(ok== true){
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								int a =((ChienDeGarde) carteAJV).protegerGraine(joueurs.get(postEstAttaque).forceEstAttaque, this.getNoTour());
								joueurs.get(postEstAttaque).estAttaquePar.getCompteur().diminuerGraine(a);
								joueurs.get(postEstAttaque).getCompteur().augmenterGraine(a);
								
							System.out.println("Joueur "+postEstAttaque+" utilise carte Chien De Garde");
							System.out.println("Avec carte :"+joueurs.get(postEstAttaque).getCarteA().toString());
							ctrl.updateScore();
							joueurs.get(postEstAttaque).notifyObservers(null);
							joueurs.get(postEstAttaque).setCarteA(null);
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							

							}
						}	
						
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
					} catch (Exception e) {
			System.out.println("interruption joueur Reel");
					}
				}
			
			}
				
		
				for (int j=0; j<joueurs.size(); j++){
					CarteAllie carteAJV = joueurs.get(j).jouerCarteAllie();
					
					if(carteAJV instanceof TaupeGeante){
						boolean ok = false;
						int pos =0;
						if(j!= posJP){
							ok = ((JoueurVirtuel) joueurs.get(j)).reflechirCarteAllie(this.getNoTour());
							pos = ((JoueurVirtuel) joueurs.get(j)).reflechirJoueurAAttaquer(1, joueurs.get(j).getPosJoueur());
						}
						if(ok == true){
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							((TaupeGeante) carteAJV).detruireMenhir(carteAJV.calForce(this.getNoTour()),joueurs.get(pos) );
							joueurs.get(j).notifyObservers(null);
							System.out.println("Joueur "+j+" utilise carte TaupeGeante a joueur "+pos);
							System.out.println("Avec carte :"+joueurs.get(j).getCarteA().toString());
							joueurs.get(j).setCarteA(null);
							ctrl.updateScore();
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				}
					

					}
			
			ctrl.updateScore();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ctrl.changerSaison();
		System.out.println(ctrl.saisonInt);
		for (int i =0;i< joueurs.size();i++){
			System.out.println("Joueur "+i + "  nombre Menhir: "+joueurs.get(i).getCompteur().toString());
			
		}

	}
	
	
	
}

