package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private int qtyOrdered = 0;
	public ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	
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
	
//	public void printCart() {
//		System.out.println("******************************CART******************************");
//		System.out.println("Ordered Items:");
//		for (int i = 0; i < qtyOrdered; ++i) {
//            DigitalVideoDisc dvd = itemsOrdered[i];
//            if (dvd != null) {
//                System.out.println(dvd.getId() + ". " + dvd.getTitle() + " - " + dvd.getCategory() + " - " + dvd.getDirector() + " - " + dvd.getLength() + ": " + dvd.getCost() + " $ ");
//            }
//        }
//		System.out.println("Total cost: " + totalCost());
//		System.out.println("****************************************************************");
//	}
//	
//	public void searchDVDById(int id) {
//		boolean check = false;
//		for (int i = 0; i < qtyOrdered; ++i) {
//            DigitalVideoDisc dvd = itemOrdered[i];
//            if (dvd != null && id == dvd.getId()) {
//                System.out.println(dvd.getId() + ". " + dvd.getTitle() + " - " + dvd.getCategory() + " - " + dvd.getDirector() + " - " + dvd.getLength() + ": " + dvd.getCost() + " $ ");
//                check = true;
//            } 
//        }
//		if (!check) {
//			System.out.println("DVD id " + id + " not found.");
//		}
//	}
//	public void searchDVDByTitle(String title) {
//		boolean check = false;
//		for (int i = 0; i < qtyOrdered; ++i) {
//            DigitalVideoDisc dvd = itemOrdered[i];
//            if (dvd != null && title.equals(dvd.getTitle())) {
//                System.out.println(dvd.getId() + ". " + dvd.getTitle() + " - " + dvd.getCategory() + " - " + dvd.getDirector() + " - " + dvd.getLength() + ": " + dvd.getCost() + " $ ");
//                check = true;
//            } 
//        }
//		if (!check) {
//			System.out.println("DVD title " + title + " not found.");
//		}
//	}
}
