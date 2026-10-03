import java.util.Scanner;

abstract class TransportJourney {
    protected double distance;

    public TransportJourney(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
}

class BusJourney extends TransportJourney {
    public BusJourney(double distance) { super(distance); }
    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(10.0, fare);
    }
}

class TrainJourney extends TransportJourney {
    public TrainJourney(double distance) { super(distance); }
    @Override
    public double calculateFare() { return 3.0 + (0.15 * distance); }
}

class MetroJourney extends TransportJourney {
    private double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        double baseFare = 1.50 + (0.20 * distance);
        return baseFare * peakHourFactor;
    }
}

public class TransportApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        
        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String transportType = scanner.next();
            double distance = scanner.nextDouble();
            TransportJourney journey = null;

            if (transportType.equals("BUS")) {
                journey = new BusJourney(distance);
            } else if (transportType.equals("TRAIN")) {
                journey = new TrainJourney(distance);
            } else if (transportType.equals("METRO")) {
                double peakHourFactor = scanner.nextDouble();
                journey = new MetroJourney(distance, peakHourFactor);
            }

            if (journey != null) {
                double fare = journey.calculateFare();
                grandTotal += fare;
                System.out.printf("%s: %.2f\n", transportType, fare);
            }
        }
        
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}