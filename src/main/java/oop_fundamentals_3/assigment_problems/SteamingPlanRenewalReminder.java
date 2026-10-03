import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;
    
    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }
    
    public String getName() {
        return name;
    }
    
    public abstract LocalDate calculateRenewalDate();
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }
    
    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }
    
    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }
    
    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class SteamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<SubscriptionPlan> plans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();
            LocalDate startDate = LocalDate.parse(dateStr);
            
            if (type.equals("BASIC")) {
                plans.add(new BasicPlan(name, startDate));
            } else if (type.equals("STANDARD")) {
                plans.add(new StandardPlan(name, startDate));
            } else if (type.equals("PREMIUM")) {
                plans.add(new PremiumPlan(name, startDate));
            }
        }
        
        for (SubscriptionPlan plan : plans) {
            LocalDate renewalDate = plan.calculateRenewalDate();
            System.out.println(plan.getName() + ": " + renewalDate);
        }
        
        scanner.close();
    }
}