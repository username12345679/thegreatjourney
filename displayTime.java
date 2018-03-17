public class displayTime {
	/** Main Method */
	public static void main(String[] args) {
			/** this is the number of seconds we are going to hard code */
			int seconds = 4000;
			int hours;
			int minutes;

			/** print out the seconds variable*/
			//System.out.println(seconds);

			/**Find the number of hours there are in the seconds */
			hours = seconds / 3600;
			System.out.println("There are " + hours + " Hour(s) in " + seconds + " seconds.");

			// Find number of minutes remaining after hours
			int min_sec = seconds - hours * 3600;
			minutes = min_sec / 60;
			System.out.println("There are " + minutes + " minutes remaining");

	}
}