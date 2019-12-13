package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * A class that displays a single orange box that will be used to 
 * display the free food
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class FoodGetter extends Food {

	public FoodGetter(GraphicsContext gc, double x, double y) {
		super(gc, x, y);
		drawObject();
	}

	/**
	 * Draws a rectangle with a specific position on the screen
	 */
	public void drawObject() {
		gc.setFill(Color.ORANGE);
		gc.setStroke(Color.YELLOW);
		gc.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
	}

	/**
	 * defines a new x and y position for the object which will change 
	 * the position of the rectangle
	 */
	public void newPostion(double foodX, double foodY) {
		x = foodX; y = foodY;
	}
}