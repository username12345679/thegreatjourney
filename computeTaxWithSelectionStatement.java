import java.util.Scanner;

public class computeTaxWithSelectionStatement{

	public static void main(String[] args) {

		// Create a scanner
		Scanner scanner = new Scanner(System.in);

		// Prompt the user to enter filing status
		System.out.print(
			"(0-single filer, 1-married jointly, \n"  +

			"2-married separately, 3-head of household)\n" +

			"Enter the filing status: ");

		int status = scanner.nextInt();

		// Prompt the user to enter a taxable income
		System.out.print("Enter the taxable income: ");

		double income = scanner.nextDouble();

		// compute the tax
		double tax = 0;

		// if the user is a single filer, he or she entered 0
		if (status == 0) { 
			if (income <= 6000) {                      
				tax = income * 0.10;      
			}
			else if (income <= 27950) {
				tax = 6000 * 0.10 + (income - 6000) * 0.15;
			}
			else if (income <= 67700) {
				tax = 6000 * 0.10 + (27950 - 6000) * 0.15 + (income - 27950) * 0.27;
			}
			else if (income <= 141250) {
				tax = 6000 * 0.10 + (27950 - 6000) * 0.15 + (67700 - 27950) * 0.27 + (income - 67700) * 0.30;
			}
			else if (income <= 307050) {
				tax = 6000 * 0.10 + (27950 - 6000) * 0.15 + (67700 - 27950) * 0.27 + (141250 - 67700) * 0.30 +
				(income - 141250) * 0.35;
			}
			else {
				tax = 6000 * 0.10 + (27950 - 6000) * 0.15 +

          		(67700 - 27950) * 0.27 + (141250 - 67700) * 0.30 +

          		(307050 - 141250) * 0.35 + (income - 307050) * 0.386;
          	}
        }
        else if (status == 1) {
          	if (income <= 12000) {                              // Rate 10%
          		tax = income * 0.10;
          	}
          	else if (income <= 46700) {							// Rate 15% next level
          		tax = 12000 * 0.10 + (income - 12000) * 0.15;
          	}
          	else if (income <= 112850) {						// Rate 27% next level
          		tax = 12000 * 0.10 + (46700 - 12000) * 0.15 + (income - 46700) * 0.27;
          	}
          	else if (income <= 171950) {                        // Rate 30% next level
          		tax = 12000 * 0.10 + (46700 - 12000) * 0.15 + (112850-46700) * 0.27 + (income-112850) * 0.30;
          	}
          	else if (income <= 307050) {						//Rate of 35%
          		tax = 12000 * 0.10 + (46700 - 12000) * 0.15 + (112850 - 46700) * 0.27 + (171950-112850) *0.30 +
          		(income - 171950) * 0.35;
          	}
          	else {
          		tax = 12000 * 0.10 + (46700 - 12000) * 0.15 + 

          		(112850 - 46700) * 0.27 + (171950 - 112851) * 0.30 +
          		
          		(307050 - 171951) * 0.35 + (income - 307051) * 0.386;
          	}
        }
	    else if (status == 2) {
          	if (income <= 6000) {                              // up to 6000 Rate 10%
          		tax = income * 0.10;
          	}
          	else if (income <= 23350) {							// up to 23350 Rate 15% 
          		tax = 6000 * 0.10 + (income - 6000) * 0.15;
          	}
          	else if (income <= 56426) {						    // Rate 27% next level
          		tax = 6000 * 0.10 + (23350 - 6000) * 0.15 + (income - 23350) * 0.27;
          	}
          	else if (income <= 85975) {                        // Rate 30% next level
          		tax = 6000 * 0.10 + (23350 - 6000) * 0.15 + (56425 - 23350) * 0.27 + (income-56425) * 0.30;
          	}
          	else if (income <= 153525) {						// Rate of 35%
          		tax = 6000 * 0.10 + (23350 - 6000) * 0.15 + (56425 - 23350) * 0.27 + (85975 - 56425) * 0.30 +
          		(income - 85976) * 0.35;
          	}
          	else {
          	    tax = 6000 * 0.10 + (23350 - 6000) * 0.15 + 

          	    (56425 - 23350) * 0.27 + (85975 - 56425) * 0.30 +

          		(153525 - 85976) * 0.35 + (income - 153526) * 0.386;
          	}
          }
          else if (status == 3) {
          	if (income <= 10000) {                              // up to 10000 Rate 10%
          		tax = income * 0.10;
          	}
          	else if (income <= 23350) {							// up to 37450 Rate 15% 
          		tax = 6000 * 0.10 + (income - 6000) * 0.15;
          	}
          	else if (income <= 56426) {						    // up to 96700 Rate 27% next level
          		tax = 6000 * 0.10 + (23350 - 6000) * 0.15 + (income - 23350) * 0.27;
          	}
          	else if (income <= 85975) {                        // Rate 30% next level
          		tax = 6000 * 0.10 + (23350 - 6000) * 0.15 + (56425 - 23350) * 0.27 + (income-56425) * 0.30;
          	}
          	else if (income <= 153525) {						// Rate of 35%
          		tax = 6000 * 0.10 + (23350 - 6000) * 0.15 + (56425 - 23350) * 0.27 + (85975 - 56425) * 0.30 +
          		(income - 85976) * 0.35;
          	}
          	else {
          	    tax = 6000 * 0.10 + (23350 - 6000) * 0.15 + 

          	    (56425 - 23350) * 0.27 + (85975 - 56425) * 0.30 +
          	    
          		(153525 - 85976) * 0.35 + (income - 153526) * 0.386;
          	}
          }
          else {
          	System.out.println("Error: invalud status");
          	System.exit(0);
          }

          // Display the result
          System.out.println("Tax is " + (int)(tax * 100) / 100.0);
      }

  }
		
	
