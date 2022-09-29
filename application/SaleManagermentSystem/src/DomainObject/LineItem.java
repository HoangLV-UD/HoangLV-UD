package DomainObject;

public class LineItem {
	private int OrderId;
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	
	
	public LineItem(int orderId, int productId, int quantity, float price) {
		super();
		OrderId = orderId;
		ProductId = productId;
		Quantity = quantity;
		Price = price;
	}
	public LineItem() {
		
	}
	private int ProductId;
	private int Quantity;
	private float Price;
}
