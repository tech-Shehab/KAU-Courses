package dh_v;

import java.math.BigInteger;
import java.util.*;

public class DH_V {

    public static void main(String[] args) {
        System.out.println(
                        "****************************\n" +
                        "* Diffie-Hellman algorithm *\n"
                        +"****************************");
        System.out.print("Please Enter A Prime number(Q)= " + "\n> ");
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt(); // Prime number

        while (!isPrime(Q)) {
            System.out.print("it's not a prime number!, please enter a prime number (Q)\n> ");
            Q = scanner.nextInt();
        }

        int a = PrimitiveRoot.primitiveRoot(Q); // Primitive root
        int Xa= secretKeyGeneration(); // Alice Secret Key
        while (Xa >= Q) {
            Xa = secretKeyGeneration();
        }
        BigInteger A = BigInteger.valueOf(a);
        BigInteger q = BigInteger.valueOf(Q);
        BigInteger Ya = (A.pow(Xa)).mod(q); // Alic public key

        int Xb= secretKeyGeneration(); // Bob Secret Key
        while (Xb >= Q) {
            Xb = secretKeyGeneration();
        }
        BigInteger Yb = BigInteger.valueOf(a);
        Yb = (Yb.pow(Xb)).mod(q); // Bob public key

        System.out.println("\nPrime Number(Q)   = "+Q +" \nAlice Secret Key  = "+Xa +" \nBob Secret Key    = "+Xb+" \nPrimitive Root(a) = "+a + " \nAlic Public Key   = "+A+" \nBob Public Key    = "+Yb+"\n");
        BigInteger KA = BigInteger.valueOf(Yb.intValue());
        KA = (KA.pow(Xa)).mod(q); // Shared key for alice
        BigInteger KB = BigInteger.valueOf(Ya.intValue());
        KB = (KB.pow(Xb)).mod(q); // Shared key for bob

        System.out.println("Alice Share Key(Ka) = " + KA + " \n Bob Share Key(Kb)  = " + KB );
    }

    public static int secretKeyGeneration() { // This method generates a secret key up to 20
        Random r = new Random();
        return r.nextInt(20) + 1;
    }

    public static int primeNumberGeneration() { // This method generates a prime number up to the same randomNumberGeneration() boundary
        while (true) {
            int random = randomNumberGeneration();
            if (isPrime(random)) {
                return random;
            } else {
                randomNumberGeneration();
            }
        }
    }

    public static int randomNumberGeneration() { // This method generates a random number up to 1000
        Random r = new Random();
        return r.nextInt(1000) + 1;
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
}

