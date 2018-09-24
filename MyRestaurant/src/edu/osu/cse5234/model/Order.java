package edu.osu.cse5234.model;

import java.util.ArrayList;

public class Order {
	
	private ArrayList<Item> itemList = new ArrayList<Item>();

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}
	
}
