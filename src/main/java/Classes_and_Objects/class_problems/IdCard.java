
import java.util.ArrayList;
import java.util.Scanner;


public class IdCard {
    String name;
    int booksIssued;


    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<IdCard> cards = new ArrayList<>();


        System.out.println("Enter student name and initial books issued:");
        String name = scanner.nextLine();
        int books = scanner.nextInt();
        scanner.nextLine();


        IdCard ravi = new IdCard(name, books);
        cards.add(ravi);


        IdCard duplicate = ravi;
        System.out.println("Enter updated books issued for duplicate reference modification:");
        duplicate.booksIssued = scanner.nextInt();
        scanner.nextLine();


        System.out.println("Enter name and books for separate card:");
        String sepName = scanner.nextLine();
        int sepBooks = scanner.nextInt();
        scanner.nextLine();


        IdCard separate = new IdCard(sepName, sepBooks);
        cards.add(separate);


        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
        scanner.close();
    }
}
