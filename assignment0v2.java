import java.util.Random; //imports the random module
import java.util.Scanner;

public class assignment0v2
{

	public static void main(String[] args)
	{
		Random rand = new Random();

		char carColor;  // make use of charAt to get to what color is for RGB
		
		String carColor_String = "";
		String carIgnition_String;

		Boolean carIgnition = false; // The car ignition state: false = off, true = on
		
		Boolean gameCounter = true;
		
		Scanner scanner = new Scanner(System.in);

		int row1 = rand.nextInt(20);
		int col1 = rand.nextInt(20); 


		char[][] carGrid = new char[20][20];		

			      			   //01234
		String carColorString = "RGBWS";

		// This is a char datatype variable. It is a 
		char carColorRandom = carColorMethod(carColorString);

		if (carColorRandom == 'R')
		{
			carColor_String = "RED";
		}
		else if(carColorRandom == 'G')
		{
			carColor_String = "GREEN";
		}
		else if (carColorRandom == 'B')
		{
			carColor_String = "BLUE";
		}
		else if(carColorRandom == 'W')
		{
			carColor_String = "WHITE";
		}
		else if(carColorRandom == 'S')
		{
			carColor_String = "SILVER";
		}



		//System.out.print("The color of the car is: " + carColor_String + "\n");

		carGrid = create2DcarGrid(20);   					 //we create this 20row10 grid and call it carGrid
		//print_array(create2DcarGrid(20)); 				     //this prints out the 20 grid array for the car
		System.out.println();             					 //prints out a line break
		carGrid[row1][col1] = carColorRandom;    //assign a random spot in 20row10 grid for Car. Call it X
		// System.out.println("Car Status: ");
		// System.out.println("Color of Car is: " + carColor_String);
		// System.out.println("The Ignition Status is: " + carIgnition);
		// print_array(carGrid);

		while (gameCounter == true)
		 {
			//System.out.print("The car is at ROW: " + Integer.toString(row1) + " COL: " + Integer.toString(col1) + "\n");
		 	if (carIgnition == false)
		 	{
		 		carIgnition_String = "OFF";
		 	}
		 	else
		 	{
		 		carIgnition_String = "ON";
		 	}
			System.out.println("Car Stats: ");
			System.out.println("Color:   " + carColor_String);
			System.out.println("Ignition: " + carIgnition_String);
			System.out.println("Location: " + row1 + "," + col1);
			print_array(carGrid);

			System.out.println();

		 	System.out.print("What would you like to do next (1 - change ignition; 2 - change position of car; 3 - quit this program?:  ");
		 	
		 	int user_int = scanner.nextInt();

		 	System.out.println();

		 	if (user_int == 3)
		 	{
		 		System.out.println("Thanks for playing. Have a nice day! :)");
		 		gameCounter = false;
		 	}
		 	else if (user_int == 1)
		 	{
		 		carIgnition = changeIgnition(carIgnition);
		 		if (carIgnition == true)
		 		{
		 			System.out.println("Now the car is on...lets ROLL!!" + "\n");
		 			System.out.println();
		 		}
		 		else
		 		{
		 			System.out.println("Car is OFF...Please turn the car on before ROLLING" + "\n");
		 			System.out.println();
		 		}
		 	}
		 	else if ((user_int == 2) && (carIgnition == true)) // we are going to ask user to move the car
		 	{

		 		System.out.print("What direction would you like to move the car (1 - horizontal; 2 - vertical)? ");
		 		int user_direction = scanner.nextInt();

		 		if (user_direction == 1)
		 		{
		 			System.out.print("How far (negative value to move left)? ");
		 			int user_leftright = scanner.nextInt();
		 			assignCarSpotLeftRight(user_leftright, carGrid, row1, col1, carColorRandom);
		 			print_array(carGrid);
		 			col1 = col1 + user_leftright;
		 		}

		 		if (user_direction == 2)
		 		{
		 			System.out.print("How far up (negative value will move car up; positive value will move the car down) ");
		 			int user_UpDown = scanner.nextInt();
		 			assignCarSpotUpDown(user_UpDown, carGrid, row1, col1, carColorRandom);
		 			print_array(carGrid);
		 			row1 = row1 + user_UpDown;
		 		}
		 	}
		 	else
		 	{
		 		System.out.println("Please turn the ignition on first before moving the car!");
		 	}

		 }

	} // main method ends jhere

