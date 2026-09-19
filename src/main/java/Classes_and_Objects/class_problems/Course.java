
import java.util.ArrayList;
import java.util.Scanner;


public class Course {
    String code;
    String title;
    int credits;
    int labCredits;


    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }


    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }


    public int totalCredits() {
        return this.credits + this.labCredits;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();


        System.out.println("Enter number of courses:");
        int n = scanner.nextInt();
        scanner.nextLine();


        for (int i = 0; i < n; i++) {
            System.out.println("Enter course type (theory/lab):");
            String type = scanner.nextLine();
            System.out.println("Enter course code:");
            String code = scanner.nextLine();
            System.out.println("Enter course title:");
            String title = scanner.nextLine();
            System.out.println("Enter credits:");
            int credits = scanner.nextInt();
            scanner.nextLine();


            if (type.equalsIgnoreCase("lab")) {
                System.out.println("Enter lab credits:");
                int labCredits = scanner.nextInt();
                scanner.nextLine();
                courses.add(new Course(code, title, credits, labCredits));
            } else {
                courses.add(new Course(code, title, credits));
            }
        }


        for (Course course : courses) {
            System.out.println(course.code + " total credits: " + course.totalCredits());
        }
        scanner.close();
    }
}

