package com.zent.entity;

public class BillDetail {
	private Long billDetailId;
	private Long billId;
	private Long productId;
	private Integer quantity;

	public BillDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillDetail(Long billDetailId, Long billId, Long productId, Integer quantity) {
		super();
		this.billDetailId = billDetailId;
		this.billId = billId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public Long getBillDetailId() {
		return billDetailId;
	}

	public void setBillDetailId(Long billDetailId) {
		this.billDetailId = billDetailId;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
