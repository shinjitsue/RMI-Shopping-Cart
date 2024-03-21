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

            Scanner scanner = new Scanner(System.in);
            String userChoice;
            do {
                System.out.println("Enter the product you want to add to the cart: \n1. Laptop \n2. Mobile Phone \n3. Charger \n4. Power Bank \n5. View Cart \n6. Exit");
                System.out.print("Enter your choice: ");
                userChoice = scanner.nextLine();

                switch (userChoice) {
                    case "1":
                        cart.addProduct(laptop);
                        System.out.println("Laptop is added to cart! \n");
                        break;
                    case "2":
                        cart.addProduct(mobilePhone);
                        System.out.println("Mobile Phone is added to cart! \n");
                        break;
                    case "3":
                        cart.addProduct(charger);
                        System.out.println("Charger is added to cart! \n");
                        break;
                    case "4":
                        cart.addProduct(powerBank);
                        System.out.println("Power Bank is added to cart! \n");
                        break;
                    case "5":
                        System.out.println(cart.viewAddedProducts());
                        break;
                    case "6":
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } while (!userChoice.equals("6"));

        } catch (Exception e) {
            System.out.println("Client side error..." + e);
        }
    }
}