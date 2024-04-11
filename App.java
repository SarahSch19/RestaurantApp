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
        int total = this.computeByOrderType();
        if (formule.cafeOffert(this.order)) {
            System.out.print(" avec café offert!");
        } else {
            if (!this.order.coffee) {
                total += 1;
            }
        }
        return total;
    }

    private int computeByOrderType() {
        int total = switch (this.order.type) {
            case ASSIETTE -> this.formule.baseAssiette;
            case SANDWICH -> this.formule.baseSandwich;
        };
        switch (this.order.size) {
            case PETIT -> total += formule.petiteFormule(order.drinkSize);
            case MOYEN -> total = formule.moyenneFormule(total, this.order.drinkSize, this.order.type);
            case GRAND -> total = formule.grandeFormule(total, this.order.drinkSize, this.order.type);
        }
        return total;
    }
}