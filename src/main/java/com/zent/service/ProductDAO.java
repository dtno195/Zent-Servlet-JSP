package com.zent.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zent.entity.Product;

import com.zent.util.*;

public class ProductDAO {
	public static final Logger LOGGER = LoggerFactory.getLogger(ProductDAO.class);

	public void insert(Product p) {
		String sql = "INSERT INTO tbl_Product(category_id,name,code,quantity,price,description,image,size) VALUES (?,?,?,?,?,?,?,?)";
		Connection conn;
		try {
			conn = DBConnection.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1,p.getCategoryId());
			statement.setString(2, p.getName());
			statement.setString(3, p.getCode());
			statement.setInt(4, p.getQuantity());
			statement.setLong(5, p.getPrice());
			statement.setString(6, p.getDescription());
			statement.setString(7, p.getImage());
			statement.setDouble(8, p.getSize());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
	}

	public void update(Product p) {
		String sql = "UPDATE tbl_Product SET category_id=?,name=?,code=?,quantity=?,price=?,description=?,image=?,size=?, WHERE Product_id=?";
		Connection conn;
		try {
			conn = DBConnection.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1,p.getCategoryId());
			statement.setString(2, p.getName());
			statement.setString(3, p.getCode());
			statement.setInt(4, p.getQuantity());
			statement.setLong(5, p.getPrice());
			statement.setString(6, p.getDescription());
			statement.setString(7, p.getImage());
			statement.setDouble(8, p.getSize());
			statement.setLong(9, p.getProductId());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
	}

