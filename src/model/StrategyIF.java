package model;

/**
 * An interface that is implemented by the class that use a strategy.
 * It enforces the behaviour of the class by having a movement algorithm 
 * and one that checks for collision.
 * Part of the Strategy Design Pattern.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public interface StrategyIF {
	public void movement(Snake snake);
	public Boolean checkMovement(double end, Snake snake);
}