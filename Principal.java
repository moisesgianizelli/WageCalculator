import java.util.Scanner;

public class Principal implements Role {

	private final double BASIC_SALARY = 5000.0;
	private Scanner scanner;

	private int teachers;

	private double additional_salary;
	private double salary;
	
	

	public double getSalary() {
		scanner = new Scanner(System.in);
		salary = BASIC_SALARY + getAdditionalPayment();
		return salary;
	}

	public void printCalculation() {
		System.out.println("# Principal #");
		System.out.println("    Basic salary: " + BASIC_SALARY);
		System.out.println("(+) Additional payment (" + teachers + " teachers): " + additional_salary);
	}

	private double getAdditionalPayment() {
		System.out.println("Number of teachers: ");
		teachers = scanner.nextInt();

		additional_salary = getTeachersAdditionalPayment(teachers);

		return additional_salary;
	}

	private double getTeachersAdditionalPayment(int number_of_teachers) {
		if(number_of_teachers >= 0 && number_of_teachers <= 9) return 775.83;
		if(number_of_teachers >= 10 && number_of_teachers <= 99) return 869.33;
		if(number_of_teachers >= 100 && number_of_teachers <= 199) return 1019.83;
		if(number_of_teachers >= 200) return 1196.67;
		return 0.0;
	}
}