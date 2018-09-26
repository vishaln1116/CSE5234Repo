package edu.osu.cse5234.model;

import java.util.ArrayList;

public class Order {
	
	private ArrayList<Item> items;
	
	public Order() {
		items = new ArrayList<>();
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> newItem) {
		this.items = newItem;
	}
	
}
