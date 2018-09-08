import java.util.Scanner; // import scanner from java.util

public class Calculate 
{
	public static void main(String args[])
	{
		// Create Scanner
		Scanner scanner = new Scanner(System.in);

		// Print out string message asking user for entering a number
		System.out.println("Please enter a number: ");

		// Await user input and store it as int. Var name is user_input1
		int user_input1 = scanner.nextInt();

		//Print out string message asking user for another number:
		System.out.println("Please enter another number");

		// Await user input and store it as int. Var name is user_input2
		int user_input2 = scanner.nextInt();

		// Print out the user to ask the user if they want to add, subtract or multiply. 
		System.out.print("1 - add; 2 - subtract; 3 - multiply");
		
		// Wait for user input
		int user_input3 = scanner.nextInt();

		if (user_input3 == 1)
		{
			// call the add method
			System.out.print("The addition of " + user_input1 + " and " + user_input2 + " is: " + add(user_input1, user_input2));
		}
		else if ( user_input3 == 2)
		{
			// call the subtract method
			System.out.print("The subtraction of " + user_input1 + " and " + user_input2 + " is: " + subtract(user_input1, user_input2));	
		}

		else if ( user_input3 == 3)
		{
			// call the multiply method
			System.out.print("The multiplication of " + user_input1 + " and " + user_input2 + " is: " + multiply(user_input1, user_input2));	
		}
		else 
		{
			System.out.println("Please try again and enter either choices 1 to add, 2 to subtract or 3 to multiply the two numbers you gave me!");
		}
	} // close out main method

	// The add method
	public static int add(int a, int b)
	{
		return (a+b);
	}

	// The subtract method
	public static int subtract(int a, int b)
	{
		return (a-b);
	}

	// the multiply method
	public static int multiply(int a, int b)
	{
		return (a*b);
	}

} // Close Class 