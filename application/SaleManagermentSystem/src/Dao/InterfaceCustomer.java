package Dao;

import DomainObject.Customer;
import java.util.List;

public interface InterfaceCustomer {
	abstract public void insert(Customer c);
	
	abstract public void update(Customer c);
	
	abstract public void delete(int id);
	
	abstract public  List<Customer> selectAll();
	
	abstract public Customer selectId(String id);
	abstract public List<Customer> selectBySQL(String sql, Object...args);
}