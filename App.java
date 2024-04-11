public class App {
    private Order order;
    private Formule formule = new Formule();

    public App(Order order) {
        this.order = order;
    }

    // calcule le prix payé par l'utilisateur dans le restaurant, en fonction de type de
    // repas qu'il prend (assiette ou sandwich), de la taille de la boisson (petit, moyen, grand), du dessert et
    // de son type (normal ou special) et si il prend un café ou pas (yes ou no).
    // les prix sont fixes pour chaque type de chose mais des réductions peuvent s'appliquer
    // si cela rentre dans une formule!
    public int Compute() {
        // prix total à payer pour le client
        int total = 0;

        // si le client prends un plat en assiette
        switch (this.order.type) {
            case ASSIETTE -> total = this.computeAssiette();
            case SANDWICH -> total = this.computeSandwich();
        }
        if (this.cafeOffert()) {
            System.out.print(" avec café offert!");
        } else {
            // Assume coffee costs 1 unit, adding to the total only if coffee is not included
            if (!this.order.coffee) {
                total += 1;
            }
        }
        return total;
    }

    private boolean cafeOffert() {
        return this.order.type == Type.ASSIETTE && this.order.size == OrderSize.MOYEN && this.order.drinkSize == DrinkSize.NORMAL && this.order.coffee;
    }

    private int computeAssiette() {
        int total = 15;

        // ainsi qu'une boisson de taille:
        switch (this.order.size) {
            case PETIT -> total += formule.petiteFormule(order.drinkSize);
            // si on prends moyen
            case MOYEN -> {
                total += formule.moyenneFormule();
                // dans ce cas, on applique la formule standard
                if (this.order.drinkSize == DrinkSize.NORMAL) {
                    // j'affiche la formule appliquée
                    System.out.print("Prix Formule Standard appliquée ");
                    // le prix de la formule est donc 18
                    total = 18;
                } else {
                    // sinon on rajoute le prix du dessert special
                    total += 4;
                }
            }
            case GRAND -> {
                total += formule.grandeFormule();
                // dans ce cas, on applique la formule standard
                if (this.order.drinkSize == DrinkSize.NORMAL) {
                    // pas de formule
                    // on ajoute le prix du dessert normal
                    total += 2;
                } else {
                    // dans ce cas on a la fomule max
                    System.out.print("Prix Formule Max appliquée ");
                    total = 21;
                }
            }
        }
        return total;
    }

    private int computeSandwich() {
        int total = 10;
        // ainsi qu'une boisson de taille:
        switch (this.order.size) {
            case PETIT -> total += formule.petiteFormule(order.drinkSize);

            // si on prends moyen
            case MOYEN -> {
                total += formule.moyenneFormule();
                // dans ce cas, on applique la formule standard
                if (this.order.drinkSize == DrinkSize.NORMAL) {
                    // j'affiche la formule appliquée
                    System.out.print("Prix Formule Standard appliquée ");
                    // le prix de la formule est donc 13
                    total = 13;
                } else {
                    // sinon on rajoute le prix du dessert special
                    total += 4;
                }
            }
            case GRAND -> {
                total += formule.grandeFormule();
                // dans ce cas, on applique la formule standard
                if (this.order.drinkSize == DrinkSize.NORMAL) {
                    // pas de formule
                    // on ajoute le prix du dessert normal
                    total += 2;
                } else {
                    // dans ce cas on a la fomule max
                    System.out.print("Prix Formule Max appliquée ");
                    total = 16;
                }
            }
        }
        return total;
    }

}