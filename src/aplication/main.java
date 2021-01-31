package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Reservation;

public class main {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat stf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.println("Room number:");
		int roomNumber = sc.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy):");
		Date checkIn = stf.parse(sc.next());
		System.out.println("Check-ou date (dd/MM/yyyy):");
		Date checkOut = stf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in Reservation: Check out date must be after check in date");

		} else {
			Reservation rs = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation" + rs);
			System.out.println("Enter data to update the reservation:");
			System.out.println("Check-in date (dd/MM/yyyy):");
			checkIn = stf.parse(sc.next());
			System.out.println("Check-ou date (dd/MM/yyyy):");
			checkIn = stf.parse(sc.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in Reservation: dates  for updates must be future dates");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in Reservation: Check out date must be after check in date");

			} else {
				rs.updateDate(checkIn, checkOut);
				System.out.println("Reservation:" + rs);

			}
		}
		sc.close();

		System.out.println("End Progam");
	}

	public static void exception() {
		Scanner sc = new Scanner(System.in);

		try {
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt();
			System.out.println(vect[position]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid Position");

		} catch (InputMismatchException e) {
			System.out.println("Input error");
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

		sc.close();

	}
}
