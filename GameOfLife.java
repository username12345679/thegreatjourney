import java.util.*;
import java.io.*;

public class GameOfLife {
	public static void main (String [] args)
	{
        final int M = 25; //The size of the row number .dat files.
        final int N = 75; //The size of the .dat file numbers of Columns.
        int numNeighbors=0;
        
        char[][] organism_world = new char[M+2][N+2]; //current gen organism world.

        char[][] organism_world_nextgen = new char[M+2][N+2]; //organism world for next-generation.

        int gen_counter = 0;

        Scanner consoleReader = new Scanner(System.in);

        Scanner scanner = new Scanner(System.in);

        boolean gameCounter = true; //Boolean value to get into the game.
        
		System.out.print ("Which file do you want to open? ");
		
		String filename = consoleReader.next();
		File file = new File(filename);
		Scanner fileReader = null;

		try 
		{
		    fileReader = new Scanner (file);		
		} 
		catch (Exception e) 
		{
		    System.out.print("file " + file + " dopes not exisit");
		    System.exit(0);
        }
        
        // STEP 1: populate the current 2D array organism_world[][] from the .dat input file.
        // We start to populate in this 2D array starting from Row1 Colum1 up to M Row and N col rather than to M+1 and N+1 to maintain border!!!
        // This is going to go through the size of the Rows of the .dat file we are inputting here.
        for (int i = 0; i < M; i++) 
		{
            //for each time this is called, it reads next line of the .dat file.
            String line = fileReader.nextLine();  // This is a String.
            char[] array = line.toCharArray();
            for (int j = 0; j < N; j++) {
                 organism_world[i+1][j+1] = array[j];
            }
			//System.out.println(line);
        }

        //This prints out the .dat file after converting the .dat into 2D char array
        //printArray(organism_world); 


        // Iterate over every cell of organism_world and see which one is vacant and which one are living.
        // Start a while loop to jump into the game. 
        // While game counter is true, we jump into this generational game.
        while (gameCounter == true) {


            //System.out.println("This is the current generation of organisms: ");
            //printArray(organism_world);

            //For each ROW, we iterate over each COLUMN of that row. For each element, we find number of neighbors surrounding the element in the world. 
            for (int i = 1; i < M; i++) {            
                for (int j = 1; j < N; j++) {

                    // call method to check that element of the 2D array 
                    // store number of number of Neighbors in variable numNeighbors
                    // method1 will return number of neighbors
                    // if the cell @ organism_world is occupied 'X', AND number of neighbors are 2 and 3, then take that 
                    //System.out.println("i value is: " + i + "|    j value is: " + j);
                    numNeighbors = method1(organism_world, i, j);
                    //System.out.println("i value is: " + i + "  |   j value is: " + j + "  |  Number of Neighbors is: " + numNeighbors);
                    // If cell is occupied, and if neighbors is 2 or 3, then survives. 
                    if (organism_world[i][j] == 'X' && ((numNeighbors == 2 || numNeighbors == 3))) {
                        //System.out.println("Row: " + i + " Column: " + j + "IS an X");
                        organism_world_nextgen[i][j] = 'X'; //this cell survives in the next generation.
                    }
                    // if current cell is occupied, and if neighbors is not 2 or 3, then dies.
                    else if (organism_world[i][j] == 'X' && ((numNeighbors < 2))) {
                        //System.out.println("Row: " + i + " Column: " + j + "IS an X");
                        organism_world_nextgen[i][j] = '.'; //this cell DIES in the next generation.
                    }

                    else if (organism_world[i][j] == 'X' && ((numNeighbors > 3))) {
                        //System.out.println("Row: " + i + " Column: " + j + "IS an X");
                        organism_world_nextgen[i][j] = '.'; //this cell DIES in the next generation.
                    }
                    // if the current cell is vacant, and neighbors is exactly 3, then there is new generation
                    else if (organism_world[i][j] == '.' && ((numNeighbors == 3))) {
                        //System.out.println("Row: " + i + " Column: " + j + "IS an .");
                        organism_world_nextgen[i][j] = 'X';
                    }
                    // if the current cell is vacant, if neighbor is not exactly 3, then remains vacant.
                    else if (organism_world[i][j] == '.' && ((numNeighbors != 3))) {
                        //System.out.println("Row: " + i + " Column: " + j + "IS an .");
                        organism_world_nextgen[i][j] = '.';
                    }
                } //exit inner for loop
            } // exit outer for loop

            System.out.println("This is the current generation number: " + gen_counter);
            printArray(organism_world);
            gen_counter = gen_counter + 1;
            System.out.println("This is the next generation number: " + gen_counter);
            printArray(organism_world_nextgen);

            // If the two arrays are equal, then we terminate the game.
            if (method2(organism_world,organism_world_nextgen,M,N) == true) {
                System.out.println("The two worlds are now the same...program will terminate now.");
                gameCounter = false;
            }

            // if the array of the next generation is empty, then we terminate the game.
            else if (method3(organism_world_nextgen,M,N) == true) {
                System.out.println("This world is now empty...program will terminate.");
                gameCounter = false;
            }

            // if array is not empty. if the current and next is not same. then ask user if they want to continue the game.
            else{
                System.out.println();
                System.out.print("Do you want to continue?: Enter 1 to Continue. Enter 0 to quit.");
                int input1 = scanner.nextInt();
                if (input1 == 1) {
                        gameCounter = true;
                        //System.out.println(organism_world.length);
                        //System.out.println(organism_world[25].length);
                        organism_world = new char[M+2][N+2];
                        organism_world = organism_world_nextgen;
                        organism_world_nextgen = new char[M+2][N+2];
                }
                else if (input1 == 0){
                gameCounter = false;      // game ends here.
                }
            }
        }
    } // END OF MAIN METHOD.