	public void delete(Product p) {
		String sql = "DELETE FROM tbl_Product WHERE Product_id=?";
		Connection conn;
		try {
			conn = DBConnection.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, p.getProductId());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}

	}

	public List<Product> getAll() {
		String sql = "SELECT * FROM tbl_Product";
		Connection conn;
		try {
			conn = DBConnection.open();
			// Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<Product> listProduct = new ArrayList<Product>();
			while (rs.next()) {
				Product p = new Product();
				p.setProductId(rs.getLong("product_id"));
				p.setCategoryId(rs.getLong("category_id"));
				p.setName(rs.getString("name"));
				p.setCode(rs.getString("code"));
				p.setQuantity(rs.getInt("quantity"));
				p.setPrice(rs.getLong("price"));
				p.setDescription(rs.getString("description"));
				p.setImage(rs.getString("image"));
				p.setSize(rs.getDouble("size"));
				listProduct.add(p);
			}
			return listProduct;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public Long getCount(Product p) {
		
		try {
			Connection conn;
			conn = DBConnection.open();
			String sql = "SELECT COUNT(*) FROM tbl_Product WHERE 1=1";
			Integer count = 0;
			if(p.getCategoryId()!=null && p.getCategoryId().toString() !="") {
				sql+=" AND category_id LIKE ?";
			}
			if(p.getName() !=null && p.getName().trim() !="") {
				sql+= " AND name LIKE ?";
			}
			if(p.getCode() !=null && p.getCode().trim() !="") {
				sql+= " AND code LIKE ?";
			}
			if(p.getQuantity() !=null && p.getQuantity().toString() !="") {
				sql+= " AND quantity LIKE ?";
			}
			if(p.getPrice() !=null && p.getPrice().toString() !="") {
				sql+= " AND price LIKE ?";
			}
			if(p.getDescription()!=null && p.getDescription().trim() !="") {
				sql+=" AND description LIKE ?";
			}
			if(p.getSize() !=null && p.getSize().toString() !="") {
				sql+= " AND size LIKE ?";
			}
			PreparedStatement statement = conn.prepareStatement(sql);
			if(p.getCategoryId()!=null && p.getCategoryId().toString() !="") {
				count++;
				statement.setString(count, "%"+p.getCategoryId()+"%");
			}
			if(p.getName() !=null && p.getName().trim() !="") {
				count++;
				statement.setString(count, "%"+p.getName().trim()+"%");
			}
			if(p.getCode() !=null && p.getCode().trim() !="") {
				count++;
				statement.setString(count, "%"+p.getCode()+"%");
			}
			if(p.getQuantity() !=null && p.getQuantity().toString() !="") {
				count++;
				statement.setString(count, "%"+p.getQuantity()+"%");
			}
			if(p.getPrice() !=null && p.getPrice().toString() !="") {
				count++;
				statement.setString(count, "%"+p.getPrice()+"%");
			}
			if(p.getDescription()!=null && p.getDescription().trim() !="") {
				count++;
				statement.setString(count, "%"+p.getDescription()+"%");
			}
			if(p.getSize() !=null && p.getSize().toString() !="") {
				count++;
				statement.setString(count, "%"+p.getSize()+"%");
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

	public List<Product> search(Product p , Integer pageNumber , Integer pageSize) {
		List<Product> result = new ArrayList<Product>();
		
		//sql += " LIMIT " + (page - 1) * Constants.PAGE_SIZE + " , " + Constants.PAGE_SIZE;
		Integer count = 0;
		String sql = "SELECT * FROM tbl_Product WHERE 1=1 ";
		try {
			Connection conn;
			conn = DBConnection.open();
			
			if(p.getCategoryId()!=null && p.getCategoryId().toString() !="") {
				sql+=" AND category_id LIKE ?";
			}
			if(p.getName() !=null && p.getName().trim() !="") {
				sql+= " AND name LIKE ?";
			}
			if(p.getCode() !=null && p.getCode().trim() !="") {
				sql+= " AND code LIKE ?";
			}
			if(p.getQuantity() !=null && p.getQuantity().toString() !="") {
				sql+= " AND quantity LIKE ?";
			}
			if(p.getPrice() !=null && p.getPrice().toString() !="") {
				sql+= " AND price LIKE ?";
			}
			if(p.getDescription()!=null && p.getDescription().trim() !="") {
				sql+=" AND description LIKE ?";
			}
			if(p.getSize() !=null && p.getSize().toString() !="") {
				sql+= " AND size LIKE ?";
			}
			sql+=" ORDER BY Product_id ASC ";
			if(pageNumber>0 && pageSize >0 ) {
				sql+= " LIMIT "+((pageNumber - 1) * pageSize)+" , "+pageSize;
			}
			PreparedStatement statement = conn.prepareStatement(sql);
			if(p.getCategoryId()!=null && p.getCategoryId().toString() !="") {
				count++;
				statement.setString(count, "%"+p.getCategoryId()+"%");
			}
			if(p.getName() !=null && p.getName().trim() !="") {
				count++;
				statement.setString(count, "%"+p.getName().trim()+"%");
			}
			if(p.getCode() !=null && p.getCode().trim() !="") {
				count++;
				statement.setString(count, "%"+p.getCode()+"%");
			}
			if(p.getQuantity() !=null && p.getQuantity().toString() !="") {
				count++;
				statement.setString(count, "%"+p.getQuantity()+"%");
			}
			if(p.getPrice() !=null && p.getPrice().toString() !="") {
				count++;
				statement.setString(count, "%"+p.getPrice()+"%");
			}
			if(p.getDescription()!=null && p.getDescription().trim() !="") {
				count++;
				statement.setString(count, "%"+p.getDescription()+"%");
			}
			if(p.getSize() !=null && p.getSize().toString() !="") {
				count++;
				statement.setString(count, "%"+p.getSize()+"%");
			}
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				Product pr = new Product();
				pr.setProductId(rs.getLong("product_id"));
				pr.setCategoryId(rs.getLong("category_id"));
				pr.setName(rs.getString("name"));
				pr.setCode(rs.getString("code"));
				pr.setQuantity(rs.getInt("quantity"));
				pr.setPrice(rs.getLong("price"));
				pr.setDescription(rs.getString("description"));
				pr.setImage(rs.getString("image"));
				pr.setSize(rs.getDouble("size"));
				result.add(pr);
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

	public Product getById(Long id) {
		String sql = "SELECT * from tbl_Product where Product_id=?";
		Connection conn;
		try {
			conn = DBConnection.open();
			// Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			Product p = new Product();
			if (rs.next()) {
				p.setProductId(rs.getLong("product_id"));
				p.setCategoryId(rs.getLong("category_id"));
				p.setName(rs.getString("name"));
				p.setCode(rs.getString("code"));
				p.setQuantity(rs.getInt("quantity"));
				p.setPrice(rs.getLong("price"));
				p.setDescription(rs.getString("description"));
				p.setImage(rs.getString("image"));
				p.setSize(rs.getDouble("size"));
			}
			return p;
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
