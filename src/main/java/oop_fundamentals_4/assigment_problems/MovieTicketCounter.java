import java.util.Scanner;

abstract class Seat {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.0;
    
    public Seat(int count) {
        this.count = count;
    }
    
    public abstract double getBasePrice();
    
    public double calculateTotal() {
        return (getBasePrice() + CONVENIENCE_FEE) * count;
    }
}

class RegularSeat extends Seat {
    public RegularSeat(int count) { super(count); }
    public double getBasePrice() { return 150.0; }
}

class PremiumSeat extends Seat {
    public PremiumSeat(int count) { super(count); }
    public double getBasePrice() { return 250.0; }
}

class ReclinerSeat extends Seat {
    public ReclinerSeat(int count) { super(count); }
    public double getBasePrice() { return 400.0; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double total = 0.0;
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int count = scanner.nextInt();
            Seat seat = null;
            if (type.equals("REGULAR")) {
                seat = new RegularSeat(count);
            } else if (type.equals("PREMIUM")) {
                seat = new PremiumSeat(count);
            } else if (type.equals("RECLINER")) {
                seat = new ReclinerSeat(count);
            }
            if (seat != null) {
                double amt = seat.calculateTotal();
                total += amt;
                System.out.printf("%s: %.2f\n", type, amt);
            }
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}