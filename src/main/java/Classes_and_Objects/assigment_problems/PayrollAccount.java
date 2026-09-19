
import java.util.ArrayList;
import java.util.Scanner;


public class PayrollAccount {
    private double basicSalary;
    private double bonus;
    private ArrayList<String> transactionHistory;


    public PayrollAccount(double basicSalary) {
        this.transactionHistory = new ArrayList<>();
        if (basicSalary < 0) {
            System.out.println("Warning: Negative basic salary. Setting to 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0;
    }


    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus amount must be greater than 0.");
        } else {
            this.bonus += amount;
            transactionHistory.add("Bonus credited: Rs " + amount);
            System.out.println("Bonus credited: Rs " + amount);
        }
    }


    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax percentage must be between 0 and 100.");
        } else {
            this.basicSalary -= this.basicSalary * (percent / 100.0);
            transactionHistory.add("Tax deducted: " + (int) percent + "%");
            System.out.println("Tax deducted: " + (int) percent + "%");
        }
    }


    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter basic salary:");
        double salary = scanner.nextDouble();


        PayrollAccount account = new PayrollAccount(salary);


        System.out.println("Enter bonus amount to credit:");
        double bonusAmt = scanner.nextDouble();
        account.creditBonus(bonusAmt);


        System.out.println("Enter tax percentage to deduct:");
        double taxPct = scanner.nextDouble();
        account.deductTax(taxPct);


        System.out.println("Net salary: Rs " + account.getNetSalary());
        scanner.close();
    }
}







