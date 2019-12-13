package view;

import controller.HomeController;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.Model;

/**
 * Displays the page that teaches the player how to play and of the rules.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class InstructionView extends View {

	public ButtonCreation backButton;
	private LabelCreation header, objective, foodLabel, fruitsLabel, player1, player2;

	public InstructionView(Pane root, Model model, NumberQuiz main) {
		super(root, model, main);
		addCanvasPicture(); // Creates the background

		// The words that will be shown in the label and will appear on the screen
		String objctive = "Be a Math Master by guiding your snake to the right\n answer and help it grow"
				+ "\nAnswer 10 questions to beat the level and move to the next";
		String freeFood = "To have access to all the free food, eat this";
		String fruits = "For free points, eat as much fruit as you can";

		// Creating the back button and styling it differently
		backButton = new ButtonCreation(root, "", 16, 0, 10);
		backButton.backButtonStyle();

		// Create the labels and making them appear on the screen
		header = new LabelCreation(root, "How to play", Color.BLUE, 60, 300, 50);
		objective = new LabelCreation(root, objctive, Color.WHITE, 30, 50, 150);
		foodLabel = new LabelCreation(root, freeFood, Color.WHITE, 30, 50, 300);
		fruitsLabel = new LabelCreation(root, fruits, Color.WHITE, 30, 50, 400);
		player1 = new LabelCreation(root, "Player 1 controls", Color.WHITE, 20, 120, 500);
		player2 = new LabelCreation(root, "Player 2 controls", Color.WHITE, 20, 610, 500);
		
		// Draw an orange rectangle on the screen
		graphicsContext.setFill(Color.ORANGE);
		graphicsContext.fillRect(700, 300, 30, 30);
		// Draw 2 images of the controls for the snake on the screen
		graphicsContext.drawImage(new Image("res/apple.png"), 750, 400, 40, 40);
		graphicsContext.drawImage(new Image("res/snakeControl.png"), 300, 350, 300, 300);
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
	 * page that will take its' place
	 */
	private void removeRootObjects() {
		for (int i = 0; i < root.getChildren().size(); i++) {
			root.getChildren().remove(i);
		}
	}

}