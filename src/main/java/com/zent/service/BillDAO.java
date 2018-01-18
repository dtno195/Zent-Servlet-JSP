package com.zent.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zent.entity.Bill;
import com.zent.util.DBConnection;
import com.zent.util.Constants;
import com.zent.util.ConvertUtil;

public class BillDAO {
	public static final Logger LOGGER = LoggerFactory.getLogger(BillDAO.class);

	public void insert(Bill bill) {
		String sql = "INSERT INTO tbl_Bill(customer_id,bill_date,sum) VALUES (?,?,?)";
		Connection conn;
		try {
			conn = DBConnection.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, bill.getCustomerId());
			statement.setDate(2, ConvertUtil.convertDate(bill.getBillDate()));
			statement.setLong(3, bill.getSum());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
	}

	public void update(Bill bill) {
		String sql = "UPDATE tbl_Bill SET customer_id=?,bill_date=?,sum=? WHERE bill_id=?";
		Connection conn;
		try {
			conn = DBConnection.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, bill.getCustomerId());
			statement.setDate(2, ConvertUtil.convertDate(bill.getBillDate()));
			statement.setLong(3, bill.getSum());
			statement.setLong(4, bill.getBillId());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
	}

	public void delete(Bill Bill) {
		String sql = "DELETE FROM tbl_bill WHERE bill_id=?";
		Connection conn;
		try {
			conn = DBConnection.open();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, Bill.getBillId());
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}

	}

	public List<Bill> getAll() {
		String sql = "SELECT * FROM tbl_bill";
		Connection conn;
		try {
			conn = DBConnection.open();
			// Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			List<Bill> listBill = new ArrayList<Bill>();
			while (rs.next()) {
				Bill b = new Bill();
				b.setBillId(rs.getLong("bill_id"));
				b.setCustomerId(rs.getLong("customer_id"));
				b.setBillDate(ConvertUtil.convertDate(rs.getDate("bill_date")));
				b.setSum(rs.getLong("sum"));
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

	public Long getCount(Bill b) {
		//String sql = "SELECT COUNT(*) FROM tbl_Bill WHERE  name LIKE ? OR description LIKE ?  ";
		
		try {
			Connection conn;
			conn = DBConnection.open();
			String sql = "SELECT COUNT(*) FROM tbl_bill WHERE 1=1";
			Integer count = 0;
			if(b.getCustomerId() !=null ) {
				sql+= " AND customer_id LIKE ?";
			}
			if(b.getBillDate()!=null) {
				sql+=" AND bill_date LIKE ?";
			}
			if(b.getSum()!=null) {
				sql+=" AND sum LIKE ?";
			}
			PreparedStatement statement = conn.prepareStatement(sql);
			if(b.getCustomerId() !=null ) {
				count++;
				statement.setString(count, "%"+b.getCustomerId()+"%");
			}
			if(b.getBillDate() !=null ) {
				count++;
				statement.setString(count, "%"+b.getBillDate()+"%");
			}
			if(b.getSum() !=null ) {
				count++;
				statement.setString(count, "%"+b.getSum()+"%");
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

	public List<Bill> search(Bill b , Integer pageNumber , Integer pageSize) {
		List<Bill> result = new ArrayList<Bill>();
		
		//sql += " LIMIT " + (page - 1) * Constants.PAGE_SIZE + " , " + Constants.PAGE_SIZE;
		Integer count = 0;
		String sql = "SELECT * FROM tbl_Bill WHERE 1=1 ";
		try {
			Connection conn;
			conn = DBConnection.open();
			
			if(b.getCustomerId() !=null ) {
				sql+= " AND customer_id LIKE ?";
			}
			if(b.getBillDate()!=null) {
				sql+=" AND bill_date LIKE ?";
			}
			if(b.getSum()!=null) {
				sql+=" AND sum LIKE ?";
			}
			PreparedStatement statement = conn.prepareStatement(sql);
			if(b.getCustomerId() !=null ) {
				count++;
				statement.setString(count, "%"+b.getCustomerId()+"%");
			}
			if(b.getBillDate() !=null ) {
				count++;
				statement.setString(count, "%"+b.getBillDate()+"%");
			}
			if(b.getSum() !=null ) {
				count++;
				statement.setString(count, "%"+b.getSum()+"%");
			}
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				Bill bill = new Bill();
				bill.setBillId(rs.getLong("bill_id"));
				bill.setCustomerId(rs.getLong("customer_id"));
				bill.setBillDate(ConvertUtil.convertDate(rs.getDate("bill_date")));
				bill.setSum(rs.getLong("sum"));
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

	public Bill getById(Long id) {
		String sql = "SELECT * from tbl_Bill where Bill_id=?";
		Connection conn;
		try {
			conn = DBConnection.open();
			// Mở kết nối
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			Bill bill = new Bill();
			if (rs.next()) {
				bill.setBillId(rs.getLong("bill_id"));
				bill.setCustomerId(rs.getLong("customer_id"));
				bill.setBillDate(ConvertUtil.convertDate(rs.getDate("bill_date")));
				bill.setSum(rs.getLong("sum"));
			}
			return bill;
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
