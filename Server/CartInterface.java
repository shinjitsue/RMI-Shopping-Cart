import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CartInterface extends Remote {
    void addProduct(ProductInterface product) throws RemoteException;
    String viewAddedProducts() throws RemoteException;
}