package hust.soict.dsai.aims.screen;

import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.element.MediaStore;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import java.awt.*;
import java.util.ArrayList;


public class StoreScreen extends JFrame{
	private Store store;
	
	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(cart), BorderLayout.CENTER);
		
		
		setTitle("Store");
		setVisible(true);
		setSize(800, 600);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Option");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		smUpdateStore.add("Add Book");
		smUpdateStore.add("Add CD");
		smUpdateStore.add("Add DVD");
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View Cart"));
		menu.add(new JMenuItem("View Store"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		menuBar.setPreferredSize(new Dimension(800, 30));
		
		return menuBar;
	}
	
	JPanel createHeader() {
		
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout (header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground (Color.CYAN);
		
		JButton cart = new JButton("View cart");
		cart.setPreferredSize (new Dimension(100, 50));
		cart.setMaximumSize (new Dimension (100, 50));
		header.add(Box.createRigidArea (new Dimension (10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea (new Dimension (10, 10)));
		
		return header;
	}
	
	JPanel createCenter(Cart cart) {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout (3, 3, 2, 2));
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		
		for (int i = 0; i < 9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
			center.add(cell);
		}
		return center;
	}
}
