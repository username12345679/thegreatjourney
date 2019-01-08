class Car 
{
	public static int carID;                    // This is the car ID Number
	public static int carColorID;               // This is the car Color ID Number.
	public static boolean carIgnitionStatus;    // This is the car Ignition Status.
	public static int row_pos;                  // This is Integer row position of car.
	public static int col_pos; 					// This is Integer column position of car.
	public static String colorSymbol;    		// The string Letter representation of the car Color
	public static String colorString;			// The string entire text representation of the car Color.

	public Car(int int1)
	{
		//System.out.println(int1);
		carID = setcarID(int1);
		carIgnitionStatus = setcarIgnitionStatus();
		carColorID = setcarColorID();
		row_pos = setRowPosition();
		col_pos = setColPosition();
		//grid = getGrid();
	}

	// method to move the coordinate left/right
	public void moveCarLeftRight(int user_leftright_move)
	{
		int new_X = col_pos + user_leftright_move;
		if (new_X >= 20 || new_X < 0)
		{
			System.out.println("That was an invalid horizontal move!" + "\n");
		}
		else
		{
			col_pos = new_X;
		}
	}

	// method to move the coordinate up/down 
	public void moveCarUpDown(int user_updown_move) 
	{
		int new_Y = row_pos + user_updown_move;
		if (new_Y >= 20 || new_Y < 0)
		{
			System.out.println("That was an invalid vertical move!" + "\n");
		}
		else
		{
			row_pos = new_Y;
		}		
	}

	public int setcarID(int int1) 
	{
		return int1;
	}

	public int getcarID() 
	{
		return carID;
	}

	public boolean setcarIgnitionStatus()
	{
		return false;
	}

	public boolean getcarIgnitionStatus()
	{
		return carIgnitionStatus;
	}

	public String getcarIgnitionString()
	{
		if (carIgnitionStatus == false) {
			return "OFF";
		}
		else {
			return "ON";
		}
	}

	public void toggleCarIgnitionStatus()
	{
		carIgnitionStatus = !(setcarIgnitionStatus());
	}

	public int setcarColorID()
	{
		int rand_color_id = (int) Math.floor(5 * Math.random()); // possible values are 0-4
		if (rand_color_id == 0) 
		{
			colorSymbol = "R";
			colorString = "Red";
			return 0;
		}
		else if (rand_color_id == 1) 
		{
			colorSymbol = "G";
			colorString = "Green";
			return 1;	
		}
		else if (rand_color_id == 2) 
		{
			colorSymbol = "B";
			colorString = "Blue";
			return 2;	
		}
		else if (rand_color_id == 3) 
		{
			colorSymbol = "W";
			colorString = "White";
			return 3;	
		}
		else 
		{
			colorSymbol = "S";
			colorString = "Silver";
			return 4;
		}
	}

	public int getColorID()
	{
		return carColorID;
	}

	public String getColorSymbol()
	{
		return colorSymbol;
	}

	public String getColorString()
	{
		return colorString;
	}

	public int getRowPosition()
	{
		return row_pos;
	}

	public int getColPosition()
	{
		return col_pos;
	}

	public int setRowPosition() {
		return (int) Math.floor(20 * Math.random());
	}

	public int setColPosition() {
		return (int) Math.floor(20 * Math.random());
	}	

	public String getGrid()
	{
		String grid ="";
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (col_pos == j && row_pos == i) {
					grid += colorSymbol;
				}
				else {
					grid += "-";
				}
			}
			grid += "\n";
		}
		return grid;
	}

	public String toString() {
		return ("Car Stats:     " + "\n" +
//			   "Car Number:    " + getcarID() + "\n" +
			   "Color:         " + getColorString() + "\n" + 
			   "Ignition:      " + getcarIgnitionString() + "\n" +
			   "Location:      " + getColPosition() + "," + getRowPosition() + "\n\n" +
			   getGrid());
	}

} // End of Car Class

