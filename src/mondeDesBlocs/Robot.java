package mondeDesBlocs;

public class Robot {
    private Cube cubeTenu;

    private Cube getCubeTenu() {
        // Automatically generated method. Please do not modify this code.
        return this.cubeTenu;
    }

    private void setCubeTenu(final Cube value) {
        // Automatically generated method. Please do not modify this code.
        this.cubeTenu = value;
    }

    private Table table;

    private Table getTable() {
        // Automatically generated method. Please do not modify this code.
        return this.table;
    }

    private void setTable(final Table value) {
        // Automatically generated method. Please do not modify this code.
        this.table = value;
    }
    
    public Robot(final Table table) {
    	this.table = table;
    }
    
    private Couleur validerCouleur(Couleur couleur) {
    	Couleur nouvCouleur;
    	
    	if (couleur != null) {
    		nouvCouleur = couleur;
    	} else {
    		nouvCouleur = Couleur.rouge;
    	}
    	return nouvCouleur;
    }
    
    private Taille validerTaille(Taille taille) {
    	Taille nouvTaille;
    	
    	if (taille != null) {
    		nouvTaille = taille;
    	} else {
    		nouvTaille = Taille.grand;
    	}
    	return nouvTaille;
    }

    // Permet de créer un cube
    public void creerCube(final Couleur couleur, final Taille taille) {
    	if (!tientCube()) {
        	Couleur couleurFinale = validerCouleur(couleur);
        	Taille tailleFinale = validerTaille(taille);
        	
    		Cube nouveau = new Cube(couleurFinale, tailleFinale);
    		setCubeTenu(nouveau);
    	} else {
    		System.out.println("Le robot tient déjà un cube !");
    	}
    }

    // Permet de verifier si le robot tient un cube
    private boolean tientCube() {
        return getCubeTenu() != null;
    }

    // Saisis un cube
    public void saisirCube(final Cube cube) {
    	setCubeTenu(cube);
    }

    // Supprime le cube tenu
    public void supprimerCube() {
    	if (tientCube()) {
    		saisirCube(null);
    	} else {
    		System.out.println("Vous ne tenez pas de cube, nous ne pouvons pas le supprimer !");
    	}
    }

    // Prend un cube sur la table
    public void prendreCube(final Couleur couleur, final Taille taille) {
        if (!tientCube()) {
            Cube nouvCube = table.getCube(couleur, taille);
            
            if (nouvCube != null) {
                saisirCube(nouvCube);
                System.out.print("Vous tenez le cube : ");
                nouvCube.afficher();
            } else {
                System.out.println("Aucun cube correspondant n'a été trouvé au sommet !");
            }
        } else {
            System.out.println("Le robot tient déjà un cube !");
        }
    }

    // Pose le cube tenu sur la table
    public void poserCubeSurTable() {
    	if (tientCube()) {
    		Cube cube = this.getCubeTenu();
    		Table table = getTable();
    		
    		table.poserSurTable(cube);
    		saisirCube(null);
    	} else {
    		System.out.println("Vous ne pouvez pas poser un cube inexistant !");
    	}
    }

    // Pose le cube tenu sur un autre cube
    public void poserCubeSurCube(final Couleur couleur, final Taille taille) {
        if (tientCube()) {
            Table table = this.getTable();
            
            Cube cubeAMettre = getCubeTenu();

            boolean reussite = table.poserCubeSurCube(cubeAMettre, couleur, taille);
            
            if (reussite) {
                saisirCube(null);
            }
        } else {
            System.out.println("Vous ne tenez pas de cube !");
        }
    }
    
    public void afficherRobot() {
        System.out.println("--- État du Robot ---");
        if (tientCube()) {
            System.out.print("Le robot tient le cube : ");
            this.getCubeTenu().afficher(); 
        } else {
            System.out.println("Le robot a les mains vides.");
        }
    }

}
