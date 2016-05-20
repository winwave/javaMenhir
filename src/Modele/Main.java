package Modele;

import Controle.Controller;
import Vue.Fenetre;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fenetre a = new Fenetre();
		Controller ctrl = new Controller();
		a.setController(ctrl);
	}
}