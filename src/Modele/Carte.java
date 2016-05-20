package Modele;
import java.util.Observable;

public class Carte extends Observable{
	/** Construire une carte en general
	 * 
	 */
	public Carte(int id, String nom){
		nomCarte = nom;
		idCarte = id;
	}

	/**
	 * Marquer la carte
	 */
	protected int idCarte;

	/**
	 * Nom de la carte
	 */
	protected String nomCarte;

	/**
	 * Indiquer si elle est disponible a jouer (ou bien si elle est etre
	 * joue)
	 */
	protected boolean estValable = true;

	/*
	 * (non-javadoc)
	 */
	public JoueurPhysique proprietaire = null;

	/**
	 * Getter of the property <tt>estValable</tt>
	 * 
	 * @return Returns the estValable.
	 * 
	 */

	public boolean getEstValable() {
		return estValable;
	}

	/**
	 * Setter of the property <tt>estValable</tt>
	 * 
	 * @param estValable
	 *            The estValable to set.
	 * 
	 */
	public void setEstValable(boolean estValable) {
		this.estValable = estValable;
	}

	/**
	 * Getter of the property <tt>nomCarte</tt>
	 * 
	 * @return Returns the nomCarte.
	 * 
	 */

	public String getNomCarte() {
		return nomCarte;
	}

	/**
	 * Setter of the property <tt>nomCarte</tt>
	 * 
	 * @param nomCarte
	 *            The nomCarte to set.
	 * 
	 */
	public void setNomCarte(String nomCarte) {
		this.nomCarte = nomCarte;
	}

	/**
	 * Getter of the property <tt>idCarte</tt>
	 * 
	 * @return Returns the idCarte.
	 * 
	 */

	public int getIdCarte() {
		return idCarte;
	}

	/**
	 * Setter of the property <tt>idCarte</tt>
	 * 
	 * @param idCarte
	 *            The idCarte to set.
	 * 
	 */
	public void setIdCarte(int idCarte) {
		this.idCarte = idCarte;
	}

	public void calForce(){
		
	}
	/**
	 * Getter of the property <tt>proprietaire</tt>
	 * 
	 * @return Returns the proprietaire.
	 * 
	 */

	public JoueurPhysique getProprietaire() {
		return proprietaire;
	}

	/**
	 * Setter of the property <tt>proprietaire</tt>
	 * 
	 * @param proprietaire
	 *            The proprietaire to set.
	 * 
	 */
	public void setProprietaire(JoueurPhysique proprietaire) {
		this.proprietaire = proprietaire;
	}
}
