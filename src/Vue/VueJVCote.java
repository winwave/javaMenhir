package Vue;

import java.util.Observable;

import javax.swing.JLabel;

import Modele.JoueurPhysique;

public class VueJVCote extends VueJV{

	public VueJVCote(JoueurPhysique j, int i) {
		super(j, i);
		// TODO Auto-generated constructor stub
		this.setBounds(10+1000*i, 230+i*100, 290, 330);
	}
	
	public void drawJ(){
		
		for(int j=0; j<4;j++){
			jLabelI[j] = new JLabel();
			jLabelI[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("carte/carteNull.jpg"))); // NOI18N
			jLabelI[j].setBounds(10+i*120, 10+j*40, 120, 120);
	        this.add(jLabelI[j]);
	        System.out.println("Coté"+j);
		}
		
		if (((JoueurPhysique)arg).getCarteA()!=null){
			jLabelA.setIcon(new javax.swing.ImageIcon(getClass().getResource("carte/carteNull.jpg"))); // NOI18N
	        this.add(jLabelA);
	        jLabelA.setBounds(10+i*120, 170, 120, 120);
		}

        jLabelNom.setText("Nom:");
        this.add(jLabelNom);
        jLabelNom.setBounds(10, 300, 69, 14);
        
        jLabelRN.setText(((JoueurPhysique)arg).getNomJoueur());
        this.add(jLabelRN);
        jLabelRN.setBounds(43, 300, 90, 14);

        jLabelMenhir.setText("Menhir:");
        this.add(jLabelMenhir);
        jLabelMenhir.setBounds(90, 300, 74, 14);
        
        jLabelRM.setText(""+((JoueurPhysique)arg).getCompteur().getNbMenhir());
        this.add(jLabelRM);
        jLabelRM.setBounds(135, 300, 90, 14);

        jLabelGraine.setText("Graine:");
        this.add(jLabelGraine);
        jLabelGraine.setBounds(90, 315, 80, 14);
        
        jLabelRG.setText(""+((JoueurPhysique)arg).getCompteur().getNbGraine());
        this.add(jLabelRG);
        jLabelRG.setBounds(135, 315, 90, 14);
	}
	
	public void setId(int id){
		this.id = id;
	}
	public void newManche(){
		//this.removeAll();
		decompte = -1;
		this.drawJJ();
		this.mAJ();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		decompte++;
		if (decompte <4){
			jLabelI[decompte].setVisible(false);
		}else{
			jLabelA.setVisible(false);
		}
		id = ((JoueurPhysique)arg).getNumCarte();
		jLabelJ.setVisible(true);
		jLabelAction.setVisible(true);
		jLabelAction.setText(((JoueurPhysique)arg).getAct());
		jLabelJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("carte/"+id+".png"))); // NOI18N
		System.out.println("carte/"+id+".png");
		if(decompte == 0){
			this.add(jLabelJ);
			jLabelJ.setBounds(150-150*i, 100 - i*40, 120, 120);
			this.add(jLabelAction);
	        jLabelAction.setBounds(154-150*i, 240-i*40, 120, 14);
		}
        
	}

}
