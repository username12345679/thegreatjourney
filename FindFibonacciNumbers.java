import java.util.Scanner; // import scanner from java.util
import javax.swing.JOptionPane;

public class FindFibonacciNumbers
{
	// create the array to store this fib sequence of numbers
	// Note that when creating arrays, everything in the array is initialized to set value of 
	// 0. So in this case, we are setting everything in this 1D array to 0.
	//	static int[] answers = new int[100];
	

	public static void main(String[] args)
	{
		//Create the Scanner called scanner
		Scanner scanner = new Scanner(System.in);

		// DECLARE long variables here.
		int user_input1;

		//Print out text which will ask user for input
		System.out.print("Input A Number and This Program Will Print out all Fibonacci Numbers up to specified Input: ");
		
		//Then wait for user_input and convert input to int.
		user_input1 = scanner.nextInt();

		// create the 1D array based on the number we are asking for
		int[] answers = new int[user_input1+1];


		for (int i = 0; i < user_input1+1; i++)
		{
			answers[i] = fibonacci(i);
		}

		for (int j = 1; j < answers.length; j++)
		{
			System.out.print(answers[j] + " ");
		}

	} // close of main()


	// recursive method fibFactorial
	public static int fibonacci(int n)
	{
		// create the base case
		if ( (n == 0) ) // if when we get fib(0)
		{
			return 0;
		}
		else if ( (n == 1) )  // if when we get fib(1)
		{
			return 1;
		}
		else  //Enter into recursive function call and return value once done.
		{
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	} // Close the fibonacci method


} // close class



/** 

Create a FindFibonacciNumbers program that prints out all the fibonacci numbers up to a specified 
user input. Fibonacci numbers are the sum of the 2 previous numbers in the sequence. The output 
should look like this:

> 4
1 1 2 3
> 6
1 1 2 3 5 8
> 10
1 1 2 3 5 8 13 21 34 55 

Notes on this topic
fib(0) = 0;
fib(1) = 1;  These two are base cases.

fib(n) = fib(n-1) + fib(n-2);

for ex:

fib(5) = fib(4) + fib(3);

fib(3) = fib(2) + fib(1);  ==> fib(3) = 1 + 1;  ==> fib(3) = 2;

fib(2) = fib(1) + fib(0) = 1 + 0 = 1 --> fib(2) = 1;

fib(1) = 1;

fib(0) = 0;


*/ 

