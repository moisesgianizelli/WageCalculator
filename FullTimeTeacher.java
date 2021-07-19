import java.util.Scanner;

public class FullTimeTeacher implements Role {

	
	private final double BASIC_SALARY = 3343.58;
	private final double PAYMENT_PER_SCRIPT = 10.18;
	private final double DEDUCTION_PER_ABSENT_DAY = 62.68;
	private Scanner scanner;

	private int additional_points;
	private int scripts_correct;
	private int days_absent;

	private double additional_salary;
	private double scripts_payment;
	private double absent_deduction;
	private double salary;

	public double getSalary() {
		scanner = new Scanner(System.in);

		salary = BASIC_SALARY
				+ getAdditionalSalary()
				+ getScriptsPayment()
				- getDaysAbsentDeduction();

		return salary;
	}

	public void printCalculation() {
		System.out.println("# Full-time teacher #");
		System.out.println("    Basic salary: " + BASIC_SALARY);
		System.out.println("(+) Additional salary (" + additional_points + " points): " + additional_salary);
		System.out.println("(+) Scripts payment: " + scripts_correct + " * " + PAYMENT_PER_SCRIPT + " = " + scripts_payment);
		System.out.println("(-) Absent days: " + days_absent + " * " + DEDUCTION_PER_ABSENT_DAY + " = " + absent_deduction);
	}

	private double getAdditionalSalary() {
		System.out.println("Additional income points: ");
		additional_points = scanner.nextInt();

		additional_salary = switch (additional_points) {
			case 1 -> 426.67;
			case 2 -> 565.75;
			case 3 -> 666.58;
			case 4 -> 750;
			default -> 0.0;
		};

		return additional_salary;
	}

	private double getScriptsPayment() {
		System.out.println("Scripts corrected: ");
		scripts_correct = scanner.nextInt();

		scripts_payment = scripts_correct * PAYMENT_PER_SCRIPT;

		return scripts_payment;
	}

	private double getDaysAbsentDeduction() {
		System.out.println("Days missed: ");
		days_absent = scanner.nextInt();

		absent_deduction = days_absent * DEDUCTION_PER_ABSENT_DAY;

		return absent_deduction;
	}
}