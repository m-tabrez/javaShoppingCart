package com.basicShoppingCart.learnCleaverly;

public class Product {
	private String id;
	private String name;
	private String category;
	private int qoh;
	private int price;

	public Product(String id, String name, String category, int qoh, int price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.qoh = qoh;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQoh() {
		return qoh;
	}

	public void setQoh(int qoh) {
		this.qoh = qoh;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
