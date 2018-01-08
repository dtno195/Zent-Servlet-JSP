package com.zent.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zent.entity.User;
import com.zent.util.ConnectionUtil;
import com.zent.util.Constants;

public class UserDAO {
	public static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class);

	public void insert(User user) {
		String sql = "INSERT INTO tbl_User(username,password,full_name,role_id) VALUES (?,?,?,?)";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullName());
			statement.setLong(4, user.getRoleId());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
	}

	public void update(User user) {
		String sql = "UPDATE tbl_User SET username=?,password=?,full_name=?,role_id=? WHERE user_id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullName());
			statement.setLong(4, user.getRoleId());
			statement.setLong(5, user.getUserId());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
	}

	public void delete(User user) {
		String sql = "DELETE FROM tbl_User WHERE user_id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, user.getUserId());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}

	}

	public List<User> getAll() {
		String sql = "SELECT * FROM tbl_User";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			// Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<User> listUser = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getLong("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullName(rs.getString("full_name"));
				user.setRoleId(rs.getLong("role_id"));
				listUser.add(user);
			}
			return listUser;
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
		String sql = "SELECT COUNT(*) FROM tbl_User WHERE  username ? OR full_name LIKE ? OR role_id = ? ";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			// Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "%" + keyword + "%");
			statement.setString(2, "%" + keyword + "%");
			statement.setLong(3, Long.parseLong(keyword));
			ResultSet rs = statement.executeQuery();
			List<User> listSearchSP = new ArrayList<User>();
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

	public List<User> search(String keyword, Integer page) {
		String sql = "SELECT * FROM tbl_User WHERE username ? OR full_name LIKE ? OR role_id = ? ";
		sql += " LIMIT " + (page - 1) * Constants.PAGE_SIZE + " ," + Constants.PAGE_SIZE;
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			// Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "%" + keyword + "%");
			statement.setString(2, "%" + keyword + "%");
			ResultSet rs = statement.executeQuery();
			List<User> listSearchSP = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getLong("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullName(rs.getString("full_name"));
				user.setRoleId(rs.getLong("role_id"));
				listSearchSP.add(user);
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

	public User getById(Long id) {
		String sql = "SELECT * from tbl_User where id=?";
		Connection conn;
		try {
			conn = ConnectionUtil.open();
			// Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			User user = new User();
			if (rs.next()) {
				user.setUserId(rs.getLong("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullName(rs.getString("full_name"));
				user.setRoleId(rs.getLong("role_id"));
			}
			return user;
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
