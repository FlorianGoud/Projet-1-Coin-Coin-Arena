public class CanardClassique extends CanardDeCombat {

    public CanardClassique(String surnom) {
        super("Canard Classique", 50, 45);
        setSurnom(surnom);
    }

    @Override
    public String getType() { return "Normal"; }

    @Override
    public void attaquer(CanardDeCombat cible) {
        double mult = cible.etreAttaqueePar(this);
        effectuerAttaque(cible, mult);
    }
}