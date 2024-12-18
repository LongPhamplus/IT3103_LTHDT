package hust.soict.dsai.aims.screen;

import java.awt.*;

import javax.swing.*;

public class DialogScreen extends JDialog{
	public DialogScreen(Frame owner, String title, String message) {
        super(owner, title, true);
        this.setSize(300, 200);
        this.setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel(message, SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(messageLabel, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> this.dispose());
        this.add(closeButton, BorderLayout.SOUTH);

        this.setLocationRelativeTo(owner);
    }
}
