//This is going to be a java app that converts F to C given a hard coded F temperature value

public class convertTemperature {

	// Main Method
	public static void main(String[] args){
		// Declare the F temperature as a double
		double f_temp;
		double c_temp;

		f_temp = 100.00;

		// Here is formula for calculation
		c_temp = (5.0/9.0)*(f_temp - 32.00);

		// Print out the result
		System.out.println("Given temperature of " +  String.format("%.2f",f_temp) + " in F. The C Temperature is " + String.format("%.2f",c_temp) + " in Celsius.");

	}

}