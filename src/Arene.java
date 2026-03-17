public class Arene {

    public static void combattre(Equipe e1, Equipe e2) {

        System.out.println("=== COMBAT ===");

        int tour = 1;

        while (!e1.touteKO() && !e2.touteKO()) {

            System.out.println("\nTour " + tour);

            CanardDeCombat c1 = e1.getPremierValide();
            CanardDeCombat c2 = e2.getPremierValide();

            c1.attaquer(c2);
            if (!c2.estKO()) c2.attaquer(c1);

            tour++;
        }

        System.out.println("\n=== FIN DU COMBAT ===");
        if (e1.touteKO()) System.out.println("Victoire équipe 2 !");
        else System.out.println("Victoire équipe 1 !");
    }
}