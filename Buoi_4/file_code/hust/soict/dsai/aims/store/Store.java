package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
	public static final int MAX_NUMBER_ORDERED = 20;
	public ArrayList<Media> itemsInStore = new ArrayList<Media>();
	private int qtyOrdered = 0;
	
	public void addMedia(Media media) {
		if (qtyOrdered < MAX_NUMBER_ORDERED) {
			itemsInStore.add(media);
			qtyOrdered ++;
			System.out.	println("Media has been added.");
		} else {
			System.out.println("There are not enough space.");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			qtyOrdered --;
			System.out.println("Media has been removed.");
		} else {
			System.out.println("Media does not exsist.");
		}
	}
}
