package isp.lab2.Exercise4StringSearch;

import java.util.Scanner;

public class Exercise4StringSearch {

    public static String[] searchSubstrings(String input, String substring) {
        String[] splitInput = input.split(",");
        String[] splitOutput = new String[100];
        int numberOfCaracter = 0;
        for (String str : splitInput) // merg pe fiecare caracter
        {
            if (str.contains(substring)) {
                splitOutput[numberOfCaracter] = str;
                numberOfCaracter++;
            }
        }

        String[] c = new String[numberOfCaracter];
        for(int i = 0; i < numberOfCaracter; i++)
            c[i] = splitOutput[i];
        return c;
    }

    public static String readFromConsole(String suffix) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + suffix);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        String input = "apples,computer,bread,tea,car"; // = readFromConsole("words");
        String substring = "te"; // = readFromConsole("substring");
        String[] result = searchSubstrings(input, substring);
        for (String string : result) {
            System.out.println(string);
        }
    }
}
