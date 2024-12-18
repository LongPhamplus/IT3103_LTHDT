package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.interfaces.Playable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.application.Platform;
import javafx.beans.value.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class CartScreenController {
	private Cart cart;
	private boolean sortBy = true;
	
	
	@FXML
	private TableView<Media> tblMedia;
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	@FXML
	private TableColumn<Media, String> colMediacategory;
	@FXML
	private TableColumn<Media, Float> colMediaCost;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private Label totalCost;
    
	public CartScreenController(Cart cart) {
		this.cart = cart;
	}
	
	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediacategory.setCellValueFactory(new PropertyValueFactory <Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory <Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered()); 
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		this.cart.getItemsOrdered().addListener((ListChangeListener<Media>) change -> updateTotalCost());
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<Media>() {
				@Override
				public void changed (ObservableValue<? extends Media> observable, Media oldValue,Media newValue) {
					if(newValue!=null) {
						updateButtonBar(newValue);
					}
				}
			}
		);
		
		
		
		
		tfFilter.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed (ObservableValue<? extends String> observable, String oldValue, String newValue) {
					showFilteredMedia(newValue);
				}
			}
		);
	}
	@FXML
	private void handleFilter() {
		if (radioBtnFilterId.isSelected()) {
			sortBy = true;
		}
		if (radioBtnFilterTitle.isSelected()) {
			sortBy = false;
		}
	}
	
	@FXML
    void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		System.out.print(media);
		cart.removeMedia(media);
    }
	void updateButtonBar (Media media)
	{
		btnRemove.setVisible(true);
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
		}
	}

	private void showFilteredMedia(String filter) {
	    ObservableList<Media> filteredItems = FXCollections.observableArrayList();
	    
	    for (Media media : cart.getItemsOrdered()) {
	        if (media.getTitle().toLowerCase().contains(filter.toLowerCase())) {
	            filteredItems.add(media);
	        }
	    }
	    
	    tblMedia.setItems(filteredItems);
	}
	
	private void updateTotalCost() {
		Platform.runLater(() -> {
	        totalCost.setText(String.format("%.2f", cart.totalCost()) + " $");
	    });
	}
}
