package isp.lab2.Exercise5EvenOddSearch;

public class Exercise5EvenOddSearch {

    public static boolean isOdd(int number){
        if(number % 2 == 0)
            return false;
        return true;
    }

    public static int[] findEvenOdd(String input) {
        String[] numbersAsString = input.split(",");
        int largestEven = Integer.MIN_VALUE;
        int smallestOdd = Integer.MAX_VALUE;
        int positionOfLargestEven = -1;
        int positionOfSmallestOdd = -1;

        for (int i = 0; i < numbersAsString.length; i++) {
            int number = Integer.parseInt(numbersAsString[i]);
            if (number % 2 == 0 && number > largestEven) {
                largestEven = number;
                positionOfLargestEven = i;
            } else if (number % 2 != 0 && number < smallestOdd) {
                smallestOdd = number;
                positionOfSmallestOdd = i;
            }
        }

        if (positionOfLargestEven == -1 && positionOfSmallestOdd == -1) {
            return new int[]{-1, -1, -1, -1}; // Nu există numere pare sau impare în listă
        } else {
            return new int[]{largestEven, positionOfLargestEven, smallestOdd, positionOfSmallestOdd};
        }
    }

    public static void main(String[] args) {
        String input = "1,2,3,4,5,6,7,8,9,10";
        int[] result = findEvenOdd(input);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
