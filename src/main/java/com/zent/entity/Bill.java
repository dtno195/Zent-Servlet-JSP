package com.zent.entity;

import java.util.Date;

public class Bill {
	private Long billId;
	private Long customerId;
	private Date billDate;
	private Long sum;

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Long getSum() {
		return sum;
	}

	public void setSum(Long sum) {
		this.sum = sum;
	}

	public Bill(Long billId, Long customerId, Date billDate, Long sum) {
		super();
		this.billId = billId;
		this.customerId = customerId;
		this.billDate = billDate;
		this.sum = sum;
	}

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

}
