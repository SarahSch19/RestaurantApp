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
        if (formule.cafeOffert(this.order)) {
            System.out.print(" avec café offert!");
        } else {
            if (!this.order.coffee) {
                total += 1;
            }
        }
        return total;
    }

    private int computeAssiette() {
        int total = this.formule.baseAssiette;

        switch (this.order.size) {
            case PETIT -> total += formule.petiteFormule(order.drinkSize);
            case MOYEN -> total += formule.moyenneFormule(total, this.order.drinkSize, this.order.type);
            case GRAND -> total = formule.grandeFormule(total, this.order.drinkSize, this.order.type);
        }
        return total;
    }

    private int computeSandwich() {
        int total = this.formule.baseSandwich;

        switch (this.order.size) {
            case PETIT -> total += formule.petiteFormule(order.drinkSize);
            case MOYEN -> total = formule.moyenneFormule(total, this.order.drinkSize, this.order.type);
            case GRAND -> total = formule.grandeFormule(total, this.order.drinkSize, this.order.type);

        }
        return total;
    }

}