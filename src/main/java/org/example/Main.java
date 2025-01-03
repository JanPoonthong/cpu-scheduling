package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int selectedAlgorithm = readInput();
    }

    /**
     * This function gets input from the user.
     *
     * @return the selected algorithm by user
     */
    public static int readAlgorithmSelection() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pick an algorithm (int): ");
        int selectedAlgorithm;

        if (scanner.hasNextInt()) {
            selectedAlgorithm = scanner.nextInt();
        } else {
            scanner.next();
            selectedAlgorithm = -1;
        }

        while (selectedAlgorithm < 1 || selectedAlgorithm > 4) {
            System.out.print("Invalid selection of an algorithm, please pick integer from 1 to 4: ");
            if (scanner.hasNextInt()) {
                selectedAlgorithm = scanner.nextInt();
            } else {
                scanner.next();
                selectedAlgorithm = -1;
            }
        }

        return selectedAlgorithm;
    }
}