package com.CodeWithShehab;

public class Passenger {
    private String name;
    private int age;
    private char gender;
    private String phone;
    private static int indexPassenger;

    public Passenger(String name, int age, char gender, String phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    public Passenger() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static int getIndexPassenger() {
        return indexPassenger;
    }

    public static void setIndexPassenger(int indexPassenger) {
        Passenger.indexPassenger = indexPassenger;
    }
}
