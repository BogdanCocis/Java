package isp.lab2.Exercise3SumOfIntegersRecursive;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumOfIntegersRecursive {

    @Test
    public void testSumOfIntegers() {
        int n = 100;
        int expected = 5050;
        int actual = Exercise3SumOfIntegersRecursive.sumOfIntegers(n);
        assertEquals(expected, actual);
    }
}
