package view;

import controller.GameLevelController;
import controller.HomeController;
import controller.RankController;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.Model;
import model.RankDetail;

/**
 * Displays the page that displays your score and informs you on your state
 * (game over or next level)
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class GameOverView extends View {

	public ButtonCreation homeButton, viewRankButton, nextLevelButton;
	private LabelCreation statusLabel, detail1, detail2;
	private RankDetail rankdetail;
	private static int score1, score2;

	public GameOverView(Pane root, Model model, NumberQuiz main, SnakeGame snakeGame) {
		super(root, model, main);
		addCanvasPicture(); // Creates the background
		homeButton = new ButtonCreation(root, "Home Page", 16, 200, 450); // Button to go home

		// Saves and updates the score of player 1 and/or 2 till it's game over
		score1 += snakeGame.player1.getScore();
		if (WriteNameView.playerName2 != null)
			score2 += snakeGame.player2.getScore();

		if (SnakeGame.option.equals("gameOver")) { // What takes place when it's game over
			main.mediaPlayer.stop(); // Stop music
			main.playsound("losingSound.mp3"); // new music
			recordScore(); // Save score and name

			// Create an display button and labels to a specific place
			viewRankButton = new ButtonCreation(root, "View Rank", 16, 600, 450);
			statusLabel = new LabelCreation(root, "Game Over :(", Color.BLACK, 50, 300, 100);
			detail1 = new LabelCreation(root, "Player 1 final score is: " + score1, 
					Color.WHITE, 30, 300, 300);

			if (WriteNameView.playerName2 != null) { // Change accordingly if player2 exists
				detail1.l.setLayoutX(100);
				detail2 = new LabelCreation(root, "Player 2 final score is: " + score2, 
						Color.WHITE, 30, 500, 300);
			}
			WriteNameView.playerName1 = WriteNameView.playerName2 = null; // remove name(s)
			score1 = score2 = 0; // restart the score

		} else if (SnakeGame.option.equals("nextLevel")) { // What takes place when you win the level
			main.mediaPlayer.stop();
			main.playsound("winningSound.mp3");

			// Create and display button and labels to specific positions
			nextLevelButton = new ButtonCreation(root, "Next Level", 16, 600, 450);
			statusLabel = new LabelCreation(root, "Congrats on beating the level!!!", 
					Color.BLACK, 50, 100, 200);
			detail1 = new LabelCreation(root, "Player 1 current score is: " + score1, 
					Color.WHITE, 30, 300, 300);

			if (WriteNameView.playerName2 != null) { // Change accordingly if player2 exists
				detail1.l.setLayoutX(100);
				detail2 = new LabelCreation(root, "Player 2 current score is: " + score2, 
						Color.WHITE, 30, 550, 300);
			}
		}
	}

	/**
	 * Replaces music to the right one and saves score and name to a folder. Takes
	 * the user to the Home page by changing the view and controller.
	 */
	public void goHomeView() {
		main.mediaPlayer.stop();
		main.playsound("backgroundSound.mp3");
		removeRootObjects();
		recordScore();
		WriteNameView.playerName1 = WriteNameView.playerName2 = null;
		score1 = score2 = 0;
		HomeView homeView = new HomeView(root, model, main);
		main.updatePage(homeView, new HomeController(model, homeView));
	}

	/**
	 * Replaces music and takes the user to the Rank page by changing the view and
	 * controller.
	 */
	public void goRankView() {
		main.mediaPlayer.stop();
		main.playsound("backgroundSound.mp3");
		removeRootObjects();
		RankView rankView = new RankView(root, model, main);
		main.updatePage(rankView, new RankController(model, rankView));
	}

	/**
	 * Takes the user to the level page to carry on by changing the view and
	 * controller.
	 */
	public void nextLevel() {
		removeRootObjects();
		GameLevelView gameLevelView = new GameLevelView(root, model, main);
		main.updatePage(gameLevelView, new GameLevelController(model, gameLevelView));
	}

	/**
	 * Writes the score and name(s) of the player(s) to a file to read for later
	 */
	private void recordScore() {
		rankdetail = new RankDetail();
		rankdetail.writeFile(WriteNameView.playerName1, score1);
		if (WriteNameView.playerName2 != null) {
			rankdetail.writeFile(WriteNameView.playerName2, score2);
		}
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