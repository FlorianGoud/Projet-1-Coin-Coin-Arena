public class CanardFeu extends CanardDeCombat {

    private double intensiteFlamme;

    public CanardFeu(String surnom, double intensiteFlamme) {
        super("Canard Flamme", 39, 52);
        setSurnom(surnom);
        this.intensiteFlamme = intensiteFlamme;
    }

    @Override
    public String getType() { return "Feu"; }

    @Override
    public void attaquer(CanardDeCombat cible) {
        double mult = cible.etreAttaqueePar(this) * intensiteFlamme;
        effectuerAttaque(cible, mult);
    }

    @Override
    public double etreAttaqueePar(CanardEau attaquant) { return 2.0; }

    @Override
    public double etreAttaqueePar(CanardPlante attaquant) { return 0.5; }
}