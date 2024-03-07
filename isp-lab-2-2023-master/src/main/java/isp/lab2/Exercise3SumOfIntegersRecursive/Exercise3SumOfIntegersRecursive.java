package isp.lab2.Exercise3SumOfIntegersRecursive;

public class Exercise3SumOfIntegersRecursive {

    public static int sumOfIntegers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfIntegers(5));

    }
}
