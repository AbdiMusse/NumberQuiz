package view;

import java.util.ArrayList;
import java.util.Random;

import controller.GameOverController;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import model.BadFood;
import model.Factory;
import model.FoodGetter;
import model.FreeFood;
import model.GameDetails;
import model.GoodFood;
import model.Model;
import model.MoveDown;
import model.MoveLeft;
import model.MoveRight;
import model.MoveUp;
import model.Player;
import model.Snake;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Displays the page that allows the user(s) to play the game.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class SnakeGame extends View {

	public SnakeGame(FlowPane pane, Model model, NumberQuiz main, boolean isPlayer2, int level) {
		super(pane, model, main);

		this.isPlayer2 = isPlayer2; // checks if there exists a second player
		GoodFood.setCurrentLevel(level); // sets the current level for user(s) to play

		gameDetail = new GameDetails(pane); // Draws the top part of the game on screen with info

		// Creates the area for the game to be played
		root = new Pane();
		root.setPrefSize(990, 480);
		pane.getChildren().add(root);
		canvas = new Canvas(root.getPrefWidth(), root.getPrefHeight());
		gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);

		// Count down before the game starts playing
		timerLabel = new LabelCreation(root, timeSeconds.toString(), Color.RED, 100, 450, 50);
		timeline2.setCycleCount(Timeline.INDEFINITE);
		timeline2.play();

		// Factory that allows the creating on classes
		factory = new Factory(gc);
		// Setting up Player 1 (and maybe player 2)
		player1 = new Player(gc, 4);
		if (this.isPlayer2) {
			player2 = new Player(gc, 2);
		}
	}

	private Pane root;
	private Canvas canvas;
	private GraphicsContext gc;
	private GameDetails gameDetail;

	private int width = 33; // The walls (33x30 = 990) 30 is the grid of the screen
	private int height = 15; // The walls (15x30 = 450) due to disabled resize

	private Factory factory;
	private GoodFood goodFood;
	private BadFood badFood;
	private FreeFood freeFood;
	private FoodGetter foodGetter;
	private ArrayList<BadFood> badFoodCollection = new ArrayList<BadFood>();
	private ArrayList<FreeFood> freebie = new ArrayList<FreeFood>();

	public Player player1;
	public Player player2;
	public String dirPlayer1 = "right";
	public String dirPlayer2 = "right";
	public static String option;

	private boolean isPlayer2;
	private boolean gameOver = false;
	private boolean keepFreeFood = false;
	private Random random = new Random();
	private LabelCreation timerLabel;
	private Integer timeSeconds = 3;
	private int questionsLeft = 10;

	private MoveUp moveUp = new MoveUp();
	private MoveDown moveDown = new MoveDown();
	private MoveLeft moveLeft = new MoveLeft();
	private MoveRight moveRight = new MoveRight();

	private double time = 0;
	private double speed = 0.2;
	AnimationTimer timer = new AnimationTimer() { // The main animation timer that runs the game
		@Override
		public void handle(long now) {
			time += 0.016;
			if (time > speed) { // this only happens when 0.2 seconds have passed
				if (gameOver) {
					option = "gameOver";
					timer.stop();
					gameOver(); // go the a new screen for game over
				} else if (questionsLeft == 0) { // if the level is cleared
					option = "nextLevel";
					timer.stop();
					gameOver(); // go the a new screen for game over
				} else {
					update(); // carry on with game and move the snake
				}
				time = 0; // return to 0 so we can wait for another 0.2 seconds
			}
		}
	};

	Timeline timeline = new Timeline(new KeyFrame(
			Duration.minutes(0.5), e -> displayFoodGetter())); // after 30 seconds this appears
	Timeline timeline2 = new Timeline(new KeyFrame(
			Duration.seconds(1), e -> countdow())); // controls the count down before the game

	/**
	 * Controls the count down before the game and starts the game once it's over
	 */
	private void countdow() {
		timeSeconds--; // count down the seconds
		timerLabel.l.setText(timeSeconds.toString());
		if (timeSeconds <= 0) {
			timeline2.stop();
			main.mediaPlayer.stop(); // stop the old music and play a new one
			main.playsound("playGameSound.mp3");
			root.getChildren().remove(timerLabel.l);
			displayGoodFood();
			displayBadFood();
			timeline.play(); // start the timer for the free food
			timer.start(); // start the main animation timer
		}
	}

	/**
	 * The main timer of the game is called by this method to control everything
	 */
	private void update() {
		// Draw the background image and the top part of the screen
		drawBackGround();
		// Movement of the snake for player 1
		snakeMovement(player1, 1, dirPlayer1);
		// Movement of the snake for player 2
		if (isPlayer2)
			snakeMovement(player2, 2, dirPlayer2);

		// Eat food for player 1
		eatFood(player1);
		// Eat food for player 2
		if (isPlayer2)
			eatFood(player2);

		if (keepFreeFood) {
			// Eat the freeFood for player 1
			eatFreeFood(player1);
			// Eat the freeFood for player 2
			if (isPlayer2)
				eatFreeFood(player2);

			if (freebie.size() == 0) {
				newFood(); // display the numbers (food)
				keepFreeFood = false;
			}
		}
		// Draw the different numbers (food) on the screen
		goodFood.drawObject();
		for (BadFood badFood : badFoodCollection) {
			badFood.drawObject();
		}
		if (foodGetter != null)
			foodGetter.drawObject();
	}

	/**
	 * Displays the right food on the screen
	 */
	private void displayGoodFood() {
		goodFood = (GoodFood) factory.createProduct(
				"good", random.nextInt(width), random.nextInt(height));
	}

	/**
	 * Displays the wrong foods on the screen
	 */
	private void displayBadFood() {
		for (int i = 0; i < 9; i++) {
			badFood = (BadFood) factory.createProduct(
					"bad", random.nextInt(width), random.nextInt(height));
			badFoodCollection.add(badFood);
		}
	}

	/**
	 * Displays the food that gets you free food on the screen
	 */
	private void displayFoodGetter() {
		foodGetter = (FoodGetter) factory.createProduct(
				"foodGetter", random.nextInt(width), random.nextInt(height));
	}

	/**
	 * Changes the position of the good and bad food
	 */
	private void newFood() {
		goodFood.newPostion(random.nextInt(width), random.nextInt(height));
		for (int i = 0; i < badFoodCollection.size(); i++) {
			badFoodCollection.get(i).newPostion(random.nextInt(width), random.nextInt(height));
		}
	}

	/**
	 * Change the position of the good and bad food
	 * 
	 * @param postion chosen by the input (used to display them outside the screen)
	 */
	private void newFood(double postion) {
		goodFood.newPostion(postion, postion);
		for (int i = 0; i < badFoodCollection.size(); i++) {
			badFoodCollection.get(i).newPostion(postion, postion);
		}
		foodGetter.newPostion(postion, postion);
	}

	/**
	 * Depending on the type of food the player eats, do some action
	 * 
	 * @param player
	 */
	private void eatFood(Player player) {
		// eat right food and gain a point + increase speed
		if (goodFood.getX() == player.getSnake().get(0).getX() && 
				goodFood.getY() == player.getSnake().get(0).getY()) {
			player.addSnakeBody();
			player.setScore(player.getScore() + 1);
			speed -= 0.01;
			newFood();
			questionsLeft--;
		}
		// eat wrong food and lose a life
		for (int i = 0; i < badFoodCollection.size(); i++) {
			if (badFoodCollection.get(i).getX() == player.getSnake().get(0).getX()
					&& badFoodCollection.get(i).getY() == player.getSnake().get(0).getY()) {
				player.getLives().remove(player.getLives().size() - 1);
				if (player.getLives().size() == 0)
					gameOver = true;
				newFood();
				questionsLeft--;
			}
		}

		if (foodGetter != null) { // checks if the free food getter is present
			// get rid of everything on the screen and display the free food
			if (foodGetter.getX() == player.getSnake().get(0).getX()
					&& foodGetter.getY() == player.getSnake().get(0).getY()) {
				newFood(root.getPrefWidth() + 10);
				// The loop is causing the programme to freeze!!!
				for (int i = 0; i < 10; i++) {
					freeFood = (FreeFood) factory.createProduct(
							"free", random.nextInt(width), random.nextInt(height));
					freebie.add(freeFood);
				}
				keepFreeFood = true;
			}
		}
	}

	/**
	 * Eating the free food and gaining points, doesn't affect the number of
	 * questions left
	 * 
	 * @param player
	 */
	private void eatFreeFood(Player player) {
		for (int i = 0; i < freebie.size(); i++) {
			freebie.get(i).drawImage();
			if (freebie.get(i).getX() == player.getSnake().get(0).getX()
					&& freebie.get(i).getY() == player.getSnake().get(0).getY()) {
				freebie.remove(freebie.get(i));
				player.setScore(player.getScore() + 1);
			}
		}
	}

	/**
	 * Draw the background of top area with scores and player info and questions
	 */
	private void drawBackGround() {
		gc.drawImage(new Image("res/background1.jpg"),0,0,root.getPrefWidth(),root.getPrefHeight()-30);
		gameDetail.drawBackGround();
		gameDetail.player1Info(player1);
		gameDetail.player2Info(isPlayer2, player2);
		gameDetail.questions(keepFreeFood, goodFood);
	}

	/**
	 * Controls the snake movement and increases it's size
	 * 
	 * @param player    player 1 or 2
	 * @param keys      key is used to seperate the colour of snakes
	 * @param direction the direction of which the snake is moving
	 */
	private void snakeMovement(Player player, int keys, String direction) {
		// Keeps the snake body together when moving
		for (int i = player.getSnake().size() - 1; i > 0; i--) {
			player.getSnake().get(i).setX(player.getSnake().get(i - 1).getX());
			player.getSnake().get(i).setY(player.getSnake().get(i - 1).getY());
		}
		// Move the snake and check if it hits any of the walls
		switch (direction) {
		case "up":
			player.getSnake().get(0).setStrategy(moveUp);
			player.getSnake().get(0).movement();
			gameOver = player.getSnake().get(0).checkClash(0);
			break;
		case "down":
			player.getSnake().get(0).setStrategy(moveDown);
			player.getSnake().get(0).movement();
			gameOver = player.getSnake().get(0).checkClash(height);
			break;
		case "left":
			player.getSnake().get(0).setStrategy(moveLeft);
			player.getSnake().get(0).movement();
			gameOver = player.getSnake().get(0).checkClash(0);
			break;
		case "right":
			player.getSnake().get(0).setStrategy(moveRight);
			player.getSnake().get(0).movement();
			gameOver = player.getSnake().get(0).checkClash(width);
			break;
		}

		// self destroy if snake touches itself
		for (int i = 1; i < player.getSnake().size(); i++) {
			if (player.getSnake().get(0).getX() == player.getSnake().get(i).getX()
					&& player.getSnake().get(0).getY() == player.getSnake().get(i).getY()) {
				gameOver = true;
			}
		}
		// Display the snake (have 2 setFill to give it a good colour)
		for (Snake s : player.getSnake()) {
			if (keys == 2)
				s.drawObject2();
			else
				s.drawObject();
		}
	}

	/**
	 * Takes the user to the game over screen when the player looses or wins level
	 */
	private void gameOver() {
		Pane root = new Pane();
		main.scene.setRoot(root);
		GameOverView gameOverView = new GameOverView(root, model, main, this);
		main.updatePage(gameOverView, new GameOverController(model, gameOverView));
	}

}