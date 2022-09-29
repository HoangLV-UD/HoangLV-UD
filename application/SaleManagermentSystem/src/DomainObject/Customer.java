package DomainObject;

public class Customer {

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	private String CustomerName;

	public Customer() {
		
	}

	private int CustomerId;

	public Customer(int customerId, String customerName) {
		super();
		CustomerId = customerId;
		CustomerName = customerName;
	}
}
