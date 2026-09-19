import java.util.ArrayList;
import java.util.Scanner;


public class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;


    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }


    public void printRecord() {
        System.out.println(this.studentName + " -> " + this.company + " @ " + this.packageLpa + " LPA");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<PlacementRecord> records = new ArrayList<>();


        System.out.println("Enter number of placement records:");
        int n = scanner.nextInt();
        scanner.nextLine();


        for (int i = 0; i < n; i++) {
            System.out.println("Enter student name, company, and package (LPA):");
            String name = scanner.nextLine();
            String comp = scanner.nextLine();
            double pkg = scanner.nextDouble();
            scanner.nextLine();
            records.add(new PlacementRecord(name, comp, pkg));
        }


        for (PlacementRecord record : records) {
            record.printRecord();
        }
        scanner.close();
    }
}

