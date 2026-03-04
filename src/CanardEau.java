public class CanardEau extends CanardDeCombat {

    public CanardEau(String surnom) {
        super("Canard Marin", 44, 48);
        setSurnom(surnom);
    }

    @Override
    public String getType() { return "Eau"; }

    @Override
    public void attaquer(CanardDeCombat cible) {
        double mult = cible.etreAttaqueePar(this);
        effectuerAttaque(cible, mult);
    }

    @Override
    public double etreAttaqueePar(CanardFeu attaquant) { return 0.5; }

    @Override
    public double etreAttaqueePar(CanardEau attaquant) { return 0.5; }

    @Override
    public double etreAttaqueePar(CanardPlante attaquant) { return 2.0; }
}