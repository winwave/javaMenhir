package Vue;



import java.awt.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;






import Controle.Controller;
import Modele.Partie;







public class Fenetre extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The instance. */
	

	/** The controlleur. */
	private static Controller controlleur;
	
        public int partie;
        
	/** The nbr joueur. */
	/** The instance. */
	private static Fenetre instance;
	/** The bouton play. */
	private JButton boutonPlay;
	/** The bouton next. */

	/** The t. */
	private Thread t;
	private Icon icon;
	private FenetreMenu Fmenu;

	
	
	
	/**
	 * Sets the thread.
	 * 
	 * @param t
	 *            the new thread
	 */
	public void setThread(Thread t) {
		this.t = t;
	}

	/**
	 * Gets the thread.
	 * 
	 * @return the thread
	 */
	public Thread getThread() {
		return t;
	}

	/**
	 * Gets the single instance of Fenetre.
	 * 
	 * @return single instance of Fenetre
	 */
	public static Fenetre getInstance() {
		if (instance == null) {
			instance = new Fenetre();
		}
		return instance;
	}
	/**
	 * Instantiates a new fenetre.
	 */
	
	public Fenetre() {
           
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Projet Menhir");
		//initComposant();
		this.setResizable(false);
		contentPaneStart();
		menuBar();
		//this.add(p);
		this.setSize(1310,740);
		this.setVisible(true);
              

	}
	
	public void contentPaneStart(){
        Fmenu=new FenetreMenu(this);
		BgPanel panel = new BgPanel("jeu.jpg");
		panel.setLayout(null);
		this.getContentPane().add(panel);

		icon = new ImageIcon(getClass().getResource("bplay.gif"));
		boutonPlay = new javax.swing.JButton(icon);
		panel.add(boutonPlay);
		boutonPlay.setBounds(500, 500, 275, 80);

        
		boutonPlay.addActionListener(new ActionListener(){

			@Override
		public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//contentPaneDemarrage();
				
				
				Fmenu.setVisible(true);
			}
			
			
		});
        pack();
       
                
  
       
       
       
    }
	/**
	 * Menu bar.
	 */
	public void menuBar() {
        Fmenu=new FenetreMenu(this);
		JMenuBar menuBar = new JMenuBar();

		/**
		 * JMenu FILE contient NEW ; EXIT ; REDUCE
		 */

		JMenu menu = new JMenu("File");
		JMenu help = new JMenu("Help");
		menuBar.add(menu);
		menuBar.add(help);

		JMenuItem itNew = new JMenuItem("New");
		itNew.addActionListener(new ActionListener() {

			@SuppressWarnings( { "deprecation" })
			@Override
			public void actionPerformed(ActionEvent e) {
				int click = JOptionPane.showConfirmDialog(null,
						"Voulez-vous vraiment créer une nouvelle partie?",
						"Question", JOptionPane.YES_NO_OPTION);
				if (click == JOptionPane.YES_OPTION) {
					try {
						controlleur.getThread().stop();
						Thread.sleep(200);
					} catch (InterruptedException ex) {
						Logger.getLogger(Fenetre.class.getName()).log(
								Level.SEVERE, null, ex.getMessage());
					}
					getContentPane().removeAll();
					
					
					contentPaneStart();
					
					revalidate();
					repaint();
					
				}
			}
		});
		menu.add(itNew);
		menu.addSeparator();

		JMenuItem itReduire = new JMenuItem("Réduire");
		itReduire.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				Fenetre.this.setState(Frame.ICONIFIED);
			}
		});
		menu.add(itReduire);
		JMenuItem itExit = new JMenuItem("Fermer");
		itExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});
		menu.add(itExit);

		JMenuItem about = new JMenuItem("About");
		help.add(about);

		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String mess = "<html><h2>Guide d'utilisation - Menhir</h2>"
						+ "<div>Le jeu se compose deux partie: Partie Simple et Partie Avacnce<p>"
						+ "<div>Le but du jeu est faire pousser plus de menhir que les adversaires<p>"
						
						+ "<ul><li></li>"
						
						+ "<li>Pour poser une carte Ingredient, vous cliquez sur la carte Ingredient et choisiez un act</li>"
						+ "<li>Geant: Récuperer des graines</li>"
						+ "<li>Engrais: Pousser vos graines</li>"
						+ "<li>Farfadets: voler des graines d'un autre joueur</li>"
						+ "<li>Vous pouvez jouer la carte TaupeGeant n'importe quand même pendant </li>"
						+ "<li>Vous ultilisez carte ChienDeGarde quand vous êtes attaqué par un act Farfadets</li>"
						+ "<li></li></ul></div></html>\n\n"
						+ "<html><div><p><b>Auteurs: </b><i>LE Tran Nhac Long - Kevin KEMBEU KENMOE</i></p>"
						+ "<p>Version 1.0 - Projet LO02 A15 - Université de Technologie de Troyes</div></html>";
					
				JOptionPane.showMessageDialog(null, mess, "Help",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		this.setJMenuBar(menuBar);

	}
	
	public static void main(String[] args){
		Fenetre a = new Fenetre();
		
			Controller ctrl = new Controller();
			
			a.setController(ctrl);
			/*ControlPartie control = new ControlPartie();	
			PartieSimple mapartie = new PartieSimple();
			
			mapartie.setNbJoueurs(6);
			mapartie.instancierCartes();
			mapartie.instancierJoueurs(6);
			control.nommerJoueurs(mapartie.getTabJoueurs(),"KEMBEU");
			mapartie.melangerCarteI();		
			mapartie.distribuerCartesI();
			mapartie.ditribuerGraines();
			
			PanelJeu mp = new PanelJeu(mapartie);
			JFrame fe = new JFrame ();
			fe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fe.setTitle("Projet Menhir");
			fe.add(mp);
			fe.setSize(1310,740);
			fe.setVisible(true);*/
			//mp.setComponentOrientation(null);
			//mapartie.instancierCartes();
			//mapartie.instancierJoueurs(a.getNbrJoueur());
		
	}


	public void setController(Controller ctrl) {
		// TODO Auto-generated method tub
		controlleur = ctrl;
	}
	
	public Controller getController (){
		return controlleur;
	}
	
}
