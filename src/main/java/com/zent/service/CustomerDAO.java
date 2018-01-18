package com.zent.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zent.entity.Customer;

import com.zent.util.*;

public class CustomerDAO {
	public static final Logger LOGGER = LoggerFactory.getLogger(CustomerDAO.class);

	public void insert(Customer customer) {
		String sql = "INSERT INTO tbl_customer(name,address,phone,email,gender,birthday) VALUES (?,?,?,?,?,?)";
		Connection conn;
		try {
			conn = DBConnection.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getAddress());
			statement.setString(3, customer.getPhone());
			statement.setString(4, customer.getEmail());
			statement.setInt(5, customer.getGender());
			statement.setDate(6, ConvertUtil.convertDate(customer.getBirthday()));
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
	}

	public void update(Customer customer) {
		String sql = "UPDATE tbl_customer SET name=?,address=?,phone=?,email=?,gender=?,birthday=? WHERE customer_id=?";
		Connection conn;
		try {
			conn = DBConnection.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getAddress());
			statement.setString(3, customer.getPhone());
			statement.setString(4, customer.getEmail());
			statement.setInt(5, customer.getGender());
			statement.setDate(6, ConvertUtil.convertDate(customer.getBirthday()));
			statement.setLong(7, customer.getCustomerId());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
	}

	public void delete(Customer customer) {
		String sql = "DELETE FROM tbl_customer WHERE customer_id=?";
		Connection conn;
		try {
			conn = DBConnection.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, customer.getCustomerId());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}

	}

	public List<Customer> getAll() {
		String sql = "SELECT * FROM tbl_customer";
		Connection conn;
		try {
			conn = DBConnection.open();
			// Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<Customer> listCustomer = new ArrayList<Customer>();
			while (rs.next()) {
				Customer c = new Customer();
				c.setCustomerId(rs.getLong("customer_id"));
				c.setName(rs.getString("name"));
				c.setAddress(rs.getString("address"));
				c.setPhone(rs.getString("phone"));
				c.setEmail(rs.getString("email"));
				c.setGender(rs.getInt("gender"));
				c.setBirthday(rs.getDate("birthday"));
				
				listCustomer.add(c);
			}
			return listCustomer;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public Long getCount(Customer customer) {
		
		try {
			Connection conn;
			conn = DBConnection.open();
			String sql = "SELECT COUNT(*) FROM tbl_customer WHERE 1=1";
			Integer count = 0;
			if(customer.getName() !=null && customer.getName().trim() !="") {
				sql+= " AND name LIKE ?";
			}
			if(customer.getAddress()!=null && customer.getAddress().trim() !="") {
				sql+=" AND address LIKE ?";
			}
			if(customer.getPhone()!=null && customer.getPhone().trim() !="") {
				sql+=" AND phone LIKE ?";
			}
			if(customer.getEmail()!=null && customer.getEmail().trim() !="") {
				sql+=" AND address LIKE ?";
			}
			if(customer.getGender()!=null) {
				sql+=" AND gender LIKE ?";
			}
			if(customer.getBirthday()!=null) {
				sql+=" AND birthday LIKE ?";
			}
			
			PreparedStatement statement = conn.prepareStatement(sql);
			if(customer.getName()!=null && customer.getName().trim() !="") {
				count++;
				statement.setString(count, "%"+customer.getName().trim()+"%");
			}
			if(customer.getAddress()!=null && customer.getAddress().trim() !="") {
				count++;
				statement.setString(count, "%"+customer.getAddress().trim()+"%");
			}
			if(customer.getPhone()!=null && customer.getPhone().trim() !="") {
				count++;
				statement.setString(count, "%"+customer.getPhone().trim()+"%");
			}
			if(customer.getEmail()!=null && customer.getEmail().trim() !="") {
				count++;
				statement.setString(count, "%"+customer.getEmail().trim()+"%");
			}
			if(customer.getGender()!=null) {
				count++;
				statement.setString(count, "%"+customer.getGender()+"%");
			}
			if(customer.getBirthday()!=null) {
				count++;
				statement.setString(count, "%"+customer.getBirthday()+"%");
			}
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				return rs.getLong(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
		return 0L;
	}

	public List<Customer> search(Customer customer , Integer pageNumber , Integer pageSize) {
		List<Customer> result = new ArrayList<Customer>();
		
		//sql += " LIMIT " + (page - 1) * Constants.PAGE_SIZE + " , " + Constants.PAGE_SIZE;
		Integer count = 0;
		String sql = "SELECT * FROM tbl_customer WHERE 1=1 ";
		try {
			Connection conn;
			conn = DBConnection.open();
			if(customer.getName() !=null && customer.getName().trim() !="") {
				sql+= " AND name LIKE ?";
			}
			if(customer.getAddress()!=null && customer.getAddress().trim() !="") {
				sql+=" AND address LIKE ?";
			}
			if(customer.getPhone()!=null && customer.getPhone().trim() !="") {
				sql+=" AND phone LIKE ?";
			}
			if(customer.getEmail()!=null && customer.getEmail().trim() !="") {
				sql+=" AND address LIKE ?";
			}
			if(customer.getGender()!=null) {
				sql+=" AND gender LIKE ?";
			}
			if(customer.getBirthday()!=null) {
				sql+=" AND birthday LIKE ?";
			}
			sql+=" ORDER BY customer_id ASC ";
			if(pageNumber>0 && pageSize >0 ) {
				sql+= " LIMIT "+((pageNumber - 1) * pageSize)+" , "+pageSize;
			}
			PreparedStatement statement = conn.prepareStatement(sql);
			if(customer.getName()!=null && customer.getName().trim() !="") {
				count++;
				statement.setString(count, "%"+customer.getName().trim()+"%");
			}
			if(customer.getAddress()!=null && customer.getAddress().trim() !="") {
				count++;
				statement.setString(count, "%"+customer.getAddress().trim()+"%");
			}
			if(customer.getPhone()!=null && customer.getPhone().trim() !="") {
				count++;
				statement.setString(count, "%"+customer.getPhone().trim()+"%");
			}
			if(customer.getEmail()!=null && customer.getEmail().trim() !="") {
				count++;
				statement.setString(count, "%"+customer.getEmail().trim()+"%");
			}
			if(customer.getGender()!=null) {
				count++;
				statement.setString(count, "%"+customer.getGender()+"%");
			}
			if(customer.getBirthday()!=null) {
				count++;
				statement.setString(count, "%"+customer.getBirthday()+"%");
			}
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				Customer c = new Customer();
				c.setCustomerId(rs.getLong("customer_id"));
				c.setName(rs.getString("name"));
				c.setAddress(rs.getString("address"));
				c.setPhone(rs.getString("phone"));
				c.setEmail(rs.getString("email"));
				c.setGender(rs.getInt("gender"));
				c.setBirthday(rs.getDate("birthday"));
				result.add(c);
			}
			return result;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
		return result;
	}

	public Customer getById(Long id) {
		String sql = "SELECT * from tbl_customer where customer_id=?";
		Connection conn;
		try {
			conn = DBConnection.open();
			// Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			Customer c = new Customer();
			if (rs.next()) {
				c.setCustomerId(rs.getLong("customer_id"));
				c.setName(rs.getString("name"));
				c.setAddress(rs.getString("address"));
				c.setPhone(rs.getString("phone"));
				c.setEmail(rs.getString("email"));
				c.setGender(rs.getInt("gender"));
				c.setBirthday(rs.getDate("birthday"));
			}
			return c;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}



}
