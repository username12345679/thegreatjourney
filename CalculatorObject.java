import java.util.Scanner; // Import the Scanner utility

public class CalculatorObject
{
	public static void main(String[] args)
	{
		// Create the scanner object. 
		Scanner scanner = new Scanner(System.in);

		// Prompt the user for a number
		System.out.print("Please enter a number: ");
		
		// Take the user input. Store it in variable user_input1. 
		int user_input1 = scanner.nextInt();

		// Prompt the user for number2
		System.out.print("Please enter another number: ");
		
		// Take the user input. Store it in variable user_input2.
		int user_input2 = scanner.nextInt();

		// Ask the user what operation they want to do
		System.out.print("1 - add | 2 - subtract | 3 - multiply: ");

		int user_input3 = scanner.nextInt();


		CalculatorConstructor calcObject1 = new CalculatorConstructor(user_input1, user_input2);

		// add the two together
		if (user_input3 == 1)
		{
			String output = "The addition of " + Integer.toString(user_input1) + " and " + Integer.toString(user_input2) + " is " + calcObject1.toAdd();
			System.out.print(output);
		}
		// minus
		else if (user_input3 == 2)
		{
			String output = "The subtraction of " + Integer.toString(user_input1) + " and " + Integer.toString(user_input2) + " is " + calcObject1.toMinus();
			System.out.print(output);	
		}

		// multiply
		else if (user_input3 == 3)
		{
			String output = "The multiplication of " + Integer.toString(user_input1) + " and " + Integer.toString(user_input2) + " is " + calcObject1.toMultiply();
			System.out.print(output);	
		}


	} // Close the main() method
} // close the public class

// Define the CalculatorConstructor
class CalculatorConstructor
{

	int user_input1; // user input 1
	int user_input2; // user input 2

	public CalculatorConstructor(int a, int b)
	{
		user_input1 = a;
		user_input2 = b;
	}

	// Method toAdd() returns a string
	public String toAdd()
	{
		int sum = user_input1 + user_input2;
		// Convert to string
		String sum_String = Integer.toString(sum);
		return (sum_String);
	}

	// Method toMinus() returns a string
	public String toMinus()
	{
		int minus = user_input1 - user_input2;
		String minus_String = Integer.toString(minus);
		return (minus_String);
	}

	// Method toMultiply() returns a string
	public String toMultiply()
	{
		int product = user_input1 * user_input2;
		String product_String = Integer.toString(product);
		return(product_String);
	}

} // close of class CalculatorConstructor
