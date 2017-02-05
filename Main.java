

public class Main {
	public static void main(String[] args){
		StorageManager store = new StorageManager();
		StoreCapable capable = new PresistentStore();
		store.addStorage(capable);
		store.addCDProduct("120 válogatott mulatós", 500, 120);
		store.addBookProduct("Villáskulcsok kézikönyve 52-dik kiadás", 3000, 846);
		System.out.println(store.listProducts());
		System.out.println(store.getTotalProductPrice());


		
		
	}

}
