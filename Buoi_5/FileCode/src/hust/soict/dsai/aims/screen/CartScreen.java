package hust.soict.dsai.aims.screen;

import java.io.IOException;
import javax.swing.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.dsai.aims.cart.Cart;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();

        this.cart = cart;
        JFXPanel fxPanel = new JFXPanel(); // JavaFX panel for Swing
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(800, 600); // Set JFrame size
        this.setVisible(true);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
                CartScreenController controller = new CartScreenController(cart);

                loader.setController(controller);

                Parent root = loader.load();
                fxPanel.setScene(new Scene(root));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
