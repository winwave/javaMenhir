package Modele;
import java.util.Observable;

public class Compteur extends Observable{
	
	/**
	 * Nombre de Graines restants
	 */
	private int nbGraine = 0;

	/**
	 * Nombre de Menhirs restants
	 */
	private int nbMenhir = 0;

	/**
	 * Getter of the property <tt>nbMenhir</tt>
	 * 
	 * @return Returns the nbMenhir.
	 * 
	 */

	public Compteur(){
		
	}
	
	public int getNbMenhir() {
		return nbMenhir;
	}

	/**
	 * Setter of the property <tt>nbMenhir</tt>
	 * 
	 * @param nbMenhir
	 *            The nbMenhir to set.
	 * 
	 */
	public void setNbMenhir(int nbMenhir) {
		this.nbMenhir = nbMenhir;
	}

	/**
	 * Getter of the property <tt>nbGraine</tt>
	 * 
	 * @return Returns the nbGraine.
	 * 
	 */

	public int getNbGraine() {
		return nbGraine;
	}

	/**
	 * Setter of the property <tt>nbGraine</tt>
	 * 
	 * @param nbGraine
	 *            The nbGraine to set.
	 * 
	 */
	public void setNbGraine(int nbGraine) {
		this.nbGraine = nbGraine;
	}

	/**
	 * Incrementer nombre de Menhirs
	 */
	public void augmenterMenhir(int nbMenhirAIncrementer) {
		setNbMenhir(nbMenhir + nbMenhirAIncrementer);
	}

	/**
	 * Diminuer le nombre de Menhirs
	 */
	public void diminuerMenhir(int nbMenhirADiminuer) {
		setNbMenhir(Math.max(0, nbMenhir - nbMenhirADiminuer));
		
	}

	/**
	 * Incrementer le nombre de Graines
	 */
	public void augmenterGraine(int nbGraineAIncrementer) {
		setNbGraine(nbGraine + nbGraineAIncrementer);

	}

	/**
	 * Diminuer le nombre de Graines
	 */
	public void diminuerGraine(int nbGraineADiminuer) {
		setNbGraine(Math.max(0, nbGraine - nbGraineADiminuer));

	}
	
	public String toString(){
		String maChaine="";
		maChaine += "nombre de Graine :"+nbGraine+"\n";
		maChaine += "nombre de Menhir :"+nbMenhir+"\n";
		return maChaine;
	}
	
}
