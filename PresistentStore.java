
public class PresistentStore extends Store{
	

	
	public void storeProduct(Product product){
		
		getAllProducts().add(product);
		
	}

}
