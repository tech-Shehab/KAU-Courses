package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------- Welcome to Bank Al-Badr ---------\n");
        System.out.print("Please enter your current balance (in SAR) : ");
        double customerBalance = scanner.nextDouble();
        System.out.print("Please enter the amount to withdraw (in SAR): ");
        double customerWithdraw = scanner.nextDouble();

        double serviceFee = 0;
        if(customerWithdraw > 2500)
            serviceFee = 0.0305;
        else
            serviceFee = 0.0245;

        int fiveHundreds = (int) customerWithdraw / 500;
        int oneHundreds = (int) (customerWithdraw % 500) / 100;
        int fifties = (int) ((customerWithdraw % 500) % 100) / 50;
        int tens = (int) (((customerWithdraw % 500) % 100) % 50) / 10;
        int fives = (int) ((((customerWithdraw % 500) % 100) % 50) % 10) / 5;
        int ones = (int) (((((customerWithdraw % 500) % 100) % 50) % 10) % 5) / 1;
        int notes = (fiveHundreds+oneHundreds+fifties+fives+tens+ones);




        if (customerWithdraw>5000) {
            System.out.println("Sorry, amount exceeds maximum daily limit!");
            return;
        }

        else if((1+serviceFee)*customerWithdraw>customerBalance) {
            System.out.println("Sorry, insufficient funds!");
            return;
        }
        else if (notes>20)
        {
            System.out.println("Sorry, number of notes exceeds 20!");
        }
        else{
            System.out.printf("Transaction successful. Your new balance is %.2f SAR \n",(customerBalance - (customerWithdraw+customerWithdraw*serviceFee)) );
            System.out.println("\n--------------------------------------------------\n" +
                    "\t\t\t\tDetails of notes dispensed\n" +
                    "\t\t\t\t500 x " + fiveHundreds + " = "+(fiveHundreds*500)+"\n" +
                    "\t\t\t\t100 x "+oneHundreds+" = "+(oneHundreds*100)+"\n" +
                    "\t\t\t\t50 x "+fifties+" = "+(fifties*50)+"\n" +
                    "\t\t\t\t10 x "+tens+" = "+(tens*10)+"\n" +
                    "\t\t\t\t5 x "+fives+" = "+(fives*5)+"\n" +
                    "\t\t\t\t1 x "+ones+" = "+(ones)+"\n" +
                    "\t\t\t\t\t\t____\n" +
                    "Total amount (in SAR) " + (int)customerWithdraw);
        }

    }
}
