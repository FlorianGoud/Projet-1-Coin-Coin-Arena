public class Main {

    public static void main(String[] args) {

        Equipe e1 = new Equipe("Sacha");
        Equipe e2 = new Equipe("Ondine");

        e1.ajouter(new CanardFeu("Gérard", 1.2));
        e1.ajouter(new CanardConfus("Coin-Coin"));
        e1.ajouter(new CanardPlante("Fernand"));

        e2.ajouter(new CanardEau("Hubert"));
        e2.ajouter(new CanardClassique("Marcel"));
        e2.ajouter(new CanardFeu("Josette", 1.0));

        e1.afficher();
        e2.afficher();

        Arene.combattre(e1, e2);

        System.out.println("\nTotal canards créés : " + CanardDeCombat.getNbCanardsCrees());
    }
}