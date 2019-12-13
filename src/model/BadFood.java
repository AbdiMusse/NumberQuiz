package model;

import javafx.scene.canvas.GraphicsContext;

/**
 * A Class that creates a rectangle with a number a random in it and makes it
 * appears on the screen
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class BadFood extends Food {

	private String stringNumber;

	public BadFood(GraphicsContext gc, double x, double y) {
		super(gc, x, y);
		randomNumber();
		drawObject();
	}

	/**
	 * This draws the food (with the random number) on to the screen by calling
	 * superclass method
	 */
	public void drawObject() {
		super.drawObject(stringNumber);
	}

	/**
	 * Change the position of the rectangle by calling the super class method change
	 * the position of the word (which should be inside the rectangle)
	 */
	public void newPostion(double foodX, double foodY) {
		randomNumber();
		super.newPostion(foodX, foodY);
		gc.fillText(stringNumber, (foodX * blockSize) + 2, (foodY * blockSize) + 20);
	}

	/**
	 * get a random number from 1 - 100, then convert it to a string
	 */
	private void randomNumber() {
		int number = random.nextInt(100 + 1);
		stringNumber = Integer.toString(number);
	}

}