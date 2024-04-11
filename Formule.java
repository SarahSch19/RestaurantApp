public class Formule {
    private int petiteFormuleBase = 2;
    private int moyenneFormuleBase = 3;
    private int grandeFormuleBase = 4;
    public int baseSandwich = 10;
    public int baseAssiette = 15;

    public Formule() {
    }

    public boolean cafeOffert(Order order) {
        return order.type == Type.ASSIETTE && order.size == OrderSize.MOYEN && order.drinkSize == DrinkSize.NORMAL && order.coffee;
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

    public int moyenneFormule (int total, DrinkSize drinkSize, Type type) {
        total += this.moyenneFormuleBase;
        if (drinkSize == DrinkSize.NORMAL) {
            // j'affiche la formule appliquée
            System.out.print("Prix Formule Standard appliquée ");
            // le prix de la formule est donc 18
            switch (type) {
                case ASSIETTE -> total = 18;
                case SANDWICH -> total = 13;
            }
        } else {
            // sinon on rajoute le prix du dessert special
            total += 4;
        }
        return total;
    }

    public int grandeFormule(int total, DrinkSize drinkSize, Type type) {
        total += this.grandeFormuleBase;
        if (drinkSize == DrinkSize.NORMAL) {
            // pas de formule
            // on ajoute le prix du dessert normal
            total += 2;
        } else {
            // dans ce cas on a la fomule max
            System.out.print("Prix Formule Max appliquée ");
            switch (type) {
                case ASSIETTE -> total = 21;
                case SANDWICH -> total = 16;
            }
        }
        return total;
    }
}