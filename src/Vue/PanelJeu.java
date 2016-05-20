/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controle.Controller;
import Modele.JoueurPhysique;
import Modele.JoueurVirtuel;
import Modele.Partie;
import Modele.PartieAvance;
import Modele.PartieSimple;
/**
 *
 * @author Win Wave
 */
public class PanelJeu extends JPanel implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form JoueurPhysique
     */
	public int nbJoueur;
	public void setNbJoueur(int nbJ){
		this.nbJoueur = nbJ;
	}
	public int getNbJoueur(){
		return this.nbJoueur;
	}
	
	private Partie part;
	private Controller ctrl;

	public PanelJeu(Partie p, Controller cont){
		
		part = p;
		ctrl = cont;
		ctrl.setPanel(this);
		for (int i=0; i<p.getTabJoueurs().size(); i++){
			if (p.getTabJoueurs().get(i).getNomJoueur()== ctrl.getNom()){
				jP = p.getTabJoueurs().get(i);
			}
		}
		initComponents(p.getNbJoueurs());
	}
	
    void initComponents(int i) {
    	
        jLabelSaison = new javax.swing.JLabel();
        jLabelManche = new javax.swing.JLabel();
        jLabelSaisonR = new javax.swing.JLabel();
        jLabelMancheR = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 700));
        jPanel1.setLayout(null);
        jPanel1.setOpaque(false);
        
        JLabel label = new JLabel();
		add(label);
		label.setForeground(Color.BLUE);
		label.setSize(1400, 700);
		
			
		label.setIcon(new javax.swing.ImageIcon(getClass().getResource("carte/table.jpg")));

		

        drawJouerPhysique();
        
        drawAutreJoueur(i);
        
        saisonManche();
        
        jLabelSaison.setText("Saison:");
        jLabelSaison.setForeground(Color.YELLOW);
        
        jPanel1.add(jLabelSaison);
        jLabelSaison.setBounds(470, 660, 90, 20);
        
        if (part instanceof PartieAvance){
        jLabelManche.setText("Manche:");
        jLabelManche.setForeground(Color.YELLOW);
        jPanel1.add(jLabelManche);
        jLabelManche.setBounds(600, 660, 80, 14);
        }
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1304, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1.add(label);  
        //this.add(label);  
    }// </editor-fold>   
    
  public void drawJouerPhysique(){
	  jPanelJouerJP = new JPanelJP(jP, ctrl);
	  jP.addObserver(jPanelJouerJP);
	  jPanelJouerJP.setLayout(null);
	  jPanelJouerJP.setOpaque(false);
	  jPanel1.add(jPanelJouerJP);
      jPanelJouerJP.setBounds(220, 375, 680, 300);
  }
  
  public void drawDesJouerVirtuel(int min){
	  for (int i = min;i<jV.size();i++){
	  
		  drawJouerVirtuel(jV.get(i), i-min);
	  }
  }
  
  public void saisonManche (){
	  
	
	  jLabelSaisonR.setText("Printemps");
      jLabelSaisonR.setForeground(Color.RED);
      
      jPanel1.add(jLabelSaisonR);
      jLabelSaisonR.setBounds(515, 660, 90, 20);

      if (part instanceof PartieAvance){
    	  jLabelMancheR.setText(""+1);  
    	  jLabelMancheR.setForeground(Color.RED);
    	  jPanel1.add(jLabelMancheR);
    	  jLabelMancheR.setBounds(655, 660, 80, 14);
      }
  }
  
  private void drawJouerVirtuel(JoueurPhysique joueurP, int i) {
	// TODO Auto-generated method stub
	  jTemp = new VueJV(joueurP, i);
	  jPanel1.add(jTemp);
	  jPanelJV.add(jTemp);
	  joueurP.addObserver(jTemp);
  }
  
  public void drawDesJoueurCote(int n ){
	  for (int i = 0;i<n;i++){
		  jTemp = new VueJVCote(jV.get(i), i);
		  jV.get(i).addObserver(jTemp);
		  jPanel1.add(jTemp);
		  jPanelJV.add(jTemp);
	  }
  }  

	  public void drawAutreJoueur(int i){
		  jPanelJV = new ArrayList<JPanel>();
		  jV = new ArrayList<JoueurPhysique>();
		  for(int k=0; k<part.getTabJoueurs().size(); k++){
			  if (part.getTabJoueurs().get(k) instanceof JoueurVirtuel){
				  jV.add((JoueurVirtuel)(part.getTabJoueurs().get(k)));
				  System.out.println(k);
				  
			  }
		  }
		  System.out.println("Taille: "+jV.size());
		  switch(i){
		  case 2:
			  drawJouerVirtuel(jV.get(0), 1);
			  break;
		  case 3:
			  drawJouerVirtuel(jV.get(0), 0);
			  drawJouerVirtuel(jV.get(1), 2);
			  break;
		  case 4:
			  drawDesJouerVirtuel(0);
			  break;
		  case 5:
			  drawDesJoueurCote(1);
			  drawDesJouerVirtuel(1);
			  break;
		  case 6:
			  drawDesJoueurCote(2);
			  drawDesJouerVirtuel(2);
			  break;
		  }
	  }
	 
	  

    private JPanelJP jPanelJouerJP;
    private ArrayList<JoueurPhysique> jV;
    private JoueurPhysique jP;
    private VueJV jTemp;
    private ArrayList<JPanel> jPanelJV;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jLabelManche;
    private javax.swing.JLabel jLabelSaison;
    private javax.swing.JLabel jLabelMancheR;
    private javax.swing.JLabel jLabelSaisonR;
	public ArrayList<JoueurPhysique> getTabJV() {
		// TODO Auto-generated method stub
		return jV;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		//this.saisonManche();
		
		for (int i=0; i<jPanelJV.size(); i++){
			((VueJV) jPanelJV.get(i)).update(null);
		}
		//this.changerSaison();
		jPanelJouerJP.update(null);
	}
	public void updateScrore(){
		for (int i=0; i<jPanelJV.size(); i++){
			((VueJV) jPanelJV.get(i)).mAJ();;
		}
		jPanelJouerJP.ScoreJP();
	}
	public void newManche(){
		for (int i=0; i<jPanelJV.size(); i++){
			((VueJV) jPanelJV.get(i)).newManche();
		}
		jPanelJouerJP.newManche(jP);
		
	}
	
	public void changerSaison() {
		// TODO Auto-generated method stub
		
		switch (ctrl.saisonInt){
		  case 0:
			  jLabelSaisonR.setText("Printemps");
			
			  break;
		  case 1:
		
			  jLabelSaisonR.setText("Eté");
			 
		

			  break;
		  case 2:
			  jLabelSaisonR.setText("Automne");
			  break;
		  case 3:
			  jLabelSaisonR.setText("Hiver");
			  break;
		  default :
			  jLabelSaisonR.setText("Pas Connue");
		  }
	}
	public void changerManche(){
		
		jLabelMancheR.setText(""+(ctrl.Manche+1));
		}
	}


