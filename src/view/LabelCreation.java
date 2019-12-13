package view;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * A label template that is used in all the label creation. Used in all view
 * classes that show a label.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class LabelCreation {

	public Label l;

	public LabelCreation(Pane root, String word, Color color, int font, int x, int y) {
		super();
		l = new Label(word);
		l.setFont(new Font("Cooper Black", font));
		l.setTextFill(color);
		l.setLayoutX(x);
		l.setLayoutY(y);
		root.getChildren().add(l);
	}
}