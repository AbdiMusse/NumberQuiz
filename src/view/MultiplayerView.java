package view;

import controller.HomeController;
import controller.WriteNameController;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import model.Model;

/**
 * Displays the page that allows the user to pick single or multiplayer.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class MultiplayerView extends View {

	public ButtonCreation onePlayerButton, twoPalyerButton, backButton;
	public static boolean isPlayer2;

	public MultiplayerView(Pane root, Model model, NumberQuiz main) {
		super(root, model, main);
		addCanvasPicture(); // Creates the background

		// Creates multiple buttons in specific places that specifies the level to play
		onePlayerButton = new ButtonCreation(root, "1 player", 16, 200, 350);
		twoPalyerButton = new ButtonCreation(root, "2 player", 16, 600, 350);
		backButton = new ButtonCreation(root, "", 16, 0, 10);
		backButton.backButtonStyle(); // Styles button differently

		// Draw 2 images to help user understand the options
		graphicsContext.drawImage(new Image("res/1player.png"), 250, 200, 150, 150);
		graphicsContext.drawImage(new Image("res/2player.png"), 630, 200, 150, 150);
	}

	/**
	 * Takes the user to the page to write their name(s) by changing the view and
	 * controller.
	 */
	public void writeNameView() {
		removeRootObjects();
		WriteNameView i = new WriteNameView(root, model, main);
		main.updatePage(i, new WriteNameController(model, i));
	}

	/**
	 * Takes the user to the previous page by changing the view and controller.
	 */
	public void goBackView() {
		removeRootObjects();
		HomeView homeView = new HomeView(root, model, main);
		main.updatePage(homeView, new HomeController(model, homeView));
	}

	/**
	 * Removes all the nodes and elements in the root so it is ready for the new
	 * page that will take its' place.
	 */
	private void removeRootObjects() {
		for (int i = 0; i < root.getChildren().size(); i++) {
			root.getChildren().remove(i);
		}
	}

}