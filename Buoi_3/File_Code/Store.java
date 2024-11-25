package MyPackage;

public class Store {
	public static final int MAX_NUMBER_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDVD (DigitalVideoDisc ...dvdList) {
		for (DigitalVideoDisc disc: dvdList) {
			if (qtyOrdered < MAX_NUMBER_ORDERED) {
				itemOrdered[qtyOrdered] = disc;
				++qtyOrdered;
				System.out.println("The Disc has been added !!!");
			} else {
				System.out.println("The Cart is already full !!!");
			}
		}
	}
	public void removeDVD (DigitalVideoDisc disc) {
		boolean found = false;
		
		for (int i = 0 ; i < qtyOrdered ; ++i) {
			if (itemOrdered[i].equals(disc)) {
				found = true;
				for (int j = i ; j < qtyOrdered ; ++j) {
					itemOrdered[j] = itemOrdered[j + 1];
				}
				itemOrdered[qtyOrdered] = null; 
				--qtyOrdered;
				System.out.println("The Disc has been removed successfully !!!");
				break;
			}
		}
		
		if (!found) {
			System.out.println("Disk not found !!!");
		}
	}
}
