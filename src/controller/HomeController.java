package controller;

import model.Model;
import view.HomeView;

/**
 * A Controller class that handles the user action when the game first starts.
 * Allows the user to play the game, quit, see the ranks, or learn how to play.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class HomeController implements ControllerIF {

	private Model model;
	private HomeView homeView;

	public HomeController(Model model, HomeView homeView) {
		super();
		this.model = model;
		this.homeView = homeView;

		// Handles the button action using lambda expressions and sends user to the right page
		this.homeView.startGameButton.b.setOnAction(e -> this.homeView.choosePlayers());
		this.homeView.instructionButton.b.setOnAction(e -> this.homeView.instructionView());
		this.homeView.rankButton.b.setOnAction(e -> this.homeView.rankView());
		this.homeView.exitButton.b.setOnAction(e -> System.exit(1));
	}

}