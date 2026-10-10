import java.util.Scanner;

abstract class Plot {
    protected String owner;
    public Plot(String owner) {
        this.owner = owner;
    }
    public abstract double calculateArea();
    public abstract String getShapeName();
}

class CirclePlot extends Plot {
    private double radius;
    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    public String getShapeName() {
        return "CIRCLE";
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;
    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }
    public double calculateArea() {
        return length * width;
    }
    public String getShapeName() {
        return "RECTANGLE";
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;
    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }
    public double calculateArea() {
        return 0.5 * base * height;
    }
    public String getShapeName() {
        return "TRIANGLE";
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double totalArea = 0.0;

        for (int i = 0; i < n; i++) {
            String shapeType = scanner.next();
            String owner = scanner.next();
            Plot plot = null;
            if (shapeType.equals("CIRCLE")) {
                double radius = scanner.nextDouble();
                plot = new CirclePlot(owner, radius);
            } else if (shapeType.equals("RECTANGLE")) {
                double length = scanner.nextDouble();
                double width = scanner.nextDouble();
                plot = new RectanglePlot(owner, length, width);
            } else if (shapeType.equals("TRIANGLE")) {
                double base = scanner.nextDouble();
                double height = scanner.nextDouble();
                plot = new TrianglePlot(owner, base, height);
            }

            if (plot != null) {
                double area = plot.calculateArea();
                totalArea += area;
                System.out.printf("%s (%s): %.2f\n", plot.owner, plot.getShapeName(), area);
            }
        }
        System.out.printf("Total Area: %.2f\n", totalArea);
        scanner.close();
    }
}