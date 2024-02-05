package com.customer.DAOImpl;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.customer.DAO.CustomerDAO;
import com.customer.Model.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	private static final String INSERT_QUERY = "INSERT INTO `customer` (`customerId`,`first_name`, `last_name`, `street`, `address`, `city`, `state`, `email`, `phone_number`) VALUES (?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_QUERY = "UPDATE `customer` SET  `first_name`=?, `last_name`=?, `street`=?, `address`=?, `city`=?, `state`=?,  `email`=?,  `phone_number`=? WHERE (`customerId`=?)";
	private static final String DELETE_QUERY = "DELETE FROM `customer` WHERE (`customerId`=?)";
	private static final String SELECT_QUERY1 = "SELECT * FROM `customer` WHERE (`first_name`=?)";
	private static final String SELECT_QUERY2 = "SELECT * FROM `customer` WHERE (`city`=?)";
	private static final String SELECT_QUERY3 = "SELECT * FROM `customer` WHERE (`email`=?)";
	private static final String SELECT_QUERY4 = "SELECT * FROM `customer` WHERE (`phone_number`=?)";
	private static final String SELECT_QUERY5 = "SELECT * FROM `customer` WHERE (`customerId`=?)";
	private static final String SELECTALL_QUERY = "SELECT * FROM `customer`";

	private static Connection connection;
	private static PreparedStatement prepareStatement;
	private static Statement statement;
	private static ResultSet res;

	public CustomerDAOImpl() {// String first_name, String last_name, String street, String city, String
								// state,
		// String email, int phone_number
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addCustomer(Customer customer) {

		try {
			if(getCustomerById(customer.getUserid())==null) {
			prepareStatement = connection.prepareStatement(INSERT_QUERY);
			
			
			prepareStatement.setString(1, customer.getUserid().trim());
			prepareStatement.setString(2, customer.getFirst_name().trim());
			prepareStatement.setString(3, customer.getLast_name().trim());
			prepareStatement.setString(4, customer.getStreet().trim());
			prepareStatement.setString(5, customer.getAddress().trim());
			prepareStatement.setString(6, customer.getCity().trim());
			prepareStatement.setString(7, customer.getState().trim());
			prepareStatement.setString(8, customer.getEmail().trim());
			prepareStatement.setLong(9, customer.getPhone_number());

			int i = prepareStatement.executeUpdate();
//			System.out.println(i);
			}else {
				
				updateCustomer(customer);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub

		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);

			prepareStatement.setString(1, customer.getFirst_name().trim());
			prepareStatement.setString(2, customer.getLast_name().trim());
			prepareStatement.setString(3, customer.getStreet().trim());
			prepareStatement.setString(4, customer.getAddress().trim());
			prepareStatement.setString(5, customer.getCity().trim());
			prepareStatement.setString(6, customer.getState().trim());
			prepareStatement.setString(7, customer.getEmail().trim());
			prepareStatement.setLong(8, customer.getPhone_number());
			prepareStatement.setString(9, customer.getUserid().trim());

			int i = prepareStatement.executeUpdate();
			System.out.println(i);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCustomer(String customerId) {
		// TODO Auto-generated method stub

		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);

			prepareStatement.setString(1, customerId.trim());

			int executeUpdate = prepareStatement.executeUpdate();
			System.out.println(executeUpdate);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Customer> getAllCustomer() {

		try {
			statement = connection.createStatement();
			res = statement.executeQuery(SELECTALL_QUERY);

			List<Customer> list = new ArrayList<Customer>();
			// `first_name`, `last_name`, `street`, `city`, `state`, `email`, `phone_number
			while (res.next()) {
				Customer c = new Customer(res.getString("customerId"), res.getString("first_name"), res.getString("last_name"),
						res.getString("street"),res.getString("address"), res.getString("city"), res.getString("state"), res.getString("email"),
						res.getLong("phone_number"));
				list.add(c);

			}

			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Customer> getCustomerByFirst_name(String first_name) {
		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY1);
			prepareStatement.setString(1, first_name.trim());

			res = prepareStatement.executeQuery();

			List<Customer> list = new ArrayList<Customer>();
			// `first_name`, `last_name`, `street`, `city`, `state`, `email`, `phone_number
			while (res.next()) {
				Customer c = new Customer(res.getString("customerId"), res.getString("first_name"), res.getString("last_name"),
						res.getString("street"),res.getString("address"), res.getString("city"), res.getString("state"), res.getString("email"),
						res.getLong("phone_number"));
				list.add(c);
			}

			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> getCustomerByEmail(String email) {
		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY3);
			prepareStatement.setString(1, email.trim());

			res = prepareStatement.executeQuery();

			List<Customer> list = new ArrayList<Customer>();
			// `first_name`, `last_name`, `street`, `city`, `state`, `email`, `phone_number
			while (res.next()) {
				Customer c = new Customer(res.getString("customerId"), res.getString("first_name"), res.getString("last_name"),
						res.getString("street"),res.getString("address"), res.getString("city"), res.getString("state"), res.getString("email"),
						res.getLong("phone_number"));
				list.add(c);
			}

			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> getCustomerByCity(String city) {
		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY2);
			prepareStatement.setString(1, city.trim());

			res = prepareStatement.executeQuery();
			System.out.println("hi");

			List<Customer> list = new ArrayList<Customer>();
			// `first_name`, `last_name`, `street`, `city`, `state`, `email`, `phone_number
			while (res.next()) {

				Customer c = new Customer(res.getString("customerId"), res.getString("first_name"), res.getString("last_name"),
						res.getString("street"),res.getString("address"), res.getString("city"), res.getString("state"), res.getString("email"),
						res.getLong("phone_number"));
				list.add(c);
			}

			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> getCustomerByPhone_number(long phone_number) {
		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY4);
			prepareStatement.setLong(1, phone_number);

			res = prepareStatement.executeQuery();

			List<Customer> list = new ArrayList<Customer>();
			// `first_name`, `last_name`, `street`, `city`, `state`, `email`, `phone_number
			while (res.next()) {
				Customer c = new Customer(res.getString("customerId"), res.getString("first_name"), res.getString("last_name"),
						res.getString("street"),res.getString("address"), res.getString("city"), res.getString("state"), res.getString("email"),
						res.getLong("phone_number"));
				list.add(c);
			}

			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer getCustomerById(String customerId) {
		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY5);
			prepareStatement.setString(1, customerId.trim());
			res = prepareStatement.executeQuery();
			
			while(res.next()) {
				Customer c = new Customer(res.getString("customerId"), res.getString("first_name"), res.getString("last_name"),
						res.getString("street"),res.getString("address"), res.getString("city"), res.getString("state"), res.getString("email"),
						res.getLong("phone_number"));
			return c;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
