
// Import the java Scanner utility
import java.util.Scanner; 


public class BorderSquareWithArray 
{

	public static void main(String[] args) 
	{

		Scanner scanner = new Scanner(System.in); // Create the scanner called scanner. 

		System.out.print("Enter an integer to determine the border size of BorderSquare with 0's: ");  //ask the user for the 0's border to the square

		final int SIZE1 = scanner.nextInt(); //data type we accepting for 0 border size is int

		System.out.print("Enter an integer to determine the inside square size of BorderSquare of -'s: "); // ask the user for the inside square - size

		final int SIZE2 = scanner.nextInt(); //data type we accepting for -'s inside square is int

		//final int SIZE1 = 1; // 0'S SURROUNDING THE - SQUARE
		//final int SIZE2 = 10; // - SQUARE
		
		// Create the 2d matrix called matrix1. This is a char data type matrix. 
		char[][] matrix1 = new char[SIZE1*2 + SIZE2][SIZE1*2 + SIZE2];

		// We create iterator here while we loop later in the while loop over the entire height of this 2D array.
		int iterator = 0;

		//HEIGHT OF THIS 2D ARRAY
		int matrix1_height = SIZE1*2 + SIZE2;

		// index1 will be up to the point where we print out only 0000s in the matrix
		int index1 = matrix1_height - SIZE2 - SIZE1;
		System.out.println("HERE IS INDEX1: " + index1);

		// index2 will be where we finish the bottom of the square where we print only 00000s.
		int index2 = matrix1_height - SIZE1 - 1;
		System.out.println("HERE IS INDEX2: " + index2);

		// Here we Enter into the while loop. Print out going in what the iterator is and what the height of matrix is
		System.out.println("Entering the while loop: " + "iterator is: " + iterator + " and matrix1.length is: " + matrix1.length + "\n");	

		while(iterator < (matrix1.length)) // Enter here
		{
			System.out.println("ITERATOR IS: " + iterator + "   index1 is: " + index1 + ",   index2 is: " + index2 + "   matrix1.length: " + matrix1.length + "\n");

		
			if (iterator < index1) // This is the outer top square with the 0's
			{
				System.out.println("We are at block 1 of the border square section WITH 000s ON TOP OF SQUARE" + "\n");
				System.out.println("iterator < index1: " + (iterator<index1));
				//System.out.println("We are here 1111");
				for(int i = 0; i < matrix1_height; i++)
				{
					matrix1[iterator][i]='0';
				}
				System.out.println("Leaving the 1st phase of BorderSquare Construction!!" + "\n");
				System.out.println();	
			} 
			
			else if( (iterator <= index2) && (iterator >= index1) )  //this is the in between mix rows
			{

				System.out.println("We are at block 2 of the border square section WITH THE MIX 000---000" + "\n");
				
				System.out.println("iterator < index2 && iterator > index1: " + ((iterator<=index2) && (iterator >= index1)) + "\n"); 
				for (int i = 0; i < matrix1_height; i++) 
				{
					if (i < index1)
					{
						matrix1[iterator][i]='0';
					}	
					else if ( (i >= index1) && (i <= index2) )
					{
						matrix1[iterator][i] = '-';
					}
					else 
					{
						matrix1[iterator][i]='0';
					}
				}
				System.out.println("Leaving the 2nd phase of BorderSquare Construction" + "\n");
			}
			else if ( iterator > index2)
			{
				System.out.println("We are at block 3 of the border square section! WITH THE 000S FINAL SECTION" + "\n");

				System.out.println("iterator > index2: " + (iterator>index2) + "\n");

				for (int i = 0; i < matrix1_height; i++)
				{
					matrix1[iterator][i]='0';	
				}
				System.out.println("Leaving the 3nd phase of BorderSquare Construction" + "\n");

			}

			iterator++;
			System.out.println("Increase iterator by 1: " + iterator + "\n");
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" + "\n");

		} // while loop ends

		System.out.println();
		// print out this 2d array called matrix
		for (int i = 0; i < matrix1.length; i++)
		{
			for (int j = 0; j < matrix1[0].length; j++)
			{
				System.out.print(matrix1[i][j]);
			}
			System.out.println();
		}


	} // End of the main method
} // End of the main class