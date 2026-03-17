import java.util.Random;

public class CanardConfus extends CanardEau {

    private Random random = new Random();

    public CanardConfus(String surnom) {
        super(surnom);
    }

    @Override
    public void attaquer(CanardDeCombat cible) {
        if (random.nextInt(4) == 0) {
            System.out.println(getSurnom() + " est confus ! Il se cogne la tête... Coin coin ?");
            effectuerAttaque(this, 0.5);
        } else {
            super.attaquer(cible);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " 🤪";
    }
}