package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    /**
     *
     * @param args
     * @throws ParseException : o metodo Main nao vai tratar o ParseException, uma vez que esta declarado
     */
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();
        System.out.print("Check in (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check out (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
        System.out.println("Reservation: " + reservation);

        System.out.println();
        System.out.println("Enter the data to update the reservation: ");
        System.out.println("Check-in (dd/MM/yyyy): ");
        checkIn = sdf.parse(sc.next());
        System.out.println("Check-out (dd/MM/yyyy): ");
        checkOut = sdf.parse(sc.next());

        reservation.updateDates(checkIn, checkOut);
        System.out.println("Reservation: " + reservation);
        sc.close();
    }
}
