package com.zent.entity;

public class Product {
	private Long productId;
	private Long categoryId;
	private String name;
	private String code;
	private Integer quantity;
	private Long price;
	private String description;
	private String image;
	private Double size;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public Product(Long productId, Long categoryId, String name, String code, Integer quantity, Long price,
			String description, String image, Double size) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.name = name;
		this.code = code;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.image = image;
		this.size = size;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

}
