package com.basicShoppingCart.learnCleaverly;

public class CartItem {
	private String prodId;
	private String custId;
	private int qty;
	private int price;

	public CartItem(String prodId, String custId, int qty, int price) {
		super();
		this.prodId = prodId;
		this.custId = custId;
		this.qty = qty;
		this.price = price;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
