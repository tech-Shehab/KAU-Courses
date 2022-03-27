package com.CodeWithShehab;

import java.util.Date;

public class Reservation {
    private String PNRNumber;
    private Date date;
    private Flight flight;
    private Passenger[] passengers;
    private static int reservationIndex;

    private String PRNumber;

    public void setPassengers(Passenger[] passengers) {
        this.passengers = passengers;
    }

    public String getPRNumber() {
        return PRNumber;
    }

    public void setPRNumber(String PRNumber) {
        this.PRNumber = PRNumber;
    }

    public Reservation(String PNRNumber, Date date, int totalPassengers) {
        this.PNRNumber = PNRNumber;
        this.date = date;
        passengers = new Passenger[totalPassengers];
    }

    public String getPNRNumber() {
        return PNRNumber;
    }

    public void setPNRNumber(String PNRNumber) {
        this.PNRNumber = PNRNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger passenger, int index) {
        passengers[index] = passenger;
    }

    public static int getReservationIndex() {
        return reservationIndex;
    }

    public static void setReservationIndex(int reservationIndex) {
        Reservation.reservationIndex = reservationIndex;
    }
}
