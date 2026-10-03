import java.util.Scanner;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double calculateAdjustedAmount();
}

class CardPayment extends Payment {
    public CardPayment(double amount) { super(amount); }
    @Override
    public double calculateAdjustedAmount() { return amount * 1.02; }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) { super(amount); }
    @Override
    public double calculateAdjustedAmount() { return amount * 1.01; }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) { super(amount); }
    @Override
    public double calculateAdjustedAmount() { return amount * 1.00; }
}

public class PaymentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String ptype = scanner.next();
            double amount = scanner.nextDouble();
            Payment payment;

            if (ptype.equals("CARD")) {
                payment = new CardPayment(amount);
            } else if (ptype.equals("WALLET")) {
                payment = new WalletPayment(amount);
            } else {
                payment = new BankTransferPayment(amount);
            }

            double adjusted = payment.calculateAdjustedAmount();
            total += adjusted;
            System.out.printf("%s: %.2f\n", ptype, adjusted);
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}