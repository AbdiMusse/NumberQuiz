package view;

import controller.InstructionController;
import controller.MultiplayerController;
import controller.RankController;
import javafx.scene.layout.Pane;
import model.Model;

/**
 * Displays the home page that lets you pick different options and takes you to
 * new pages such as instruction page, rank page, play game page and a quit option. 
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class HomeView extends View {

	public ButtonCreation startGameButton, instructionButton, rankButton, exitButton;

	public HomeView(Pane root, Model model, NumberQuiz main) {
		super(root, model, main);
		addCanvasPicture(); // Creates the background

		// Creates multiple buttons in specific places that specifies the level to play
		startGameButton = new ButtonCreation(root, "Start Game", 16, 400, 100);
		instructionButton = new ButtonCreation(root, "How To play", 16, 400, 200);
		rankButton = new ButtonCreation(root, "Ranking", 16, 400, 300);
		exitButton = new ButtonCreation(root, "Exit", 16, 400, 400);
	}

	/**
	 * Takes the user to the instruction page by changing the view and controller.
	 */
	public void instructionView() {
		removeRootObjects();
		InstructionView i = new InstructionView(root, model, main);
		main.updatePage(i, new InstructionController(model, i));
	}

	/**
	 * Takes the user to pick 1 or 2 players by changing the view and controller.
	 */
	public void choosePlayers() {
		removeRootObjects();
		MultiplayerView multiplaterView = new MultiplayerView(root, model, main);
		main.updatePage(multiplaterView, new MultiplayerController(model, multiplaterView));
	}

	/**
	 * Takes the user to the ranking page by changing the view and controller.
	 */
	public void rankView() {
		removeRootObjects();
		RankView i = new RankView(root, model, main);
		main.updatePage(i, new RankController(model, i));
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