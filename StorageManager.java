

public class StorageManager {
	private StoreCapable storage;
	public void addStorage(StoreCapable storage){
		this.storage = storage;

		
	}
	public void addCDProduct(String name, int price, int tracks){
		storage.storeCDProduct(name, price, tracks);
	}

	public void addBookProduct(String name, int price, int size){
		storage.storeBookProduct(name, price, size);
	}
	public String listProducts(){
		String products = "";
		for(Product product:storage.getAllProducts()){
			products += product.name + ", ";
			
		}
		return products;
		
	}
	public int getTotalProductPrice(){
		int price = 0;
		for(Product product:storage.getAllProducts()){
			price += product.price;
			
		}
		return price;
	}

}
