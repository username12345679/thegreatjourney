import java.util.*;

public class assignment1 {

	public static void main(String[] args) {

		// scanner object to read in user input. 
		Scanner scanner = new Scanner(System.in);

		// boolean for game to start in our while() loop.
		boolean gameCounter = true; //while loop set to true for game start LINE36

		// Initialize and Declare the String color variable. 
		String color = ""; 
		
		// Initialize 2D array. 
		int[][] carData = new int[11][5];

		/*
		car0 = [ car number, ignition status, car Color ID, row, col]
		car1 = [ car number, ignition status, car Color ID, row, col]
		car2 = ...
		...
		car10 = ...
		*/

		// FOR EACH ROW OF THE 2D ARRAY carData, we set ignition to false, randomize color and randomize xpos,ypos
		// The car array itself is [car number(0-10), car ignition status(0-1), car color ID(0-4), xpos, ypos]
		for (int i = 1; i<10; i++) {
			initializeCar(carData, i);
		}

		// BEGIN THE GAME HERE
		while (gameCounter == true) {

			int carNumber;

			// Check user enters car number between 1 to 10. If not, stay in loop. Else continue with game...
			while (true) {
				System.out.print("Which car would you like to use(1-10)?: ");
				carNumber = scanner.nextInt();

				System.out.println();
				
				if (carNumber<1 || carNumber>10) {
					System.out.println("Please enter a number between 1 and 10");
				}
				else{
					break;
				}
			}
			 
			//#####################################################################
			// Below two lines of code might not be needed anymore with better while loop above
			//System.out.print("Which car would you like to use(1-10) "); //ASK THE USER WHICH CAR TO MOVE
			//int carNumber = scanner.nextInt(); // USER CHOSES WHICH CAR TO MOVE. e.g User chooses 1, so that would be car1
			// ####################################################################

			// After user chooses their car choice, then we ask if they want to do next (1-change ignition; 2-change position of car; 3-quit this program)
			System.out.print("What would you like to do next (1 - change ignition; 2 - change position of car; 3 - quit this program?:  ");

			int answer_2 = scanner.nextInt(); // 1 - change ignition , 2 - move car, 3 - quit game

			System.out.println();  // Print out one line break. 

			// If user chooses 3, then we quit the game. 
			if (answer_2 == 3) {

				System.out.println("Thanks for playing. Have a nice day! :) ");
				gameCounter = false;

			}

			// If user selects 2, and the ignition status is ON (1), then we ask which way to move car. 
			else if (answer_2 == 2 && carData[carNumber][1] == 1) {

				System.out.print("What direction would you like to move the car (1 - Horizontal; 2 - vertical)?" );
				int answer_3 = scanner.nextInt(); //answer_3 - 1 - move left/right(through columns), 2-move up/down (rows)
				int answer_4;
				if (answer_3 == 1){
					System.out.print("How far (NEGATIVE VALUE TO MOVE LEFT)? ");
					answer_4 = scanner.nextInt(); 
					carData = moveLeftRight(carData, carNumber, answer_3, answer_4); 
				}

				if (answer_3 == 2) {
					System.out.print("How far (NEGATIVE VALUE to move UP)?");
					answer_4 = scanner.nextInt();
					carData = moveUpDown(carData, carNumber, answer_3, answer_4); 
					System.out.println();
				}
			}

			// User selects 1. Then we change the ignition status of car which user has previously selected. 
			else if (answer_2 == 1) {
				//If Ignition status is off(0), then we set it ON(1).
				if (carData[carNumber][1] == 0) {
					carData[carNumber][1] = 1;
					System.out.println("Ignition set to ON!" + " for car " + carNumber + "\n");
					System.out.println();
				}
				//If Ignition status is On(1), then we set it OFF(0).
				else {
					System.out.println("Ignition set to OFF!" + " for car " + carNumber + "\n");
					carData[carNumber][1] = 0;
				}
			}

			// If the user selects move car but ignition status is OFF, Tell user to turn on ignition status
			else if (answer_2 == 2 && carData[carNumber][1] == 0){
				System.out.println("Please turn the ignition on first before moving the car!");
			}

			// If user does not enter choices 1, 2 or 3, then print this message.
			else {
				System.out.println("Error: Please enter integers between 1 and 3.");
			}
			System.out.println();

			// Print out the current status of the car
			printState(carData, carNumber, color);

			System.out.println();
		} // END OF WHILE LOOP

	} // method main ends here

	//                                    2D car Data,       car #      left or right    how much  
	public static int[][] moveLeftRight(int[][] carData, int carNumber, int answer_3, int answer_4) {	
		
		int new_X = carData[carNumber][3] + answer_4;

		if (new_X >= 20 || new_X < 0) {
			// print this is an invalid move
			System.out.println("This is an invalid horizontal move!");
			return carData;
		}
		else {
			carData[carNumber][3] = new_X; //Update the X position of the car.
			return carData;
		}
	} // END OF moveLeftRight Method.

	// Method to move the car UP or DOWN. 
	public static int[][] moveUpDown(int[][] carData, int carNumber, int answer_3, int answer_4) {

		int new_Y = carData[carNumber][4] + answer_4;

		//If the position of the new_Y is greater than 20 or less than 0, then outside boundary. 
		if (new_Y >= 20 || new_Y < 0) {
			System.out.println("This is an illegal vertical move!");
			return carData;
		}
		// Otherwise, this is a legal move and we update position. 
		else {
			carData[carNumber][4] = new_Y; //Update the Y position of the car.
			return carData;
		}
	} // END OF moveUpDown

	public static void printState(int[][] carData, int carNumber, String color) {
		System.out.println("Car Stats: ");
		System.out.println("Car #: " + carNumber);
		System.out.print("Color: ");
		if (carData[carNumber][2] == 0) {
			System.out.println("Red");
			color = "R";
		}
		else if (carData[carNumber][2] == 1) {
			System.out.println("Green");
			color = "G";
		}
		else if (carData[carNumber][2] == 2) {
			System.out.println("Blue");
			color = "B";
		}
		else if (carData[carNumber][2] == 3) {
			System.out.println("White");
			color = "W";
		}
		else if (carData[carNumber][2] == 4) {
			System.out.println("Silver");
			color = "S";
		}
		System.out.print("Ignition: ");
		if (carData[carNumber][1] == 0) {
			System.out.println("Ignition Status: OFF");
		}
		else {
			System.out.println("Ignition Status: ON");
		}
		System.out.println("Location: " + carData[carNumber][3] + " , " + carData[carNumber][4]);
		for(int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (carData[carNumber][3] == j && carData[carNumber][4] == i) {
					System.out.print(color);
				}
				else {
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
	
	// Method to initialize each of the cars from 0 to 10. (up to not including 11)
	public static int[][] initializeCar(int[][] carData, int i) {
		// carArray[ car number, car inition state, car color, xpos, ypos]
		Random rand = new Random();

		int colorID = rand.nextInt(5); 

		int row1 = rand.nextInt(20);
		int col1 = rand.nextInt(20);

		carData[i][0] = i; //THIS IS THE CAR NUMBER
		carData[i][1] = 0; //IGNITION INITIALIZED TO 0 FALSE START
		carData[i][2] = colorID; // RANDOM INTEGER FROM 0 TO 4 FOR RANDOM COLOR
		carData[i][3] = row1;
		carData[i][4] = col1;
		return carData;
	} // END OF METHOD
}