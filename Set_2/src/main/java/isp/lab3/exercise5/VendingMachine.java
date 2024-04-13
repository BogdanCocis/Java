package isp.lab3.exercise5;

import java.sql.SQLOutput;
import java.util.*;

public class VendingMachine {
    private int idProduct;
    private static String nameProduct;
    private static double costProduct;
    private int quantity;
    private int valueInsert;
    private List<VendingMachine> products;
    private Map<Integer, String> productNames;

    public VendingMachine(Map<Integer, String> productNames) {
        this.productNames = productNames;
    }

    public Map<Integer, String> getProductNames() {
        return productNames;
    }

    public void addProduct(int productId, String productName) {
        productNames.put(productId, productName);
    }

    public void setProductNames(Map<Integer, String> productNames) {
        this.productNames = productNames;
    }

    public VendingMachine(int idProduct, String nameProduct, double costProduct, int quantity, int valueInsert, List<VendingMachine> products) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.costProduct = costProduct;
        this.quantity = quantity;
        this.valueInsert = valueInsert;
        this.products = products;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public static String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public static double getCostProduct() {
        return costProduct;
    }

    public void setCostProduct(double costProduct) {
        this.costProduct = costProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getValueInsert() {
        return valueInsert;
    }

    public void setValueInsert(int valueInsert) {
        this.valueInsert = valueInsert;
    }

    public List<VendingMachine> getProducts() {
        return products;
    }

    public void setProducts(List<VendingMachine> products) {
        this.products = products;
    }

    public void displayProducts() {
        for (VendingMachine produstd : products)
            System.out.println("Product name: " + VendingMachine.getNameProduct() + " cost: " + VendingMachine.getCostProduct());
    }

    public void addProduct(VendingMachine product) {
        this.products.add(product);
    }

    public int insertCoin() {
        if (costProduct > valueInsert) {
            System.out.println("Insufficient funds!");
            return 0;
        } else if (costProduct == valueInsert && !products.isEmpty()) {
            return products.remove(0).getIdProduct();
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VendingMachine)) return false;
        VendingMachine that = (VendingMachine) o;
        return getIdProduct() == that.getIdProduct() && getQuantity() == that.getQuantity() && getValueInsert() == that.getValueInsert() && Objects.equals(getProducts(), that.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdProduct(), getQuantity(), getValueInsert(), getProducts());
    }

    public String selectProduct(int idProduct) {
        String productName = productNames.get(idProduct);
        if (productName != null) {
            return "Product selected are: " + productName;
        } else {
            return "Product id: " + idProduct + " don't exist.";
        }
    }

    public void userMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu, choose an option:");
            System.out.println("1. Buy product");
            System.out.println("2. Check menu");
            System.out.println("3. Exit");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Input product id: ");
                    int productId = scanner.nextInt();
                    String selectedProduct = selectProduct(productId);
                    System.out.println(selectedProduct);
                    break;
                case 2:
                    System.out.println("Current menu:");
                    for (Map.Entry<Integer, String> entry : productNames.entrySet()) {
                        System.out.println("ID: " + entry.getKey() + ", Product: " + entry.getValue());
                    }
                    break;
                case 3:
                    exit = true;
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

}