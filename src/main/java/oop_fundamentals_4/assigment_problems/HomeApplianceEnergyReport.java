import java.util.Scanner;

interface SaverModeSupport {
    double applySaver(double units);
}

abstract class Appliance {
    protected double hours;
    protected boolean saverRequested;
    
    public Appliance(double hours, boolean saverRequested) {
        this.hours = hours;
        this.saverRequested = saverRequested;
    }
    
    public abstract double getPowerRating();
    
    public boolean isValid() {
        if (saverRequested && !(this instanceof SaverModeSupport)) {
            return false;
        }
        return true;
    }
    
    public double calculateUnits() {
        double units = (getPowerRating() * hours) / 1000.0;
        if (saverRequested && this instanceof SaverModeSupport) {
            units = ((SaverModeSupport) this).applySaver(units);
        }
        return units;
    }
    
    public double calculateCost() {
        return calculateUnits() * 8.0;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours, boolean saver) { super(hours, saver); }
    public double getPowerRating() { return 150.0; }
}

class AC extends Appliance implements SaverModeSupport {
    public AC(double hours, boolean saver) { super(hours, saver); }
    public double getPowerRating() { return 1500.0; }
    public double applySaver(double units) { return units * 0.75; }
}

class TV extends Appliance {
    public TV(double hours, boolean saver) { super(hours, saver); }
    public double getPowerRating() { return 100.0; }
}

class Washer extends Appliance implements SaverModeSupport {
    public Washer(double hours, boolean saver) { super(hours, saver); }
    public double getPowerRating() { return 500.0; }
    public double applySaver(double units) { return units * 0.75; }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();
        double totalCost = 0.0;
        
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                i--;
                continue;
            }
            String[] parts = line.split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length > 2 && parts[2].equals("SAVER");
            
            Appliance app = null;
            if (type.equals("FRIDGE")) {
                app = new Fridge(hours, saver);
            } else if (type.equals("AC")) {
                app = new AC(hours, saver);
            } else if (type.equals("TV")) {
                app = new TV(hours, saver);
            } else if (type.equals("WASHER")) {
                app = new Washer(hours, saver);
            }
            
            if (app != null) {
                if (!app.isValid()) {
                    System.out.println(type + ": saver mode not supported");
                } else {
                    double units = app.calculateUnits();
                    double cost = app.calculateCost();
                    totalCost += cost;
                    System.out.printf("%s: Units=%.2f Cost=%.2f\n", type, units, cost);
                }
            }
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
        scanner.close();
    }
}