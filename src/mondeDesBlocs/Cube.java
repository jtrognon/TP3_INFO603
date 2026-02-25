package mondeDesBlocs;


public class Cube {
    private Taille taille;

    public Taille getTaille() {
        // Automatically generated method. Please do not modify this code.
        return this.taille;
    }

    private void setTaille(final Taille value) {
        // Automatically generated method. Please do not modify this code.
        this.taille = value;
    }

    private Couleur couleur;

    private Couleur getCouleur() {
        // Automatically generated method. Please do not modify this code.
        return this.couleur;
    }

    private void setCouleur(final Couleur value) {
        // Automatically generated method. Please do not modify this code.
        this.couleur = value;
    }

    private Cube dessus;

    private Cube getDessus() {
        // Automatically generated method. Please do not modify this code.
        return this.dessus;
    }

    private void setDessus(final Cube value) {
        // Automatically generated method. Please do not modify this code.
        this.dessus = value;
    }

    private Cube dessous;

    public Cube(final Couleur couleur, final Taille taille) {
        this.couleur = couleur;
        this.taille = taille;
        this.dessus = null;
        this.dessous = null;
    }

    public boolean estMemeCouleur(final Couleur couleur) {
        return this.couleur == couleur;
    }

    public Cube getSuivant() {
        return this.dessus;
    }

    public void setSuivant(final Cube cube) {
    	this.dessus = cube;
    }

    public boolean peutAccueillir(final Taille taille) {
    	boolean res;
    	
        if (this.taille == null || taille == null) {
        	res = false;
        } else {
        	// Basé sur l'ordre de l'enum (Petit < Moyen < Grand)
        	res = this.taille.ordinal() >= taille.ordinal();
        }
        
        return res;
    }

    public void afficher() {
        System.out.print("[" + this.couleur + " " + this.taille + "]");
        
        if (this.dessus != null) {
            System.out.print(" sur ");
            this.dessus.afficher(); 
        } else {
            System.out.println("");
        }
    }
}
