package com.zent.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zent.entity.Role;
import com.zent.util.DBConnection;
import com.zent.util.Constants;

public class RoleDAO {
	public static final Logger LOGGER = LoggerFactory.getLogger(RoleDAO.class);

	public void insert(Role role) {
		String sql = "INSERT INTO tbl_Role(name,description) VALUES (?,?)";
		Connection conn;
		try {
			conn = DBConnection.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());

			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
	}

	public void update(Role role) {
		String sql = "UPDATE tbl_role SET name=?,description=? WHERE role_id=?";
		Connection conn;
		try {
			conn = DBConnection.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			statement.setLong(3, role.getId());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
	}

	public void delete(Role role) {
		String sql = "DELETE FROM tbl_role WHERE role_id=?";
		Connection conn;
		try {
			conn = DBConnection.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, role.getId());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}

	}

	public List<Role> getAll() {
		String sql = "SELECT * FROM tbl_role";
		Connection conn;
		try {
			conn = DBConnection.open();
			// Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<Role> listrole = new ArrayList<Role>();
			while (rs.next()) {
				Role role = new Role();
				role.setId(rs.getLong("role_id"));
				role.setName(rs.getString("name"));
				role.setDescription(rs.getString("description"));
				listrole.add(role);
			}
			return listrole;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public Long getCount(String keyword) {
		String sql = "SELECT COUNT(*) FROM tbl_role WHERE  name ? OR description LIKE ?  ";
		Connection conn;
		try {
			conn = DBConnection.open();
			// Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "%" + keyword + "%");
			statement.setString(2, "%" + keyword + "%");
			ResultSet rs = statement.executeQuery();
			List<Role> listSearchSP = new ArrayList<Role>();
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

	public List<Role> search(String keyword, Integer page) {
		String sql = "SELECT * FROM tbl_role WHERE name LIKE ? OR description LIKE ?";
		sql += " LIMIT " + (page - 1) * Constants.PAGE_SIZE + " , " + Constants.PAGE_SIZE;
		Connection conn;
		try {
			conn = DBConnection.open();
			// Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "%" + keyword + "%");
			statement.setString(2, "%" + keyword + "%");
			ResultSet rs = statement.executeQuery();
			List<Role> listSearchSP = new ArrayList<Role>();
			while (rs.next()) {
				Role role = new Role();
				role.setId(rs.getLong("role_id"));
				role.setName(rs.getString("name"));
				role.setDescription(rs.getString("description"));
				listSearchSP.add(role);
			}
			return listSearchSP;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public Role getById(Long id) {
		String sql = "SELECT * from tbl_role where role_id=?";
		Connection conn;
		try {
			conn = DBConnection.open();
			// Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			Role role = new Role();
			if (rs.next()) {
				
				role.setId(rs.getLong("role_id"));
				role.setName(rs.getString("name"));
				role.setDescription(rs.getString("description"));
			}
			return role;
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
