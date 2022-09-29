package DomainObject;

public class Product {
	private int ProductId;
	private String ProductName;
	private float ListPrice;
	
	public Product(int productId, String productName, float listPrice) {
		super();
		ProductId = productId;
		ProductName = productName;
		ListPrice = listPrice;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public float getListPrice() {
		return ListPrice;
	}
	public void setListPrice(float listPrice) {
		ListPrice = listPrice;
	}
	
	public Product() {
		
	}
	
}
