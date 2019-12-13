package model;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * A class that represents a player. 
 * Holds all the information related to player.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class Player {
	private GraphicsContext gc;
	private int noOfLives;
	private int score;
	private Image hearts;
	private ArrayList<Image> lives;
	private ArrayList<Snake> snake;
	private Factory factory;

	public Player(GraphicsContext gc, int startPoint) {
		super();
		this.gc = gc;
		noOfLives = 5;
		score = 0;
		hearts = new Image("res/heart.png");
		lives = new ArrayList<Image>();
		snake = new ArrayList<Snake>();
		factory = new Factory(gc);

		gameLives();
		createBody(startPoint);
	}

	/**
	 * This shows how many lives the player has when starting the game
	 */
	private void gameLives() {
		for (int i = 0; i < noOfLives; i++) {
			lives.add(hearts);
		}
	}

	/**
	 * This creates the snake body when the game starts which is stored in an array.
	 * It starts of with 3 rectangles.
	 * 
	 * @param startPoint 		The position of where the snake is starting from
	 */
	private void createBody(int startPoint) {
		for (int i = 0; i < 3; i++) {
			snake.add((Snake) factory.createProduct("snake", 33 / 4, 16 / startPoint));
			// 33 is width an 16 is height of scene (multiplied by blocksize)
		}
	}

	/**
	 * Add another rectangle to the snake (done when the snake eats right food)
	 */
	public void addSnakeBody() {
		snake.add(new Snake(gc, -1, -1));
	}

	/**
	 * Get the score of the player
	 * 
	 * @return
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the score of the player
	 * 
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Gets the array that holds the lives of the player
	 * 
	 * @return
	 */
	public ArrayList<Image> getLives() {
		return lives;
	}

	/**
	 * Gets the array that holds the snake body
	 * 
	 * @return
	 */
	public ArrayList<Snake> getSnake() {
		return snake;
	}

}