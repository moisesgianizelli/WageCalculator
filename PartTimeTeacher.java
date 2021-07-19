import java.util.Scanner;

public class PartTimeTeacher implements Role {

	private final double PAYMENT_PER_HOUR = 34.03;
	private final double PAYMENT_PER_SCRIPT = 10.18;
	private Scanner scanner;

	private int hours_worked;
	private int scripts_correct;

	private double worked_hours_payment;
	private double scripts_payment;
	private double salary;

	public double getSalary() {
		scanner = new Scanner(System.in);
		salary = getWorkedHoursPayment() + getScriptsPayment();
		return salary;
	}

	public void printCalculation() {
		System.out.println("# Part-time teacher #");
		System.out.println("    Worked hours payment: " + hours_worked + " * " + PAYMENT_PER_HOUR + " = " + worked_hours_payment);
		System.out.println("(+) Scripts payment: " + scripts_correct + " * " + PAYMENT_PER_SCRIPT + " = " + scripts_payment);
	}

	private double getWorkedHoursPayment() {
		System.out.println("Hours worked: ");
		hours_worked = scanner.nextInt();

		worked_hours_payment = hours_worked * PAYMENT_PER_HOUR;

		return worked_hours_payment;
	}

	private double getScriptsPayment() {
		System.out.println("Scripts corrected: ");
		scripts_correct = scanner.nextInt();

		scripts_payment = scripts_correct * PAYMENT_PER_SCRIPT;

		return scripts_payment;
	}
}