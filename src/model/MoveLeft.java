package model;

/**
 * A class that represents the strategy of moving left. 
 * Part of the Strategy Pattern.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class MoveLeft implements StrategyIF {

	/**
	 * Makes the snake move left.
	 * 
	 * @param snake 	The snake that will be moving
	 */
	@Override
	public void movement(Snake snake) {
		snake.setX(snake.getX()-1);
	}

	/**
	 * Checks if the snake has hit the left side of the snake.
	 * 
	 * @param end   	The left side of the screen
	 * @param snake 	The snake that will be moving
	 * @return 			True, if the snake hit the left side of the screen
	 */
	@Override
	public Boolean checkMovement(double end, Snake snake) {
		boolean gameOver = false;
		if (snake.getX() < 0) {
			gameOver = true;
		}
		return gameOver;
	}

}