package controller;

import javafx.scene.control.Button;
import model.Model;
import view.MultiplayerView;

/**
 * A Controller class that handles the user action when the game choosing the
 * option of single player or multiple player. Sends user to the home page or
 * allows the player(s) to write their name(s).
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class MultiplayerController implements ControllerIF {

	private Model model;
	private MultiplayerView multiplayerView;

	public MultiplayerController(Model model, MultiplayerView multiplayerView) {
		super();
		this.model = model;
		this.multiplayerView = multiplayerView;

		// Handles the button action using lambda expressions and sends user to the right page
		this.multiplayerView.backButton.b.setOnAction(e -> this.multiplayerView.goBackView());
		playerOption(this.multiplayerView.onePlayerButton.b, false);
		playerOption(this.multiplayerView.twoPalyerButton.b, true);
	}

	/**
	 * This sends the user to the page to write their name(s)
	 * 
	 * @param button  the button to be clicked to handle the event
	 * @param player2 the information passed on to the game to play the right level
	 */
	private void playerOption(Button button, Boolean player2) {
		button.setOnAction(e -> {
			MultiplayerView.isPlayer2 = player2;
			this.multiplayerView.writeNameView();
		});
	}

}