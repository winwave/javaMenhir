package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Modele.JoueurPhysique;
import Modele.PartieAvance;
import Modele.PartieSimple;
import Modele.TaupeGeante;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controle.Controller;

public class JPanelJP extends JPanel implements Observer{
	protected Observable o;
	protected JButton jButtonA;
	protected JLabel jLabelJ;
	protected JLabel jLabelNom;
	protected JLabel jLabelMenhir;
	protected JLabel jLabelGraine;
	protected JLabel jLabelRM;
	protected JLabel jLabelRG;
	protected JLabel jLabelRN;
	protected JButton[] jButtonI;
	protected Controller ctrl;
	
	public JPanelJP (JoueurPhysique j, Controller cont){
		
		super();
		o =j;
		ctrl = cont;
		this.setLayout(null);
		this.setOpaque(false);
		this.initComponents();
		this.drawComponents(j);
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		jLabelRM.setText(""+((JoueurPhysique)o).getCompteur().getNbMenhir());
		jLabelRG.setText(""+((JoueurPhysique)o).getCompteur().getNbGraine());
	}
	public void ScoreJP(){
		jLabelRM.setText(""+((JoueurPhysique)o).getCompteur().getNbMenhir());
		jLabelRG.setText(""+((JoueurPhysique)o).getCompteur().getNbGraine());
	}
	public void initComponents (){
		//jButtonA = new JButton();
		jButtonI = new JButton[4];
		jLabelJ = new JLabel();
		jLabelNom = new JLabel();
		jLabelMenhir = new JLabel();
		jLabelGraine = new JLabel();
		jLabelRM = new JLabel();
		jLabelRG = new JLabel();
		jLabelRN = new JLabel();
	}
	
	public void newManche(JoueurPhysique j){
		this.removeAll();
		this.drawComponents(j);
	}
	
	public void drawComponents (final Observable o){
		
		final JPanelJP panel= this;
		
		for( int i=0;i<4;i++){
			  jButtonI[i] = new JButton();
			  final int k = i; 
			  
			  final int num = ((JoueurPhysique)o).getCarteI().get(i).getIdCarte();
			  System.out.println("carte/"+num+".png");
			  jButtonI[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("carte/"+num+".png"))); // NOI18N
			  panel.add(jButtonI[i]);
			  jButtonI[i].setBounds(20+i*130, 160, 120, 120);
			  jButtonI[i].addActionListener(new ActionListener(){
				  		
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if(ctrl.getAtour() == true){
							ctrl.jouerCarteIJP(((JoueurPhysique)o).getCarteI().get(k), ctrl.getPanel().getTabJV());
							panel.remove(jLabelJ);
							jLabelJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("carte/"+num+".png"))); // NOI18N
						    panel.add(jLabelJ);
						    jLabelJ.setBounds(280, 0, 120, 120);
						    jLabelJ.setVisible(true);
						    jLabelJ.revalidate();
						    jLabelJ.repaint();
						    jButtonI[k].setVisible(false);
							panel.update(o, null);
						
							((JoueurPhysique)o).setAjoue(true);
							ctrl.Atour=false;
							//((JoueurPhysique)o).getCarteI().remove(((JoueurPhysique)o).getCarteI().get(k));
							}
							
						}
						
						
					});
			}
		
		if (((JoueurPhysique)o).getCarteA()!=null){
			jButtonA = new JButton();
			final int num1 = ((JoueurPhysique)o).getCarteA().getIdCarte();
			System.out.println("carte/"+num1+".png");
			  jButtonA.setIcon(new javax.swing.ImageIcon(getClass().getResource("carte/"+num1+".png"))); // NOI18N
			  panel.add(jButtonA);
			  jButtonA.setBounds(550, 160, 120, 120);
			  
			  jButtonA.addActionListener(new ActionListener(){
			  		
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(((JoueurPhysique)o).getCarteA() instanceof TaupeGeante){
						System.out.println("c");
						ctrl.jouerCarteAJP(((JoueurPhysique)o).getCarteA(), ctrl.getPanel().getTabJV());
						}
						if(((JoueurPhysique)o).getCarteA() instanceof TaupeGeante||ctrl.getAttaque()==true){
						panel.remove(jLabelJ);
						jLabelJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("carte/"+num1+".png"))); // NOI18N 
					    panel.add(jLabelJ);
					    jLabelJ.setBounds(280, 0, 120, 120);
					    jLabelJ.setVisible(true);
					    jLabelJ.revalidate();
					    jLabelJ.repaint();
						jButtonA.setVisible(false);
						panel.update(o, null);
						//((JoueurPhysique)o).setCarteA(null);
						ctrl.setDejaJouerA();
						
						}
					}	
					
			});
			  }
		
		
		 jLabelJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/1.png"))); // NOI18N
		 panel.add(jLabelJ);
	     jLabelJ.setBounds(280, 0, 120, 120);
	     jLabelJ.setVisible(false);

	     jLabelNom.setText("Nom:");
	     panel.add(jLabelNom);
	     jLabelNom.setBounds(200, 130, 90, 14);
	     
	     jLabelRN.setText(((JoueurPhysique)o).getNomJoueur());
	     panel.add(jLabelRN);
	     jLabelRN.setBounds(233, 130, 90, 14);

	     jLabelMenhir.setText("Menhir:");
	     panel.add(jLabelMenhir);
	     jLabelMenhir.setBounds(300, 130, 100, 14);
	     
	     jLabelRM.setText(""+((JoueurPhysique)o).getCompteur().getNbMenhir());
	     panel.add(jLabelRM);
	     jLabelRM.setBounds(350, 130, 100, 14);

	     jLabelGraine.setText("Graine:");
	     panel.add(jLabelGraine);
	     jLabelGraine.setBounds(400, 130, 90, 14);
	     
	     jLabelRG.setText(""+((JoueurPhysique)o).getCompteur().getNbGraine());
	     panel.add(jLabelRG);
	     jLabelRG.setBounds(450, 130, 90, 14);
	      
	     //jPanel1.add(jPanelJouerJP);
	}
	

}
