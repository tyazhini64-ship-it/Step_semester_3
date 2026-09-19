

import java.util.ArrayList;
import java.util.Scanner;


public class HallTicket {
    String studentName;
    int seatNumber;


    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<HallTicket> tickets = new ArrayList<>();


        System.out.println("Enter student name and initial seat number for Priya:");
        String name = scanner.nextLine();
        int seat = scanner.nextInt();
        scanner.nextLine();


        HallTicket priya = new HallTicket(name, seat);
        tickets.add(priya);


        HallTicket copy = priya;
        System.out.println("Enter updated seat number for copy modification:");
        copy.seatNumber = scanner.nextInt();
        scanner.nextLine();


        System.out.println("Enter name and seat for separate ticket:");
        String sepName = scanner.nextLine();
        int sepSeat = scanner.nextInt();
        scanner.nextLine();


        HallTicket separate = new HallTicket(sepName, sepSeat);
        tickets.add(separate);


        System.out.println("Priya's seatNumber (via first variable):\n" + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
        scanner.close();
    }
}



