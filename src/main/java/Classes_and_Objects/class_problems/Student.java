

import java.util.ArrayList;
import java.util.Scanner;


public class Student {
    String name;
    double attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;


    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }


    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();


        System.out.println("Enter number of students to create:");
        int n = scanner.nextInt();
        scanner.nextLine();


        for (int i = 0; i < n; i++) {
            System.out.println("Enter student name:");
            String name = scanner.nextLine();
            System.out.println("Enter attendance percentage:");
            double attendance = scanner.nextDouble();
            scanner.nextLine();
            students.add(new Student(name, attendance));
        }


        System.out.println(n + " Student objects created");
        Student.printCollegeInfo();
        scanner.close();
    }
}

