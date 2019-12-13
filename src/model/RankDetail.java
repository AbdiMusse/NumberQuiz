package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import static java.util.stream.Collectors.*;

/**
 * A class that reads and writes to a file which holds the scores of players.
 * 
 * @author Abdi-rahman Musse
 * @version 1.0
 */
public class RankDetail {

	private File file;
	private Scanner scanner;
	private PrintWriter printWriter;
	private HashMap<String, Integer> records;
	private HashMap<String, Integer> sortedRecords;

	public RankDetail() {
		super();
		// the targeted file, if it doesnt't exist, then create it
		file = new File("record.txt");
		records = new HashMap<String, Integer>();
	}

	/**
	 * Write the name and score of the player to the file chosen
	 * 
	 * @param name
	 * @param score
	 */
	public void writeFile(String name, int score) {
		try {
			printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			printWriter.println(score + ", " + name);
			printWriter.close();
		} catch (IOException e) {
			System.err.println("IOException: " + e.getMessage());
		}
	}

	/**
	 * Read the file and store the what is read into a hash map
	 */
	private void readFile() {
		try {
			scanner = new Scanner(file);
			scanner.useDelimiter("[,\n]"); 		// The delimiter (what is checked)
			while (scanner.hasNext()) {
				int i = scanner.nextInt();
				String a = scanner.next().trim();
				records.put(a, i); 				// Store the name and score into the hash map
			}
			scanner.close();
		} catch (IOException e) {
			System.err.println("IOException: " + e.getMessage());
		}
	}

	/**
	 * Orders the hash map based on the value of the scores
	 * 
	 * @return The ordered hash map
	 */
	public HashMap<String, Integer> top10() {
		readFile();
		sortedRecords = records
		.entrySet()
		.stream()
		.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
		.limit(10) // Limit what is ordered to 10 pairs
		.collect(
			toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, 
				LinkedHashMap::new));
		return sortedRecords;
	}

}