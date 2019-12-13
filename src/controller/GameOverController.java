package controller;

import model.Model;
import view.GameOverView;
import view.SnakeGame;

/**
 * A Controller class that handles the user action when the game is over. Sends
 * user to the home page or the rank page depending on what the user chooses.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class GameOverController implements ControllerIF {

	private Model model;
	private GameOverView gameOVerView;

	public GameOverController(Model model, GameOverView gameOVerView) {
		super();
		this.model = model;
		this.gameOVerView = gameOVerView;

		// Handles the button action using lambda expressions and sends user to the right page
		this.gameOVerView.homeButton.b.setOnAction(e -> this.gameOVerView.goHomeView());
		// To avoid error, only one of these buttons should work depending on game status
		if (SnakeGame.option.equals("gameOver"))
			this.gameOVerView.viewRankButton.b.setOnAction(e -> this.gameOVerView.goRankView());
		else if (SnakeGame.option.equals("nextLevel"))
			this.gameOVerView.nextLevelButton.b.setOnAction(e -> this.gameOVerView.nextLevel());
	}

}