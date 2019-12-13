package model;

import javafx.scene.canvas.GraphicsContext;

/**
 * This class utilises the Factory Design Pattern which creates the objects that
 * is needed based on input. Has to be of type GameObject (or a subclass)
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class Factory implements FactoryIF {

	private GraphicsContext gc;

	public Factory(GraphicsContext gc) {
		super();
		this.gc = gc;
	}

	/**
	 * This creates the objects of type gameObject based on the input given
	 * 
	 * @param type represent the type of object
	 * @param x    x position of the game
	 * @param y    y position of the game
	 * @return an object which correspond to the string or a null
	 */
	@Override
	public GameObject createProduct(String type, double x, double y) {
		if (type.equals("good"))
			return new GoodFood(gc, x, y);
		else if (type.equals("bad"))
			return new BadFood(gc, x, y);
		else if (type.equals("free"))
			return new FreeFood(gc, x, y);
		else if (type.equals("snake"))
			return new Snake(gc, x, y);
		else if (type.equals("foodGetter"))
			return new FoodGetter(gc, x, y);
		return null;
	}

}