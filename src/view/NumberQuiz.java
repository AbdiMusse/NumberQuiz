package view;

import controller.ControllerIF;
import controller.HomeController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Model;

/**
 * The main class of the programme. This starts the game and displays the screen,
 * then calls for the home view to be displayed along with its' controller.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class NumberQuiz extends Application {

	public static final int STAGE_WIDTH = 990;
	public static final int STAGE_HEIGHT = 600;
	public MediaPlayer mediaPlayer;

	public Scene scene;
	private Pane root;

	private Model model;
	private View view;
	private ControllerIF controller;

	/**
	 * Provides the program with a static point of entrance.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * This is what is executed when the programme first runs.
	 * 
	 * @param primaryStage 		Stage that will be displayed
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		playsound("backgroundSound.mp3"); // play music for background

		root = new Pane();
		scene = new Scene(root, STAGE_WIDTH, STAGE_HEIGHT);

		primaryStage.getIcons().add(new Image("res/logo.png")); // Logo of the game displayed
		primaryStage.setTitle("Number Quiz Game by Abdi-rahman Musse");
		primaryStage.setMaxHeight(STAGE_HEIGHT);
		primaryStage.setMaxWidth(STAGE_WIDTH);
		primaryStage.setResizable(false); // Stop user from resizing the stage
		primaryStage.setScene(scene);
		primaryStage.show(); // display the screen

		model = new Model();
		view = new HomeView(root, model, this);
		controller = new HomeController(model, (HomeView) view);
	}

	/**
	 * Gets the sound from the res package and plays it in a loop
	 * 
	 * @param fileName name of the sound without the "res/"
	 */
	public void playsound(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		String music = classLoader.getResource("res/" + fileName).toExternalForm();
		Media sound = new Media(music);
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			public void run() {
				mediaPlayer.seek(Duration.ZERO);
			}
		});
		mediaPlayer.play();
	}

	/**
	 * This controls the swapping of the scene every time a user does an action
	 * 
	 * @param view       The view that is being displayed
	 * @param controller The controller for the view that is being displayed
	 */
	public void updatePage(View view, ControllerIF controller) {
		this.view = view;
		this.controller = controller;
	}

}