import java.util.Scanner; // Import the Scanner in java.util for taking in user input

public class MakeReverseTriangleB 
{
	public static void main(String[] args)
	{
		// Create the Scanner called scanner that accepts user input.		
		Scanner scanner = new Scanner(System.in); 

		// Print out statement to ask user for integer
		System.out.print("Enter the custom size for Reverse Triangle Top Heavy: ");

		// Once the above statement is printed out wait for user input
		int userInput1 = scanner.nextInt();

		for (int x = userInput1-1; x >= 0; x--)
		{
			for (int c = x; c < userInput1-1; c++)
			{
				System.out.print(' ');
			}

			// Print out the xxxxs in reverse 
			for (int c = 0; c <= x; c++)
			{
				System.out.print('x');
			}

			// Here we print out a line break at the end of each for loop inner cycles
			System.out.println();
		}




	} // End of main Method
} // End of class 