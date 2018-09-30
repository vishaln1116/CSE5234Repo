package edu.osu.cse5234.model;

import java.util.ArrayList;

public class Order {

    private ArrayList<Item> items;

    private String totalPrice;

    public Order() {
        this.items = new ArrayList<>();
        this.totalPrice = "0.00";
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<Item> newItem) {
        this.items = newItem;
    }

    public void recalculateTotalPrice() {
        //calculate total price
        double price = 0;
        for (Item i : this.items) {
            if (i.getQuantity() != null && i.getPrice() != null
                    && !i.getQuantity().isEmpty()) {
                price += Integer.parseInt(i.getQuantity())
                        * Double.parseDouble(i.getPrice());
            }
        }
        this.totalPrice = String.format("%.2f", price);
    }

    public String getTotalPrice() {
        return this.totalPrice;
    }
}
