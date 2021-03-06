/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controle.Controller;
import Modele.JoueurPhysique;
import Modele.Partie;
import Modele.PartieSimple;
import Modele.PartieAvance;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
/**
 *
 * @author Win Wave
 */
public class FenetreMenu extends JDialog implements ActionListener {
	
	private Controller controlleur;
    private Fenetre parent;
    private boolean OK =false;
    
    public boolean getButton(){
        return this.OK;
    }


    /**
     * Creates new form FenetreMenu
     */
    public FenetreMenu(Fenetre a) {
    	this.parent = a;
    	setLocation(400,200);
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
        buttonGroup1 = new javax.swing.ButtonGroup();
        textNom = new javax.swing.JTextField();
        nbJoueur = new javax.swing.JComboBox();
        partieSimple = new javax.swing.JRadioButton();
        partieAvance = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        buttonOK = new javax.swing.JButton();
        
        jLabel4 = new javax.swing.JLabel();
        age = new javax.swing.JComboBox();

     //   setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);

        
          

        nbJoueur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3", "4", "5", "6" }));
        

        buttonGroup1.add(partieSimple);
        partieSimple.setText("Partie Simple");
        partieSimple.setMnemonic(1);

        buttonGroup1.add(partieAvance);
        partieAvance.setSelected(true);
        partieAvance.setText("Partie Avance");
        partieAvance.setMnemonic(0);

        jLabel1.setText("Votre nom :");

        jLabel2.setText("Choisir partie :");

        jLabel3.setText("Nombre joueur :");

        buttonOK.setText("OK");
        buttonOK.addActionListener(this);

        jLabel4.setText("Age :");

        age.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(partieSimple)
                                .addGap(84, 84, 84)
                                .addComponent(partieAvance)
                                .addGap(61, 61, 61))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(nbJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textNom, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(62, 62, 62)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(buttonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(partieAvance, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(partieSimple))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nbJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(buttonOK)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetreMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
        /* Create and display the form */
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox age;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox nbJoueur;
    private javax.swing.JRadioButton partieAvance;
    private javax.swing.JRadioButton partieSimple;
    private javax.swing.JTextField textNom;
    // End of variables declaration//GEN-END:variables
	
    
    @Override
        
	public void actionPerformed(ActionEvent e) {
    	
    	
		parent.getController().setPartie(buttonGroup1.getSelection().getMnemonic());
		
		System.out.println("Type partie : "+buttonGroup1.getSelection().getMnemonic());
		parent.getController().setNBJ((nbJoueur.getSelectedIndex()+2));
		System.out.println("NBJ : "+(nbJoueur.getSelectedIndex()+2));
		parent.getController().setNom(textNom.getText());
		System.out.println("Nom : "+textNom.getText());
		
		this.dispose();
		
		parent.getController().demarrerPartie();
		parent.getController().nommerJoueurs(parent.getController().getPartie().getTabJoueurs(),parent.getController().getNom() );
		p = new PanelJeu(parent.getController().getPartie(), parent.getController());

	//	p.initComponents(nbJoueur.getSelectedIndex()+2);
	  
	 
		
		parent.getContentPane().removeAll();
		parent.add(p);
		parent.revalidate();
		parent.repaint();
		
		
	}

	private PanelJeu p;
    private JoueurPhysique j;
    private Controller ctrl;
}
