package model;

/**
 * An interface that is implemented by the factory class to enforce the
 * behaviour of creating classes based on the string type Part of the Factory
 * Design Pattern
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public interface FactoryIF {
	// Create an object that is a GameObject or a subclass of the object
	GameObject createProduct(String type, double x, double y);
}