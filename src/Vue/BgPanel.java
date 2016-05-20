package Vue;
import java.awt.Graphics;
	import java.awt.Image;

	import javax.swing.ImageIcon;
	import javax.swing.JPanel;

	

	
	public class BgPanel extends JPanel {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/** Source d'image. */
		private String str;

		/**
		 * Instantialiser un background panel.
		 *
		 * @param str the str
		 */
		public BgPanel(String str) {
			this.str = str;
		}

		/* (non-Javadoc)
		 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
		 */
		public void paintComponent(Graphics g) {
			Image background = new ImageIcon(getClass().getResource(str)).getImage();
			g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
		}
	}

