import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Customer {
    public static void main(String[] args) {
        try {
            // Locate the registry.
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            // Get the references of exported object from the RMI Registry...
            ProductInterface laptop = (ProductInterface) registry.lookup("laptop");
            ProductInterface mobilePhone = (ProductInterface) registry.lookup("mobilePhone");
            ProductInterface charger = (ProductInterface) registry.lookup("charger");
            ProductInterface powerBank = (ProductInterface) registry.lookup("powerBank");

            CartInterface cart = (CartInterface) registry.lookup("access_cart");

            cart.addProduct(powerBank);
            System.out.println("Product Power Bank is added to cart! \n");

            System.out.println(cart.viewAddedProducts());

        } catch (Exception e) {
            System.out.println("Client side error..." + e);
        }
    }
}