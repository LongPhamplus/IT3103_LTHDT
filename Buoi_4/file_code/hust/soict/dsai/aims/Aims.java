package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	// Create a new Cart
	 private static Store myStore = new Store();
	 private static Cart myCart = new Cart();
	 private static Scanner scanner = new Scanner(System.in);
	
	 public static void main(String[] args) {
        ArrayList<Track> track = new ArrayList<>();
        track.add(new Track("This's not tracks", 1));
        
        ArrayList<String> author = new ArrayList<>();
        author.add("LongPahm");
        
        CompactDisc cd = new CompactDisc(1, "This's not a title", "This's not category", 1234.0, "This's not diractor", 4567, "This's not artist", track);
        DigitalVideoDisc dvd = new DigitalVideoDisc(2, "hehe", "Drama", "LongPahm", 12, 123.0);
        Book book = new Book(3, "Title", "Don't know", 123.0, author);
        
        myStore.addMedia(cd);
        myStore.addMedia(dvd);
        myStore.addMedia(book);

        showMenu();
    }
	
	public static void showMenu() {
		while (true) {
			System.out.println("AIMS: ");
			System.out.println("------------------------------------------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("------------------------------------------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
			
			int command = scanner.nextInt();
			
			switch(command) {
			case 1:
				for (Media me: myStore.itemsInStore) {
					System.out.println(me.toString());
				}
				storeMenu();
				break;
			case 2:
				updateStore();
				break;
			case 3:
				seeCurrentCart();
				break;
			case 0:
				System.out.println("Exiting the program.");
				break;
			default:
				System.out.println("Please choose a number: 0-1-2-3");
			}
		}
	}
	public static void storeMenu() {
		while (true) {
			System.out.println("Options: ");
			System.out.println("------------------------------------------------------------------");
			System.out.println("1. See a media's details");
			System.out.println("2. Add a media to cart"); 
			System.out.println("3. Play a media");
			System.out.println("4. See current cart");
			System.out.println("0. Back");
			System.out.println("------------------------------------------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");
			
			int command = scanner.nextInt();
			
			switch(command) {
			case 1:
				seeMediaDetails();
				break;
			case 2:
				addMediaToCart();
				break;
			case 3:
				playMedia();
				break;
			case 4:
				seeCurrentCart();
				cartMenu();
				break;
			case 0:
				showMenu();
				break;
			default:
				System.out.println("Please choose a number: 0-1-2-3");
			}
		}
	}
	public static void mediaDetailsMenu() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("------------------------------------------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("------------------------------------------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    addMediaToCart();
                    break;
                case 2:
                    playMedia();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Please choose a valid number: 0-1-2");
            }
        }
    }
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");

		Scanner scanner = new Scanner(System.in);
		int command = scanner.nextInt();
		
		switch(command) {
		case 1:
			filterMediasInCart();
			break;
		case 2:
			sortMediasInCart();
			break;
		case 3:
			removeMediaFromCart();
			break;
		case 4:
			playMedia();
			cartMenu();
		case 5:
			break;
		case 0:
			storeMenu();
			break;
		default:
			System.out.println("Please choose a number: 0-1-2-3");
		}
		scanner.close();
	}
	public static void seeMediaDetails() {
		System.out.println("Enter the title of the media: ");
		scanner.nextLine();
	    String title = scanner.nextLine();

	    Media foundMedia = null;
	    for (Media media : myStore.itemsInStore) {
	        if (media.getTitle().equalsIgnoreCase(title)) {
	            foundMedia = media;
	            break;
	        }
	    }

	    if (foundMedia == null) {
	        System.out.println("The media with the title \"" + title + "\" does not exist.");
	        scanner.close();
	        return;
	    }

	    System.out.println("Details of the media:");
	    System.out.println(foundMedia.toString());

	    mediaDetailsMenu();
	}
	public static void updateStore() {
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter the ID of the media: ");
	    int id = scanner.nextInt();
	    scanner.nextLine();

	    System.out.println("Enter the title of the media: ");
	    String title = scanner.nextLine();

	    System.out.println("Enter the category of the media: ");
	    String category = scanner.nextLine();

	    System.out.println("Enter the cost of the media: ");
	    double cost = scanner.nextDouble();

	    Media newMedia = new Media(id, title, category, cost);

	    if (myStore.itemsInStore.contains(newMedia)) {
	        System.out.println("This media already exists in the store.");
	    } else {
	    	myStore.addMedia(newMedia);
	    }
	    scanner.close();
	}
	public static void seeCurrentCart() {
	    if (myCart.itemsOrdered.isEmpty()) {
	        System.out.println("The cart is empty.");
	    } else {
	        System.out.println("Current cart contains:");
	        for (Media media : myCart.itemsOrdered) {
	            System.out.println(media.toString()); 
	        }
	    }
	}
	 public static void addMediaToCart() {
        System.out.println("Enter the title of the media you want to add: ");
        scanner.nextLine(); 
        String title = scanner.nextLine();

        Media mediaToAdd = null;
        for (Media media : myStore.itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                mediaToAdd = media;
                break;
            }
        }

        if (mediaToAdd == null) {
            System.out.println("The media with the title \"" + title + "\" does not exist in the store.");
        } else {
            myCart.addMedia(mediaToAdd);
            System.out.println("Added " + title + " to the cart.");
        }
    }
	 public static void playMedia() {
        System.out.println("Enter the title of the media you want to play: ");
        scanner.nextLine();
        String title = scanner.nextLine();

        Media mediaToPlay = null;
        for (Media media : myCart.itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                mediaToPlay = media;
                break;
            }
        }

        if (mediaToPlay == null) {
            System.out.println("The media with the title \"" + title + "\" is not in the cart.");
            return;
        }

        if (mediaToPlay instanceof CompactDisc) {
            CompactDisc cd = (CompactDisc) mediaToPlay;
            System.out.println("Now playing the CD: " + cd.getTitle());
        } else if (mediaToPlay instanceof DigitalVideoDisc) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) mediaToPlay;
            System.out.println("Now playing the DVD: " + dvd.getTitle());
        } else {
            System.out.println("Sorry, the media \"" + mediaToPlay.getTitle() + "\" cannot be played.");
        }
    }
	public static void filterMediasInCart() {
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Filter options:");
	    System.out.println("1. Filter by ID");
	    System.out.println("2. Filter by title");
	    System.out.println("Please choose a filter option: 1 or 2");

	    int filterChoice = scanner.nextInt();
	    scanner.nextLine(); // Consume newline

	    List<Media> filteredMedia = new ArrayList<>();

	    switch (filterChoice) {
	        case 1:
	            System.out.println("Enter the ID of the media to filter:");
	            int idFilter = scanner.nextInt();
	            scanner.nextLine(); // Consume newline
	            for (Media media : myCart.itemsOrdered) {
	                if (media.getId() == idFilter) {
	                    filteredMedia.add(media);
	                }
	            }
	            break;

	        case 2:
	            System.out.println("Enter the title of the media to filter:");
	            String titleFilter = scanner.nextLine();
	            for (Media media : myCart.itemsOrdered) {
	                if (media.getTitle().equalsIgnoreCase(titleFilter)) {
	                    filteredMedia.add(media);
	                }
	            }
	            break;

	        default:
	            System.out.println("Invalid option.");
	            scanner.close();
	            return;
	    }

	    if (filteredMedia.isEmpty()) {
	        System.out.println("No media found matching the filter.");
	    } else {
	        System.out.println("Filtered media:");
	        for (Media media : filteredMedia) {
	            System.out.println(media.toString());
	        }
	    }
	    scanner.close();
	    cartMenu();
	}
	public static void sortMediasInCart() {
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Sort options:");
	    System.out.println("1. Sort by title");
	    System.out.println("2. Sort by cost");
	    System.out.println("Please choose a sort option: 1 or 2");

	    int sortChoice = scanner.nextInt();
	    scanner.nextLine();

	    switch (sortChoice) {
	        case 1:
	            myCart.itemsOrdered.sort((media1, media2) -> media1.getTitle().compareToIgnoreCase(media2.getTitle()));
	            break;

	        case 2:
	        	myCart.itemsOrdered.sort((media1, media2) -> Double.compare(media1.getCost(), media2.getCost()));
	            break;

	        default:
	            System.out.println("Invalid option. Sorting will not be applied.");
	            scanner.close();
	            return;
	    }

	    System.out.println("Media sorted:");
	    for (Media media : myCart.itemsOrdered) {
	        System.out.println(media.toString());
	    }
	    scanner.close();
	    cartMenu();
	}
	public static void removeMediaFromCart() {
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter the title of the media to remove: ");
	    String titleToRemove = scanner.nextLine();

	    Media mediaToRemove = null;
	    for (Media media : myCart.itemsOrdered) {
	        if (media.getTitle().equalsIgnoreCase(titleToRemove)) {
	            mediaToRemove = media;
	            break;
	        }
	    }

	    if (mediaToRemove != null) {

	        myCart.removeMedia(mediaToRemove);
	    } else {
	        System.out.println("The media with the title \"" + titleToRemove + "\" is not in the cart.");
	    }
	    scanner.close();
	    cartMenu();
	}
}
