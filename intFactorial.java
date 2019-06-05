import java.util.Scanner; //scanner 
import java.util.*;


public class intFactorial 
{
	static int answer;

	/* Main Method */
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in); //scanner object create here.

		System.out.print("Please enter in integer value: "); // ask user to input

		int userInt = scanner.nextInt(); // accept user key input and store in userInt var

		System.out.println("You chose the integer: " + userInt);

		System.out.println("The factorial of the integer: " + userInt + " is " + factorial_function(userInt));

		// using recursion
		System.out.println("Using recursion to solve this: " + userInt + " is " + recursion_factorial(userInt));

	}//end of main method

	public static int factorial_function(int a) 
	{
		answer = a;
		for (int i = a; i >= 2; i--)
		{
			answer *= (i-1);
		}
		return answer;

	}//end of user

	// using recursion to write this program
	public static int recursion_factorial(int a)
	{
		if (a == 0)
		{
			return 1;
		}

		else 
		{
			return (a * recursion_factorial(a-1));
		}

	} // end of recursion_factorial

}// end of class intFactorial 