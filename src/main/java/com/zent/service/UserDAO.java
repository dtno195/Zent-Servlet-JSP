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
import com.zent.util.DBConnection;
import com.zent.util.Constants;

public class UserDAO {
	public static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class);

	public void insert(User user) {
		String sql = "INSERT INTO tbl_User(username,password,full_name,role_id) VALUES (?,?,?,?)";
		Connection conn;
		try {
			conn = DBConnection.open();
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
			conn = DBConnection.open();
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
			conn = DBConnection.open();
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
			conn = DBConnection.open();
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

	public Long getCount(User user) {
		
		try {
			Connection conn;
			String sql = "SELECT COUNT(*) FROM tbl_User WHERE  1=1";
			conn = DBConnection.open();
			Integer count = 0;
			if(user.getUsername() !=null && user.getUsername().trim() !="") {
				sql+=" AND username LIKE ?";
			}
			if(user.getFullName() !=null && user.getFullName().trim() !="") {
				sql+=" AND full_name LIKE ?";
			}
			PreparedStatement statement = conn.prepareStatement(sql);
			if(user.getFullName() !=null && user.getFullName().trim() !="") {
				count++;
				statement.setString(count, "%"+user.getUsername()+"%");
			}
			if(user.getFullName() !=null && user.getFullName().trim() !="") {
				count++;
				statement.setString(count, "%"+user.getFullName()+"%");
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

	public List<User> search(User user, Integer pageNumber , Integer pageSize) {
		List<User> result = new ArrayList<User>();
		String sql = "SELECT * FROM tbl_User WHERE 1=1 ";
		
		Integer count = 0;
		try {
			Connection conn;
			conn = DBConnection.open();
			if(user.getUsername() !=null && user.getUsername().trim() !="") {
				sql+=" AND username LIKE ?";
			}
			if(user.getFullName() !=null && user.getFullName().trim() !="") {
				sql+=" AND full_name LIKE ?";
			}
			sql+=" ORDER BY user_id ASC ";
			if(pageNumber>0 && pageSize >0 ) {
				sql+= " LIMIT "+((pageNumber - 1) * pageSize)+" , "+pageSize;
			}
			PreparedStatement statement = conn.prepareStatement(sql);
			if (user.getUsername() != null && user.getUsername().trim() != "") {
				count++;
				statement.setString(count, "%" + user.getUsername().trim()
						+ "%");
			}
			if (user.getFullName() != null && user.getFullName().trim() != "") {
				count++;
				statement.setString(count, "%" + user.getFullName().trim()
						+ "%");
			}
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setUserId(rs.getLong("user_id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setFullName(rs.getString("full_name"));
				u.setRoleId(rs.getLong("role_id"));
				result.add(user);
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

	public User getById(Long id) {
		String sql = "SELECT * from tbl_User where id=?";
		Connection conn;
		try {
			conn = DBConnection.open();
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
	public static Boolean checkLogin(User user) {
		String sql = "SELECT COUNT(*) FROM tbl_user WHERE username =? AND password=?";
		try {
			Connection conn = DBConnection.open(); // Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql); 
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			// Thực hiện câu truy vấn và lấy ra kết quả trả về
			// Đối với các câu truy vấn bắt đầu bằng select thì sử dụng
			// ExcuteQuery để truy vấn.
			// Đối vs insert vs update thì dùng excute();
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Long count = rs.getLong(1); // Cột cout sql
				if (count > 0) {
					return true;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(),e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(),e);
		}
		return false;
	}

	public static String getUser(String username) {
		String sql = "SELECT full_name FROM tbl_user where username=?";
		try {
			Connection conn = DBConnection.open();
			// Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return rs.getString("full_name");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(),e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(),e);
		}
		return null;
	}

}
