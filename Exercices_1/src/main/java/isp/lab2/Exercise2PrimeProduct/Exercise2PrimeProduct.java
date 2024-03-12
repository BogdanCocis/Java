package isp.lab2.Exercise2PrimeProduct;

import java.util.Scanner;

public class Exercise2PrimeProduct {

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;
        for (int div = 3; div <= Math.sqrt(n); div += 2)
            if (n % div == 0)
                return false;
        return true;
    }

    public static long getPrimeProduct(int n, int m) {
        long product = 1;
        if (n < m) {
            for (int i = n; i <= m; i++) {
                if (isPrime(i))
                    product *= i;
            }
        } else {
            for (int i = m; i <= n; i++) {
                if (isPrime(i))
                    product *= i;
            }
        }
        return product;
    }

    public static int readfromConsoleInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        return number;
    }

    public static void main(String[] args) {
        System.out.println("The product of the first 10 prime numbers is: " + getPrimeProduct(1, 10));
        System.out.println("The product of prime numbers between m and n: " + getPrimeProduct(readfromConsoleInt(), readfromConsoleInt()));
    }

}
