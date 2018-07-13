import java.util.Scanner; // Scanner is in java.util

public class CustomSquare{

	public static void main(String[] args) {
		// Create a scanner
		Scanner scanner = new Scanner(System.in);

		// Prompt the user to enter an integer
		System.out.print("Enter an integer: ");

		// Set the value of the user input as int variable: intValue
		int intValue = scanner.nextInt();
		//System.out.println("You entered the integer: " + intValue);

		// Create the string
		String string1 = "";

		// Create the string based on user input for Integer size of square.
		for (int i = intValue; i > 0; i--) 
		{
			string1 = string1 + "X";
		}
		
		
		// Based on user input for Square unit size, print out each line.
		for (int i = intValue; i > 0; i--) 
		{
			System.out.println(string1);
		}
	}
}