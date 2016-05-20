package Vue;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Modele.JoueurPhysique;

public class VueJV extends JPanel implements Observer{

	protected Observable arg;
	protected JLabel jLabelA;
	protected JLabel jLabelJ;
	protected JLabel jLabelNom;
	protected JLabel jLabelMenhir;
	protected JLabel jLabelGraine;
	protected JLabel jLabelRM;
	protected JLabel jLabelRG;
	protected JLabel jLabelRN;
	protected JLabel[] jLabelI;
	protected JLabel jLabelAction;
	protected int i;
	protected int id;
	protected int decompte = 0;
	protected boolean jourA;
	public void setJourA(){
		this.jourA = true;
	}
	public VueJV (JoueurPhysique j, int i){
		super();
		arg = j;
		this.i=i;
		this.setLayout(null);
        this.setOpaque(false);
        this.setBounds(400*(this.i)+90, 10, 390, 320);
		this.init();
		
	}
	
	public void init(){
		jLabelAction = new JLabel();
		jLabelA = new JLabel();
		jLabelJ = new JLabel();
		jLabelNom = new JLabel();
		jLabelMenhir = new JLabel();
		jLabelGraine = new JLabel();
		jLabelRM = new JLabel();
		jLabelRG = new JLabel();
		jLabelRN = new JLabel();
		jLabelI = new JLabel[4];
		this.drawJ();
	}
	
	public void drawJ(){
		
		for(int j=0; j<4;j++){
			jLabelI[j] = new JLabel();
			this.add(jLabelI[j]);
	        jLabelI[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("carte/carteNull.jpg"))); // NOI18N
	        jLabelI[j].setBounds(20 + j*50, 20, 120, 122);
	        System.out.println("BonjourB"+j);
		}
		
		if (((JoueurPhysique)arg).getCarteA()!=null){
			
			this.add(jLabelA);
			jLabelA.setIcon(new javax.swing.ImageIcon(getClass().getResource("carte/carteNull.jpg"))); // NOI18N
	        jLabelA.setBounds(220, 20, 121, 122);
		}
		
        jLabelNom.setText("Nom:");
        this.add(jLabelNom);
        jLabelNom.setBounds(50, 150, 90, 14);
        
        jLabelRN.setText(((JoueurPhysique)arg).getNomJoueur());
        this.add(jLabelRN);
        jLabelRN.setBounds(100, 150, 90, 14);

        jLabelMenhir.setText("Menhir:");
        this.add(jLabelMenhir);
        jLabelMenhir.setBounds(170, 150, 90, 14);
        
        jLabelRM.setText(""+((JoueurPhysique)arg).getCompteur().getNbMenhir());
        this.add(jLabelRM);
        jLabelRM.setBounds(220, 150, 90, 14);

        jLabelGraine.setText("Graine:");
        this.add(jLabelGraine);
        jLabelGraine.setBounds(270, 150, 90, 14);
        
        jLabelRG.setText(""+((JoueurPhysique)arg).getCompteur().getNbGraine());
        this.add(jLabelRG);
        jLabelRG.setBounds(320, 150, 90, 14);
        
	}
	
	public void drawJJ(){
		jLabelAction.setVisible(false);
		jLabelJ.setVisible(false);
		for(int j=0; j<4;j++){
			jLabelI[j].setVisible(true);
			
		}
		
		if (((JoueurPhysique)arg).getCarteA()!=null){
			jLabelA.setVisible(true);
			
		}else{
			
			jLabelA.setVisible(false);
		}
		
	}
	
	public void mAJ(){
		jLabelRG.setText(""+((JoueurPhysique)arg).getCompteur().getNbGraine());
		jLabelRM.setText(""+((JoueurPhysique)arg).getCompteur().getNbMenhir());
		jLabelRN.setText(((JoueurPhysique)arg).getNomJoueur());
	}
	
	public void newManche(){
		//this.removeAll();
		decompte = -1;
		this.drawJJ();
		this.mAJ();
	}
	
	public void setId(int id){
		this.id = id;
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
		jLabelAction.setVisible(true);
		jLabelAction.setText(((JoueurPhysique)arg).getAct());
		
		jLabelJ.setVisible(true);
		jLabelJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("carte/"+id+".png"))); // NOI18N
		System.out.println("carte/"+id+".png");
		if(decompte == 0){
			this.add(jLabelJ);
	        jLabelJ.setBounds(150, 170, 130, 130);
	        this.add(jLabelAction);
	        jLabelAction.setBounds(154, 295, 120, 14);
	        
		}
		
		this.mAJ();
	}

}
