package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * An abstract class that is used to create all the other main game objects.
 * Used by the factory class for the Design Pattern
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public abstract class GameObject {
	protected Image img;
	protected double x, y;
	protected GraphicsContext gc;

	public GameObject(GraphicsContext gc, double x, double y) {
		this.gc = gc;
		this.x = x;
		this.y = y;
	}

	/**
	 * Display the image of the class on the screen
	 */
	public void update() {
		if (img != null)
			gc.drawImage(img, x * 30, y * 30, 30, 30);
	}

	/**
	 * Set the vlaue of x
	 * 
	 * @param x
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Set the value of y
	 * 
	 * @param y
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Get the value of x
	 * 
	 * @return
	 */
	public double getX() {
		return x;
	}

	/**
	 * Get the value of y
	 * 
	 * @return
	 */
	public double getY() {
		return y;
	}

}