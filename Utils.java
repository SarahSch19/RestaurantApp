public class Utils {
    public static Type typeFromString(String type) throws Exception {
        return switch (type.toLowerCase()) {
            case "assiette" -> Type.ASSIETTE;
            case "sandwich" -> Type.SANDWICH;
            default -> throw new Exception("Invalid type: " + type);
        };
    }

    public static DrinkSize drinkSizeFromString(String size) throws Exception {
        return switch (size.toLowerCase()) {
            case "petit" -> DrinkSize.PETIT;
            case "normal" -> DrinkSize.NORMAL;
            case "grand" -> DrinkSize.GRAND;
            default -> throw new Exception("Invalid size: " + size);
        };
    }

    public static OrderSize orderSizeFromString(String size) throws Exception {
        return switch (size.toLowerCase()) {
            case "petit" -> OrderSize.PETIT;
            case "moyen" -> OrderSize.MOYEN;
            case "grand" -> OrderSize.GRAND;
            default -> throw new Exception("Invalid size: " + size);
        };
    }
}
