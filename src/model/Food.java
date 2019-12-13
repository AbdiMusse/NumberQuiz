package model;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * An abstract class that is extends the GameObject. Used for the different
 * types of food. Specifies a new location for the food and allows to draw the food.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public abstract class Food extends GameObject {
	protected double blockSize = 30;
	protected Random random = new Random();

	public Food(GraphicsContext gc, double x, double y) {
		super(gc, x, y);
	}

	/**
	 * This draws a rectangle with a number inside it at a certain point on the screen.
	 * 
	 * @param number The number that will be inside the rectangle
	 */
	public void drawObject(String number) {
		gc.setFill(Color.BROWN);
		gc.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
		gc.setFill(Color.WHITE);
		gc.setFont(new Font("", 16));
		gc.fillText(number, (x * blockSize) + 2, (y * blockSize) + 20);
	}

	/**
	 * This draws a new rectangle at a different location on the screen
	 * 
	 * @param foodX new x position
	 * @param foodY new y position
	 */
	public void newPostion(double foodX, double foodY) {
		x = foodX; y = foodY;
		gc.fillRect(foodX * blockSize, foodY * blockSize, blockSize, blockSize);
		gc.setFill(Color.WHITE);
		gc.setFont(new Font("", 16));
	}

}