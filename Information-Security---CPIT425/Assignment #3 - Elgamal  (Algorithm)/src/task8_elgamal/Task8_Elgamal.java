package task8_elgamal;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Task8_Elgamal {

    public static void main(String[] args) {
        System.out.println("*********************"
                + "\n* Elgamal Algorithm *"
                + "\n*********************");
        System.out.print("Please Enter A Prime number(Q)= " + "\n> ");
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt(); // Prime number

        while (!isPrime(Q)) {
            System.out.print("it's not A prime number!, please enter A prime number (Q)\n> ");
            Q = scanner.nextInt();
        }

        int A = PrimitiveRoot.primitiveRoot(Q); // Primitive root

        int Xa = secretKeyGeneration(); // private key
        while (Xa >= Q - 1) {
            Xa = secretKeyGeneration();
        }
        BigInteger a = BigInteger.valueOf(A);
        BigInteger q = BigInteger.valueOf(Q); // Because the method .mod() in next line accept only Bigintegers
        BigInteger Ya = (a.pow(Xa)).mod(q); // public key

        int plainTextValue;
        String plainText;
        while (true) {
            System.out.print("Please Enter plaintext (M) where (M) is less than (Q)= " + "\n> ");
            scanner.nextLine();
            plainText = scanner.nextLine();
            plainText = plainText.toUpperCase();

            char[] plainTextArray = new char[plainText.length()]; // Converting the string to char array
            for (int i = 0; i < plainText.length(); i++) {
                plainTextArray[i] = plainText.charAt(i);
            }
            plainTextValue = map(plainTextArray, plainText.length());
            if (plainTextValue < Q) {
                break;
            } else {
                System.out.println("(M)>(Q)!!");
            }
        }
        int k0;
        while (true) {
            k0 = randomNumberGeneration();
            if (k0 < Q) {
                break;
            }
        }

        BigInteger EK1; // Encryption K1
        EK1 = (Ya.pow(k0)).mod(q);
        BigInteger C1 = (a.pow(k0)).mod(q);
        BigInteger M = BigInteger.valueOf(plainTextValue);
        BigInteger C2 = (EK1.multiply(M)).mod(q);
        BigInteger DK1 = (C1.pow(Xa)).mod(q); // Decryption K1
        BigInteger one = BigInteger.valueOf(1);
        BigInteger restoredPlainText = (C2.multiply(C1.pow(Q - 1 - Xa))).mod(q);
        System.out.println("Prime number (Q) = " + Q);
        System.out.println("Primitive Root (a) = " + A);
        System.out.println("Private key (Xa) = " + Xa);
        System.out.println("Public key (Ya) = " + Ya);
        System.out.println("PlainText (M) : '" + plainText + "' With the value = " + plainTextValue);
        System.out.println("K0 = " + k0);
        System.out.println("Encryption K1 = " + EK1);
        System.out.println("C1 = " + C1);
        System.out.println("C2 = " + C2);
        System.out.println("Decryption K1 = " + DK1);
        System.out.println("Decrypted ciphertext = " + restoredPlainText);
    }

    public static int secretKeyGeneration() { // This method generates a secret key up to 20
        Random r = new Random();
        return r.nextInt(20) + 1;
    }

    private static boolean isPrime(int n) { // This method test the random number if it is a prime or not
        int i;
        for (i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int randomNumberGeneration() { // This method generates a random number up to 100,000
        Random r = new Random();
        return r.nextInt(100000) + 1;
    }

    public static int map(char plainTextArray[], int plaintextLength) {
        int plainTextHashed[] = new int[plaintextLength];
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('B', 1);
        map.put('C', 2);
        map.put('D', 3);
        map.put('E', 4);
        map.put('F', 5);
        map.put('G', 6);
        map.put('H', 7);
        map.put('I', 8);
        map.put('J', 9);
        map.put('K', 10);
        map.put('L', 11);
        map.put('M', 12);
        map.put('N', 13);
        map.put('O', 14);
        map.put('P', 15);
        map.put('Q', 16);
        map.put('R', 17);
        map.put('S', 18);
        map.put('T', 19);
        map.put('U', 20);
        map.put('V', 21);
        map.put('W', 22);
        map.put('X', 23);
        map.put('Y', 24);
        map.put('Z', 25);
        map.put(' ', 66);
        int sumPlaintTextValue = 0;
        for (int i = 0; i < plaintextLength; i++) {
            plainTextHashed[i] = map.get(plainTextArray[i]);
            sumPlaintTextValue = sumPlaintTextValue + plainTextHashed[i];
        }
        return sumPlaintTextValue;
    }
}
