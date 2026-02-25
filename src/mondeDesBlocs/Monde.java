package mondeDesBlocs;

import in.keyboard.Keyboard;

public class Monde {
    private Robot robot;

    private Robot getRobot() {
        // Automatically generated method. Please do not modify this code.
        return this.robot;
    }

    private void setRobot(final Robot value) {
        // Automatically generated method. Please do not modify this code.
        this.robot = value;
    }

    private Table tableMonde;

    private Table getTableMonde() {
        // Automatically generated method. Please do not modify this code.
        return this.tableMonde;
    }

    private void setTableMonde(final Table value) {
        // Automatically generated method. Please do not modify this code.
        this.tableMonde = value;
    }
    
	public static void ecrire(Couleur coul, String s) {
		System.out.printf("\033[%d;1m%s\033[0m\n", coul.ordinal()+31, s);
	}
    
	public static void main(String[] args) {
//		Couleur.testCouleur();
		Table tab = new Table();
		Robot D2R2 = new Robot(tab);
		char c = ' ';
		Couleur coul;
		Taille tc;
		do {
		System.out.println("1 - creer un cube");
		System.out.println("2 - détruire un cube");
		System.out.println("3 - prendre un cube");
		System.out.println("4 - poser un cube sur la table");
		System.out.println("5 - poser un cube sur un autre cube");
		System.out.println("f - fin du monde");
		System.out.print("Votre choix : ");
		c = Keyboard.getChar();
		System.out.println();
		switch (c) {
		// Creer un cube
		case '1': 
			System.out.print("Couleur du cube (rouge/vert/jaune/bleu/violet/cyan/gris/noir) : ");
			coul = Couleur.getCouleur(Keyboard.getString());

			System.out.print("Taille du cube (grand/moyen/petit) : ");
			tc = Taille.getTaille(Keyboard.getString());
			D2R2.creerCube(coul, tc);
			System.out.println();
			break;
		// Détruire un cube
		case '2':
			System.out.println("Le cube tenu par le robot va être détruit ");
//			Keyboard.pause();
			D2R2.supprimerCube();
			System.out.println();
			break;
		// Prendre un cube
		case '3' :
			System.out.print("Couleur du cube (rouge/vert/jaune/bleu/violet/cyan/gris/noir) : ");
			coul = Couleur.getCouleur(Keyboard.getString());

			System.out.print("Taille du cube (grand/moyen/petit) : ");
			tc = Taille.getTaille(Keyboard.getString());
			
			D2R2.prendreCube(coul, tc);
			System.out.println();
			break;
		// Poser un cube sur la table
		case '4' :
			System.out.println("Le cube tenu par le robot va être posé sur la table !");
			D2R2.poserCubeSurTable();
			System.out.println();
			break;
		// Poser un cube sur un cube
		case '5' :
			System.out.print("Couleur du cube (rouge/vert/jaune/bleu/violet/cyan/gris/noir) : ");
			coul = Couleur.getCouleur(Keyboard.getString());

			System.out.print("Taille du cube (grand/moyen/petit) : ");
			tc = Taille.getTaille(Keyboard.getString());
			D2R2.poserCubeSurCube(coul, tc);
			System.out.println();
			break;
		}
		afficherMonde(D2R2, tab);
		} while (c != 'f');
	}

	private static void afficherMonde(Robot R, Table T) {
		R.afficherRobot();
		System.out.println();
		T.afficherTable();
		System.out.println();
//		Keyboard.pause();
	
	}


}
