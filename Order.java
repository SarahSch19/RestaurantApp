public class Order {
    public String type;
    public String name;
    public String beverage;
    public String size;
    public String dessert;
    public String dsize;
    public String coffee;

    private Order(String type, String name, String beverage, String size, String dessert, String dsize, String coffee) {
        this.type = type;
        this.name = name;
        this.beverage = beverage;
        this.size = size;
        this.dessert = dessert;
        this.dsize = dsize;
        this.coffee = coffee;
    }

    public static Order fromArgs(String[] args) throws Exception {
        if (args.length != 7) {
            throw new Exception("Invalid number of arguments, 7 required : type, name, beverage, size, dessert, dsize, coffee");
        }
        return new Order(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
    }
}
