package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

	private boolean mode = true;
	
    @FXML
    private Pane drawingAreaPane;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if (mode) {
    		Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK); 
        	drawingAreaPane.getChildren().add(newCircle);
    	} else {
    		Circle newCircle = new Circle(event.getX(), event.getY(), 6, Color.WHITE); 
        	drawingAreaPane.getChildren().add(newCircle);
    	}
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }
    
    @FXML
    void eraseTool(ActionEvent event) {
    	mode = false;
    }

    @FXML
    void penTool(ActionEvent event) {
    	mode = true;
    }
}
