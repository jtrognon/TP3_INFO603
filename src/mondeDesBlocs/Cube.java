package mondeDesBlocs;


public class Cube {
    private Taille taille;

    private Taille getTaille() {
        // Automatically generated method. Please do not modify this code.
        return this.taille;
    }

    private void setTaille(final Taille value) {
        // Automatically generated method. Please do not modify this code.
        this.taille = value;
    }

    private String couleur;

    private String getCouleur() {
        // Automatically generated method. Please do not modify this code.
        return this.couleur;
    }

    private void setCouleur(final String value) {
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

    public Cube(final String couleur, final Taille taille) {
        // TODO Auto-generated return
    }

    public boolean estMemeCouleur(final String couleur) {
        // TODO Auto-generated return
        return false;
    }

    public Cube getSuivant() {
        // TODO Auto-generated return
        return null;
    }

    public void setSuivant(final Cube cube) {
    }

    public boolean peutAccueillir(final Taille taille) {
        // TODO Auto-generated return
        return false;
    }

}
