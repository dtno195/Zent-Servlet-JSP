package com.zent.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zent.entity.BillDetail;
import com.zent.util.DBConnection;
import com.zent.util.Constants;
import com.zent.util.ConvertUtil;

public class BillDetailDAO {
	public static final Logger LOGGER = LoggerFactory.getLogger(BillDetailDAO.class);

	public void insert(BillDetail bill) {
		String sql = "INSERT INTO tbl_bill_detail(bill_id,product_id,quantity) VALUES (?,?,?)";
		Connection conn;
		try {
			conn = DBConnection.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, bill.getBillId());
			statement.setLong(2, bill.getProductId());
			statement.setInt(3, bill.getQuantity());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
	}

	public void update(BillDetail bill) {
		String sql = "UPDATE tbl_bill_detail SET bill_id=?,product_id=?,quantity=? WHERE bill_detail_id=?";
		Connection conn;
		try {
			conn = DBConnection.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, bill.getBillId());
			statement.setLong(2, bill.getProductId());
			statement.setInt(3, bill.getQuantity());
			statement.setLong(4, bill.getBillDetailId());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
	}

	public void delete(BillDetail Bill) {
		String sql = "DELETE FROM tbl_Bill_detail WHERE bill_detail_id=?";
		Connection conn;
		try {
			conn = DBConnection.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, Bill.getBillDetailId());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}

	}

	public List<BillDetail> getAll() {
		String sql = "SELECT * FROM tbl_bill_detail";
		Connection conn;
		try {
			conn = DBConnection.open();
			// Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<BillDetail> listBill = new ArrayList<BillDetail>();
			while (rs.next()) {
				BillDetail b = new BillDetail();
				b.setBillDetailId(rs.getLong("bill_detail_id"));
				b.setBillId(rs.getLong("bill_id"));
				b.setProductId(rs.getLong("product_id"));
				b.setQuantity(rs.getInt("quantity"));
				listBill.add(b);
			}
			return listBill;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public Long getCount(BillDetail b) {
		// String sql = "SELECT COUNT(*) FROM tbl_Bill WHERE name LIKE ? OR description
		// LIKE ? ";

		try {
			Connection conn;
			conn = DBConnection.open();
			String sql = "SELECT COUNT(*) FROM tbl_Bill_detail WHERE 1=1";
			Integer count = 0;
			if (b.getBillId() != null) {
				sql += " AND bill_id LIKE ?";
			}
			if (b.getProductId() != null) {
				sql += " AND product_id LIKE ?";
			}
			if (b.getQuantity() != null) {
				sql += " AND quantity LIKE ?";
			}
			PreparedStatement statement = conn.prepareStatement(sql);
			if (b.getBillId() != null) {
				count++;
				statement.setString(count, "%" + b.getBillId() + "%");
			}
			if (b.getProductId() != null) {
				count++;
				statement.setString(count, "%" + b.getProductId() + "%");
			}
			if (b.getQuantity() != null) {
				count++;
				statement.setString(count, "%" + b.getQuantity() + "%");
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

	public List<BillDetail> search(BillDetail b, Integer pageNumber, Integer pageSize) {
		List<BillDetail> result = new ArrayList<BillDetail>();

		// sql += " LIMIT " + (page - 1) * Constants.PAGE_SIZE + " , " +
		// Constants.PAGE_SIZE;
		Integer count = 0;
		String sql = "SELECT * FROM tbl_Bill_detail WHERE 1=1 ";
		try {
			Connection conn;
			conn = DBConnection.open();

			if (b.getBillId() != null) {
				sql += " AND bill_id LIKE ?";
			}
			if (b.getProductId() != null) {
				sql += " AND product_id LIKE ?";
			}
			if (b.getQuantity() != null) {
				sql += " AND quantity LIKE ?";
			}
			PreparedStatement statement = conn.prepareStatement(sql);
			if (b.getBillId() != null) {
				count++;
				statement.setString(count, "%" + b.getBillId() + "%");
			}
			if (b.getProductId() != null) {
				count++;
				statement.setString(count, "%" + b.getProductId() + "%");
			}
			if (b.getQuantity() != null) {
				count++;
				statement.setString(count, "%" + b.getQuantity() + "%");
			}

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				BillDetail bill = new BillDetail();
				b.setBillDetailId(rs.getLong("bill_detail_id"));
				b.setBillId(rs.getLong("bill_id"));
				b.setProductId(rs.getLong("product_id"));
				b.setQuantity(rs.getInt("quantity"));
				result.add(bill);
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

	public BillDetail getById(Long id) {
		String sql = "SELECT * from tbl_Bill_detail where Bill_id=?";
		Connection conn;
		try {
			conn = DBConnection.open();
			// Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			BillDetail b = new BillDetail();
			if (rs.next()) {
				b.setBillDetailId(rs.getLong("bill_detail_id"));
				b.setBillId(rs.getLong("bill_id"));
				b.setProductId(rs.getLong("product_id"));
				b.setQuantity(rs.getInt("quantity"));
			}
			return b;
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
