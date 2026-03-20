public class EspeceCanard {

    private final String nom;
    private final TypeCanard type;
    private final int pvBase;
    private final int atkBase;

    public EspeceCanard(String nom, TypeCanard type, int pvBase, int atkBase) {
        this.nom = nom;
        this.type = type;
        this.pvBase = pvBase;
        this.atkBase = atkBase;
    }

    public String getNom() { return nom; }
    public TypeCanard getType() { return type; }
    public int getPvBase() { return pvBase; }
    public int getAtkBase() { return atkBase; }
}