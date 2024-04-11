public class Main {

    public static void main(String[] args) {
        // pour tester, lancer en ligne de commande :
        // java Program "assiette" "couscous" "coca" "moyen" "baba" "normal" "yes"
        // Note: Make sure the class name matches the file name when compiling and running in Java.
        try {
            Order order = Order.fromArgs(args);
            App app = new App(order);
            int price = app.Compute();
            System.out.println("Prix à payer : " + price + "€");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}