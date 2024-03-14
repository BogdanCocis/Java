package isp.lab2.Exercise6WordGuess;

import java.util.Random;
import java.util.Scanner;

public class Exercise6WordGuess {

    public static int[] getOccurrencePositions(char c, char[] word) {
        int count = 0;
        for (char letter : word) {
            if (letter == c) {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }
        int[] positions = new int[count];
        int index = 0;
        for (int i = 0; i < word.length; i++) {
            if (word[i] == c) {
                positions[index++] = i;
            }
        }
        return positions;
    }

    public static void main(String[] args) {
        // Aici puteți adăuga cuvinte suplimentare la dicționar
        String[] dictionary = {"apple", "banana", "orange", "grape", "kiwi"};

        // Selectăm un cuvânt aleatoriu din dicționar
        Random random = new Random();
        String selectedWord = dictionary[random.nextInt(dictionary.length)];
        char[] word = selectedWord.toCharArray();

        // Inițializăm variabilele pentru numărul de încercări și dacă cuvântul a fost ghicit sau nu
        boolean solved = false;
        Scanner scanner = new Scanner(System.in);
        int tries = 0;

        // Inițializăm șirul de litere ghicite cu caracterele '*'
        char[] guessedLetters = new char[word.length];
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '*';
        }

        // Începem jocul
        while (tries < 10 && !solved) {
            tries++;
            System.out.println("Enter a letter: ");
            char guess = scanner.next().charAt(0);
            int[] occurrences = getOccurrencePositions(guess, word);
            if (occurrences != null) {
                for (int position : occurrences) {
                    guessedLetters[position] = guess;
                }
                System.out.println("The letter " + guess + " is in the word at positions: " + java.util.Arrays.toString(occurrences));
                System.out.println("Current word status: " + String.valueOf(guessedLetters));
                if (String.valueOf(guessedLetters).equals(selectedWord)) {
                    solved = true;
                }
            } else {
                System.out.println("The letter " + guess + " is not in the word.");
            }
        }

        // La sfârșit, afișăm cuvântul și numărul de încercări
        System.out.println("The word was: " + selectedWord);
        if (solved) {
            System.out.println("Congratulations! You guessed the word in " + tries + " tries.");
        } else {
            System.out.println("Sorry, you did not guess the word. Better luck next time!");
        }
    }
}
