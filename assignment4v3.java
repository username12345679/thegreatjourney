import java.util.*;

public class assignment4v3 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		boolean gameCounter = true;

		
		Car[] carData = new Car[10]; // Create a 1D array holding the array made up of object Car type.

		// Create the 10 car objects. 
		for (int i = 0; i < carData.length; i++)
		{
			//System.out.println("The i value is: " + i);
			carData[i] = new Car();      //Each element of this 1D array is a creation of this Car() object. 
		}

		
		// BEGIN THE GAME
		while (gameCounter == true) 
		{
			int carNumber;
			while (true)  // Enter in while loop. Check if user enters in a valid car number between car 0 to car 9.
			{
				System.out.print("Which Car would you like to use 0 - 9)?: ");
				
				carNumber = scanner.nextInt();

				System.out.println();

				if (carNumber < 0 || carNumber > 9) 
				{
					System.out.println("Please enter a number between 0 and 9!! ");
				}
				else 
				{
					break;
				}
			}
			//
			// Current state of the car you chose
			//
			// System.out.println("The car number is: " + carNumber);
			System.out.println("Car Stats: " );
			System.out.println("Car Number: " + carNumber);
			System.out.println(carData[carNumber]);
			///////////////////////////////////////////////////


			System.out.print("What would you like to do next (1 - change ignition; 2 - change position of car; 3 - quit this program?: ");

			int answer_2 = scanner.nextInt();

			System.out.println();

			// If user choses answer_2 == 3, then the game ENDS.
			if (answer_2 == 3)
			{
				System.out.println("Thanks for playing. Have a nice day! :) ");
				gameCounter = false;
			}

			// If user selects 2, and the ignition status is on, then we ask which way to move the car
			else if (answer_2 == 2 && carData[carNumber].getcarIgnitionStatus() == true) {
				System.out.print("What direction would you like to move the car (1 - Horizontal; 2 - Vertical)? ");	
				int answer_3 = scanner.nextInt();
				int answer_4;
				System.out.println();
				if (answer_3 == 1) {
					System.out.print("How far (NEGATIVE VALUE TO MOVE LEFT)? ");
					answer_4 = scanner.nextInt();
					System.out.println();
					carData[carNumber].moveCarLeftRight(answer_4);
					System.out.println("Car Stats: " );
					System.out.println("Car Number: " + carNumber);
					System.out.println(carData[carNumber]);
				}
				else if (answer_3 == 2) {
					System.out.print("How far (NEGATIVE VALUE TO MOVE UP)? ");
					answer_4 = scanner.nextInt();
					carData[carNumber].moveCarUpDown(answer_4);
					System.out.println("Car Stats: " );
					System.out.println("Car Number: " + carNumber);
					System.out.println(carData[carNumber]);
				}
				else 
				{
					System.out.println("Please enter a valid response!");
				}
			}

			//If the user chooses choice 2 and the car ignition is OFF, then we tell the user the car ignition status
			else if (answer_2 == 2 && carData[carNumber].getcarIgnitionStatus() == false) {
				System.out.println("The car number " + carNumber + " current ignition status is: " + carData[carNumber].getcarIgnitionString() + ". Please turn Ignition ON before moving the car! " + "\n");
			}

			else if (answer_2 == 1) {
				// if the ignition status is set to OFF / false, then set it to ON / true.
				if (carData[carNumber].getcarIgnitionStatus() == false) {
					carData[carNumber].toggleCarIgnitionStatus(); //change the car ignition status
					System.out.println("The ignition status is set to ON! " + " for car " + carNumber + ". You are now ready to move the car! " + "\n");
					System.out.println("Car Stats: " );
					System.out.println("Car Number: " + carNumber);
					System.out.println(carData[carNumber]);
					System.out.println();

				}
				else {
					carData[carNumber].toggleCarIgnitionStatus(); // change the car ignition status
					System.out.println("Ignition status set to OFF! " + " for car " + carNumber + "\n");
					System.out.println("Car Stats: " );
					System.out.println("Car Number: " + carNumber);
					System.out.println(carData[carNumber]);
					System.out.println();
				}
			}
		} // end the game here
	} // End of Main Method

} // End of public class assignment4v2