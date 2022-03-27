package com.CodeWithShehab;

/**
 * This assignment wasn't clear so,s I did my best to get the same result as much as possible */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static File inFile;
    public static File outFile;
    public static Scanner scanner;
    public static PrintWriter writer;
    public static Flight[] flights;
    public static Passenger[] passengers;
    public static Reservation[] reservations;

    public static int totalFlights, totalPassengers, bookingRequests;
    public static int currentFlights, currentPassengers, currentBookingRequests;
    public static int indexOfReservationPRNumber;

    public static void main(String[] args) throws FileNotFoundException {
        // Initializing input and output file objects
        inFile = new File("input.txt");
        outFile = new File("output.txt");
        // Initializing the scanner to read form the input file
        scanner = new Scanner(inFile);
        if (!inFile.exists()) {
            System.out.println("File Not Found!");
            return;
        }
        // Initializing print writer object and set it the auto flush on
        writer = new PrintWriter(new PrintWriter(outFile), true);
        // reading the first 3 numbers and set it based on their meanings
        totalFlights = scanner.nextInt();
        totalPassengers = scanner.nextInt();
        bookingRequests = scanner.nextInt();
        // Initializing the most important arrays through the project
        flights = new Flight[totalFlights];
        passengers = new Passenger[totalPassengers];
        reservations = new Reservation[bookingRequests];
        // Welcome message
        writer.println("###########################################\n" +
                "***** Welcome to Flight Reservation System *****\n" +
                "###########################################");
        // Skipping the line stored in the buffer
        scanner.nextLine();
        // Using hasNextLine() method helps reading the whole file without waiting for "Quit"
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            switch (split[0]) {
                case "Add_Flight":
                    inputFlight(line);
                    break;
                case "Add_Passenger":
                    inputPassenger(line);
                    break;
                case "Make_Booking":
                    BookingFlight(line);
                    break;
                case "Search_Print":
                    flightStatus(line);
                    break;
                case "Flight_Status":
                    bookingDetails(line);
                    break;
            }
        }
        // Goodbye message
        writer.println("Thank you for using the flight booking System, Good Bye!\n" +
                "\n" +
                "#####################################");
    }

    public static void inputFlight(String line) {
        /**
         * This method will be used to read the flight details from the input file and add the flight
         * details to the system. System only allows limited flight entry [see sample output file]
         */
        String[] split = line.split(" ");
        if (totalFlights > currentFlights) {
            flights[currentFlights] = new Flight(split[1],
                    split[2], split[3], Integer.parseInt(split[4])
                    , totalPassengers, Double.parseDouble(split[6]));
            writer.println("Flight " + flights[currentFlights].getFlightCode() + " Successfully Added \n" +
                    "###########################################");
            currentFlights++;
        } else {
            writer.println("Flight " + split[1] + " Was not Added\n" +
                    " You exceed the maximum number of Flights\n" +
                    "###########################################");
        }
    }

    public static void inputPassenger(String line) {
        /**
         * This method will be used to read the passenger details from the file and enter passenger
         * details to the system. System only allows limited passenger entry [see sample output file]
         */
        String[] split = line.split(" ");
        if (totalPassengers > currentPassengers) {
            passengers[currentPassengers++] = new Passenger(split[1], Integer.parseInt(split[2]), (char) split[3].indexOf(0), split[4]);
            writer.println("Passenger " + split[1] + " Successfully Added \n" +
                    "###########################################");
        } else {
            writer.println("^^^^ You exceeded the number of booking for passengers  ^^^^\n");
        }
    }

    public static void BookingFlight(String line) {
        /**
         * This method will make booking based on the details from the file. System only allows
         * limited booking entry [see sample output file]
         */
        if (bookingRequests > currentBookingRequests) {
            String[] split = line.split(" ");
            reservations[currentBookingRequests] = new Reservation(split[1], new Date(), Integer.parseInt(split[2]));
            Flight flight = null;
            Passenger passenger = null;
            int counter1 = 3;

            for (int j = 0; j < Integer.parseInt(split[2]); j++) {
                for (int i = 0; i < currentPassengers; i++) {
                    if (passengers[i].getName().equals(split[counter1])) {
                        passenger = passengers[i];
                        break;
                    }
                }

                reservations[currentBookingRequests].setPassengers(passenger, j);

                for (int i = 0; i < currentFlights; i++) {
                    if (flights[i].getFlightCode().equals(split[1])) {
                        flight = flights[i];
                        break;
                    }
                }

                reservations[currentBookingRequests].setFlight(flight);
                counter1++;
            }

            flight.setRemainingSeats(flight.getRemainingSeats() - Integer.parseInt(split[2]));
            currentBookingRequests++;
            writer.println(split[1] + " Booked successfully for " + Integer.valueOf(split[2]) + " passengers, PRN " + getPRNumber() + "\n" +
                    "###########################################");
            reservations[currentBookingRequests - 1].setPRNumber(getPRNumber());
            indexOfReservationPRNumber++;
        } else {
            writer.println("^^^^ You exceeded the number of booking requests ^^^^\n");
        }
    }

    public static void flightStatus(String line) {
        /**
         * This method will search and print the details of a flight given its flight code. The method
         * will also list all the passengers in these flights [see sample output file]
         */
        String[] split = line.split(" ");
        Flight flight = null;

        for (int i = 0; i < currentBookingRequests; i++) {
            if (reservations[i].getPRNumber().equals(split[1])) {
                flight = reservations[i].getFlight();
            }
        }

        if (flight == null) {
            writer.println("\n" +
                    "No Record found with the PNR " + split[1] + "\n" +
                    "\n" +
                    "#####################################");
        } else {
            writer.println("\nRecord found with the PNR " + split[1] + "\n" +
                    "\n" +
                    "#####################################");
            writer.println("Flight " + flight.getFlightCode() + " Information \n" +
                    " from:" + flight.getCityForm() + "\n" +
                    " to: " + flight.getCityTo() + "\n" +
                    " total seats: " + flight.getTotalSeat() + "\n" +
                    " available seats: " + flight.getRemainingSeats() + "\n" +
                    " ticket price: " + flight.getPrice() + "\n" +
                    "###########################################");
        }
    }

    public static void bookingDetails(String line) {
        /**
         * This method will search and display the details of a single booking given its PNR code.
         */
        String[] split = line.split(" ");
        Flight flight = null;

        for (int i = 0; i < currentFlights; i++) {
            if (split[1].equals(flights[i].getFlightCode())) {
                flight = flights[i];
                break;
            }
        }

        if (flight == null) {
            writer.println("\n" +
                    "No Record found with the Flight Code " + split[1] + "\n" +
                    "\n" +
                    "#####################################");
        } else {
            Reservation reservation = null;
            for (int i = 0; i < currentBookingRequests; i++) {
                if (reservations[i].getFlight().equals(flight)) {
                    reservation = reservations[i];
                    break;
                }
            }

            writer.println("\n" +
                    "Record found with the Flight Code " + flight.getFlightCode() + "\n" +
                    "\n" +
                    "#####################################\n" +
                    "Flight " + flight.getFlightCode() + " Information \n" +
                    " from:" + flight.getCityForm() + "\n" +
                    " to: " + flight.getCityTo() + "\n" +
                    " total seats: " + flight.getTotalSeat() + "\n" +
                    " available seats: " + flight.getRemainingSeats() + "\n" +
                    " ticket price: " + flight.getPrice() + "\n" +
                    "Passengers information:\n" +
                    "\n" +
                    "--- Passenger Details --- ");

            for (int i = 0; i < reservation.getPassengers().length; i++) {
                writer.println(reservation.getPassengers()[i].getName());
            }

            writer.println("\n" +
                    "\n" +
                    "#####################################");
        }
    }

    public static String getPRNumber() {
        return ("JED10" + indexOfReservationPRNumber);
    }

}
