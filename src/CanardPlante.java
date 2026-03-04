public class CanardPlante extends CanardDeCombat {

    public CanardPlante(String surnom) {
        super("Canard Mousse", 45, 49);
        setSurnom(surnom);
    }

    @Override
    public String getType() {
        return "Plante";
    }

    @Override
    public void attaquer(CanardDeCombat cible) {
        double mult = cible.etreAttaqueePar(this);
        effectuerAttaque(cible, mult);
    }

    public void regenerer() {
        int regen = (int)(getPvMax() * 0.1);
        subirDegats(-regen);
        System.out.println(getSurnom() + " régénère " + regen + " PV !");
    }

    @Override
    public String toString() {
        return super.toString() + " | Régénération active";
    }
}