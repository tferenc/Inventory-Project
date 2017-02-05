
public class BookProduct extends Product{
	int pageSize;

	public BookProduct(String name, Integer price,int pageSize){
		super(name, price);
		this.pageSize = pageSize;
	}
}
