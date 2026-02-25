package mondeDesBlocs;

public enum Taille {
    petit, moyen, grand;
	
	 public static Taille getTaille(String tailleSaisie) {
			for (Taille t:Taille.values())
				if (t.name().equalsIgnoreCase(tailleSaisie))
					return t;		
			return null;
		}
}
