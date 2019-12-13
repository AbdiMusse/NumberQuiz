package controller;

import model.Model;
import view.RankView;

/**
 * A Controller class that handles the user action when the game is in the
 * ranking page. Sends user back to the home page.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class RankController implements ControllerIF {

	private Model model;
	private RankView rankView;

	public RankController(Model model, RankView rankView) {
		super();
		this.model = model;
		this.rankView = rankView;

		// Handles the button action using lambda expressions and sends user to the right page
		this.rankView.backButton.b.setOnAction(e -> this.rankView.goBackView());
	}

}