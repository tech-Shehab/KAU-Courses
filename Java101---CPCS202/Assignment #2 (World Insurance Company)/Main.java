package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String customerName, customerMobileNumber, insuranceType, description, paymentMethod, mebershipDate, claim;
        int choiceInt, numberOfQuantities, lifeQ = 0, lifeRM = 0, lifeCorC = 0, healthQ = 0, healthRM = 0, healthCorC = 0, carQ = 0, carRM = 0, carCorC = 0;
        double cost;
        String choiceString;
        do {
            System.out.print("\n----------------------------------------------------------------------------------\n" +
                    "-------            Welcome to World Insurance Company      -------\n" +
                    "----------------------------------------------------------------------------------\n" +
                    " | 1 : Information about insurance types                                  | \n" +
                    " | 2 : Be a member of World Insurance Company (Appointment or Pay Bill )  | \n" +
                    " | 3 : Submit customer claim or complaint                                 | \n" +
                    " | 4 : Exit                                                               | \n" +
                    " --------------------------------------------------------------------------------\n" +
                    " > Please enter your choice: ");
            choiceInt = scanner.nextInt();
            if (choiceInt == 1) {
                do {
                    System.out.print("\n" +
                            "     ------- SERVICES -------\n" +
                            "-----------------------------------\n" +
                            " | L or l : Life Insurance           | \n" +
                            " | H or h : Health Insurance         | \n" +
                            " | C or c : Car Insurance            | \n" +
                            " | R or r : Return to Main Menu      | \n" +
                            " --------------------------------- \n" +
                            " > Please enter the choice: ");
                    choiceString = scanner.next();
                    if (choiceString.equalsIgnoreCase("l")) {
                        while (!choiceString.equalsIgnoreCase("p")) {
                            System.out.print("----------- Life Insurance-----------\n" +
                                    "--------------------------------------\n" +
                                    " | S or s:  Saudi Arabia Only        |\n" +
                                    " | G or g:  Gulf Countries           |\n" +
                                    " | W or w:  World Wide               |\n" +
                                    " | P or p:  Previous Menu            |\n" +
                                    " -------------------------------------\n" +
                                    " > Please enter the choice:");
                            choiceString = scanner.next();
                            if (choiceString.equalsIgnoreCase("s")) {
                                lifeQ++;
                                System.out.println("AnnualCost:10000.0\n" +
                                        "MonthlyCost 1000.00 :\n" +
                                        "Needed Number of Days to be settled:10\n");
                            }
                        }
                    }
                    if (choiceString.equalsIgnoreCase("h")) {
                        do {
                            System.out.print("\n---------- Health Insurance -------\n" +
                                    "-------------------------------------\n" +
                                    " | N or n:  New Membership         | \n" +
                                    " | R or r:  Renew Membership       | \n" +
                                    " | P or p:  Previous Menu          | \n" +
                                    " ----------------------------------- \n" +
                                    " > Please enter the choice:");
                            choiceString = scanner.next();
                            if (choiceString.equalsIgnoreCase("n")) {
                                healthQ++;
                                System.out.println("AnnualCost:3000.0\n" +
                                        "MonthlyCost 300.00 :\n" +
                                        "Needed Number of Days to be settled:5");
                            }
                        } while (!choiceString.equalsIgnoreCase("p"));
                    }
                    if (choiceString.equalsIgnoreCase("c")) {
                        do {
                            System.out.print("\n------------- Car Insurance-------------\n" +
                                    "-----------------------------------------\n" +
                                    " | FC: Fully comprehensive            | \n" +
                                    " | TPft: Third-party, fire and theft  | \n" +
                                    " | TP: Third party                    | \n" +
                                    " | PR:  Previous Menu                 | \n" +
                                    " -------------------------------------- \n" +
                                    " > Please enter the choice: ");
                            choiceString = scanner.next();
                            if (choiceString.equalsIgnoreCase("fc")) {
                                carQ++;
                                System.out.println("AnnualCost:4000.0\n" +
                                        "MonthlyCost 400.00 :\n" +
                                        "Needed Number of Days to be settled:1");
                            }
                        } while (!choiceString.equalsIgnoreCase("PR"));
                    }
                } while (!choiceString.equalsIgnoreCase("r"));

            }
            if (choiceInt == 2) {
                do {
                    choiceInt=0;
                    System.out.print("     ------- SERVICES -------\n" +
                            "-----------------------------------\n" +
                            " | L or l : Life Insurance           | \n" +
                            " | H or h : Health Insurance         | \n" +
                            " | C or c : Car Insurance            | \n" +
                            " | R or r : Return to Main Menu      | \n" +
                            " --------------------------------- \n" +
                            " > Please enter the choice: ");
                    choiceString = scanner.next();
                    if (choiceString.equalsIgnoreCase("l")) {}
                    if (choiceString.equalsIgnoreCase("h")) {
                        do {
                            System.out.print("--------------- Request Membership ------------------\n" +
                                    "------------------------------------------------------\n" +
                                    " | 1: Via world insurance company representative    | \n" +
                                    " | 2: Pay insurance fee                             | \n" +
                                    " | 3: Previous Menu                                 | \n" +
                                    " ---------------------------------------------------- \n" +
                                    " > Please enter the choice: ");
                            choiceInt = scanner.nextInt();
                            if (choiceInt == 2) {
                                lifeRM++;
                                System.out.print(" > Enter your name (first and last): ");
                                scanner.nextLine();
                                customerName = scanner.nextLine();
                                System.out.print(" > Enter your mobile (##-###-####): \n");
                                customerMobileNumber = scanner.next();
                                System.out.print(" > Enter type of the insurance Life or Health or Car name: \n");
                                insuranceType = scanner.next();
                                System.out.print(" > Enter the description service of the selected insurance type  : \n");
                                scanner.nextLine();
                                description = scanner.nextLine();
                                System.out.print(" > Method of payment Monthly or Annually : \n");
                                paymentMethod = scanner.next();
                                System.out.print(" > When do you want your to start your Membership service : \n");
                                mebershipDate = scanner.next();
                                System.out.print(" > Enter number of quantities of this service you want: \n");
                                numberOfQuantities = scanner.nextInt();
                                System.out.print(" > Please enter the cost of the selected type insurance: \n");
                                cost = scanner.nextDouble();
                                System.out.println("\n" +
                                        "-------------------------------------------------------------------------------------\n" +
                                        " | Yor request was received; you will be contacted within 24 hours to finalize it. |\n" +
                                        " -----------------------------------------------------------------------------------\n" +
                                        " Here is a confirmation of your request to LIFE INSURANCE:\n" +
                                        "\tThe confirmation of the type insurance and the amount you have paid\n" +
                                        "\tName:  " + customerName + "                     Phone:  " + customerMobileNumber + "\n" +
                                        "\tthe starting date of the membership: " + mebershipDate + "\n" +
                                        "\tPreferred payment method monthly or annually " + paymentMethod + "\n" +
                                        "\tThe amount you have paid is: " + cost + "\n" +
                                        "\n" +
                                        "\t**You will now be returned to the Membership Menu.\n");
                            }
                        } while (choiceInt != 3);
                    }
                    if (choiceString.equalsIgnoreCase("c")) {}
                }while (!choiceString.equalsIgnoreCase("r"));
            }
            if (choiceInt == 3) {
                do {
                    System.out.print("     ------- SERVICES -------\n" +
                            "-----------------------------------\n" +
                            " | L or l : Life Insurance           | \n" +
                            " | H or h : Health Insurance         | \n" +
                            " | C or c : Car Insurance            | \n" +
                            " | R or r : Return to Main Menu      | \n" +
                            " --------------------------------- \n" +
                            " > Please enter the choice: ");
                    choiceString = scanner.next();
                    if (choiceString.equalsIgnoreCase("l")) {

                    }
                    if (choiceString.equalsIgnoreCase("h")) {
                        do {
                            System.out.print("\n" +
                                    "  ------ CLAIM/COMPLAINT ------\n" +
                                    "-------------------------------------\n" +
                                    " | 1: Submit Claim                 | \n" +
                                    " | 2: Submit Complaint             | \n" +
                                    " | 3: Previous Menu                | \n" +
                                    " ----------------------------------- \n" +
                                    " > Please enter the choice: ");
                            choiceInt = scanner.nextInt();
                            if (choiceInt == 1) {
                                healthCorC++;
                                System.out.print(" > Enter your name (first and last): ");
                                scanner.nextLine();
                                customerName = scanner.nextLine();
                                System.out.println(" > Enter your mobile (##-###-####): ");
                                customerMobileNumber = scanner.next();
                                System.out.print(" > Enter your claim (on one line only): ");
                                scanner.nextLine();
                                claim = scanner.nextLine();
                                System.out.print("\n" +
                                        "--------------------------------------------------------------------------------------\n" +
                                        " | Your Claim / Complaint was submitted successfully; you will contact you shortly.  |\n" +
                                        " -------------------------------------------------------------------------------------\n" +
                                        " Here is a confirmation of your submission to HEALTH INSURANCE:\n" +
                                        "\tSubmission Type: claim\n" +
                                        "\tName:  " + customerName + "                     Phone:  " + customerMobileNumber + "\n" +
                                        "\tClaim:\n" +
                                        "\t\"" + claim + "\"\n" +
                                        "\n" +
                                        "\t**You will now be returned to the Claim and Complaint  Menu.\n" +
                                        "\n");
                            }
                        } while (choiceInt != 3);
                    }
                    if (choiceString.equalsIgnoreCase("c")) {

                    }
                } while (!choiceString.equalsIgnoreCase("r"));
            }

        } while (choiceInt != 4);
        System.out.println("\n*** SUMMARY Activity for\n" +
                " World Insurance Company:\n" +
                "Insurance Type     # query for Insurance     # of request Memebership     # of Claim & Complaintl \n" +
                "--------------------------------------------------------------------------------------------------\n" +
                "Life                          " + lifeQ + "                        " + lifeRM + "                             " + lifeCorC + "\n" +
                "Health                        " + healthQ + "                        " + healthRM + "                             " + healthCorC + "\n" +
                "Car                           " + carQ + "                        " + carRM + "                             " + carCorC + "");

    }
}
