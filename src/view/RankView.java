package view;

import java.util.HashMap;

import controller.HomeController;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.Model;
import model.RankDetail;

/**
 * Displays the page that shows the rank of players (only top 10).
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class RankView extends View {

	public ButtonCreation backButton;
	private LabelCreation title, headers, names, scores;
	private HashMap<String, Integer> highScore;

	public RankView(Pane root, Model model, NumberQuiz main) {
		super(root, model, main);
		addCanvasPicture(); // Creates the background

		// Creates the back button and styles it differently
		backButton = new ButtonCreation(root, "", 16, 0, 10);
		backButton.backButtonStyle();

		// Create and display the labels
		title = new LabelCreation(root, "Hall of Fame - top 10 players", Color.RED, 32, 200, 50);
		headers = new LabelCreation(root, "player Name:\t\t\tplayer Score:", Color.WHITE, 26, 200, 150);
		headers.l.setStyle("-fx-border-color: #FFFFFF; -fx-border-width: 0 0 1 0; -fx-underline: true;");
		names = new LabelCreation(root, "", Color.WHITE, 20, 200, 200);
		scores = new LabelCreation(root, "", Color.WHITE, 20, 520, 200);

		highScore = new RankDetail().top10(); // hash map hold top 10 player in order
		// Displayed the top 10 player names with their scores
		for (String i : highScore.keySet()) {
			names.l.setText(names.l.getText() + i + "\n");
			scores.l.setText(scores.l.getText() + highScore.get(i) + "\n");
		}
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