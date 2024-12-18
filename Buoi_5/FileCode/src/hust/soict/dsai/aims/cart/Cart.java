package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private int qtyOrdered = 0;
//	public ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	public void addMedia(Media media) {
		if (qtyOrdered < MAX_NUMBER_ORDERED) {
			itemsOrdered.add(media);
			qtyOrdered ++;
			System.out.println("Media has been added.");
		} else {
			System.out.println("There are not enough space.");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			qtyOrdered --;
			System.out.println("Media has been removed.");
		} else {
			System.out.println("Media does not exsist.");
		}
	}
 	public double totalCost() {
		double totalCost = 0;
		
		for (Media media : itemsOrdered) {
			totalCost += media.getCost();
		}
		
		return totalCost;
	}
 	
 	public ObservableList<Media> getItemsOrdered() {
 		return itemsOrdered;
 	}
 	
 	public int getQty() {
 		return qtyOrdered;
 	}
}
