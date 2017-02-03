import java.util.ArrayList;

public class PersistentStore extends Store
{
    private ArrayList<Product> productArrayList;

    public ArrayList<Product> getProductArrayList()
    {
        return productArrayList;
    }

    public void storeProduct(Product product)
    {
        productArrayList.add(product);
    }
}
