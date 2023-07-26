/*
 * Name :Anan Elayan 
 * ID :1211529 
 * sectione 3*/

package application;
import java.util.ArrayList;

import javafx.scene.control.Label;


public class Inventory {

	// date filed
	private ArrayList<Item> inventory;
	private String category;
	Label text;

	public Inventory() {

	}

	
	// argument constructor
	public Inventory(String category) {
		this.category = category;
		this.inventory = new ArrayList<>();
	}
	

	// in this method add new item with argument, type and quantity and price
	public void newItem(String type, int quantity, double price) {
		int index = findItem(type, true);
		if (index == -1) {
			inventory.add(new Item(type).setQuantity(quantity).setPrice(price));
		}
	}

	
	// in this method add new item specific brand
	public void newItem(String brand, String type, int quantity, double price) {
		int index = findItem(type, true, brand);
		if (index == -1) {
			inventory.add(new Brand(brand, type).setPrice(price).setQuantity(quantity));
		}
	}

	
	// the method set quantity
	public void setQuantity(String type, int quantity) {
		int index = findItem(type, false);
		if (index != -1) {
			inventory.get(index).setQuantity(quantity);// add the quantity in this index on array
		}
	}

	
	// the method set quantity
	public void setQuantity(String brand, String type, int quantity) {
		int index = findItem(type, false, brand);
		if (index != -1) {// exist object
			inventory.get(index).setQuantity(quantity);// add the quantity in this index on array
		}
	}

	
	// the method set price
	public void setPrice(String type, double price) {
		int index = findItem(type, false);
		if (index != -1) {// exist object
			inventory.get(index).setPrice(price);// add the price in this index on array
		}
	}

	// the method set price
	public void setPrice(String brand, String type, double price) {
		int index = findItem(type, false, brand);
		if (index != -1) {// exist object
			inventory.get(index).setPrice(price);// add the price in this index on array
		}
	}
	
	

	// in this method return quantity
	public int getQuantity(String type) {
		int index = findItem(type, false);
		if (index != -1) {// exist object
			return inventory.get(index).getQuantity();// add the price in this index on array
		}
		return -1; // no object
	}

	
	// in this method return quantity
	public int getQuantity(String brand, String type) {
		int index = findItem(type, false, brand);
		if (index != -1) {// exist object
			return inventory.get(index).getQuantity();
		}
		return 0;// no object
	}

	
	// this method return price
	public double getPrice(String type) {
		int index = findItem(type, false);
		if (index != -1) {// exist object
			return inventory.get(index).getPrice();
		}
		return Double.NaN;
	}

	
	// the method return price
	public double getPrice(String brand, String type) {
		int index = findItem(type, false, brand);
		if (index != -1) {// exist object
			return inventory.get(index).getPrice();// return the price on theis index
		}
		return Double.NaN;
	}
	

	// the method update according type by increasing the price
	// -------------------------
	public void update(String type, int qtyIncrease) {
		int index = findItem(type, false);
		if (index != -1) {// exist object
			inventory.get(index).update(qtyIncrease);
		}
	}

	// the method update according type brand by increasing the price
	public void update(String brand, String type, int qtyIncrease) {
		int index = findItem(type, false, brand);
		if (index != -1) {// exist object
			inventory.get(index).update(qtyIncrease);
		}

	}
	
	

	// the method update according type brand by adjustmentFactor
	public void update(String type, double adjustmentFactor) {
		int index = findItem(type, false);
		if (index != -1) {// exist object
			inventory.get(index).update(adjustmentFactor);
		}
	}
	
	

	public void update(String brand, String type, double adjustmentFactor) {
		int index = findItem(type, false, brand);
		if (index != -1) {
			inventory.get(index).update(adjustmentFactor);
		}

	}
	
	

	// in this method delete item from array list with brand
	public void delete(String type, String brand) {
		if (findItem(type, false, brand) != -1) {
			for (int i = 0; i < inventory.size(); i++) {
				if (inventory.get(i).getType().equals(type)) {
					if (inventory.get(i) instanceof Brand && ((Brand) inventory.get(i)).getBrand().equals(brand)) {
						inventory.remove(i);
						break;
					}
				}
			}
		}

	}

	
	
	// in this method delete item from array list with not brand
	public void delete(String type) {
		if (findItem(type, false) != -1) {
			for (int i = 0; i < inventory.size(); i++) {
				if (inventory.get(i).getType().equals(type)) {
					inventory.remove(i);
					break;
				}
			}
		}
	}
	
	
	

	// the aim method to find item on arrayList according type
	private int findItem(String type, boolean warningIfFound) {
		int index = -1;
		int itemsFound = 0;
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i) != null) { //// exist object
				if (inventory.get(i).getType().equals(type)) { // check if the type specific index equal what was given
					index = i;// storage index object on (index variable)
					itemsFound++;// increasing items Found
				}
			}
		}
		if (itemsFound == 0 && !warningIfFound) { // cannot find type if items Found equals 0 and warningIfFound true
			text = new Label("cannot find " + type);
		}
		if (itemsFound > 0 && warningIfFound) { // already exists type if items found grater than 0 and warningIfFound
			text = new Label("  " + type + " already exists");
		}
		if (itemsFound > 1) {
			text = new Label("Found more than one brand of " + inventory.get(index).getType());
		}

		if (itemsFound == 1) {
			return index;
		}
		return -1;
	}

	
	
	// the aim method to find item on arrayList according type and brand
	private int findItem(String type, boolean warningIfFound, String brand) {
		int index = -1;
		int itemsFound = 0;
		for (int i = 0; i < inventory.size(); i++) {
			Item item = inventory.get(i);
			if (type.equals(item.getType()) && (item instanceof Brand && brand.equals(((Brand) item).getBrand()))) { // check
																														// if
																														// object
																														// instance
																														// of
																														// brand
																														// if
																														// this
				// comparing between brand if equal what was sent
				index = i;
				itemsFound++;
			}
		}
		if (itemsFound == 0 && !warningIfFound) {// cannot find type if items Found equals 0 and warningIfFound true
			text = new Label("cannot find " + brand + " " + type);
		}
		if (itemsFound > 0 && warningIfFound) {// already exists brand and type if items found grater than 0 and
												// warningIfFound false
			text = new Label(brand + "  " + type + " already exists");
		}
		if (itemsFound == 1) {
			return index;
		}
		return -1;
	}

	
	
	// in this method to print report item
	public String stockReport() {
		double total = 0;
		String report = "";
		
		for (int i = 0; i < inventory.size(); i++) {
			
			Item item = inventory.get(i); // What is returned from the array is stored in item
			
			if (item instanceof Brand) {
				report += ((Brand) item).getBrand() + " " + item.getType() + " - in the stock: " + item.getQuantity()+ ", price: $" + item.getPrice() + "\n";
			} else {
				report += (item.getType()) + " - in the stock: " + item.getQuantity() + ", price: $" + item.getPrice()+ "\n";
			}
			total += item.getPrice() * item.getQuantity();// to calculate total
		}
		report += "Total value: $" +total;
		return report;
	}

	
	
	
	// the method search according type
	public Item serchItem(String type) {
		int index = findItem(type, false);
		if (index != -1) {// exist object
			return inventory.get(index);//return object at index
		}
		return null;
	}

	
	
	// the method search according type and brand
	public Item serchItem(String brand, String type) {
		int index = findItem(type, false, brand);
		if (index != -1) {// exist object
			return inventory.get(index);//return object at index
		}
		return null;

	}

}
