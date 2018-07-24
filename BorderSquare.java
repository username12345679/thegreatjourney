
// Import the java Scanner utility
import java.util.Scanner; 


public class BorderSquare {

	public static void main(String[] args) {

		// Create the scanner 
		Scanner scanner = new Scanner(System.in);

		// Ask user for the amount of 0's for the border
		System.out.print("Enter an integer for the border of square with 0's: ");

		// Set the value of the input as the 0's for the border of the rectangle
		// Set this to user_input1
		int user_input1 = scanner.nextInt();

		// Ask user for the amount of -'s for the actual rectangle
		System.out.print("Enter an integer for the square with -'s: ");

		// Set the value of the input as the -'s for the border of the rectangle
		// Set this to user_input2
		int user_input2 = scanner.nextInt();


//------------------------------------------------------------------------
		//
		// Creating the big 00000 block at top portion of this square border
		// This is the big long 0 in the BorderSquare number of times needed to print
		// We use this for bottom portion of the square with 000000 block again
		int long_zero = 2*user_input1 + user_input2;
		String long_zero_str = ""; 
		for (int i = 0; i < long_zero; i++) {
			long_zero_str = long_zero_str + "0";
		}

//-----------------------------------------------------------------------------
		//
		// This is the middle combination of 0's and -'s of the Square
		//
		String mix_length_zero_dash = "";
		// Create the 000 of the "000---000" square AKA the side L/R 000 border
		String zero_small_piece = "";
		for (int i = 0; i < user_input1; i++){
			zero_small_piece = zero_small_piece + "0";
		}
		// Create the ---- of the square
		String dash_small_piece = "";
		for (int i = 0; i < user_input2; i++){
			dash_small_piece = dash_small_piece + "-";
		}
		// Piece the 000s and the ---s and 000s for 000---000
		for (int i = 0; i < long_zero; i++){
			mix_length_zero_dash = zero_small_piece + dash_small_piece + zero_small_piece;
		}

//---------------------------------------------------------------------------------

		//
		//
		// Here we piece 3 pieces together to form the BorderSquare
		//
		//

	
		// Use For loop to print out top of the rectangle with the 000s
		for (int i = 0; i < user_input1; i=i+1) {
			System.out.println(long_zero_str);
		}

		// use For loop to print the mix 000----000 part of the BorderSquare
		for (int i = 0; i < user_input2; i++) {
			System.out.println(mix_length_zero_dash);
		}
		// use  For loop to print out the bottom 000s
		for (int i = 0; i < user_input1; i=i+1) {
			System.out.println(long_zero_str);
		}


		// Use one For loop to print out remianing bottom big long zeros
	}
}