	// Randomly choose an integer between 0 to 4. Then use charAt() to pick a point in the string ABCDE color key.
	public static char carColorMethod(String carColorString)
	{
		Random rand = new Random();                                  
		int colorInt = rand.nextInt(5);

		char carColor = carColorString.charAt(colorInt);

		return carColor; // Return a char

	}

	// Method to print the array
	//print given char[][] array
	public static void print_array(char[][] ca) 
	{
		for (int i = 0; i < ca.length; i++) 
		{
			for (int j = 0; j < ca[0].length; j++) 
			{
				System.out.print(ca[i][j]);
			}
			System.out.println();
		}
		return;
	}

	// Change Ignition Status
	public static boolean changeIgnition(boolean carIgnition)
	{
		if (carIgnition == false)
		{
			carIgnition = true;
		}
		else
		{
			carIgnition = false;
		}
		return carIgnition;
	}

	// method returns a char[][]. Initialize and declare the 2d array here.
	public static char[][] create2DcarGrid(int row1)
	{
		char[][] carGrid = new char[row1][row1]; // initialize and declare the 2d array

		for (int i = 0; (i < carGrid.length); i++)  // for each row
		{
			for (int j = 0; (j < carGrid[0].length); j++) // for respective row, cycle through the column 
			{
				carGrid[i][j] = '-'; // each space here we put in '-' char
			}
		}
		return carGrid; // return the 2D array
	}

	// method used for moving the car leftRight horizontally.
	public static char[][] assignCarSpotLeftRight(int user_leftright, char[][] carGrid, int row1, int col1, char carColorRandom)
	{
		//We are going to assign the given coordinates into the coordinate plane. Assign coordinate using row1, col1 
		// coordinates. Change the original back to '-'
		int row1_orig = row1;
		//System.out.println("row1_orig: " + Integer.toString(row1_orig));

		int col1_orig = col1;
		//System.out.println("col1_orig: " + Integer.toString(col1_orig));

		col1 = col1 + (user_leftright);
		//System.out.println("row1: " + Integer.toString(row1));
		//System.out.println("col1: " + Integer.toString(col1));

		
		if ((col1_orig + user_leftright >= 20))
		{
			System.out.println("Scenerio 1 Horzintal Out of bounds: " + (col1_orig + user_leftright >= 20));
			System.out.println("You chosen a value goes out of bounds for the X Coordinate!");
			System.out.println("Please try again with a valid number within bounds!!");
			print_array(carGrid);
			System.exit(0);
		}
		else if ((user_leftright < 0) && (col1_orig + user_leftright < 0))
		{
			System.out.println("Scenerio 2 Horizontal Out of bounds: " + (col1_orig + user_leftright < 0));
			System.out.println("You chosen a value goes out of bounds for the X Coordinate!");
			print_array(carGrid);
			System.exit(0);
		}
		

		else 
		{
			carGrid[row1_orig][col1_orig] = '-';  // take the original X car position and make it into '-'.
			carGrid[row1][col1] = carColorRandom;	          // move it to the new place.
		}

		return carGrid;  // return to the caller a 2d char data type array.
	}

	public static char[][] assignCarSpotUpDown(int user_UpDown, char[][] carGrid, int row1, int col1, char carColorRandom)
	{
		int row1_orig = row1;
		//System.out.println("row1_orig" + Integer.toString(row1_orig));

		int col1_orig = col1;
		//System.out.println("col1_orig" + Integer.toString(col1_orig));

		row1 = row1 + (user_UpDown);
		//System.out.println("row1: " + Integer.toString(row1));
		//System.out.println("col1: " + Integer.toString(col1));

		if ((row1_orig + user_UpDown >= 20))
		{
			System.out.println("Scenerio 1 Vertical Out of bounds: " + (row1_orig + user_UpDown >= 20));
			System.out.println("You chosen a value that goes out of bounds for the Y coordinates!");
			print_array(carGrid);
			System.exit(0);
		}
		else if ((user_UpDown < 0) && (row1_orig + user_UpDown < 0))
		{
			System.out.println("Scnerio 2 Vertical Out of bounds: " + (row1_orig + user_UpDown < 0));
			System.out.println("You chosen a value that goes out of bounds for the Y coordinates!");
			print_array(carGrid);
			System.exit(0);
		}

		else
		{
			carGrid[row1_orig][col1_orig] = '-';
			carGrid[row1][col1] = carColorRandom;
		}
		return carGrid;
	}
}