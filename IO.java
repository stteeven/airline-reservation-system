import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * IO is a utility class for ITP 265 that helps provide a friendly way to read input from
 * a user and verify that the input is correct.
 * 
 * @author Kendra Walther
 * ITP 265, 20201
 * Week #03
 * Email: kwalther@usc.edu and stevengo@usc.edu
 *
 */

public class IO {

	private Scanner sc;
	
	
	/**
	 * Constructor sets up a Scanner to be used by the class in order to read input from the standard console window (System.in)
	 */
	public IO() {
		sc = new Scanner(System.in);
	}
	
	/**
	 * Short-cut helper method that prints a String with a series of stars around it.
	 * @param output: The String to be printed
	 */
	public void printPretty(String output) {
		System.out.println("***********************************************************************************************");
		System.out.println(output);
		System.out.println("***********************************************************************************************");
	}
	/**
	 * Prompt the user and read one line of text as a String
	 * @param prompt: the question to ask the user
	 * @return: a line of user input (including spaces, until they hit enter)
	 */
	public String inputLine(String prompt) {
		System.out.println(prompt);
		return sc.nextLine();
	}
	
	/**
	 * Prompt the user and read one word of text as a String
	 * @param prompt: the question to ask the user
	 * @return: a one word String - if the user enters multiple words, all other input until the return will be discarded.
	 */
	public String inputWord(String prompt) {
		System.out.println(prompt);
		String word = sc.next();
		sc.nextLine(); // remove any "garbage" (like extra whitespace or the return key) after the one word that is read in
		return word;
	}
	
	/**
	 * Prompt the user and read one word - which must match either option1 or option2 parameters.
	 * @param prompt: the question to ask the user (should include the two valid options the user should choose from)
	 * @param option1 : One string option for the user to choose.
	 * @param option2: the other string option for the user to choose.
	 * @return: A string matching either option1 or option2
	 */
	public String inputWord(String prompt, String option1, String option2) {
		// Prompt user to choose an option
		System.out.println(prompt);
		String word = sc.next().toLowerCase();
		sc.nextLine(); // remove any "garbage" (like extra whitespace or the return key) after the one word that is read in
		// If the user inputs an invalid answer, loop until user inputs valid answer
		while (!(word.equals(option1) || word.equals(option2))) {
			System.out.println("Please enter one of the two valid options.");
			System.out.println(prompt);
			word = sc.next().toLowerCase();
			sc.nextLine(); // remove any "garbage" (like extra whitespace or the return key) after the one word that is read in
		}
		return word;
	}
	/**
	 * Prompt the user and read an int, clearing whitespace or the enter after the number
	 * @param prompt: the question to ask the user 
	 * @return: an int 
	 */
	public int inputInt(String prompt) {
		System.out.println(prompt);
		// if scanner does not see an int, get rid of garbage and ask again.
		while (!sc.hasNextInt()) {
			String garbage = sc.nextLine();
			System.out.println("Didn't recognize " + garbage + " as an integer...");
			System.out.println(prompt);
		}
		int num = sc.nextInt();
		sc.nextLine(); // clear the buffer
		return num;
	}
	
	/** Prompt the user and read positive int, clearing whitespace or the enter after {@link #clone()}
	 * @param promtpt: ask user a q
	 * @return: an int >= 0
	 */
	public int inputPositiveInt(String prompt) {
		int num = inputInt(prompt); //off load the work to the method we already wrote
		while (num<0) { // while bad 
			System.out.println("Need a positive number: " + num + " does not qualify");
			num = inputInt(prompt);
		}
		return num;
	}
	
	/**
	 * Prompt the user and read an int between (inclusive) of minValue and maxValue, clearing whitespace or the enter after the number
	 * @param prompt: the question to ask the user 
	 * @return: an int between minValue and maxValue
	 */
	public int inputIntInRange(String prompt, int minValue, int maxValue) {
		int num = inputInt(prompt);
		while (num < minValue || num > maxValue) {
			System.out.println("Please enter a number between " + minValue + " and " + maxValue + "(inclusive).");
			num = inputInt(prompt);
		}
		return num;
	}
	
	/**
	 * Prompt the user and read a postive (>=0) int, clearing whitespace or the enter after the number
	 * @param prompt: the question to ask the user 
	 * @return: an int >= 0
	 */
	public int inputPostiveInt(String prompt) {
		System.out.println(prompt);
		System.out.println("not yet implemented, returning 0");
		return 0;
	}
	/**
	 * Prompt the user and read a floating point number, clearing whitespace or the enter after the number
	 * @param prompt: the question to ask the user 
	 * @return: a double value 
	 */
	public double inputDouble(String prompt) {
		System.out.println(prompt);
		System.out.println("not yet implemented, returning 0");
		return 0.0;
	}
	/**
	 * Prompt the user and read a boolean value, clearing whitespace or the enter after the number
	 * @param prompt: the question to ask the user 
	 * @return: a boolean value 
	 */
	public boolean inputBoolean(String prompt) {
		System.out.println(prompt);
		System.out.println("not yet implemented, returning false");
		return false;
	}
	
	/**
	 * Prompt the user enter yes or no (will match y/yes and n/no any case) and return true for yes and false for no.
	 * @param prompt: the question to ask the user 
	 * @return: a boolean value 
	 */
	public boolean inputYesNoAsBoolean(String prompt) {
		System.out.println(prompt);
		// if scanner is seeing BAD input... loop to get good input
		String answer = sc.nextLine().toLowerCase();
		while ( ! (answer.equals("y") || answer.equals("yes") 
					|| answer.equals("n") || answer.equals("no") )) {
		
			System.out.println("Didn't recognize " + answer + " as yes or no...");
			System.out.println(prompt);
			answer = sc.nextLine().toLowerCase();
		}
		//end of loop = good input
		
	
		if(answer.equals("y") || answer.equals("yes")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Get the user's answer and compare it to a string and return true if its a match and false otherwise.
	 * @param prompt: the question to ask the user 
	 * @param  : A question to ask the user.
	 * @param beveragePrompt: asks the user to pick 
	 */
	public String matchWordToQuestion(String word, String bookPrompt, String beveragePrompt) {
		if (word.equals("book")) {
//			System.out.println(bookPrompt);
			return bookPrompt;
		}
		else if (word.equals("beverage")) {
//			System.out.println(beveragePrompt);
			return beveragePrompt;
		}
		else {
			return "Invalid input.";
		}
			
	}
	
	/**
	 * list all the possible types, let the user pick one by number and then will return that type.
	 * @return: an Airline
	 */
	public Airline getAirline() {
		Airline[] airlines = Airline.values();
		for (int i = 0; i < airlines.length; i++) {
			System.out.println(i + ": " + airlines[i]);
		}
		int num = inputIntInRange("Please choose an airline: ", 0, 4);
		return airlines[num];
	}
	
	
}