
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Room {
    protected int units;
    protected String roomType;
    
    public Room(String roomType, int units) {
        this.roomType = roomType;
        this.units = units;
    }
    
    public String getRoomType() {
        return roomType;
    }
    
    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super("SINGLE", units);
    }
    
    @Override
    public double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom extends Room {
    private int occupants;
    
    public SharedRoom(int units, int occupants) {
        super("SHARED", units);
        this.occupants = occupants;
    }
    
    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super("AC", units);
    }
    
    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0;
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            
            if (type.equals("SINGLE")) {
                rooms.add(new SingleRoom(units));
            } else if (type.equals("SHARED")) {
                int occupants = scanner.nextInt();
                rooms.add(new SharedRoom(units, occupants));
            } else if (type.equals("AC")) {
                rooms.add(new ACRoom(units));
            }
        }
        
        double grandTotal = 0.0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f\n", r.getRoomType(), bill);
        }
        
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}