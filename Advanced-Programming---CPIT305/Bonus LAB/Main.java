package com.codewithshehab;

import javax.swing.*;
import java.io.*;
import java.math.BigInteger;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // all necessary declarations

        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = null;
        JFileChooser fileChooser = new JFileChooser();
        String choice = "";
        File file = null;
        String path = null;

        // while loop
        while (true) {
            //interface
            System.out.println("\n\n--- Welcome To Reader Program ---\n");
            System.out.println("\t1- Absolute Path");
            System.out.println("\t2- File Chooser");
            System.out.println("\t3- Read As Text");
            System.out.println("\t4- Read and print as (Hexadecimal Output)");
            System.out.println("\t0-    Exit");
            System.out.print("\n> Enter a choice: ");
            choice = scanner.nextLine();
            if (choice.equals("0"))
                break;
            else if (choice.equals("1")) {
                System.out.print("\n> Enter The Absolute path : ");
                path = scanner.nextLine();
                file = new File(path);
            } else if (choice.equals("2")) {
                int x = fileChooser.showOpenDialog(null);
                if (x == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
                    System.out.println("--- File has been chosen ---");
                    continue;
                }
                System.err.println("Something went wrong! please try again!");
            } else if (choice.equals("3")) {
                try {
                    String line = "";
                    bufferedReader = new BufferedReader(new FileReader(file));
                    System.out.println("\n--- File Content ---\n");
                    while ((line = bufferedReader.readLine()) != null) {
                        System.out.println(line);
                    }
                    System.out.println("\n--- End Of Content ---");
                } catch (NullPointerException exception) {
                    System.err.println("Choose File First!");
                    continue;
                } catch (IOException exception) {
                    System.err.println("File doesn't exist! please make sure you have typed the correct name!");
                    continue;
                }
            } else if (choice.equals("4")) {
                try {
                    String line = "";
                    System.out.println("\n--- File Content As Hexadecimal ---\n");
                    byte [] b = new byte[10];
                    FileInputStream in = new FileInputStream(new File("Text.txt"));
                    int x;
                    while ((x = in.read(b)) != -1) {
                        line = "";
                        for (int i = 0; i < b.length; i++) {
                            line += (char) b[i];
                        }
                        line = toHex(line).toUpperCase();
                        line = line.replaceAll("..", "$0 ");
                        System.out.println(line);
                    }
                    System.out.println("\n--- End Of Content ---");
                } catch (NullPointerException exception) {
                    System.err.println("Choose File First!");
                    continue;
                } catch (IOException exception) {
                    System.err.println("File doesn't exist! please make sure you have typed the correct name!");
                    continue;
                }
            } else {
                System.err.print("Enter a correct choice!");
            }
        }
        System.out.println("--- Thanks for using the program ---");
    }

    public static String toHex(String arg) {
        return String.format("%01x", new BigInteger(1, arg.getBytes(/*YOUR_CHARSET?*/)));
    }

}
