package com.zent.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zent.entity.Category;

import com.zent.util.*;

public class CategoryDAO {
	public static final Logger LOGGER = LoggerFactory.getLogger(CategoryDAO.class);

	public void insert(Category category) {
		String sql = "INSERT INTO tbl_category(name,description) VALUES (?,?)";
		Connection conn;
		try {
			conn = DBConnection.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, category.getName());
			statement.setString(2, category.getDescription());

			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
	}

	public void update(Category category) {
		String sql = "UPDATE tbl_category SET name=?,description=? WHERE category_id=?";
		Connection conn;
		try {
			conn = DBConnection.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, category.getName());
			statement.setString(2, category.getDescription());
			statement.setLong(3, category.getCategoryId());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
	}

	public void delete(Category category) {
		String sql = "DELETE FROM tbl_category WHERE category_id=?";
		Connection conn;
		try {
			conn = DBConnection.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, category.getCategoryId());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}

	}

	public List<Category> getAll() {
		String sql = "SELECT * FROM tbl_category";
		Connection conn;
		try {
			conn = DBConnection.open();
			// Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<Category> listCategory = new ArrayList<Category>();
			while (rs.next()) {
				Category role = new Category();
				role.setCategoryId(rs.getLong("category_id"));
				role.setName(rs.getString("name"));
				role.setDescription(rs.getString("description"));
				listCategory.add(role);
			}
			return listCategory;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public Long getCount(Category category) {
		
		try {
			Connection conn;
			conn = DBConnection.open();
			String sql = "SELECT COUNT(*) FROM tbl_category WHERE 1=1";
			Integer count = 0;
			if(category.getName() !=null && category.getName().trim() !="") {
				sql+= " AND name LIKE ?";
			}
			if(category.getDescription()!=null && category.getDescription().trim() !="") {
				sql+=" AND description LIKE ?";
			}
			PreparedStatement statement = conn.prepareStatement(sql);
			if(category.getDescription()!=null && category.getDescription().trim() !="") {
				count++;
				statement.setString(count, "%"+category.getName().trim()+"%");
			}
			if(category.getDescription()!=null && category.getDescription().trim() !="") {
				count++;
				statement.setString(count, "%"+category.getDescription().trim()+"%");
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

	public List<Category> search(Category category , Integer pageNumber , Integer pageSize) {
		List<Category> result = new ArrayList<Category>();
		
		//sql += " LIMIT " + (page - 1) * Constants.PAGE_SIZE + " , " + Constants.PAGE_SIZE;
		Integer count = 0;
		String sql = "SELECT * FROM tbl_category WHERE 1=1 ";
		try {
			Connection conn;
			conn = DBConnection.open();
			
			if(category.getName() != null && category.getName().trim() != "") {
				sql+= " AND name LIKE ?";
			}
			if(category.getDescription()!=null && category.getDescription().trim() !="") {
				sql+=" AND description LIKE ?";
			}
			sql+=" ORDER BY category_id ASC ";
			if(pageNumber>0 && pageSize >0 ) {
				sql+= " LIMIT "+((pageNumber - 1) * pageSize)+" , "+pageSize;
			}
			PreparedStatement statement = conn.prepareStatement(sql);
			if (category.getName() != null && category.getName().trim() != "") {
				count++;
				statement.setString(count, "%" + category.getName().trim()
						+ "%");
			}
			if (category.getDescription() != null && category.getDescription().trim() != "") {
				count++;
				statement.setString(count, "%" + category.getDescription().trim()
						+ "%");

			}
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				Category r = new Category();
				r.setCategoryId(rs.getLong(1));
				r.setName(rs.getString(2));
				r.setDescription(rs.getString(3));
				result.add(r);
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

	public Category getById(Long id) {
		String sql = "SELECT * from tbl_category where category_id=?";
		Connection conn;
		try {
			conn = DBConnection.open();
			// Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			Category c = new Category();
			if (rs.next()) {
				c.setCategoryId(rs.getLong("category_id"));
				c.setName(rs.getString("name"));
				c.setDescription(rs.getString("description"));
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
