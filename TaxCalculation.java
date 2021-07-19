/*
* @author Moises Gianizelli 
* Date started: 10/04/21
* Last Update: 23/04/21
*
* 3nd Skills Demo
*
*
*

*
** the program consists of calculating rates from three different segments.
*
*/


import java.util.Scanner;
import java.util.regex.Pattern;

public class TaxCalculation {

	private static final double TAX = 0.22;
	private static final double ADDITIONAL_TAX = 0.42;
	private static final double PRSI = 0.04;
	private static Scanner scanner;

	public static void main(String[] args) {
	while(true) {
		scanner = new Scanner(System.in);
		String pps_number = getPPSNumber();
		Role role = getRole();
		double gross_salary = role.getSalary();
		double tax = calculateTax(gross_salary);
		double prsi = calculatePRSI(gross_salary);

	
		System.out.println("# PPS Number: " + pps_number + " #");
		role.printCalculation();
		System.out.println("(=) Gross Salary: " + String.format("%.2f", gross_salary));
		System.out.println("Tax: " + String.format("%.2f", tax));
		System.out.println("PRSI: " + String.format("%.2f", prsi));
		System.out.println("Net Salary: " + String.format("%.2f", gross_salary - tax - prsi));
		
		System.out.println("0 - Finish | 1 - Use again");
		int next_action = scanner.nextInt();
	
		if(next_action == 0) {
			return;
		}
	
	}	
	
	}
	// set the while 
	private static String getPPSNumber() {
		while(true) {
			System.out.println("Enter the PPS number: ");

			String pps_number = scanner.nextLine();
			boolean is_valid = Pattern.matches("\\d{7}[A-Z]", pps_number);

			if(is_valid) {
				return pps_number;
			}


			
		System.out.println("The PPS number is not valid (123456A7)");
		
		}


		
			
}

	// show the options
	private static Role getRole() {
		System.out.println("Enter the role: ");
		System.out.println("1 - Full-time teacher || 2 - Part-time teacher || 3 - Principal");

		return switch (scanner.nextInt()) {
			case 1 -> new FullTimeTeacher();
			case 2 -> new PartTimeTeacher();
			case 3 -> new Principal();
			default -> null;
		};
	}
	// tax calculation for the three role
	private static double calculateTax(double salary) {
		double tax_to_pay = salary * TAX;

		if(salary > 40000) {
			tax_to_pay += (salary - 40000) * ADDITIONAL_TAX;
		}

		return tax_to_pay;
	}

	private static double calculatePRSI(double salary) {
		return salary * PRSI;
	
	
	}
	

	

}