    //Prints out a 2D array. Input is a char[][] datatype 2D array.
    public static void printArray(char[][] ca) {
        for (int i = 0; i < ca.length; i++) {
            for (int j = 0; j < ca[0].length; j++) {
                System.out.print(ca[i][j]);
            }
            System.out.println();
        }
        return; // we need a return for void method. Just return nothing.
    } // End of printArray Method

    // Method to check element of the 2D array for how many neighbors it is. 
    public static int method1(char[][] organism_world, int row_pos, int col_pos) {
        int num_neighbors = 0;
        int row_pos_ORIG = row_pos;
        int col_pos_ORIG = col_pos;
        int i; 
        int j; 
        //System.out.println("We are at center point at ROW: " + row_pos + " and at COLUMN: " + col_pos);
        //we look 1 row above current cell
        for (i = (row_pos - 1); i <= (row_pos+1); i++) 
        {
            //we iterate through the columns of said ROW
            for (j = (col_pos - 1); j <= (col_pos+1); j++) {
                if (organism_world[i][j] == 0) {
                    //System.out.println("We are inside Method1 ROW: " + i + " COLUMN: " + j + " it is a BLANK. DO NOT ADD Neighbors");
                    //do nothing
                }
                else if (organism_world[i][j] == '.') {
                    //System.out.println("We are inside Method1 ROW: " + i + " COLUMN: " + j + " it is a '.' . DO NOT ADD Neighbors");
                    //do nothing
                }

                else if ((i == row_pos_ORIG) && (j == col_pos_ORIG)) {
                    //System.out.println("We are inside Method1 ROW: " + i + " COLUMN: " + j + " THIS IS ITSELF THIS IS ITSELF.");
                }
                else if (organism_world[i][j] == 'X') {
                    //System.out.println("We are inside Method1 ROW: " + i + " COLUMN: " + j + " it is a 'x'. ADD A Neighbors");
                    num_neighbors += 1;
                }
            }
        }
        //System.out.println("The TOTAL NEIGHBOR at ROW: " + row_pos_ORIG + " COLUMN: " + col_pos_ORIG + " has TOTAL NEIGHBOR OF: " + num_neighbors);
        //return number of neighbors
        return num_neighbors;
    }

    //This method checks if the array input are equal to each other.
    public static boolean method2(char[][] array1, char[][] array2, int M, int N) {
        for (int i = 0; i < M; i++) 
        {
            for (int j = 0; j < N; j++) {
                if (array1[i][j] == array2[i][j]){
                    // do nothing. go past.
                }
                else{
                    return false;
                }  
            }
        }
        return true;
    }

    // method to check if array is empty
    public static boolean method3(char[][] array3, int M, int N) 
    {
        for (int i = 0; i < M; i++) 
        {
            for (int j = 0; j<N; j++){
                if (array3[i][j] == ' '){
                    // do nothing
                }
                if (array3[i][j] == '.'){
                    //do nothing
                } 
                if (array3[i][j] == 'X') {
                    return false; //this array is not empty.
                }
            }
        }
        return true; //this array is empty.
    }
    
} // End of PUBLIC Class GameOfLife