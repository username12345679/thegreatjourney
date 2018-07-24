import java.util.Scanner; // Scanner is in java.util


public class PrintEven {

	public static void main(String[] args) {

		// Create a boolean
		boolean isOdd = true;

		while (isOdd) {

			// Create a scanner to use later for user input
			Scanner scanner = new Scanner(System.in);

			// Print out message which will prompt user for input
			System.out.print("Enter an even integer: ");

			// Set the value of the user input as int variable
			int user_input = scanner.nextInt();

			System.out.println("You entered the integer: " + user_input);

			System.out.println("user_input % 2 = " + user_input % 2 );
			

			// Test if the user_input is an EVEN integer. If EVEN, then proceed and while loop will
			// terminate later. If NOT EVEN, then while loop continues and ask user until EVEN
			// number is given.
			if (user_input % 2 == 0) {
				isOdd = false;
				System.out.println("The number: " + user_input + " is even!");

				for (int i = 2; i <= user_input; i = i + 2) {
					System.out.print(i + " ");
				}

			// When EVEN is not
			} else {
				isOdd = true;
				System.out.println("You did not enter an even number. Please try again");
			}
		}
	}
}