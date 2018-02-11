package com.zent.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zent.entity.Product;

public class Cart {

	private Product pro;
	private int quantityBuy;

	public Product getPro() {
		return pro;
	}

	public void setPro(Product pro) {
		this.pro = pro;
	}

	

	public int getQuantityBuy() {
		return quantityBuy;
	}

	public void setQuantityBuy(int quantityBuy) {
		this.quantityBuy = quantityBuy;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

}
