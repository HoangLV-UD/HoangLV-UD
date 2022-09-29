package DomainObject;

import java.util.Date;

public class Orders {
	private int OrderId;
	private Date OrderDate;
	private int CustomerId;
	private int EmployeeId;
	private int  Total;
	
	
	public Orders() {
		
	}

	public Orders(int orderId, Date orderDate, int customerId, int employeeId, int total) {
		super();
		OrderId = orderId;
		OrderDate = orderDate;
		CustomerId = customerId;
		EmployeeId = employeeId;
		Total = total;
	}
	
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		Total = total;
	}
	
	
}
