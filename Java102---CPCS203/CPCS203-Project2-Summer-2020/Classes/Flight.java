package com.CodeWithShehab;

public class Flight {
    private String flightCode;
    private String cityForm;
    private String cityTo;
    private int TotalSeat;
    private int remainingSeats;
    private double Price;
    private static int indexFlight;



    public Flight(String flightCode, String cityForm,
                  String cityTo, int totalSeat,
                  int remainingSeats, double price) {
        this.flightCode = flightCode;
        this.cityForm = cityForm;
        this.cityTo = cityTo;
        TotalSeat = totalSeat;
        this.remainingSeats = remainingSeats;
        Price = price;
    }

    public Flight() {
    }

    public static int getIndexFlight() {
        return indexFlight;
    }

    public static void setIndexFlight(int indexFlight) {
        Flight.indexFlight = indexFlight;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getCityForm() {
        return cityForm;
    }

    public void setCityForm(String cityForm) {
        this.cityForm = cityForm;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public int getTotalSeat() {
        return TotalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        TotalSeat = totalSeat;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }

    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
