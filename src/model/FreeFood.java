package model;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * A class that displays the free food which is a fruit. Extended by the food class. 
 * Displayed once the foodGetter object is eaten by the snake.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class FreeFood extends Food {
	private ArrayList<Image> freebie = new ArrayList<Image>();

	public FreeFood(GraphicsContext gc, double x, double y) {
		super(gc, x, y);
		addFreeFood();
		img = freebie.get(random.nextInt(10)); // a random image will be held
		super.update();
	}

	/**
	 * Draw the image on the screen on a random position
	 */
	public void drawImage() {
		gc.drawImage(img, getX() * blockSize, getY() * blockSize, 30, 30);
	}

	/**
	 * make the array hold all 10 images which will be used to pick for the img field
	 */
	private void addFreeFood() {
		freebie.add(new Image("res/apple.png"));
		freebie.add(new Image("res/banana.png"));
		freebie.add(new Image("res/blueberry.png"));
		freebie.add(new Image("res/grapes.png"));
		freebie.add(new Image("res/kiwi.png"));
		freebie.add(new Image("res/mango.png"));
		freebie.add(new Image("res/orange.png"));
		freebie.add(new Image("res/pear.png"));
		freebie.add(new Image("res/pineapple.png"));
		freebie.add(new Image("res/strawberry.png"));
	}

}