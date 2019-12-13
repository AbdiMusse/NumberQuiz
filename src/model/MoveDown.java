package model;

/**
 * A class that represents the strategy of moving down. 
 * Part of the Strategy Pattern.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class MoveDown implements StrategyIF {

	/**
	 * Makes the snake move down.
	 * 
	 * @param snake 	The snake that will be moving
	 */
	@Override
	public void movement(Snake snake) {
		snake.setY(snake.getY() + 1);
	}

	/**
	 * Checks if the snake has hit the bottom of the snake.
	 * 
	 * @param end   	The bottom of the screen
	 * @param snake 	The snake that will be moving
	 * @return 			True, if the snake hit the bottom of the screen
	 */
	@Override
	public Boolean checkMovement(double end, Snake snake) {
		boolean gameOver = false;
		if (snake.getY() >= end) {
			gameOver = true;
		}
		return gameOver;
	}

}