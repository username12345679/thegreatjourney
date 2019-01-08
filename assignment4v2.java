import java.util.*;

public class assignment4v2 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		boolean gameCounter = true;

		
		Car[] carData = new Car[11]; // Create a 1D array holding the array made up of object Car type.

		// Create the 10 car objects. 
		for (int i = 1; i < carData.length; i++)
		{
			//System.out.println("The i value is: " + i);
			carData[i] = new Car(i);
			// System.out.println("The car ID is the following: " + carData[i].getcarID() + " Ignition Status is: " + carData[i].getcarIgnitionStatus()
			// 	+ " The car of the color is: " + carData[i].getColorString() + " and the getcarID is: " + carData[i].getcarID());			
		}

		
		// BEGIN THE GAME
		while (gameCounter == true) 
		{

		for (int i = 1; i < carData.length; i++)
		{
			//System.out.println("The i value is: " + i);
		//	carData[i] = new Car(i);
			System.out.println("The car ID is the following: " + carData[i].getcarID() + " Ignition Status is: " + carData[i].getcarIgnitionStatus()
				+ " The car of the color is: " + carData[i].getColorString() + " and the getcarID is: " + carData[i].getcarID());			
		}

			int carNumber;
			// Check if the user enters a number between 1 and 10. If not, stay in loop. Else we continue with game...
			while (true) 
			{
				System.out.print("Which Car would you like to use 1 - 10)?: ");
				
				carNumber = scanner.nextInt();

				System.out.println();

				if (carNumber < 1 || carNumber > 11) 
				{
					System.out.println("Please enter a number between 1 and 10 ");
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
			System.out.println(carData[carNumber].toString());
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
				
				System.out.println("What direction would you like to move the car (1 - Horizontal; 2 - Vertical)? ");
				
				int answer_3 = scanner.nextInt();
				
				int answer_4;
				
				if (answer_3 == 1) {
					System.out.print("How far (NEGATIVE VALUE TO MOVE LEFT)? ");
					answer_4 = scanner.nextInt();
					carData[carNumber].moveCarLeftRight(answer_4);
					System.out.println(carData[carNumber].toString());
				}
				else if (answer_3 == 2) {
					System.out.print("How far (NEGATIVE VALUE TO MOVE UP)? ");
					answer_4 = scanner.nextInt();
					carData[carNumber].moveCarUpDown(answer_4);
					System.out.println(carData[carNumber].toString());
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
					System.out.println(carData[carNumber].toString());
					System.out.println();

				}
				else {
					carData[carNumber].toggleCarIgnitionStatus(); // change the car ignition status
					System.out.println("Ignition status set to OFF! " + " for car " + carNumber + "\n");
					System.out.println(carData[carNumber].toString());
					System.out.println();
				}
			}


		
		} // end the game here



	} // End of Main Method

} // End of public class assignment4v2