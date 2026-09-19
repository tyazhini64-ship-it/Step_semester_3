
import java.util.ArrayList;
import java.util.Scanner;


public class MessWallet {
    private double balance;


    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Negative opening balance. Starting at 0.");
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
    }


    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up amount must be greater than 0.");
        } else {
            this.balance += amount;
            System.out.println("Balance after top-up: " + this.balance);
        }
    }


    public void deduct(double amount) {
        if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            this.balance -= amount;
            System.out.println("Balance after deduction: " + this.balance);
        }
    }


    public double getBalance() {
        return this.balance;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<MessWallet> wallets = new ArrayList<>();


        System.out.println("Enter opening balance for wallet:");
        double opening = scanner.nextDouble();
        MessWallet wallet = new MessWallet(opening);
        wallets.add(wallet);


        System.out.println("Enter top-up amount:");
        double topUpAmt = scanner.nextDouble();
        wallet.topUp(topUpAmt);


        System.out.println("Enter amount to deduct:");
        double deductAmt = scanner.nextDouble();
        wallet.deduct(deductAmt);


        System.out.println("Final balance: " + wallet.getBalance());
        scanner.close();
    }
}

