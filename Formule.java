public class Formule {
    private int petiteFormuleBase = 2;
    private int moyenneFormuleBase = 3;
    private int grandeFormuleBase = 4;

    public Formule() {
    }

    public int petiteFormule (DrinkSize drinkSize) {
        int prix = this.petiteFormuleBase;
        // dans ce cas, on applique la formule standard
        if (drinkSize == DrinkSize.NORMAL) {
            // pas de formule
            // on ajoute le prix du dessert normal
            prix += 2;
        } else {
            // sinon on rajoute le prix du dessert special
            prix += 4;
        }
        return prix;
    }

    public int moyenneFormule () {
        int prix = this.moyenneFormuleBase;
        return prix;
    }

    public int grandeFormule() {
        int prix = this.grandeFormuleBase;
        return prix;
    }
}