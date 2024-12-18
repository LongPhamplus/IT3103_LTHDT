package MyPackage;

public class StoreTest {
	public static void main(String[] args) {
		// Create a new Cart
		Store newOrder = new Store();
		
		DigitalVideoDisc disc1 = new DigitalVideoDisc(1, "The King of Lion", "LiveAction", "LongPahm", 69, 19.99);
		DigitalVideoDisc disc2 = new DigitalVideoDisc(2, "Avenger: End game", "LiveAction", "Anthony Russo", 119, 11.99);
		DigitalVideoDisc disc3 = new DigitalVideoDisc(3, "Hercules", "Cartoon", "Anthony Russo", 79, 10.99);
		DigitalVideoDisc disc4 = new DigitalVideoDisc(4, "The King of Lion", "LiveAction", "LongPahm", 99, 9.99);
		
		newOrder.addDVD(disc1, disc2, disc3, disc4);
		newOrder.removeDVD(disc4);
		
//		System.out.print("Total cost is: ");
//		System.out.println(newOrder.totalCost());
//		
//		newOrder.removeDigitalVideoDisc(disc1);
//		System.out.print("Total cost is: ");
//		System.out.println(newOrder.totalCost());
	}
}
