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
    public Cube getCube(final Couleur couleur, final Taille taille) {
        Cube trouve = null;

        if (couleur == null && taille == null) {
            trouve = contientCubeVide(null); 
        } else if (couleur != null && taille == null) {
            trouve = contientCubeCouleur(couleur, null);
        } else if (couleur == null && taille != null) {
            trouve = contientCubeTaille(taille);
        } else {
            trouve = contientCube(couleur, taille);
        }

        if (trouve != null) {
            return depiler(trouve);
        }
        
        return null;
    }
    
    private Cube contientCubeVide(final Taille tailleDuCubeTenu) {
        for (Cube c : cubes) {
            if (tailleDuCubeTenu == null || c.peutAccueillir(tailleDuCubeTenu)) {
                return c;
            }
        }
        return null;
    }

    private Cube contientCubeCouleur(final Couleur couleur, final Taille tailleDuCubeTenu) {
        for (Cube c : cubes) {
            if (c.estMemeCouleur(couleur)) {
                if (tailleDuCubeTenu == null || c.peutAccueillir(tailleDuCubeTenu)) {
                    return c;
                }
            }
        }
        return null;
    }
    
    private Cube contientCubeTaille(final Taille taille) {
    	for (Cube c : cubes) {
    		if (c.getTaille() == taille) {
    			return c;
    		}
    	}
    	return null;
    }

    // Verifie s'il y a un cube de taille taille et de couleur couleur
    private Cube contientCube(final Couleur couleur, final Taille taille) {
        for (Cube c : cubes) {
            // On vérifie juste si c'est le bon cube (couleur et taille)
            if (c.estMemeCouleur(couleur) && c.getTaille() == taille) {
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
   

    public boolean poserCubeSurCube(final Cube cube, final Couleur couleur, final Taille taille) {
        Cube c = null;
        Taille tTenu = cube.getTaille();
        
        if (couleur == null && taille == null) {
            c = contientCubeVide(tTenu);
        } else if (couleur != null && taille == null) {
            c = contientCubeCouleur(couleur, tTenu);
        } else if (couleur == null && taille != null) {
            c = contientCubeTaille(taille);
        } else {
            c = contientCube(couleur, taille);
        }
        
        if (c != null) {
            if (c.peutAccueillir(cube.getTaille())) {
                empilerCubeSurCube(cube, c);
                return true;
            } else {
                System.out.println("Trop gros !");
                return false;
            }
        }
        System.out.println("Support non trouvé.");
        return false;
    }

    // Empile un cube sur un autre cube
    private void empilerCubeSurCube(final Cube nouvelleTete, final Cube ancienneTete) {
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
    
    public void afficherTable() {
        System.out.println("--- TABLE ---");
        if (cubes.isEmpty()) {
            System.out.println("(La table est vide)");
        } else {
            for (Cube c : cubes) {
                System.out.print("[Pile] ");
                c.afficher();
            }
        }
        System.out.println("-------------");
    }
}
