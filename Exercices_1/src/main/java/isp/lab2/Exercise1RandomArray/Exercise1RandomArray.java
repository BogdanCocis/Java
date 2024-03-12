package isp.lab2.Exercise1RandomArray;

import java.util.Random;

public class Exercise1RandomArray {

    public static int[] getArrayOfRandomNumbers(int n) {
        int[] array = new int[n];
        Random random = new Random();
        for(int i = 0; i < n; i++){
            array[i] = random.nextInt(90)+10;
        }
        return array;
    }

    public static int[] findMinAndMax(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{-1, -1};
        }

        int[] maxMin = {array[0], array[0]};

        for(int i = 1; i < array.length; i++) {
            if(array[i] < maxMin[0]) {
                maxMin[0] = array[i];
            }
            if(array[i] > maxMin[1]) {
                maxMin[1] = array[i];
            }
        }
        return maxMin;
    }


    public static void main(String[] args) {

        Random random = new Random();
        int size = random.nextInt(91) + 10;
        int[] a = getArrayOfRandomNumbers(size);
        int[] mm = findMinAndMax(a);
        System.out.println("Min is:"+mm[0]+" Max is:"+mm[1] );
    }
}
