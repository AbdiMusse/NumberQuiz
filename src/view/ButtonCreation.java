package view;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 * A button template that is used in all the button creation. Used in all view
 * classes that show a button.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class ButtonCreation {

	public Button b;

	public ButtonCreation(Pane root, String word, int font, int x, int y) {
		super();
		b = new Button(word);
		b.setPrefSize(200, 50); // size of the button
		b.setFont(new Font("Cooper Black", font));
		b.setLayoutX(x);
		b.setLayoutY(y);
		// Styling the button, uses gradient to display different colours
		String style = "-fx-background-color: linear-gradient(#ffd65b, #e68400), "
				+ "linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), "
				+ "linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), "
				+ "linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0)); "
				+ "-fx-background-radius: 30; -fx-background-insets: 0,1,2,3,0;";
		b.setStyle(style);
		root.getChildren().add(b); // Make it appear on the screen
	}

	/**
	 * Makes the button an image and merges the background colour with the screen
	 */
	public void backButtonStyle() {
		ImageView backImage = new ImageView("res/back.png");
		backImage.setFitHeight(50);
		backImage.setFitWidth(0);
		this.b.setGraphic(backImage);
		this.b.setStyle("-fx-background-color: LIGHTBLUE");
	}

}