package com.techelevator.view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.techelevator.view.ConsoleService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConsoleServiceTest {

	private ByteArrayOutputStream output;

	@Before
	public void setup() {
		output = new ByteArrayOutputStream();
	}

	@Test
	public void displays_a_list_of_menu_options_and_prompts_user_to_make_a_choice() {
		Object[] options = new Object[] { Integer.valueOf(3), "Blind", "Mice" };

		ConsoleService console = getServiceForTesting();

		console.getChoiceFromOptions(options);

		String expected = "\n" + "1) " + options[0].toString() + "\n" + "2) " + options[1].toString() + "\n" + "3) "
				+ options[2].toString() + "\n\n" + "Please choose an option >>> \n";
		Assert.assertEquals(expected, output.toString());
	}

	@Test
	public void returns_object_corresponding_to_user_choice() {
		Integer expected = Integer.valueOf(456);
		Integer[] options = new Integer[] { Integer.valueOf(123), expected, Integer.valueOf(789) };
		ConsoleService console = getServiceForTestingWithUserInput("2\n");

		Integer result = (Integer) console.getChoiceFromOptions(options);

		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void prints_a_blank_line_after_successful_choice() {
		Integer[] options = new Integer[] { 123, 456, 789 };
		ConsoleService console = getServiceForTestingWithUserInput("2\n");

		Integer result = (Integer) console.getChoiceFromOptions(options);

		String expected = "\n" + "1) " + options[0].toString() + "\n" + "2) " + options[1].toString() + "\n" + "3) "
				+ options[2].toString() + "\n\n" + "Please choose an option >>> \n";
		
		Assert.assertEquals(expected, output.toString());
	}

	@Test
	public void redisplays_menu_if_user_does_not_choose_valid_option() {
		Object[] options = new Object[] { "Larry", "Curly", "Moe" };
		ConsoleService console = getServiceForTestingWithUserInput("4\n1\n");

		console.getChoiceFromOptions(options);

		String menuDisplay = "\n" + "1) " + options[0].toString() + "\n" + "2) " + options[1].toString() + "\n" + "3) "
				+ options[2].toString() + "\n\n" + "Please choose an option >>> ";

		String expected = menuDisplay + "\n*** 4 is not a valid option ***\n\n" + menuDisplay + "\n";

		Assert.assertEquals(expected, output.toString());
	}

	@Test
	public void redisplays_menu_if_user_chooses_option_less_than_1() {
		Object[] options = new Object[] { "Larry", "Curly", "Moe" };
		ConsoleService console = getServiceForTestingWithUserInput("0\n1\n");

		console.getChoiceFromOptions(options);

		String menuDisplay = "\n" + "1) " + options[0].toString() + "\n" + "2) " + options[1].toString() + "\n" + "3) "
				+ options[2].toString() + "\n\n" + "Please choose an option >>> ";

		String expected = menuDisplay + "\n*** 0 is not a valid option ***\n\n" + menuDisplay + "\n";

		Assert.assertEquals(expected, output.toString());
	}

	@Test
	public void redisplays_menu_if_user_enters_garbage() {
		Object[] options = new Object[] { "Larry", "Curly", "Moe" };
		ConsoleService console = getServiceForTestingWithUserInput("Mickey Mouse\n1\n");

		console.getChoiceFromOptions(options);

		String menuDisplay = "\n" + "1) " + options[0].toString() + "\n" + "2) " + options[1].toString() + "\n" + "3) "
				+ options[2].toString() + "\n\n" + "Please choose an option >>> ";

		String expected = menuDisplay + "\n*** Mickey Mouse is not a valid option ***\n\n" + menuDisplay + "\n";

		Assert.assertEquals(expected, output.toString());
	}
	
	@Test
	public void displays_prompt_for_user_input() {
		ConsoleService console = getServiceForTesting();
		String prompt = "Your Name";
		String expected = "Your Name: ";
		console.getUserInput(prompt);
		Assert.assertEquals(expected, output.toString());
	}
	
	@Test
	public void returns_user_input() {
		String expected = "Juan";
		ConsoleService console = getServiceForTestingWithUserInput(expected);
		String result = console.getUserInput("Your Name");
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void displays_prompt_for_user_input_integer() {
		ConsoleService console = getServiceForTesting();
		String prompt = "Your Age";
		String expected = "Your Age: ";
		console.getUserInputInteger(prompt);
		Assert.assertEquals(expected, output.toString());
	}
	
	@Test
	public void returns_user_input_for_integer() {
		Integer expected = 27;
		ConsoleService console = getServiceForTestingWithUserInput(expected.toString());
		Integer result = console.getUserInputInteger("Enter a number");
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void shows_error_and_redisplays_prompt_if_user_enters_invalid_integer() {
		ConsoleService console = getServiceForTestingWithUserInput("bogus\n1\n");
		String prompt = "Your Age";
		String expected = "Your Age: " + "\n*** bogus is not valid ***\n\nYour Age: ";
		console.getUserInputInteger(prompt);
		Assert.assertEquals(expected, output.toString());
	}

	private ConsoleService getServiceForTestingWithUserInput(String userInput) {
		ByteArrayInputStream input = new ByteArrayInputStream(String.valueOf(userInput).getBytes());
		return new ConsoleService(input, output);
	}

	private ConsoleService getServiceForTesting() {
		return getServiceForTestingWithUserInput("1\n");
	}
}
