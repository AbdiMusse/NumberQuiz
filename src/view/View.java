package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.Model;

/**
 * Abstract class that is a template for all classes in the view package.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public abstract class View {

	protected Pane root;
	protected Model model;
	protected Canvas canvas;
	protected GraphicsContext graphicsContext;
	protected Image image;
	public NumberQuiz main;

	public View(Pane root, Model model, NumberQuiz main) {
		super();
		this.root = root;
		this.model = model;
		this.main = main;
	}

	/**
	 * Displays the game logo and sets a background colour which covers the screens
	 */
	public void addCanvasPicture() {
		canvas = new Canvas(NumberQuiz.STAGE_WIDTH, NumberQuiz.STAGE_HEIGHT);
		graphicsContext = canvas.getGraphicsContext2D();
		graphicsContext.setFill(Color.LIGHTBLUE);
		graphicsContext.fillRect(0, 0, NumberQuiz.STAGE_WIDTH, NumberQuiz.STAGE_WIDTH);
		image = new Image("res/logo.png");
		graphicsContext.drawImage(image, 650, 0, 300, 200);
		root.getChildren().add(canvas);
	}

}