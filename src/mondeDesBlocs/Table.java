package mondeDesBlocs;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<Cube> cubes = new ArrayList<Cube> ();

    private List<Cube> getCubes() {
        // Automatically generated method. Please do not modify this code.
        return this.cubes;
    }

    private void setCubes(final List<Cube> value) {
        // Automatically generated method. Please do not modify this code.
        this.cubes = value;
    }

    // Récupère le cube de taille et de couleur données
    public Cube getCube(final String couleur, final Taille taille) {
    	Cube trouve = contientCube(couleur, taille);
    	
    	if (trouve != null) {
    		return depiler(trouve);
    	}
    	
        return null;
    }

    // Verifie s'il y a un cube de taille taille et de couleur couleur
    private Cube contientCube(final String couleur, final Taille taille) {
    	for (Cube c : cubes) {
    		if (c.estMemeCouleur(couleur) && c.peutAccueillir(taille)) {
    			return c;
    		}
    	}
        return null;
    }

    // pose le cube sur la table
    public void poserSurTable(final Cube cube) {
    	ajouterTetePile(cube);
    }

    // Ajoute un cube en tête de pile
    private void ajouterTetePile(final Cube tete) {
    	if (tete != null) {
    		cubes.add(tete);
    	}
    }

    // Retire un cube en tête de pile
    private void retirerTetePile(final Cube tete) {
    	cubes.remove(tete);
    }

    // Pose un cube sur un cube
    public void poserCubeSurCube(final Cube cube, final String couleur, final Taille taille) {
    	Cube c = contientCube(couleur, taille);
    	if (c != null) {
    		empilerCubeSurCube(cube,c);
    	} else {
    		System.out.println("Nous n'avons pas trouvé de cube disponible ...");
    	}
    }

    // Empile un cube sur un autre cube
    private void empilerCubeSurCube(final Cube ancienneTete, final Cube nouvelleTete) {
    	nouvelleTete.setSuivant(ancienneTete);
    	retirerTetePile(ancienneTete);
    	ajouterTetePile(nouvelleTete);
    }

    // Dépile un cube
    public Cube depiler(final Cube cube) {
        retirerTetePile(cube);
        
        Cube dessous = cube.getSuivant();
        if (dessous != null) {
        	ajouterTetePile(dessous);
        	cube.setSuivant(null);
        }
        return cube;
    }

}
