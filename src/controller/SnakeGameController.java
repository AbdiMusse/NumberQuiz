package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Model;
import view.SnakeGame;

/**
 * A Controller class that handles the user action (snake moving) while playing
 * the actual game.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class SnakeGameController implements ControllerIF {

	private Model model;
	private SnakeGame snakeGame;
	// Decides what happens when a user presses a certain key for player 1 and 2
	// Also stops the snake from moving at the opposite direction
	private EventHandler<KeyEvent> eventHandler = new EventHandler<KeyEvent>() {
		@Override
		public void handle(KeyEvent key) {
			if (key.getCode() == KeyCode.UP) { // For player 1
				if (snakeGame.dirPlayer1 != "down")
					snakeGame.dirPlayer1 = "up";
			}
			if (key.getCode() == KeyCode.W) { // For player 2
				if (snakeGame.dirPlayer2 != "down")
					snakeGame.dirPlayer2 = "up";
			}
			if (key.getCode() == KeyCode.LEFT) { // For player 1
				if (snakeGame.dirPlayer1 != "right")
					snakeGame.dirPlayer1 = "left";
			}
			if (key.getCode() == KeyCode.A) { // For player 2
				if (snakeGame.dirPlayer2 != "right")
					snakeGame.dirPlayer2 = "left";
			}
			if (key.getCode() == KeyCode.DOWN) { // For player 1
				if (snakeGame.dirPlayer1 != "up")
					snakeGame.dirPlayer1 = "down";
			}
			if (key.getCode() == KeyCode.S) { // For player 2
				if (snakeGame.dirPlayer2 != "up")
					snakeGame.dirPlayer2 = "down";
			}
			if (key.getCode() == KeyCode.RIGHT) { // For player 1
				if (snakeGame.dirPlayer1 != "left")
					snakeGame.dirPlayer1 = "right";
			}
			if (key.getCode() == KeyCode.D) { // For player 2
				if (snakeGame.dirPlayer2 != "left")
					snakeGame.dirPlayer2 = "right";
			}
		}
	};

	public SnakeGameController(Model model, SnakeGame snakeGame) {
		super();
		this.model = model;
		this.snakeGame = snakeGame;

		// Handles the snake movement when the user presses a key
		this.snakeGame.main.scene.setOnKeyPressed(eventHandler);
	}

}