import java.util.Scanner; // Import the Scanner in java.util for taking in user input

public class MakeReverseTriangleA 
{

	public static void main(String[] args) 
	{
		// counter sentinel value for while loop later
		boolean counter = true;

		// Create the scanner
		Scanner scanner = new Scanner(System.in);

		// Print out statement to ask user for integer
		System.out.print("Enter the custom size for Reverse Triangle: ");

		// Take User input and make it an integer data.
		int user_input_int1 = scanner.nextInt();
		

		// Begin the for loop which set x to user_input_int1 to minus 1. Since the final slot is our 'x'
		// conditional is to stop at 0. Then after each loop, we decrement the value of x by 1 as we go down 
		// the triangle rows. 
		
		for (int x = user_input_int1 - 1; x >= 0; x--)
		{
			//This is for printing out the blank spaces. We start with c = 0 and increment UP to value of our custom
			// size of the triangle.

			// At the start the size of the blank spaces are biggest so we start from zero and print UP to the 
			// end where we have the tip of the X triangle. That is why c < x. 
			// After one cycle of this for loop, we go onto print the x.
			// After each cycle, the value of c will increase meaning less and less blank spaces will be printed.
			for (int c = 0; c < x; c++)
			{
				System.out.print(' ');
			}
			// Set the value of c to be equal to number of size of triangle. This will slowly decrease by one per each
			// cycle of the outer for loop.
			for (int c = x; c < user_input_int1; c++) 
			{
				//Print out without a line break the x.
				System.out.print('x');
			}

			//Here we print the line break for the next line of the triangle
			System.out.println();
		}
	
	} // End the main method

}// End public class


// when it reaches full length, then print only X
// Before it reaches end of count, then print spaces and only right amount of Xl