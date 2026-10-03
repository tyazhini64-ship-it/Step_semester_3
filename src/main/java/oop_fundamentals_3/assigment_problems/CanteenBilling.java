import java.util.*;

abstract class CustomerBill {
    protected double amount;
    protected String typeName;
    
    public CustomerBill(String typeName, double amount) {
        this.typeName = typeName;
        this.amount = amount;
    }
    
    public String getTypeName() {
        return typeName;
    }
    
    public abstract double calculateFinalAmount();
}

class StudentBill extends CustomerBill {
    public StudentBill(double amount) {
        super("STUDENT", amount);
    }
    
    @Override
    public double calculateFinalAmount() {
        return amount * 0.9;
    }
}

class StaffBill extends CustomerBill {
    public StaffBill(double amount) {
        super("STAFF", amount);
    }
    
    @Override
    public double calculateFinalAmount() {
        return amount * 0.95;
    }
}

class GuestBill extends CustomerBill {
    public GuestBill(double amount) {
        super("GUEST", amount);
    }
    
    @Override
    public double calculateFinalAmount() {
        return amount + 10.0;
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<CustomerBill> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            
            if (type.equals("STUDENT")) {
                bills.add(new StudentBill(amount));
            } else if (type.equals("STAFF")) {
                bills.add(new StaffBill(amount));
            } else if (type.equals("GUEST")) {
                bills.add(new GuestBill(amount));
            }
        }
        
        double grandTotal = 0.0;
        for (CustomerBill bill : bills) {
            double finalAmount = bill.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f\n", bill.getTypeName(), finalAmount);
        }
        
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}