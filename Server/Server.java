import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {
            Cart cart = new Cart();
            
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            System.out.println("Server has been started...");

            Product Laptop = new Product("Aspire", "Acer", "Laptop", 15, 3740.91, 4000.50);
            Product MobilePhone = new Product("Xen", "Chingchong", "MobilePhone", 5, 10233.82, 20565.20);
            Product Charger = new Product("LCharge","Lenovo Charger", "Charger", 8, 841.55, 1000.00);
            Product PowerBank = new Product("P1Bank","Panasonic", "PowerBank", 2, 44.12, 100.00);
            
            ProductInterface stub_laptop = (ProductInterface) UnicastRemoteObject.exportObject(Laptop, 0);
			ProductInterface stub_mobilePhone = (ProductInterface) UnicastRemoteObject.exportObject(MobilePhone, 0);
            ProductInterface stub_charger = (ProductInterface) UnicastRemoteObject.exportObject(Charger, 0);
			ProductInterface stub_powerBank = (ProductInterface) UnicastRemoteObject.exportObject(PowerBank, 0);
            
            CartInterface stub_cart = (CartInterface) UnicastRemoteObject.exportObject(cart, 0);

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            registry.rebind("laptop", stub_laptop);
            registry.rebind("mobilePhone", stub_mobilePhone);
            registry.rebind("charger", stub_charger);
			registry.rebind("powerBank", stub_powerBank);
            
            registry.rebind("access_cart", stub_cart);

            System.out.println(Laptop.ViewProduct()+ "\n");
            System.out.println(MobilePhone.ViewProduct()+ "\n");
            System.out.println(Charger.ViewProduct()+ "\n");
            System.out.println(PowerBank.ViewProduct()+ "\n");

            System.out.println("Exporting and binding of Objects has been completed...");
            System.out.println("Access Cart..");
        } catch (Exception e) {
            System.out.println("Some server error..." + e);
        }
    }
}



// CLI Server - start rmiregistry 9100
// CLI Server - compile and run
// CLI Client - compile and run