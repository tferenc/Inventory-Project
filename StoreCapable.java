import java.util.*;
public interface StoreCapable
{
    ArrayList<Product> getAllProduct();

    void storeCdProduct(String name, int price, int size) throws Exception;

    void storeBookProduct(String name, int price, int size) throws Exception;

}
