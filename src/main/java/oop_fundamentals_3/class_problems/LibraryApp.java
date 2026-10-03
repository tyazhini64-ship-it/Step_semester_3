import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract LocalDate getDueDate(LocalDate currentDate);
    public String getTitle() { return title; }
}

class Book extends LibraryItem {
    public Book(String title) { super(title); }
    @Override
    public LocalDate getDueDate(LocalDate currentDate) { return currentDate.plusDays(14); }
}

class DVD extends LibraryItem {
    public DVD(String title) { super(title); }
    @Override
    public LocalDate getDueDate(LocalDate currentDate) { return currentDate.plusDays(7); }
}

class Magazine extends LibraryItem {
    public Magazine(String title) { super(title); }
    @Override
    public LocalDate getDueDate(LocalDate currentDate) { return currentDate.plusDays(3); }
}

public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            int firstSpace = line.indexOf(' ');
            String itemType = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1).replace("\"", "").trim();

            LibraryItem item;
            if (itemType.equals("BOOK")) {
                item = new Book(title);
            } else if (itemType.equals("DVD")) {
                item = new DVD(title);
            } else {
                item = new Magazine(title);
            }

            LocalDate dueDate = item.getDueDate(currentDate);
            System.out.println(item.getTitle() + ": " + dueDate);
        }
        scanner.close();
    }
}