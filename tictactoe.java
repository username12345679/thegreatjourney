public class tictactoe {

    private char[][] board; 
    public char playerSide;
			
    public tictactoe() {
        board = new char[3][3];
        playerSide = 'X';
        setBoard();
    }
	
	
    // Create the board.
    public void setBoard() {
		
        // Loop through rows of the tic tac toe game.
        for (int i = 0; i < 3; i++) 
        {
            // Loop through columns of the tic tac toe game.
            for (int j = 0; j < 3; j++) 
            {
                board[i][j] = '-';
            }
        }
    }
	
	
    // This prints out the board in the current state.
    public void printBoard() {
        System.out.println("-------------");
		
        for (int i = 0; i < 3; i++) 
        {   
            System.out.print("| ");
            for (int j = 0; j < 3; j++) 
            {
                System.out.print(board[i][j] + " | ");
            }            
            System.out.println();            
            System.out.println("-------------");
        }
    }
	
	
    // Checks if the board is used up all spaces.
    public boolean isBoardFull() 
    {
        boolean isBoardFull = true;
		
        for (int i = 0; i < 3; i++) // iterate over row...
        {
            for (int j = 0; j < 3; j++) // for each row iterate each column
            {
                if (board[i][j] == '-')  // if the board point has a cell that equals the '-' char, then it is not full
                {
                    isBoardFull = false;
                }
            }
        }
        return isBoardFull;
    }
	
	
    // Returns true if there is a win, false otherwise.
    // This calls our other win check functions to check the entire board. We use the "or" boolean logic
    // to see that if there are any wins. As long as one of them is true, then there is a win!.
    public boolean CheckForGameWin() 
    {
        return (CheckRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }
	
	
    // Check if there are any winners through a row
    public boolean CheckRowsForWin() 
    {
        for (int i = 0; i < 3; i++) 
        {
            if (checkRowsAndColumnEquality(board[i][0], board[i][1], board[i][2]) == true) 
            {
                return true;
            }
        }
        return false;
    }
	
	
    // Check if there are any winners through columns
    public boolean checkColumnsForWin() 
    {
        for (int i = 0; i < 3; i++) 
        {
            if (checkRowsAndColumnEquality(board[0][i], board[1][i], board[2][i]) == true) 
            {
                return true;
            }
        }
        return false;
    }
	
	
    // Check if there are any diagonal wins.
    public boolean checkDiagonalsForWin() 
    {
        return ((checkRowsAndColumnEquality(board[0][0], board[1][1], board[2][2]) == true) || (checkRowsAndColumnEquality(board[0][2], board[1][1], board[2][0]) == true));
    }
	
	
    // Check to see if all three values which we feed to this method to check if there is three in a row
    // For this method, we are input 3 char data types. These are what the cells are in the TicTacToe. 
    // We first check if the cell is empty or not. If it is empty, then this breaks down and there is no equality. So first it has to not be empty.
    // Then we check if the 1st cell is equal to the 2nd cell. Then we check the 2nd if equal to 3rd and if so we good and we win and return true for the other
    // check for wins. 
    public boolean checkRowsAndColumnEquality(char c1, char c2, char c3) 
    {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }
	
	
    // Calling this method is going to switch the playerSide to the other side for the different turn.
    // We run this each time the game is not over at the end of the while loop.
    public void changePlayer() 
    {
        if (playerSide == 'X') 
        {
            playerSide = 'O';
        }
        else 
        {
            playerSide = 'X';
        }
    }
	
	
    // Place the player choice on the tic tac toe board.
    public boolean placeMark(int row, int col) 
    {	
        // Make sure that row and column are in bounds of the board.
        if ((row >= 0) && (row < 3)) 
        {
            if ((col >= 0) && (col < 3)) 
            {
                if (board[row][col] == '-') 
                {
                    board[row][col] = playerSide;
                    return true;
                }
            }
        }
		System.out.println("This has already been used.");
        return false;
    }
}