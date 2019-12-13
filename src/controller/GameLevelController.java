package controller;

import javafx.scene.control.Button;
import model.Model;
import view.GameLevelView;

/**
 * A Controller class that handles the user action when choosing the level of
 * the game. Sends user to the game with the correct information.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class GameLevelController implements ControllerIF {

	private Model model;
	private GameLevelView gameLevelView;

	public GameLevelController(Model model, GameLevelView gameLevelView) {
		super();
		this.model = model;
		this.gameLevelView = gameLevelView;

		// Handles the button action using lambda expressions and sends user to the right page
		this.gameLevelView.backButton.b.setOnAction(e -> this.gameLevelView.goBackView());

		// Calls the gameAction method to go to the game with the right level
		gameAction(this.gameLevelView.level1.b, 1);
		gameAction(this.gameLevelView.level2.b, 2);
		gameAction(this.gameLevelView.level3.b, 3);
		gameAction(this.gameLevelView.level4.b, 4);
	}

	/**
	 * This sends the user to play the game with the correct information
	 * 
	 * @param button the button to be clicked to handle the event
	 * @param level  the information passed on to the game to play the right level
	 */
	private void gameAction(Button button, int level) {
		button.setOnAction(e -> {
			GameLevelView.level = level;
			this.gameLevelView.playLevel();
		});
	}
}