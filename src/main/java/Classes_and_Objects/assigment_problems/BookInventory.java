import java.util.ArrayList;
import java.util.Scanner;


public class BookInventory {
    String title;
    String author;
    int copiesAvailable;


    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }


    public void printEntry() {
        System.out.println(this.title + " by " + this.author + " - " + this.copiesAvailable + " copies available");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BookInventory> books = new ArrayList<>();


        System.out.println("Enter number of books:");
        int n = scanner.nextInt();
        scanner.nextLine();


        for (int i = 0; i < n; i++) {
            System.out.println("Enter title, author, and copies available:");
            String title = scanner.nextLine();
            String author = scanner.nextLine();
            int copies = scanner.nextInt();
            scanner.nextLine();
            books.add(new BookInventory(title, author, copies));
        }


        for (BookInventory book : books) {
            book.printEntry();
        }
        scanner.close();
    }
}


