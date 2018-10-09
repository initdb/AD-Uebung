package de.fh_rosenheim.algorithmen.lecture02;



// adjusted from Sedgewick et al.


import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Karatsuba {

    public static BigInteger karatsuba(BigInteger a, BigInteger b) {

        // cutoff to brute force
        int n = Math.max(a.bitLength(), b.bitLength());
        if (n <= 2000) return a.multiply(b);                // optimize this parameter

        // number of bits divided by 2, rounded up
        int n2 = (n / 2) + (n % 2);

        // attention: n now matches n/2
        // a = "pq" = 2^N/2 * p + q,   b = "rs" = 2^N/2 * r + s
        // Todo: determine p, q, r, s (based on a and b)
        BigInteger p = a.shiftRight(n2);
        BigInteger q = a.subtract(p.shiftLeft(n2));
        BigInteger r = b.shiftRight(n2);
        BigInteger s = b.subtract(r.shiftLeft(n2));

        // compute sub-expressions
        BigInteger w = karatsuba(q, s);
        BigInteger u = karatsuba(p, r);
        BigInteger v = karatsuba(p.subtract(q), s.subtract(r));


        // combination
        return u.shiftLeft(2*n2).add(u.add(w).add(v).shiftLeft(n2)).add(w);
    }


    public static void main(String[] args) {
        long start, stop, elapsed;
        Random random = new Random();
        System.out.println("How many bits should the integers that we multiply should have?");
        Scanner scanner = new Scanner(System.in);
        int numBits = scanner.nextInt();
        BigInteger a = new BigInteger(numBits, random);
        BigInteger b = new BigInteger(numBits, random);


        start = System.currentTimeMillis();
        BigInteger c = karatsuba(a, b);
        stop = System.currentTimeMillis();
        System.out.println("Time with Karatsuba:" +  (stop - start));

        start = System.currentTimeMillis();
        BigInteger d = a.multiply(b);
        stop = System.currentTimeMillis();
        System.out.println("Time with Java Multiplication:" + (stop - start));
        // Hint: Java uses a combination of Karatsuba and Toom-Cook multiplication ... that's why it's faster most of the time

        if (d.equals(c)) {
            System.out.println("Korrekt");
        }

    }

}