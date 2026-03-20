public class Canard {

    private final EspeceCanard espece;
    private final String surnom;
    private final int pvMax;
    private int pvActuels;
    private final int atk;

    public Canard(EspeceCanard espece, String surnom) {
        this.espece = espece;
        this.surnom = surnom;
        this.pvMax = espece.getPvBase();
        this.pvActuels = pvMax;
        this.atk = espece.getAtkBase();
    }

    public TypeCanard getType() {
        return espece.getType();
    }

    public boolean estKO() {
        return pvActuels <= 0;
    }

    public void attaquer(Canard cible) {

        double mult = getType().getMultiplicateur(cible.getType());
        int degats = (int)(atk * mult);

        cible.pvActuels -= degats;
        if (cible.pvActuels < 0) {
            cible.pvActuels = 0;
        }

        System.out.println(surnom + " attaque " + cible.surnom);
        System.out.println("Multiplicateur: " + mult);
        System.out.println("Dégâts: " + degats);
    }

    public void soigner(int montant) {
        pvActuels += montant;
        if (pvActuels > pvMax) {
            pvActuels = pvMax;
        }
    }

    public String toString() {
        return surnom + " (" + espece.getNom() + ")"
                + " | Type: " + getType()
                + " | PV: " + pvActuels + "/" + pvMax
                + " | ATK: " + atk;
    }
}