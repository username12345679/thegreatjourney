import java.util.*;

public class TestSmallInt {
	
	/** Main Method */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		SmallInt maxvalue = new SmallInt();
		System.out.print("Please enter in a value between 0 to MAXVALUE of " + maxvalue.MAXVALUE + ": ");

		int myInteger = scanner.nextInt();

		SmallInt mySmallInt = new SmallInt(myInteger); //Create a SmallInt with parameter of -5
		//System.out.println("The integer value of mySmallInt is: " + mySmallInt.getValue());
		System.out.println("getDec is the following: " + mySmallInt.getDec());
		System.out.println("getBin is the binary representation: " + mySmallInt.getBin());
		System.out.println("getHex is the hex representation: " + mySmallInt.getHex());

	} // End of main Method

} // End of public class SmallInt


// Default Constructor. Name as the public class.
// a constructor (one parameter)
class SmallInt {
	
	/** Private instance variable named value (Type int) */
	// create an original one which we will use to reset the value number back to the original.
	private int value;
	//private int value_orig = value;

	// A public static CONSTANT named MAXVALUE. MAXVALUE is used for UPPER LIMIT for the values SmallInt can represent. 
	// Value is set to 1000.
	public static int MAXVALUE = 1000;

	// Nothing here
	public SmallInt(){
		//do nothing here
	}

	// Construct the SmallInt with a specified parameter integer input. 
	// Call the setDec() method here to set the value.
	public SmallInt(int parameter) {
		setDec(parameter);
	}

	// Get the value with the getValue() function
	public int getValue() {
		return value;
	}

	//
	public String getDec(){
		String str_value = "" + value;
		return str_value;
	}

	// Accepts 1 int input. Returns void. Sets the value after doing error checking. 
	// If not meet requirement, then set value to 0. otherwise, set to parameter.
	public void setDec(int parameter) {
		if (parameter < 0 || parameter > MAXVALUE) {
			System.out.println("The number selected is invalid. Not between 0 and " + MAXVALUE);
			value = 0;
		}
		else {
			value = parameter;
		}
	}

	public String getBin() {

		String answer1 = "";
		int remainder;
		String reverse1 = "";
		int value_orig = value;
		
		while (true) {

			// We take the remainder from our value % 2. It will either be a 1 or a 0 when dividing by 2.
			remainder = (value % 2); 
			
			// After getting the remainder, we do an integer division to continue down to the 0 value
			// and then we are done.
			value = (value/2);
			
			// if remainder is 1 we add it to the answer1
			if (remainder == 1) {
				answer1 += "1";	
			}

			// if the remainder is 0, we add it to the answer1
			if (remainder == 0) {
				answer1 += "0";
			}

			// once we do integer division and it is 0, we reached end point.
			if (value == 0) {
				// if the dec number is too small we didnt reach the 8 bits, we pad it to 8 bits.
				while (answer1.length() < 7) {
					answer1 += "0";
				}

				// reverse the string to get it to binary format.
				for (int i = answer1.length() - 1; i >= 0; i--){
					reverse1 = reverse1 + answer1.charAt(i);
				}
				// return the solution which is the binary representation. 
				value = value_orig; // also make the value back to the original value.
				return reverse1; /// return the reverse1 to the user 
			}
		}
	} // End of getBin() method


	public String getHex() {

		String answer2 = "";
		int remainder;
		// we need to create the hex look up table
		String hexlookup[] = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		String reverse2 = "";

		// Enter in the while loop. Going to continue until we reach end of integer division with zero.
		while (true) {

			remainder = value % 16;

			//Obtain the remainder of the hex division. Look it up in the hexlookup array. Add it to the answer2.
			answer2 += hexlookup[remainder];
			
			// After adding to answer2, we go down the value and perform the integer division.
			value = value / 16; 

			// once we hit zero with the integer division, we reached the end.
			if (value == 0) {
				// we must revise the answer2 since we were stacking it from the right. we need to reverse it.
				for (int i = answer2.length() - 1; i >= 0; i--) {
					reverse2 = reverse2 + answer2.charAt(i);
				}
				// return the solution which is the hex representation of the number. 
				return reverse2; // return the reverse2 to the user. 
			}
		}		
	} // End of getHex()	
}

