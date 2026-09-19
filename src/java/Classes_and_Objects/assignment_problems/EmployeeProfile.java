import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(this.empId + " | " + this.empName + " | Rs " + this.salary + " | Intern: " + this.isIntern);
    }
}

public class EmployeeProfile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        System.out.println("Enter number of employees:");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter employee type (permanent/intern):");
            String type = scanner.nextLine();
            System.out.println("Enter Employee ID:");
            String id = scanner.nextLine();
            System.out.println("Enter Employee Name:");
            String name = scanner.nextLine();

            if (type.equalsIgnoreCase("permanent")) {
                System.out.println("Enter Salary:");
                double salary = scanner.nextDouble();
                scanner.nextLine();
                employees.add(new Employee(id, name, salary));
            } else {
                employees.add(new Employee(id, name));
            }
        }

        for (Employee emp : employees) {
            emp.printProfile();
        }
        scanner.close();
    }
}