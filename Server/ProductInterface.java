import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProductInterface extends Remote{
	// Lets us define API
	public String getProductcode() throws RemoteException;
	public String getName() throws RemoteException;
	public String getDescription() throws RemoteException;
	public int getQuantity() throws RemoteException;
	public double getRetailprice() throws RemoteException;
	public double getStoreprice() throws RemoteException;
	
	String ViewProduct() throws RemoteException;
}