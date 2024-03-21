import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Admin{
	public static void main(String[] args){
		try{
			// Get the references of exported object from RMI Registry...

			//locate the registry.
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            ProductInterface laptop = (ProductInterface) registry.lookup("laptop");
            ProductInterface mobilePhone = (ProductInterface) registry.lookup("mobilePhone");
            ProductInterface charger = (ProductInterface) registry.lookup("charger");
            ProductInterface powerBank = (ProductInterface) registry.lookup("powerBank");

            System.out.println("\nAdmin - View Products");
            System.out.println("=====================");
            System.out.println(laptop.ViewProduct()+ "\n");
            System.out.println(mobilePhone.ViewProduct()+ "\n");
            System.out.println(charger.ViewProduct()+ "\n");
            System.out.println(powerBank.ViewProduct()+ "\n");

		}catch(Exception e){
			System.out.println("Client side error..." + e);
		}
	}
} 