package controller;

import model.Model;
import view.WriteNameView;

/**
 * A Controller class that handles the user action when the game user writes
 * their name. Sends user back to the choosing players option or to choosing the
 * level to play.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class WriteNameController implements ControllerIF {

	private Model model;
	private WriteNameView writeNameView;

	public WriteNameController(Model model, WriteNameView writeNameView) {
		super();
		this.model = model;
		this.writeNameView = writeNameView;

		// Handles the button action using lambda expressions and sends user to the right page
		this.writeNameView.playGameButton.b.setOnAction(e -> this.writeNameView.gameModeView());
		this.writeNameView.backButton.b.setOnAction(e -> this.writeNameView.goBackView());
	}

}