import java.util.ArrayList;

public class StorageManager
{
    private StoreCapable storage;

    public void addStorage(StoreCapable storage)
    {
        this.storage = storage;
    }

    public void addCdProduct(String name, int price, int tracks) throws Exception
    {
        Product cd = ((Store)storage).createProduct("CD", name, price, tracks) ;
        ((Store) storage).store(cd);
    }

    public void addBookProduct(String name, int price, int size) throws Exception
    {
        Product book = ((Store)storage).createProduct("Book", name, price, size);
        ((Store) storage).store(book);
    }

    public String listProducts()
    {
        return null;
    }

    public int getTotalProductPrice()
    {
        return 0;
    }
}
