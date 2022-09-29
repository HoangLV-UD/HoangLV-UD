package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DomainObject.Customer;
import JDBC.jdbc;

public class CustomerDao implements InterfaceCustomer{
	private final String insert ="insert into Customer (CustomerName) values (?)";
	private final String  update= "update Customer set CustomerName = ? Where CustomerId = ?";
	private final String delete = "delete from Customer Where CustomerId= ?";
	private final String selectAll= "select *from Customer";
	private final String selectById ="select *from Customer where CustomerId=?";
	@Override
	public void insert(Customer c) {
		jdbc.update(insert, c.getCustomerName());
		
	}

	@Override
	public void update(Customer c) {
		jdbc.update(update, c.getCustomerName(),
							c.getCustomerId());
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		jdbc.update(delete, id);
			
	}

	@Override
	public List<Customer> selectAll() {
		
		return selectBySQL(selectAll);
	}

	@Override
	public Customer selectId(String id) {
		List<Customer> lst = selectBySQL(selectById, id);
		if(lst.isEmpty()) {
		return null;
		}
		return lst.get(0);
	}

	@Override
	public List<Customer> selectBySQL(String sql, Object... args) {
		List<Customer> lst = new ArrayList<>();
		try {
			ResultSet rs = jdbc.query(sql, args);
			while(rs.next()) {
				Customer c = new Customer();
				c.setCustomerId(rs.getInt("CustomerId"));
				c.setCustomerName(rs.getString("CustomerName"));
				lst.add(c);
			}
			rs.getStatement().getConnection().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}
	 

}
