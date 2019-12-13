package controller;

import model.Model;
import view.InstructionView;

/**
 * A Controller class that handles the user action when in the how to play page.
 * Sends user back to the home page.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class InstructionController implements ControllerIF {

	private Model model;
	private InstructionView instructionView;

	public InstructionController(Model model, InstructionView instructionView) {
		super();
		this.model = model;
		this.instructionView = instructionView;

		// Handles the button action using lambda expressions and sends user to the right page
		this.instructionView.backButton.b.setOnAction(e -> instructionView.goBackView());
	}

}