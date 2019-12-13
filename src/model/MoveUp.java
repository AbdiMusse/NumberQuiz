package model;

/**
 * A class that represents the strategy of moving up. 
 * Part of the Strategy Pattern.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class MoveUp implements StrategyIF {

	/**
	 * Makes the snake move up.
	 * 
	 * @param snake 	The snake that will be moving
	 */
	@Override
	public void movement(Snake snake) {
		snake.setY(snake.getY()-1);
	}

	/**
	 * Checks if the snake has hit the top of the snake.
	 * 
	 * @param end   	The top of the screen
	 * @param snake 	The snake that will be moving
	 * @return 			True, if the snake hit the top of the screen
	 */
	@Override
	public Boolean checkMovement(double end, Snake snake) {
		boolean gameOver = false;
		if (snake.getY() < 0) {
			gameOver = true;
		}
		return gameOver;
	}

}