import java.util.ArrayList;
import java.util.Scanner;


class Employee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;


    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }


    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}


public class EmployeeCompany {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();


        System.out.println("Enter number of employees to create:");
        int n = scanner.nextInt();
        scanner.nextLine();


        for (int i = 0; i < n; i++) {
            System.out.println("Enter employee name:");
            String name = scanner.nextLine();
            System.out.println("Enter salary:");
            double salary = scanner.nextDouble();
            scanner.nextLine();
            employees.add(new Employee(name, salary));
        }


        System.out.println(n + " Employee objects created");
        Employee.printCompanyInfo();
        scanner.close();
    }
}

