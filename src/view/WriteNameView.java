package view;

import controller.GameLevelController;
import controller.MultiplayerController;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Model;

/**
 * Displays the page that allows the user(s) to write their name.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class WriteNameView extends View {

	public ButtonCreation playGameButton, backButton;
	public static String playerName1, playerName2;
	private LabelCreation nameLabel1, nameLabel2;
	private TextField nameField1, nameField2;

	public WriteNameView(Pane root, Model model, NumberQuiz main) {
		super(root, model, main);
		addCanvasPicture(); // Creates the background

		// Creates the buttons and text fields and displays them at a specific position
		playGameButton = new ButtonCreation(root, "Start", 16, 400, 450);
		backButton = new ButtonCreation(root, "", 16, 0, 10);
		backButton.backButtonStyle(); // Different style
		nameLabel1 = new LabelCreation(root, "Please enter your name:", Color.WHITE, 16, 400, 300);
		nameField1 = createTextField(350, 350);

		if (MultiplayerView.isPlayer2 == true) { 	// checks if it's 1 or 2 player
			// change text and position accordingly
			nameLabel1.l.setText("Player one name:");
			nameLabel1.l.setLayoutX(100);
			nameLabel1.l.setLayoutY(300);

			nameField1.setPrefSize(300, 50);
			nameField1.setLayoutX(100);
			nameField1.setLayoutY(350);

			nameLabel2 = new LabelCreation(root, "Player two name:", Color.WHITE, 16, 600, 300);
			nameField2 = createTextField(600, 350);
		}
	}

	/**
	 * Checks if the user(s) have typed in their name(s). 
	 * Takes the user to choose a level by changing the view and controller.
	 */
	public void gameModeView() {
		if (nameField2 != null) {
			playerName1 = nameField1.getText();
			playerName2 = nameField2.getText();
			if (playerName1.length() > 0 && playerName2.length() > 0) {
				removeRootObjects();
				GameLevelView gameLevelView = new GameLevelView(root, model, main);
				main.updatePage(gameLevelView, new GameLevelController(model, gameLevelView));
			} else {
				nameLabel1.l.setFont((new Font("Cooper Black", 22)));
				nameLabel1.l.setTextFill(Color.RED);

				nameLabel2.l.setFont((new Font("Cooper Black", 22)));
				nameLabel2.l.setTextFill(Color.RED);
			}
		} else {
			playerName1 = nameField1.getText();
			if (playerName1.length() > 0) {
				removeRootObjects();
				GameLevelView gameLevelView = new GameLevelView(root, model, main);
				main.updatePage(gameLevelView, new GameLevelController(model, gameLevelView));
			} else {
				nameLabel1.l.setLayoutX(350);
				nameLabel1.l.setFont((new Font("Cooper Black", 22)));
				nameLabel1.l.setTextFill(Color.RED);
			}
		}
	}

	/**
	 * Takes the user to the previous page by changing the view and controller.
	 */
	public void goBackView() {
		removeRootObjects();
		MultiplayerView multiplayerView = new MultiplayerView(root, model, main);
		main.updatePage(multiplayerView, new MultiplayerController(model, multiplayerView));
	}

	/**
	 * Creates the text field object and sets it's position and size.
	 * 
	 * @param x
	 * @param y
	 * @return Returns the text field
	 */
	private TextField createTextField(int x, int y) {
		TextField field = new TextField();
		field.setPrefSize(300, 50);
		field.setFont((new Font("Cooper Black", 16)));
		field.setLayoutX(x);
		field.setLayoutY(y);
		root.getChildren().add(field);
		return field;
	}

	/**
	 * Removes all the nodes and elements in the root so it is ready for the new
	 * page that will take its' place
	 */
	private void removeRootObjects() {
		for (int i = 0; i < root.getChildren().size(); i++) {
			root.getChildren().remove(i);
		}
	}

}