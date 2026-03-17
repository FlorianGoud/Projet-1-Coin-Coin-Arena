public class Equipe {

    private CanardDeCombat[] canards = new CanardDeCombat[6];
    private int taille = 0;
    private final String nomDresseur;

    public Equipe(String nomDresseur) {
        this.nomDresseur = nomDresseur;
    }

    public boolean ajouter(CanardDeCombat c) {
        if (taille >= 6) return false;
        canards[taille++] = c;
        return true;
    }

    public CanardDeCombat getPremierValide() {
        for (int i = 0; i < taille; i++) {
            if (!canards[i].estKO()) return canards[i];
        }
        return null;
    }

    public boolean touteKO() {
        return getPremierValide() == null;
    }

    public void afficher() {
        System.out.println("=== ÉQUIPE de " + nomDresseur + " ===");
        for (int i = 0; i < taille; i++) {
            System.out.println(canards[i]);
        }
        System.out.println();
    }
}