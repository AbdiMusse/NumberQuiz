package model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * A class that represents everything to do with the top part of the screen for
 * the game. Displays player(s) information with life(s) and questions.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class GameDetails {
	private Pane root;
	private Canvas canvas;
	private GraphicsContext gc;

	public GameDetails(FlowPane pane) {
		super();
		root = new Pane();
		root.setPrefSize(990, 120); // Dimension of the top part of screen
		pane.getChildren().add(root); // add to the Flowpane (the whole screen)
		canvas = new Canvas(root.getPrefWidth(), root.getPrefHeight());
		gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
	}

	/**
	 * This draws the background of the top screen
	 */
	public void drawBackGround() {
		gc.drawImage(new Image("res/background2.jpg"), 0, 0, root.getPrefWidth(), root.getPrefHeight());
	}

	/**
	 * Provides the information for player 1
	 * 
	 * @param player1
	 */
	public void player1Info(Player player1) {
		gc.setFill(Color.WHITE);
		gc.setFont(new Font("", 30));
		gc.fillText("Score: " + player1.getScore(), 10, 60);

		// Display lives for player 1
		int postion = 10;
		for (int i = 0; i < player1.getLives().size(); i++) {
			gc.drawImage(player1.getLives().get(i), postion, 70, 40, 40);
			postion = postion + 40;
		}
	}

	/**
	 * If player 2 exists, display infomration for player 2
	 * 
	 * @param isPlayer2 checks if player 2 exists
	 * @param player2
	 */
	public void player2Info(Boolean isPlayer2, Player player2) {
		if (isPlayer2) {
			gc.fillText("Score: " + player2.getScore(), 700, 60);
			gc.setFill(Color.RED);
			gc.fillText("Player 1", 10, 30);
			gc.fillText("Player 2", 700, 30);

			// Display lives for player 2
			int postion2 = 700;
			for (int i = 0; i < player2.getLives().size(); i++) {
				gc.drawImage(player2.getLives().get(i), postion2, 70, 40, 40);
				postion2 = postion2 + 40;
			}
		}
	}

	/**
	 * Display the question that will be presented on the screen
	 * 
	 * @param freeFood if it's free food, hide the question
	 * @param goodFood if not, display the question
	 */
	public void questions(Boolean freeFood, GoodFood goodFood) {
		if (freeFood) {
			// Free food notice
			gc.setFill(Color.RED);
			gc.setFont(new Font("", 50));
			gc.fillText("FREE FOOD!!!!!", root.getPrefWidth() / 3, 50);
		} else {
			// Question
			gc.setFill(Color.WHITE);
			gc.setFont(new Font("", 40));
			gc.fillText(goodFood.displayQuestion(), root.getPrefWidth() / 2, 50);
		}
	}

}