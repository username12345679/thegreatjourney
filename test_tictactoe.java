import java.util.Scanner;

public class test_tictactoe
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);  // Create the Scanner object called scanner

		tictactoe game = new tictactoe(); // create the game object. type of this object is tictactoe which is in a different file called tictactoe.java

		game.printBoard();

		while (game.isBoardFull() == false)
		{
			System.out.print("Player: " + Character.toString(game.playerSide) + "...Please enter your move by entering in row position first: (rows 1 to 3) ");
			int row = scanner.nextInt();
			row = row - 1;

			System.out.print("Player: " + Character.toString(game.playerSide) + "...Now please enter in the column position of your move: (columns 1 to 3) ");
			int col = scanner.nextInt(); 
			col = col - 1;

			game.placeMark(row,col);

			game.printBoard();	

			if (game.CheckForGameWin()) 
			{
				System.out.println("Player:" + Character.toString(game.playerSide) + " won!! good job!");
				game.printBoard();
				break;
			}
			else if (game.isBoardFull()) 
			{
				System.out.println("Nobody got three in a row, so this is a draw");
				game.printBoard();
				break;
			}
			// If the game did not end through a draw or a win, then we go through this while loop again and we change the player to the other person. 
			game.changePlayer();		
		}
	}
}