package com.company;

import java.util.Scanner;

public class Main {
    public static final int TOTAL_FLOORS = 3;
    public static final int ROOMS_PER_FLOOR = 2;
    public static final int MAX_GUESTS = 6;
    public static boolean roomACStatus[][] = new boolean[TOTAL_FLOORS][ROOMS_PER_FLOOR];
    public static double roomTemperature[][] = new double[TOTAL_FLOORS][ROOMS_PER_FLOOR];
    public static int roomOccupancy[][] = new int[TOTAL_FLOORS][ROOMS_PER_FLOOR];
    // Defined by me
    private static Scanner scanner = new Scanner(System.in);

    // DO NOT EDIT THIS METHOD
    public static void turnAcOn(int floor, int room, boolean status) {
        roomACStatus[floor - 1][room - 1] = status;
        roomTemperature[floor - 1][room - 1] = 0.0;
    }

    // DO NOT EDIT THIS METHOD
    public static boolean getRoomACStatus(int floor, int room) {
        return roomACStatus[floor - 1][room - 1];
    }

    // DO NOT EDIT THIS METHOD
    public static void setRoomTemperature(int floor, int room, double roomTemp) {
        roomTemperature[floor - 1][room - 1] = roomTemp;
    }

    // DO NOT EDIT THIS METHOD
    public static double getRoomTemperature(int floor, int room) {
        return roomTemperature[floor - 1][room - 1];
    }

    // DO NOT EDIT THIS METHOD
    public static void setRoomOccupancy(int floor, int room, int guests) {
        roomOccupancy[floor - 1][room - 1] = guests;
    }

    // DO NOT EDIT THIS METHOD
    public static int getRoomOccupancy(int floor, int room) {
        return roomOccupancy[floor - 1][room - 1];
    }

    // DO NOT EDIT THE MAIN METHOD
    public static void main(String[] args) {
        // Initialize the Jeddah Hotel System
        resetHotel();

        // Display the daily report
        displayReport();

        // Display the main menu
        mainMenu();
    }

    // Methods need to be created

    public static void resetHotel() {
        turnAllACsOff();
        setAllRoomOccupancyToZero();
        System.out.println("START - Resetting Jeddah Palace Hotel system...\n" +
                "\tSetting all room a/c to off...Done!\n" +
                "\tSetting all rooms occupancy to zero...Done!\n" +
                "END - Done resetting Jeddah Palace Hotel System");
    } //done

    public static void displayReport() {
        System.out.println("*** Jeddah Palace Hotel - Daily Report ***\n");
        for (int i = 1; i <= TOTAL_FLOORS; i++) {
            System.out.print("Floor  " + i + " : ");
            for (int j = 1; j <= ROOMS_PER_FLOOR; j++) {
                if (getRoomACStatus(i, j))
                    System.out.print("ON\t");
                else
                    System.out.print("OFF\t");
            }
            System.out.println();
        }
        System.out.println("\nRooms currently occupied : ");
        for (int i = 0; i < TOTAL_FLOORS; i++) {
            System.out.print("Floor  " + (i+1) + " : ");
            for (int j = 0; j < ROOMS_PER_FLOOR; j++) {
                if (isRoomAvailable(i, j))
                    System.out.print("");
                else
                    System.out.print((j+1) + " ");
            }
            System.out.println();
        }
        System.out.println("*** END OF REPORT ***\n\n");
    } //done

    public static void mainMenu() {
        int choice;
        do {
            System.out.print("*** Jeddah Palace Hotel ***\n" +
                    "1. Guest Check in\n" +
                    "2. Guest Check out\n" +
                    "3. Print Report\n" +
                    "Any other number to exit\n" +
                    "Please enter your choice : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkInGuest();
                    break;
                case 2:
                    checkOutGuest();
                    break;
                case 3:
                    displayReport();
                    break;
            }
        } while (choice > 0 && choice < 4);
        System.out.print("Thank you for using the Jeddah Palace Hotel System!!!");
    } // done

    public static void setAllRoomOccupancyToZero() {
        for (int i = 1; i <= TOTAL_FLOORS; i++) {
            for (int j = 1; j <= ROOMS_PER_FLOOR; j++) {
                setRoomOccupancy(i, j, 0);
            }
        }
    } // done

    public static void turnAllACsOff() {
        for (int i = 1; i <= TOTAL_FLOORS; i++) {
            for (int j = 1; j <= ROOMS_PER_FLOOR; j++) {
                turnAcOn(i, j, false);
            }
        }
    } //done

    public static boolean isRoomAvailable(int floor, int room) {
        return (roomOccupancy[floor][room] == 0);
    } // done

    public static int getFreeRoomNumber() {
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= TOTAL_FLOORS; i++) {
            for (int j = 1; j <= ROOMS_PER_FLOOR; j++) {
                if (roomOccupancy[i-1][j-1] == 0) {
                    s.append(i).append(0).append(j);
                    return Integer.parseInt(s.toString());
                }
            }
        }
        return -1;
    } //done

    public static void checkInGuest() {
        System.out.println("\n*** Guest Checkin Menu ***");
        if (getFreeRoomNumber() != -1) {
            System.out.print("Please enter your name : ");
            scanner.nextLine();
            String guestName = scanner.nextLine();
            System.out.print("Please enter your mobile number : ");
            String mobileNumber = scanner.next();
            System.out.print("Please enter number of guests : ");
            int numberOfGuests = scanner.nextInt();
            int roomNumber = getFreeRoomNumber();
            String roomNumberInString = roomNumber + "";
            String roomFloor = roomNumberInString.charAt(0) + "";
            String roomNumberx = roomNumberInString.charAt(2) + "";
            setRoomOccupancy(Integer.parseInt(roomFloor),Integer.parseInt(roomNumberx),numberOfGuests);
            turnAcOn(Integer.parseInt(roomFloor),Integer.parseInt(roomNumberx),true);
            System.out.println("*** Jeddah Palace Hotel ***\n" +
                    "\n" +
                    "Guest Details\n" +
                    "\tName : \t\t\t" + guestName + "\n" +
                    "\tMobile number : \t" + mobileNumber + "\n" +
                    "\tRoom Number: \t\t" + roomNumber + "\n" +
                    "Your room is getting readied for you....Done!\n" +
                    "-- Enjoy your stay with us! --\n");
        } else
            System.out.println("Sorry room not available today!\n");
    } //done

    public static void checkOutGuest() {
        System.out.print("\n" +
                "*** Guest Checkout Menu ***\n" +
                "Please enter room number : ");
        String roomNumber = scanner.next();
        turnAcOn(Integer.parseInt(roomNumber.charAt(0)+""),Integer.parseInt(roomNumber.charAt(2)+""),false);
        setRoomOccupancy(Integer.parseInt(roomNumber.charAt(0)+""),Integer.parseInt(roomNumber.charAt(2)+""),0);
        System.out.println("You have checked out of room : "+roomNumber+"\n" +
                "Thank you for staying with us!\n" +
                "\n");
    }
}
