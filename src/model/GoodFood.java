package model;

import javafx.scene.canvas.GraphicsContext;

/**
 * A class that displays the food which has the right answer. 
 * Extended by the food class.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class GoodFood extends Food {
	public static int currentLevel;
	private int number1, number2;
	private String answer;

	public GoodFood(GraphicsContext gc, double x, double y) {
		super(gc, x, y);
		createQuestion();
		drawObject();
	}

	/**
	 * Draws a rectangle with the correct answer in the middle by calling a
	 * superclass method.
	 */
	public void drawObject() {
		super.drawObject(answer);
	}

	/**
	 * Changes the position of the food and changes the number to with the question.
	 */
	public void newPostion(double foodX, double foodY) {
		createQuestion(); // creates a new question
		super.newPostion(foodX, foodY);
		gc.fillText(answer, (foodX * blockSize) + 2, (foodY * blockSize) + 20);
	}

	/**
	 * Depending on the level chosen, calls a method that gives the answer to a
	 * particular question
	 */
	public void createQuestion() {
		int answer = 0;
		if (currentLevel == 1)
			answer = addition();
		else if (currentLevel == 2)
			answer = subtraction();
		else if (currentLevel == 3)
			answer = multiplication();
		else if (currentLevel == 4)
			answer = division();

		String stringAnswer = Integer.toString(answer); // Change the integer to string
		this.answer = stringAnswer;
	}

	/**
	 * This does an addition between 2 random numbers in the range of 1-50
	 * 
	 * @return the sum of the addition
	 */
	private int addition() {
		number1 = random.nextInt(50 + 1);
		number2 = random.nextInt(50 + 1);

		return number1 + number2;
	}

	/**
	 * This does a subtraction between 2 random numbers in the range of 1-50
	 * 
	 * @return the sum of the subtraction
	 */
	private int subtraction() {
		int firstNumber = random.nextInt(50 + 1);
		int secondNumber = random.nextInt(50 + 1);

		if (firstNumber > secondNumber) {
			number1 = firstNumber;
			number2 = secondNumber;
		} else {
			number1 = secondNumber;
			number2 = firstNumber;
		}

		return number1 - number2;
	}

	/**
	 * This does a multiplication between 2 random numbers in the range of 1-12
	 * 
	 * @return the sum of the multiplication
	 */
	private int multiplication() {
		number1 = random.nextInt(12) + 1;
		number2 = random.nextInt(12) + 1;

		return number1 * number2;
	}

	/**
	 * This does a division between 2 random numbers in the range of 1-50
	 * 
	 * @return the sum of the division
	 */
	private int division() {
		int number3 = random.nextInt(12) + 1;
		number2 = random.nextInt(12) + 1;
		number1 = number3 * number2;

		return number1 / number2;
	}

	/**
	 * Check the current level and set the operator
	 * 
	 * @return the question
	 */
	public String displayQuestion() {
		String operation = null;
		if (currentLevel == 1)
			operation = "+";
		if (currentLevel == 2)
			operation = "-";
		if (currentLevel == 3)
			operation = "x";
		if (currentLevel == 4)
			operation = "/";
		return number1 + operation + number2;
	}

	/**
	 * get the static variable currentLevel
	 * 
	 * @return
	 */
	public static int getCurrentLevel() {
		return currentLevel;
	}

	/**
	 * set the static variable currentLevel
	 * 
	 * @param currentLevel
	 */
	public static void setCurrentLevel(int currentLevel) {
		GoodFood.currentLevel = currentLevel;
	}

}