import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Vehicle {
    protected int hours;
    protected String vehicleType;
    
    public Vehicle(String vehicleType, int hours) {
        this.vehicleType = vehicleType;
        this.hours = hours;
    }
    
    public String getVehicleType() {
        return vehicleType;
    }
    
    public abstract double calculateCharge();
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super("BIKE", hours);
    }
    
    @Override
    public double calculateCharge() {
        return hours * 10.0;
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super("CAR", hours);
    }
    
    @Override
    public double calculateCharge() {
        if (hours <= 1) {
            return 30.0;
        }
        return 30.0 + (hours - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super("TRUCK", hours);
    }
    
    @Override
    public double calculateCharge() {
        return Math.max(100.0, hours * 50.0);
    }
}

public class CampusParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            
            if (type.equals("BIKE")) {
                vehicles.add(new Bike(hours));
            } else if (type.equals("CAR")) {
                vehicles.add(new Car(hours));
            } else if (type.equals("TRUCK")) {
                vehicles.add(new Truck(hours));
            }
        }
        
        double grandTotal = 0.0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            grandTotal += charge;
            System.out.printf("%s: %.2f\n", v.getVehicleType(), charge);
        }
        
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}