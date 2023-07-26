/*
 * Name :Anan Elayan 
 * ID :1211529 
 * sectione 3*/
package application;



public class Item implements Comparable<Item> {
    //data fields
    private String type;
    private int quantity;
    private double price;
 

    //NO argument constructor
    public Item() {

    }

    //argument constructor
    public Item(String type) {
        this.type = type;
    }

    //in this method to return object type item after the add argument quantity
    public Item setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    //in this method to return object type item after the add argument price
    public Item setPrice(double price) {
        this.price = price;
        return this;
    }

    //in this method to return type item
    public String getType() {
        return this.type;
    }

    //in this method to return quantity item
    public int getQuantity() {
        return this.quantity;
    }

    //this method to return price item
    public double getPrice() {
        return this.price;
    }

    //method to return object of type item after to Increase quantity type
    public Item update(int qtyIncrease) {
        this.quantity += qtyIncrease;
        return this;
    }


    //method to return object of type item after calculate the adjustmentFactor
    public Item update(double adjustmentFactor) {
        this.price  = (this.price * adjustmentFactor) +  this.price;
        return this;
    }


    //method do compare between two object according the price
    @Override
    public int compareTo(Item o) {
        return (int) (this.price - o.price);
    }

    @Override
    public String toString() {
        return "Item{" +
                "type='" + type + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

	public void setType(String type) {
		this.type = type;
	}

	
}
