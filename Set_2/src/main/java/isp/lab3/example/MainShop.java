package isp.lab3.example;


public class MainShop {
    public static void main(String[] args) {
        ShopSingleton shop = ShopSingleton.getInstance();
        ShopSingleton shop1 = ShopSingleton.getInstance();
        System.out.println("Single instance? " + (shop == shop1));
    }
}
