package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * A class that represents part of the snake. 
 * Holds all the information related to the snake.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class Snake extends GameObject {
	private double blockSize = 30;
	private StrategyIF strategy;

	public Snake(GraphicsContext gc, double x, double y) {
		super(gc, x, y);
	}

	/**
	 * Set the strategy that will be used for the snake
	 * 
	 * @param strategy one of the movements
	 */
	public void setStrategy(StrategyIF strategy) {
		this.strategy = strategy;
	}

	/**
	 * The movement of the snake depending on the strategy that is in use
	 */
	public void movement() {
		this.strategy.movement(this);
	}

	/**
	 * Checks if the snake hits any of the corners. 
	 * Uses the method held by the strategy object for the movement.
	 * 
	 * @param end corners
	 * @return true or false
	 */
	public boolean checkClash(double end) {
		return this.strategy.checkMovement(end, this);
	}

	/**
	 * Draw a rectangle that represents the a part of the snake body. 
	 * This is for player 1.
	 */
	public void drawObject() {
		gc.setFill(Color.LIMEGREEN);
		gc.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
		gc.setFill(Color.GREEN);
		gc.fillRect(x * blockSize, y * blockSize, blockSize - 2, blockSize - 2);
	}

	/**
	 * Draw a rectangle that represents the a part of the snake body. 
	 * This is for player 2.
	 */
	public void drawObject2() {
		gc.setFill(Color.DARKMAGENTA);
		gc.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
		gc.setFill(Color.MAGENTA);
		gc.fillRect(x * blockSize, y * blockSize, blockSize - 2, blockSize - 2);
	}

}