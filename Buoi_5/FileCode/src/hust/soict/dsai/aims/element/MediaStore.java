package hust.soict.dsai.aims.element;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.screen.DialogScreen;
import hust.soict.dsai.interfaces.Playable;

public class MediaStore extends JPanel{
	private Media media;
	private Cart cart;
	
	public MediaStore (Media media, Cart cart) {
		this.media= media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.cart = cart;
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout (FlowLayout.CENTER));
		JButton addToCartButton = new JButton("Add to cart");
		
		addToCartButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cart.addMedia(media);
                if(cart.getQty() != 20) {
                	JOptionPane.showMessageDialog(
                        MediaStore.this,
                        media.getTitle() + " has been added to the cart.",
                        "Cart",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                	JOptionPane.showMessageDialog(
                        MediaStore.this,
                        "Cart is full !!!",
                        "Cart",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
			}
		});
		
		container.add(addToCartButton);
		
		
		if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DialogScreen dialog = new DialogScreen(
                        (Frame) SwingUtilities.getWindowAncestor(MediaStore.this),
                        "Play Media",
                        "Now playing: " + media.getTitle()
                    );
                    dialog.setVisible(true);
                }
            });
            container.add(playButton);
        }
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}