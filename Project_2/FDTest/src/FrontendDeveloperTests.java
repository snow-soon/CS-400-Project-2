// --== CS400 Fall 2022 File Header Information ==--
// Name: <Soonho Chung>
// Email: <schung75@wisc.edu>
// Team: <CT>
// TA: <Ilay>
// Lecturer: <Gary Dahl>
// Notes to Grader: <optional extra notes>

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author 
 *
 */
public class FrontendDeveloperTests {
	
	/**
	 * test for the option 1
	 */
	@Test
	public void test1() {
		//try {
			// 1. Create a new TextUITester object for each test, and
	        // pass the text that you'd like to simulate a user typing as only argument.
			TextUITester tester = new TextUITester("1\n");
			Scanner scanner = new Scanner(System.in);
			IGameBackend backend = new GameLibraryBD();
			GameFrontEnd _instance = new GameFrontEnd(scanner, backend);
    		String out = "You are in the Search for Name Word Menu:\n"
    				+ "          Enter a word to search for in game names:";
			
    		// 2. Run the code that you want to test here:
    		_instance.runCommandLoop();
    		
    		// 3. Check whether the output printed to System.out matches your expectations.
			String output = tester.checkOutput();
			assertTrue(output.contains(out));
		//} catch(Exception e) {};
	}
	
	/**
	 * test for the option 2
	 */
	@Test
	public void test2() {
		try {
			// 1. Create a new TextUITester object for each test, and
	        // pass the text that you'd like to simulate a user typing as only argument.
			TextUITester tester = new TextUITester("2\n");
			Scanner scanner = new Scanner(System.in);
			IGameBackend backend = new GameLibraryBD();
			GameFrontEnd _instance = new GameFrontEnd(scanner, backend);
    		String out = "You are in the Add New Game Menu:";
			_instance.runCommandLoop();
			String output = tester.checkOutput();
			assertTrue(output.contains(out));
		} catch(Exception e) {};
	}
	
	/**
	 * test for the option 3 and delete input value
	 */
	@Test
	public void test3() {
		try {
			// 1. Create a new TextUITester object for each test, and
	        // pass the text that you'd like to simulate a user typing as only argument.
			TextUITester tester = new TextUITester("3\n");
			Scanner scanner = new Scanner(System.in);
			IGameBackend backend = new GameLibraryBD();
			GameFrontEnd _instance = new GameFrontEnd(scanner, backend);
    		String out = "You are in the Delete Game Menu:";
    		
    		// 2. Run the code that you want to test here:
    		_instance.runCommandLoop();
    		
    		// 3. Check whether the output printed to System.out matches your expectations.
			String output = tester.checkOutput();
			assertTrue(output.contains(out));
		} catch(Exception e) {};
	}
	
	/**
	 * test for the option 4 (exit)
	 */
	@Test
	public void test4() {
		try {
			// 1. Create a new TextUITester object for each test, and
	        // pass the text that you'd like to simulate a user typing as only argument.
			TextUITester tester = new TextUITester("4\n");
			Scanner scanner = new Scanner(System.in);
			IGameBackend backend = new GameLibraryBD();
			GameFrontEnd _instance = new GameFrontEnd(scanner, backend);
    		String out = "Goodbye!";
    		
    		// 2. Run the code that you want to test here:
    		_instance.runCommandLoop();
    		
    		// 3. Check whether the output printed to System.out matches your expectations.
			String output = tester.checkOutput();
			assertTrue(output.contains(out));
		} catch(Exception e) {};
	}
	
	/**
	 * test for the invalid input out of bound 1-4
	 */
	@Test
	public void test5() {
		try {
			// 1. Create a new TextUITester object for each test, and
	        // pass the text that you'd like to simulate a user typing as only argument.
			TextUITester tester = new TextUITester("5\n");
			Scanner scanner = new Scanner(System.in);
			IGameBackend backend = new GameLibraryBD();
			GameFrontEnd _instance = new GameFrontEnd(scanner, backend);
    		String out = "Invalid Input!";
    		
    		// 2. Run the code that you want to test here:
    		_instance.runCommandLoop();
    		
    		// 3. Check whether the output printed to System.out matches your expectations.
			String output = tester.checkOutput();
			assertTrue(output.contains(out));
		} catch(Exception e) {};
	}

	/**
	 * test for removing game is working right in GameFrontEnd
	 */
	@Test
	public void Integration1() {
		try {
			Scanner scanner = new Scanner(System.in);
			IGameBackend backend = new GameLibraryBD();
			GameFrontEnd _instance = new GameFrontEnd(scanner, backend);
    		
			String game = "Fifa 16";

			assertTrue(_instance.backend.removeGame(game));
		} catch(Exception e) {};
	}

	/**
	 * test whether getName method working right in GameFrontend 
	 */
	@Test
	public void Integration2() {
		try {
			Scanner scanner = new Scanner(System.in);
			IGameBackend backend = new GameLibraryBD();
			GameFrontEnd _instance = new GameFrontEnd(scanner, backend);
    		
			String game = "Fifa 16";
    		String instance = _instance.backend.searchByName(game).getName();

			assertEquals("Fifa 16", instance);
		} catch(Exception e) {};
	}

	/**
	 * test for searching gmae
	 */
	@Test
	public void CodeReviewOfFrontendDeveloper1() {
		try {
			// 1. Create a new TextUITester object for each test, and
	        // pass the text that you'd like to simulate a user typing as only argument.
			TextUITester tester = new TextUITester("1\nMario Kart: Double Dash!!\n");
			Scanner scanner = new Scanner(System.in);
			IGameBackend backend = new GameLibraryBD();
			GameFrontEnd _instance = new GameFrontEnd(scanner, backend);
    		String out = "\"Mario Kart: Double Dash!!\" published by Nintendo in 2003, Genre: Racing";
    		
    		// 2. Run the code that you want to test here:
    		_instance.runCommandLoop();
    		
    		// 3. Check whether the output printed to System.out matches your expectations.
			String output = tester.checkOutput();
			assertTrue(output.contains(out));
		} catch(Exception e) {};
	}

	/**
	 * test add a new game and delete the game
	 */
	@Test
	public void CodeReviewOfFrontendDeveloper2() {
		try {
			// 1. Create a new TextUITester object for each test, and
	        // pass the text that you'd like to simulate a user typing as only argument.
			TextUITester tester = new TextUITester("2\nJust Added\nred\n2022\neducation\n");
			Scanner scanner = new Scanner(System.in);
			IGameBackend backend = new GameLibraryBD();
			GameFrontEnd _instance = new GameFrontEnd(scanner, backend);
    		String out = "You have added a new game: \"Just Added\" published by red in 2022, Genre: education";
    		
    		// 2. Run the code that you want to test here:
    		_instance.runCommandLoop();
    		
    		// 3. Check whether the output printed to System.out matches your expectations.
			String output = tester.checkOutput();
			assertTrue(output.contains(out));
		} catch(Exception e) {};
	}

}
