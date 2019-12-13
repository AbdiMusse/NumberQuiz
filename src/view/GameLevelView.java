package view;

import controller.SnakeGameController;
import controller.WriteNameController;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import model.Model;

/**
 * Displays the page that displays the options to play the game.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class GameLevelView extends View {

	public ButtonCreation backButton, level1, level2, level3, level4;
	public static int level;

	public GameLevelView(Pane root, Model model, NumberQuiz main) {
		super(root, model, main);
		addCanvasPicture(); // Creates the background

		// Creates multiple buttons in specific places that specifies the level to play
		level1 = new ButtonCreation(root, "Level 1 - Add", 16, 400, 100);
		level2 = new ButtonCreation(root, "level 2 - Subtract", 16, 400, 200);
		level3 = new ButtonCreation(root, "Level 3 - Multiply", 16, 400, 300);
		level4 = new ButtonCreation(root, "Level 4 - Divide", 16, 400, 400);
		// Creates the back button and styles it differently
		backButton = new ButtonCreation(root, "", 16, 0, 10);
		backButton.backButtonStyle();
		// If the page is entered from passing a level, don't show the back button
		if (SnakeGame.option != null && SnakeGame.option.equals("nextLevel"))
			root.getChildren().remove(backButton.b);
	}

	/**
	 * Takes the user to the actual game by changing the view and controller.
	 * Changes the pane to flowPane to display two panes when playing the game.
	 */
	public void playLevel() {
		removeRootObjects(); // Remove everything in root
		FlowPane pane = new FlowPane();
		main.scene.setRoot(pane);
		SnakeGame snakeGame = new SnakeGame(
				pane, model, main, MultiplayerView.isPlayer2, GameLevelView.level);
		main.updatePage(snakeGame, new SnakeGameController(model, snakeGame));
	}

	/**
	 * Takes the user to the previous page by changing the view and controller.
	 */
	public void goBackView() {
		removeRootObjects();
		WriteNameView writeNameView = new WriteNameView(root, model, main);
		main.updatePage(writeNameView, new WriteNameController(model, writeNameView));
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