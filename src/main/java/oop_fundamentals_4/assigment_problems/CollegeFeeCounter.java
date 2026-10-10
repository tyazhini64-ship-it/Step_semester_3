import java.util.Scanner;

interface BusUser {
    double getTransportFee();
}

abstract class Student {
    protected String name;
    
    public Student(String name) {
        this.name = name;
    }
    
    public abstract double calculateTuition();
    
    public double calculateTotal() {
        double total = calculateTuition();
        if (this instanceof BusUser) {
            total += ((BusUser) this).getTransportFee();
        }
        return total;
    }
}

class DayScholar extends Student implements BusUser {
    public DayScholar(String name) { super(name); }
    public double calculateTuition() { return 40000.0; }
    public double getTransportFee() { return 12000.0; }
}

class Hosteller extends Student {
    public Hosteller(String name) { super(name); }
    public double calculateTuition() { return 40000.0 + 60000.0; }
}

class Scholar extends Student implements BusUser {
    public Scholar(String name) { super(name); }
    public double calculateTuition() { return 20000.0; }
    public double getTransportFee() { return 12000.0; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double totalCollected = 0.0;
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            
            Student student = null;
            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else if (type.equals("SCHOLAR")) {
                student = new Scholar(name);
            }
            
            if (student != null) {
                double fee = student.calculateTotal();
                totalCollected += fee;
                System.out.printf("%s: %.2f\n", name, fee);
            }
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
        scanner.close();
    }
}