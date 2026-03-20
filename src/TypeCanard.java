public enum TypeCanard {
    FEU, EAU, PLANTE, NORMAL;

    public double getMultiplicateur(TypeCanard cible) {

        if (this == FEU) {
            if (cible == PLANTE) return 2.0;
            if (cible == EAU) return 0.5;
        }

        if (this == EAU) {
            if (cible == FEU) return 2.0;
            if (cible == PLANTE) return 0.5;
        }

        if (this == PLANTE) {
            if (cible == EAU) return 2.0;
            if (cible == FEU) return 0.5;
        }

        return 1.0;
    }
}