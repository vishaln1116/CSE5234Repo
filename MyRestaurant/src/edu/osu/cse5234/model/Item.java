package edu.osu.cse5234.model;

public class Item {

	private String name;
	
	private String price;
	
	private String quantity;
	
	public Item() {
	}
	
	public String getName() {
		return name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public String getPrice() {
		return this.price;
	}
	
	public void setPrice(String newPrice) {
		this.price = newPrice;
	}
	
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String newQuantity) {
		this.quantity = newQuantity;
	}
	
}
